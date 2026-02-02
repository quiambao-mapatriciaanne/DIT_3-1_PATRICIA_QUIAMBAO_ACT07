package com.example.advanceduinavapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment

            val navController = navHostFragment?.navController

            if (navController != null) {
                // Setup Portrait
                findViewById<BottomNavigationView>(R.id.bottom_navigation)?.setupWithNavController(navController)

                // Setup Landscape
                findViewById<NavigationRailView>(R.id.navigation_rail)?.setupWithNavController(navController)
            }
        } catch (e: Exception) {
            // Dito natin mahuhuli ang internal error nang hindi nag-ko-close ang app
            e.printStackTrace()
        }
    }
}