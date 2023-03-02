package com.example.mws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
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
		val navView: BottomNavigationView = binding.navView
		navView.itemIconTintList = null

		val navController = findNavController(R.id.nav_host_fragment_activity_main)
//		val appBarConfiguration = AppBarConfiguration(
//			setOf(
//				R.id.navigation_movies, R.id.navigation_tvshows, R.id.navigation_favorites
//			)
//		)

//		setupActionBarWithNavController(navController, appBarConfiguration)
		navView.setupWithNavController(navController)
	}
}