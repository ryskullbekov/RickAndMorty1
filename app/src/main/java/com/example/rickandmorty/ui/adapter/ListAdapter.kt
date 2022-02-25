package com.example.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.remote.model.Character
import com.example.rickandmorty.databinding.ItemCharacterBinding


class ListAdapter :
    RecyclerView.Adapter<ListAdapter.ViewHolder?>() {

    private var list: ArrayList<Character> = ArrayList()

    fun addList(list: ArrayList<Character>?) {
        if (list != null) {
            this.list = list
        }
        notifyDataSetChanged()
    }



    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characters: Character) {
            binding.tvName.text = characters.name
            binding.tvStatus.text = characters.status
            Glide.with(binding.tvImage).load(characters.image).into(binding.tvImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}