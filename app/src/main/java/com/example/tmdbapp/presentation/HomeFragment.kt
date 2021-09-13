package com.example.tmdbapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tmdbapp.R
import com.example.tmdbapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        binding.btMovie.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
        }

        binding.btTvShows.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tvShowFragment)
        }

        return binding.root
    }

}