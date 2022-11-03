package com.example.fragmentsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

    override fun onHelpButtonPressed(exampleParam: Int) {
        supportFragmentManager.replaceFragment(
            R.id.fragment_container,
            HelpFragment.newInstance(exampleParam),
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