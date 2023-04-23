package com.example.cyphersystemcompanion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.adapter.ItemAdapter
import com.example.cyphersystemcompanion.adapter.TypeAdapter
import com.example.cyphersystemcompanion.data.Foci
import com.example.cyphersystemcompanion.data.Type
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TypeActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var typeRecyclerView : RecyclerView
    private lateinit var typeArrayList : ArrayList<Type>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type)

        typeRecyclerView = findViewById(R.id.typeList)
        typeRecyclerView.layoutManager = LinearLayoutManager(this)
        typeRecyclerView.setHasFixedSize(true)

        typeArrayList = arrayListOf<Type>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("types")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    println("In SnapShot")
                    for (typeSnapshot in snapshot.children) {
                        val type = typeSnapshot.getValue(Type::class.java)
                        println("Test" + typeSnapshot.getValue(Type::class.java))
                        typeArrayList.add(type!!)
                    }
                    typeRecyclerView.adapter = TypeAdapter(typeArrayList)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}