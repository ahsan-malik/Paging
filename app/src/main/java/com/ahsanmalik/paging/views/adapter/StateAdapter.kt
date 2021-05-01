package com.ahsanmalik.paging.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadState.Loading
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahsanmalik.paging.R
import com.ahsanmalik.paging.databinding.LoadStateItemBinding
import com.ahsanmalik.paging.others.visible

class StateAdapter(private val mRetryCallback: View.OnClickListener):
    LoadStateAdapter<StateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(parent, mRetryCallback)
    }

    inner class LoadStateViewHolder(parent: ViewGroup, retryCallback: View.OnClickListener):
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.load_state_item, parent, false))
    {
        private var binding: LoadStateItemBinding = LoadStateItemBinding.bind(itemView)

        init {
            binding.retryButton.setOnClickListener(retryCallback)
        }

        fun bind(loadState: LoadState?) {
            // Check load state
            if (loadState is LoadState.Error) {
                // Get the error
                // Set text of Error message
                binding.errorMsg.text = loadState.error.localizedMessage
            }
            // set visibility of widgets based on LoadState
            binding.progressBar.visible(loadState is Loading)
            binding.retryButton.visible(loadState is LoadState.Error)
            binding.errorMsg.visible(loadState is LoadState.Error)
            /*binding.progressBar.visibility = if (loadState is Loading) View.VISIBLE else View.GONE
            binding.retryButton.visibility = if (loadState is LoadState.Error) View.VISIBLE else View.GONE
            binding.errorMsg.visibility = if (loadState is LoadState.Error) View.VISIBLE else View.GONE*/
        }

    }
}