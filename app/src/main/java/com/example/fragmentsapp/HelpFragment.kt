package com.example.fragmentsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentsapp.databinding.FragmentHelpBinding

const val PARAM = "param"

class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding: FragmentHelpBinding
        get() = _binding!!

    private var exampleParam = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            exampleParam = it.getInt(PARAM, -1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHelpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        binding.randomTv.text = "Parámetro: $exampleParam"
    }

    companion object {
        const val TAG = "HelpFragment"

        @JvmStatic
        fun newInstance(exampleParam: Int) = HelpFragment().apply {
            arguments = Bundle().apply {
                putInt(PARAM, exampleParam)
            }
        }

    }
}