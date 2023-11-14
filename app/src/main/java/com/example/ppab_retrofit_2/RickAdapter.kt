package com.example.ppab_retrofit_2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.per10_retrofit_ppapb.model.RickData
import com.example.per10_retrofit_ppapb.model.location

class RickAdapter(val dataRick: List<RickData>?): RecyclerView.Adapter<RickAdapter.MyViewHolder>(){
    class MyViewHolder (view: View):RecyclerView.ViewHolder(view){
        val imageRick = view.findViewById<ImageView>(R.id.gambar_url)
        val nameRick = view.findViewById<TextView>(R.id.name)
        val statusRick = view.findViewById<TextView>(R.id.status)
        val speciesRick = view.findViewById<TextView>(R.id.species)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataRick!=null){
            return dataRick.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameRick.text = dataRick?.get(position)?.name
        holder.speciesRick.text = dataRick?.get(position)?.species
        holder.statusRick.text = dataRick?.get(position)?.status

        Glide.with(holder.imageRick)
            .load(dataRick?.get(position)?.image)
            .fitCenter()
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageRick)

        holder.itemView.setOnClickListener{
            val name = dataRick?.get(position)?.name
            val intentToDetail = Intent(holder.itemView.context, detailRick::class.java)
            intentToDetail.putExtra("IMAGES", dataRick?.get(position)?.image)
            intentToDetail.putExtra("NAMA", dataRick?.get(position)?.name)
            intentToDetail.putExtra("SPECIES", dataRick?.get(position)?.species)
            intentToDetail.putExtra("STATUS", dataRick?.get(position)?.status)
            intentToDetail.putExtra("GENDER", dataRick?.get(position)?.gender)
            intentToDetail.putExtra("LOCATION", dataRick?.get(position)?.location?.name)
            intentToDetail.putExtra("LOCATION_URL", dataRick?.get(position)?.location?.url)
            Toast.makeText(holder.itemView.context, dataRick?.get(position)?.location?.url, Toast.LENGTH_SHORT).show()
            holder.itemView.context.startActivity(intentToDetail)
        }
    }

}