package com.asmasyaf.hotelappssubmission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailHotelActivity : AppCompatActivity() {
    companion object {
        const val DATA_HOTEL = "data_hotel"
    }
    private var dataHotel: Hotel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hotel)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        dataHotel = intent.getParcelableExtra(DATA_HOTEL)
        val imgHotel = findViewById<ImageView>(R.id.img_hotel_detail)
        val nameHotel = findViewById<TextView>(R.id.title_hotel_detail)
        val descHotel = findViewById<TextView>(R.id.desc_hotel_detail)
        val rateHotel = findViewById<TextView>(R.id.rate_hotel_detail)
        val telHotel = findViewById<TextView>(R.id.telp_hotel_detail)

        Glide.with(this)
            .load(dataHotel?.imgHotel)
            .into(imgHotel)

        nameHotel.text = dataHotel?.nameHotel
        descHotel.text = dataHotel?.descHotel
        rateHotel.text = dataHotel?.rateHotel
        telHotel.text = dataHotel?.telpHoltel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_share -> {
                val intentShare = Intent(Intent.ACTION_SEND)
                intentShare.type = "text/plain"
                intentShare.setPackage("com.whatsapp")
                intentShare.putExtra(Intent.EXTRA_TEXT, dataHotel?.nameHotel)
                intentShare.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                startActivity(intentShare)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}