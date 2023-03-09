package com.example.mws.data.repository

import com.example.mws.BuildConfig
import com.example.mws.data.model.DiscoveredCollection
import com.example.mws.data.model.Movie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

private const val BASE_URL = "https://api.themoviedb.org/3/"

val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
	level = HttpLoggingInterceptor.Level.BODY
}

val client: OkHttpClient = OkHttpClient.Builder()
	.addInterceptor { chain ->
		val url = chain
			.request()
			.url
			.newBuilder()
			.addQueryParameter("api_key", BuildConfig.TMDB_KEY)
			.build()
		chain.proceed(chain.request().newBuilder().url(url).build())
	}
//	.apply {
////		Add request logging
////		TODO: DELETE ME
//		addInterceptor(interceptor)
//	}
	.build()

private val moshi = Moshi.Builder()
	.add(KotlinJsonAdapterFactory())
	.build()

private val retrofit = Retrofit.Builder()
	.addConverterFactory(MoshiConverterFactory.create(moshi))
	.addCallAdapterFactory(CoroutineCallAdapterFactory())
	.baseUrl(BASE_URL)
	.client(client)
	.build()

interface TMDBApiService {
	@GET("discover/movie")
	fun getMovieCollectionAsync(
		@QueryMap options: Map<String, String>,
	):
			Deferred<DiscoveredCollection>

	@GET("movie/76341")
	fun getMovieAsync(@Path("key") apiKey: String):
			Deferred<Movie>
}

object TMDBApi {
	val retrofitService: TMDBApiService by lazy {
		retrofit.create(TMDBApiService::class.java)
	}
}