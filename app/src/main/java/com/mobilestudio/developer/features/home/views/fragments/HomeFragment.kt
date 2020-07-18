package com.mobilestudio.developer.features.home.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.mobilestudio.developer.databinding.FragmentHomeBinding
import com.mobilestudio.developer.features.home.LocalConfiguration
import com.mobilestudio.developer.features.home.adapters.ThemeAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var themesAdapter: ThemeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        themesAdapter = ThemeAdapter()

        val json = getContent()
        val data = Gson().fromJson(json, LocalConfiguration::class.java)
        themesAdapter?.addAll(data.competencies)

        setupComponents()
    }

    private fun setupComponents() {
        themesAdapter?.listener = { theme, _ ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToSubThemesFragment(theme)
            )
        }
        binding.themesRecyclerView.apply {
            setHasFixedSize(true)
            adapter = themesAdapter
        }
    }

    private fun getContent(): String {
        return requireActivity().assets.open("data.json").bufferedReader().use { it.readText() }
    }

}
