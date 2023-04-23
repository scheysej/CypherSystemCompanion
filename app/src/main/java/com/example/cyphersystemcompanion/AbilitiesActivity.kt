package com.example.cyphersystemcompanion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.adapter.AbilitiesAdapter
import com.example.cyphersystemcompanion.data.Abilities
import com.google.firebase.database.*

class AbilitiesActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var abilitiesRecyclerView : RecyclerView
    private lateinit var abilitiesArrayList : ArrayList<Abilities>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abilities)

        abilitiesRecyclerView = findViewById(R.id.abilitiesList)
        abilitiesRecyclerView.layoutManager = LinearLayoutManager(this)
        abilitiesRecyclerView.setHasFixedSize(true)

        abilitiesArrayList = arrayListOf<Abilities>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("abilities")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    println("In SnapShot")
                    for (abilitiesSnapshot in snapshot.children) {

                        val abilities = abilitiesSnapshot.getValue(Abilities::class.java)
                        println("Test" + abilitiesSnapshot.getValue(Abilities::class.java))
                        abilitiesArrayList.add(abilities!!)
                    }

                    abilitiesRecyclerView.adapter = AbilitiesAdapter(abilitiesArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}