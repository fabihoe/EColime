package com.example.ecolime.Adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.ecolime.Model.User
import com.example.ecolime.databinding.ItemFriendBinding

class FriendsCoinAdapter(private val listData: List<User>, var context: Context) :
    RecyclerView.Adapter<FriendsCoinAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding=
            ItemFriendBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val user=listData[i]
        val binding=holder.binding
        binding.txtUserName.text="${i+1} : ${user.username}"
        binding.txtcoins.text="has a total of ${user.coins}"
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ViewHolder(var binding: ItemFriendBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}