package com.example.coderproprement.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.coderproprement.R
import com.example.coderproprement.ui.CharacterListViewModel
import fr.quentin.android3.model.Item

class AdapterMarvel(val result: Item, val navController: NavController, val viewModel: CharacterListViewModel) :
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
        holder.itemView.setOnClickListener {
            viewModel.idCharacter = result.data.result[position].id.toString()
            navController.navigate(R.id.action_characterListFragment_to_detailCharacterFragment)
        }

    }

    override fun getItemCount(): Int {
        return result.data.count
    }

    class CustomViewHolder(mView: View): RecyclerView.ViewHolder(mView){
        val image: ImageView = mView.findViewById(R.id.picture)
        val name : TextView = mView.findViewById(R.id.nameDetail)
        val description : TextView = mView.findViewById(R.id.descriptionDetail)
    }
}