package com.example.mws.ui.view.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is Favorites Fragment"
	}
	val text: LiveData<String> = _text
}