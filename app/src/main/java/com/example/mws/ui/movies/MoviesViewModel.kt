package com.example.mws.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is movies Fragment"
	}
	val text: LiveData<String> = _text
}