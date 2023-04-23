package com.example.cyphersystemcompanion.data

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

data class Foci(
    var name: String ?= null,
    var description: String ?= null,
    var intrusions: String ?= null,
)
