package com.mobilestudio.developer.features.themedetail.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobilestudio.developer.databinding.FragmentThemeDetailBinding
import kotlinx.android.synthetic.main.fragment_theme_detail.*

class ThemeDetailFragment : Fragment() {

    private lateinit var binding: FragmentThemeDetailBinding

    private val args: ThemeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThemeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        binding.subThemeTitleTextView.text = args.subTheme.title
        slidesButton.setOnClickListener {
            findNavController().navigate(
                ThemeDetailFragmentDirections.actionThemeDetailFragmentToWebViewerFragment(args.subTheme.link)
            )
        }
    }

}
