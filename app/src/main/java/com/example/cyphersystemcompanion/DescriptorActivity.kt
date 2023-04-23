package com.example.cyphersystemcompanion

import android.annotation.SuppressLint
import android.media.audiofx.AudioEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.adapter.DescriptorAdapter
import com.example.cyphersystemcompanion.adapter.ItemAdapter
import com.example.cyphersystemcompanion.data.Descriptors
import com.example.cyphersystemcompanion.data.Foci
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DescriptorActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var descriptorRecyclerView : RecyclerView
    private lateinit var descriptorArrayList : ArrayList<Descriptors>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descriptor)

        descriptorRecyclerView = findViewById(R.id.descriptorList)
        descriptorRecyclerView.layoutManager = LinearLayoutManager(this)
        descriptorRecyclerView.setHasFixedSize(true)

        descriptorArrayList = arrayListOf<Descriptors>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("descriptors")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    println("In SnapShot")
                    for (descriptorSnapshot in snapshot.children) {

                        val descriptors = descriptorSnapshot.getValue(Descriptors::class.java)
                        println("Test" + descriptorSnapshot.getValue(Descriptors::class.java))
                        descriptorArrayList.add(descriptors!!)
                    }

                    descriptorRecyclerView.adapter = DescriptorAdapter(descriptorArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}