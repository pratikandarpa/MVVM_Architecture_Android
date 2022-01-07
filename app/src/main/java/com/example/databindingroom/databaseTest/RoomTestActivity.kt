package com.example.databindingroom.databaseTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.databindingroom.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomTestActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_test)

        database = ContactDatabase.getDatabase(this)

//        database = Room.databaseBuilder(
//            applicationContext,
//            ContactDatabase::class.java,
//            "ContactDB"
//        ).build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "Pratik", "156464", Date(), 1))
        }
    }

    fun AddData(view: android.view.View) {
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "Pratik", "156464", Date(), 2))
        }
    }

    fun getData(view: android.view.View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.i("DataData", it.toString())
        })
    }
}