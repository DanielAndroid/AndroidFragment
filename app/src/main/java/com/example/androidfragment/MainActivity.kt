package com.example.androidfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottom_navigation_view)


        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item1 -> {
                    // Respond to navigation item 1 click
                    showFragment(FragmentOne.newInstance())
                    true
                }
                R.id.item2 -> {
                    // Respond to navigation item 2 click
                    showFragment(FragmentTwo.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    // A function that uses the fragment Manager to do transactions on the fragments.
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, fragment)
        }
    }

}