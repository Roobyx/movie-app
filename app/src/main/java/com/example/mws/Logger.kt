package com.example.mws
import android.app.Application
import timber.log.Timber

class Logger: Application() {
	override fun onCreate() {
		super.onCreate()
		Timber.plant(Timber.DebugTree())
	}
}