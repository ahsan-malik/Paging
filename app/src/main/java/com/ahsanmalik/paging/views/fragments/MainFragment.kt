package com.ahsanmalik.paging.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahsanmalik.paging.databinding.FragmentMainBinding
import com.ahsanmalik.paging.viewModels.MyViewModel
import com.ahsanmalik.paging.views.adapter.MyAdapter
import com.ahsanmalik.paging.views.adapter.StateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment() {

    private val viewModel: MyViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    @Inject lateinit var mAdapter: MyAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        initRecyclerView(binding.recyclerView)

        lifecycleScope.launchWhenStarted { viewModel.getAll.collectLatest {
            mAdapter.submitData(it)
        } }

        return binding.root
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        if (recyclerView.layoutManager == null)
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        if (recyclerView.adapter == null)
            recyclerView.adapter = mAdapter.withLoadStateFooter(StateAdapter(View.OnClickListener { mAdapter.retry() }))
    }

}