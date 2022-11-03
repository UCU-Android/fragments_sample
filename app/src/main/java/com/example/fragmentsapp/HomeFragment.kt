package com.example.fragmentsapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsapp.databinding.FragmentHomeBinding
import java.lang.ClassCastException

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupHelpButton()
        setupStartButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw ClassCastException("Must implement HomeFragment.OnFragmentInteractionListener")
        }
    }

    private fun setupStartButton() {
        binding.startButton.setOnClickListener {
            listener?.onStartButtonPressed()
        }
    }

    private fun setupHelpButton() {
        binding.helpButton.setOnClickListener {
            listener?.onHelpButtonPressed()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onHelpButtonPressed()
        fun onStartButtonPressed()
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}