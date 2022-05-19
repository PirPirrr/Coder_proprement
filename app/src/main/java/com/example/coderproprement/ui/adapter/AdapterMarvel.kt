package com.example.coderproprement.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.coderproprement.R
import fr.quentin.android3.model.Item

class AdapterMarvel(val result: Item) :
RecyclerView.Adapter<AdapterMarvel.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.character, parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = result.data.result[position].name
        holder.description.text = result.data.result[position].description
        val url = "${result.data.result[position].thumbnail.path}.${result.data.result[position].thumbnail.extension}"
        holder.image.load("https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"){
            placeholder(R.drawable.ic_launcher_background)
            scale(Scale.FIT)
        }
    }

    override fun getItemCount(): Int {
        return result.data.count
    }

    class CustomViewHolder(mView: View): RecyclerView.ViewHolder(mView){
        val image: ImageView = mView.findViewById(R.id.picture)
        val name : TextView = mView.findViewById(R.id.name)
        val description : TextView = mView.findViewById(R.id.description)
    }
}