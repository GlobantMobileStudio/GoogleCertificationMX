package com.mobilestudio.developer.features.webviewer.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobilestudio.developer.databinding.FragmentWebViewerBinding

class WebViewerFragment : Fragment() {

    private lateinit var binding: FragmentWebViewerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebViewerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}
