package com.ahsanmalik.paging.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahsanmalik.paging.databinding.RowBinding
import com.ahsanmalik.paging.models.Dogs
import javax.inject.Inject

class MyAdapter @Inject constructor() : PagingDataAdapter<Dogs, MyAdapter.ViewHolder>(PassengersComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null)
            holder.itemPassengerBinding.dog = item
    }

   inner class ViewHolder(val itemPassengerBinding: RowBinding) : RecyclerView.ViewHolder(itemPassengerBinding.root)

    object PassengersComparator : DiffUtil.ItemCallback<Dogs>() {
        override fun areItemsTheSame(oldItem: Dogs, newItem: Dogs): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Dogs, newItem: Dogs): Boolean {
            return oldItem == newItem
        }
    }


}