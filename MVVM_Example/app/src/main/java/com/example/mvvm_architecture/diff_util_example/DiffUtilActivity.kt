package com.example.mvvm_architecture.diff_util_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_architecture.R

class DiffUtilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)

        val rvList = findViewById<RecyclerView>(R.id.rvList)
        val adapter = ProgrammingAdapter()
        val p1 = ProgrammingData(1, "J", "Java")
        val p2 = ProgrammingData(1, "P", "Paython")
        val p3 = ProgrammingData(1, "K", "Kotlin")

        adapter.submitList(listOf(p1, p2, p3))

        rvList.layoutManager = LinearLayoutManager(this)
        rvList.setHasFixedSize(true)
        rvList.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(kotlinx.coroutines.Runnable {
            val p6 = ProgrammingData(1, "K", "Kotlin")
            val p4 = ProgrammingData(1, "JH", "JavaV")
            val p5 = ProgrammingData(1, "PD", "PayDDhon")
            adapter.submitList(listOf(p4, p5, p6))
        }, 4000)
    }
}