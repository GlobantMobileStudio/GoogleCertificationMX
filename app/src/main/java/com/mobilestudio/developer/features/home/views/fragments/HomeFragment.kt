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
import com.mobilestudio.developer.features.home.models.Theme

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var themesAdapter: ThemeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.executePendingBindings()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupThemes()
    }

    private fun setupThemes() {
        themesAdapter = ThemeAdapter()
        themesAdapter?.addAll(retrieveThemes())
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

    private fun retrieveThemes(): List<Theme> {
        val json = getContent()
        val data = Gson().fromJson(json, LocalConfiguration::class.java)
        return data.competencies
    }

    private fun getContent(): String {
        return requireActivity().assets.open("data.json").bufferedReader().use { it.readText() }
    }

}
