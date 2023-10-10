package com.asmasyaf.hotelappssubmission2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHotelAdapter(private val hotelList: ArrayList<Hotel>) :
    RecyclerView.Adapter<ListHotelAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hotel, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = hotelList.size

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val photoHotel: ImageView = itemView.findViewById(R.id.img_hotel_row)
        val nameHotel : TextView = itemView.findViewById(R.id.title_hotel)
        val descHotel : TextView = itemView.findViewById(R.id.desc_hotel)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hotel)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, img) = hotelList[position]
        Glide.with(holder.itemView.context)
            .load(img)
            .into(holder.photoHotel)
        holder.nameHotel.text = name
        holder.descHotel.text = desc
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(hotelList[holder.adapterPosition]) }
    }
}