package com.example.fragmentsapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.fragmentsapp.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null
    private val binding: FragmentFormBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmButton.setOnClickListener {
            binding.progressBar.isVisible = true
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    binding.progressBar.isVisible = false
                },
                2000
            )
        }
    }

    companion object {
        const val TAG = "FormFragment"
    }
}