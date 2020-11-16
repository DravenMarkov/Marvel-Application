package com.example.marvelapplication.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapplication.R
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import kotlinx.android.synthetic.main.detail_fragment.view.character_image_iv
import kotlinx.android.synthetic.main.view_item_character.view.*

class HomeAdapter(private val context: Context) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var onItemClick: ((MarvelCharactersEntity.Data.Result) -> Unit)? = null

    private var marvelCharactersList = listOf<MarvelCharactersEntity.Data.Result>()

    fun setListData(list: MutableList<MarvelCharactersEntity.Data.Result>) {
        marvelCharactersList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_character, null, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int = marvelCharactersList.size

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.setData(marvelCharactersList[position])
        holder.itemView.setOnClickListener { onItemClick?.invoke(marvelCharactersList[position]) }
    }

    class ViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {
        fun setData(character: MarvelCharactersEntity.Data.Result) {
            itemView.character_name_tv.text = character.name
            Glide.with(context)
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .override(150, 150)
                .centerCrop()
                .placeholder(R.mipmap.ic_placeholder)
                .error(R.drawable.ic_launcher_foreground)
                .into(itemView.character_image_iv)
        }
    }
}