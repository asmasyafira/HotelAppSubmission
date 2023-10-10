package com.asmasyaf.hotelappssubmission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHotel: RecyclerView
    private val list = ArrayList<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHotel = findViewById(R.id.rv_hotel)
        rvHotel.setHasFixedSize(true)

        list.addAll(getListHotel())
        showRecyclerList()
    }

    private fun getListHotel(): ArrayList<Hotel> {
        val dataHotelName = resources.getStringArray(R.array.data_name_hotel)
        val dataHotelDesc = resources.getStringArray(R.array.data_description_hotel)
        val dataHotelImg = resources.getStringArray(R.array.data_img_hotel)
        val dataHotelRate = resources.getStringArray(R.array.data_rating_hotel)
        val dataHotelPhone = resources.getStringArray(R.array.data_phone_hotel)
        val listHotel = ArrayList<Hotel>()
        for (i in dataHotelName.indices){
            val hotel = Hotel(dataHotelName[i], dataHotelDesc[i], dataHotelImg[i], dataHotelRate[i], dataHotelPhone[i])
            listHotel.add(hotel)
        }
        return listHotel
    }

    private fun showRecyclerList() {
        rvHotel.layoutManager = LinearLayoutManager(this)
        val listHotelAdapter = ListHotelAdapter(list)
        rvHotel.adapter = listHotelAdapter

        listHotelAdapter.setOnItemClickCallback(object : ListHotelAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hotel) {
                showSelectedHotel(data)
            }

        })
    }

    private fun showSelectedHotel(hotel: Hotel) {
        Toast.makeText(this, hotel.nameHotel, Toast.LENGTH_SHORT).show()
        val detailIntent = Intent(this, DetailHotelActivity::class.java)
        detailIntent.putExtra(DetailHotelActivity.DATA_HOTEL, hotel)
        startActivity(detailIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> {
                val aboutIntent = Intent(this, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}