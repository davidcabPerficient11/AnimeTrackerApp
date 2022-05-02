package com.example.animetrackerapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animetrackerapp.databinding.FragmentHomeBinding
import com.example.animetrackerapp.domain.entities.TopAnime
import com.example.animetrackerapp.presentation.home.adapter.JikanAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val jikanAdapter = JikanAdapter(emptyList())
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        observers()
        configureRecyclerView()
        homeViewModel.retrieveAnimeList()
        return root
    }

    private fun observers() {
        homeViewModel.topAnimeList.observe(this, Observer {
            populateList(it)
        })
        homeViewModel.isLoading.observe(this, {
            progressBarState(it)
        })
    }

    private fun populateList(list: List<TopAnime>) {
        jikanAdapter.updateAnimeList(list)
    }

    private fun progressBarState(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    private fun configureRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = jikanAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}