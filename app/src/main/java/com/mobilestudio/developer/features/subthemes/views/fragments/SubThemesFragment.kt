package com.mobilestudio.developer.features.subthemes.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobilestudio.developer.databinding.FragmentSubThemesBinding
import com.mobilestudio.developer.features.subthemes.adapters.SubThemeAdapter

class SubThemesFragment : Fragment() {

    private lateinit var binding: FragmentSubThemesBinding

    private var subThemesAdapter: SubThemeAdapter? = null

    private val args: SubThemesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubThemesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subThemesAdapter = SubThemeAdapter()
        args.theme.topics?.let { subThemesAdapter?.addAll(it) }

        setupComponents()
    }

    private fun setupComponents() {
        subThemesAdapter?.listener = { subTheme, _ ->
            findNavController().navigate(
                SubThemesFragmentDirections.actionSubThemesFragmentToThemeDetailFragment(subTheme)
            )
        }
        binding.subThemesRecyclerView.apply {
            setHasFixedSize(true)
            adapter = subThemesAdapter
        }
    }

}
