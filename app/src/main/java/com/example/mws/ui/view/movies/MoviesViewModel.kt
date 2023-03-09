package com.example.mws.ui.view.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mws.data.model.Movie
import com.example.mws.data.repository.TMDBApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
	private val status = MutableLiveData<String>()
	val response: LiveData<String>
		get() = status

	private val _moviesCollection = MutableLiveData<List<Movie>>()
	val movie: LiveData<List<Movie>>
		get() = _moviesCollection

	private var viewModelJob = Job()
	private val couroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

	init {
		getMovieCollection()
		status.value = "Loading..."
	}

	private fun getMovieCollection() {
		couroutineScope.launch {
			val getMovieCollectionDeferred =
				TMDBApi.retrofitService.getMovieCollectionAsync(
					mapOf(
						"language" to "en",
						"sort_by" to "popularity.desc",
						"include_adult" to "false",
						"include_video" to "false",
						"page" to "1",
						"with_watch_monetization_types" to "flatrate"
					)
				)
			try {
				val result = getMovieCollectionDeferred.await()
				if (result.results?.isNotEmpty() == true) _moviesCollection.value =
					result.results.orEmpty()
			} catch (t: Throwable) {
				Log.i("debug", "Catching: ${t.message}")
			}
		}
	}

	override fun onCleared() {
		super.onCleared()
		viewModelJob.cancel()
	}
}