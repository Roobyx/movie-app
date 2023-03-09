package com.example.mws.ui.view.tvshows

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mws.data.model.TVShow
import com.example.mws.data.repository.TMDBApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TVShowsViewModel : ViewModel() {
	private val status = MutableLiveData<String>()
	val response: LiveData<String>
		get() = status

	private val _tvShowsCollection = MutableLiveData<List<TVShow>>()
	val tvShow: LiveData<List<TVShow>>
		get() = _tvShowsCollection

	private var viewModelJob = Job()
	private val couroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

	init {
		getTVShowCollection()
		status.value = "Loading..."
	}

	private fun getTVShowCollection() {
		couroutineScope.launch {
			val getTVShowCollectionDeferred =
				TMDBApi.retrofitService.getTvShowsCollectionAsync(
					mapOf(
						"language" to "en-US",
						"sort_by" to "popularity.desc",
						"page" to "1",
						"timezone" to "Europe/Sofia",
						"include_null_first_air_dates" to "false",
						"with_watch_monetization_types" to "flatrate",
						"with_status" to "0",
						"with_type" to "0"
					)
				)
			try {
				val result = getTVShowCollectionDeferred.await()
				if (result.results?.isNotEmpty() == true) _tvShowsCollection.value =
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