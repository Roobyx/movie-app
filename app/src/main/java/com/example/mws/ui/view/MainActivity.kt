package com.example.mws.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mws.R
import com.example.mws.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
//		Thread.sleep(2000)
		val splashScreen = installSplashScreen()

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		val navView: BottomNavigationView = binding.navElementBottomNavigation
		navView.itemIconTintList = null

		val navController = findNavController(R.id.navigationHostMainActivity)
		navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
			binding.appBarTitle.text = nd.label
		}
		navView.setupWithNavController(navController)
	}
}