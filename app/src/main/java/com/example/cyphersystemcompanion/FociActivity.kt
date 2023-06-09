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
import com.example.cyphersystemcompanion.data.Foci
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FociActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var fociRecyclerView : RecyclerView
    private lateinit var fociArrayList : ArrayList<Foci>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foci)

        fociRecyclerView = findViewById(R.id.fociList)
        fociRecyclerView.layoutManager = LinearLayoutManager(this)
        fociRecyclerView.setHasFixedSize(true)

        fociArrayList = arrayListOf<Foci>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("foci")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    println("In SnapShot")
                    for (fociSnapshot in snapshot.children) {

                        val foci = fociSnapshot.getValue(Foci::class.java)
                        println("Test" + fociSnapshot.getValue(Foci::class.java))
                        fociArrayList.add(foci!!)
                    }

                    fociRecyclerView.adapter = ItemAdapter(fociArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}