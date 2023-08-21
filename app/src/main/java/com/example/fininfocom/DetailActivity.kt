package com.example.fininfocom

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {


    private val userDataList: MutableList<UserData> = mutableListOf()
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()
        setContentView(R.layout.activity_detail)

        recyclerView = findViewById(R.id.recyclerView)

        adapter = RecyclerViewAdapter(userDataList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val dummyData = createDummyData()
        val adapter = RecyclerViewAdapter(dummyData as List<UserData>)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_name -> {
                sortDataByName()
                true
            }
            R.id.action_sort_age -> {
                sortDataByAge()
                true
            }
            R.id.action_sort_city -> {
                sortDataByCity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun sortDataByName() {
        userDataList.sortBy { it.name }
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun sortDataByAge() {
        userDataList.sortBy { it.age }
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun sortDataByCity() {
        userDataList.sortBy { it.city }
        adapter.notifyDataSetChanged()
    }


    private fun createDummyData(): Any {
        val userList = mutableListOf<UserData>()
        userList.add(UserData("Sehwag", 25, "Delhi"))
        userList.add(UserData("Sachin", 30, "Mumbai"))
        userList.add(UserData("Gambir", 22, "KKR"))
        userList.add(UserData("Virat", 20, "RCB"))
        userList.add(UserData("Dhoni", 27, "CSK"))
        userList.add(UserData("Yuvi", 28, "Punjab"))
        userList.add(UserData("Raina", 24, "CSK"))
        userList.add(UserData("Harbhajan", 27, "CSK"))
        userList.add(UserData("Zaheer", 29, "Delhi"))
        userList.add(UserData("Munaf", 31, "Mumbai"))
        userList.add(UserData("Sreesanth", 28, "Rajasthan"))
        userList.add(UserData("Nehra", 32, "Gujarat"))
        userList.add(UserData("Yousuf", 28, "SRH"))
        userList.add(UserData("Gary", 44, "Lucknow"))
        userList.add(UserData("Venkatesh", 45, "RCB"))
        userList.add(UserData("Ashwin", 28, "Rajasthan"))
        userList.add(UserData("Rohit", 24, "Mumbai"))
        userList.add(UserData("Shreyas", 18, "KKR"))
        userList.add(UserData("Samson", 18, "Rajasthan"))
        userList.add(UserData("Tilak", 16, "Mumbai"))
        userList.add(UserData("Bhuvi", 20, "SRH"))
        userList.add(UserData("Steyn", 24, "RCB"))
        userList.add(UserData("ABD", 26, "RCB"))

        return userList
    }
}