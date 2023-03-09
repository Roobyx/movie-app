package com.example.mws.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mws.R
import com.example.mws.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Thread.sleep(2000)
		val splashScreen = installSplashScreen()

//		Delay the splashscreen until data is fetched:
//		splashScreen.setKeepOnScreenCondition()

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		val navView: BottomNavigationView = binding.navElementBottomNavigation
		navView.itemIconTintList = null

		val navController = findNavController(R.id.navigationHostMainActivity)
//		val appBarConfiguration = AppBarConfiguration(
//			setOf(
//				R.id.navigation_movies, R.id.navigation_tvshows, R.id.navigation_favorites
//			)
//		)

//		setupActionBarWithNavController(navController, appBarConfiguration)
		navView.setupWithNavController(navController)
	}
}