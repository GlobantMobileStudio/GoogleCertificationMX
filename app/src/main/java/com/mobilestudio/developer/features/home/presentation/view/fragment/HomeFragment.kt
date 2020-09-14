package com.mobilestudio.developer.features.home.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mobilestudio.developer.databinding.FragmentHomeBinding
import com.mobilestudio.developer.extentions.observe
import com.mobilestudio.developer.features.home.presentation.view.adapter.ThemeAdapter
import com.mobilestudio.developer.features.home.presentation.viewmodel.HomeViewModel
import com.mobilestudio.developer.features.theme.presentation.model.ThemeModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var themesAdapter: ThemeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.executePendingBindings()
        }
        setupThemes()
        viewModel.init()
        return binding.root
    }

    private fun setupThemes() {
        themesAdapter = ThemeAdapter()
        binding.themesRecyclerView.apply {
            setHasFixedSize(true)
            adapter = themesAdapter
        }
        themesAdapter.listener = { theme, _ ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToSubThemesFragment(
                    theme
                )
            )
        }
    }

    private fun setUpObservers() {
        observe(viewModel.getThemes(), ::managerThemes)
    }

    private fun managerThemes(themes: List<ThemeModel>) {
        themesAdapter.addAll(themes)
    }

}
