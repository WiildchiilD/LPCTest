package com.lakooz.lpctest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakooz.lpctest.databinding.PotsFragmentBinding


class PotsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = PotsFragmentBinding.inflate(inflater, container, false)
        // set up recycler view
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PotAdapter(requireContext())
        adapter.setPots(arrayListOf())
        binding.recyclerView.adapter = adapter
        // TODO : set up view model
        val viewModel = ViewModelProviders.of(this)[PotsViewModel::class.java]

        arguments?.getInt("pos")?.let {
            viewModel.loadData(it)
        }
        viewModel.pots.observe(this, Observer {
            Log.e("TAG", "onCreateView: $it")
            adapter.setPots(it)
        })

        return binding.root
    }

}
