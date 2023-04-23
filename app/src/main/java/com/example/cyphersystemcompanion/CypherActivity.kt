package com.example.cyphersystemcompanion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.adapter.CypherAdapter
import com.example.cyphersystemcompanion.data.Cyphers
import com.google.firebase.database.*

class CypherActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var cypherRecyclerView : RecyclerView
    private lateinit var cypherArrayList : ArrayList<Cyphers>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cypher)

        cypherRecyclerView = findViewById(R.id.cypherList)
        cypherRecyclerView.layoutManager = LinearLayoutManager(this)
        cypherRecyclerView.setHasFixedSize(true)

        cypherArrayList = arrayListOf<Cyphers>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("cyphers")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for (cypherSnapshot in snapshot.children) {

                        val cypher = cypherSnapshot.getValue(Cyphers::class.java)
                        cypherArrayList.add(cypher!!)
                    }

                    cypherRecyclerView.adapter = CypherAdapter(cypherArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}