package com.example.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentsapp.databinding.ActivityMainBinding
import com.example.fragmentsapp.utils.addFragment
import com.example.fragmentsapp.utils.replaceFragment

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.addFragment(
            R.id.fragment_container,
            HomeFragment(),
            false,
            HomeFragment.TAG
        )

    }

    override fun onHelpButtonPressed() {
        supportFragmentManager.replaceFragment(
            R.id.fragment_container,
            HelpFragment(),
            true,
            HomeFragment.TAG
        )
    }

    override fun onStartButtonPressed() {
        supportFragmentManager.replaceFragment(
            R.id.fragment_container,
            FormFragment(),
            true,
            FormFragment.TAG
        )
    }
}