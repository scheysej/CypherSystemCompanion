package com.example.cyphersystemcompanion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.adapter.FlavorAdapter
import com.example.cyphersystemcompanion.data.Flavor
import com.google.firebase.database.*

class FlavorActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var flavorRecyclerView : RecyclerView
    private lateinit var flavorArrayList : ArrayList<Flavor>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flavor)

        flavorRecyclerView = findViewById(R.id.flavorList)
        flavorRecyclerView.layoutManager = LinearLayoutManager(this)
        flavorRecyclerView.setHasFixedSize(true)

        flavorArrayList = arrayListOf<Flavor>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("flavors")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for (flavorSnapshot in snapshot.children) {

                        val flavor = flavorSnapshot.getValue(Flavor::class.java)
                        println("Test" + flavorSnapshot.getValue(Flavor::class.java))
                        flavorArrayList.add(flavor!!)
                    }

                    flavorRecyclerView.adapter = FlavorAdapter(flavorArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}