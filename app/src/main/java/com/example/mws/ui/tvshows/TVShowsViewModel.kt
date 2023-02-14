package com.example.mws.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TVShowsViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is TV Shows Fragment"
	}
	val text: LiveData<String> = _text
}