package com.nbd.afinal

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbd.afinal.databinding.ActivityMainBinding
import com.nbd.afinal.databinding.ItemProductBinding
import org.json.JSONObject

class CarAdapter(private val wishes:Array<JSONObject>):RecyclerView.Adapter<CarAdapter.CarHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.CarHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CarAdapter.CarHolder, position: Int) {
        holder.render(wishes[position])
    }

    override fun getItemCount( ): Int =wishes.size
    class CarHolder(val binding: ItemProductBinding):RecyclerView.ViewHolder(binding.root){
        fun render(jsonObject: JSONObject) {


        }

    }
}