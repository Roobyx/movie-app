package com.example.mws.data.model

import com.squareup.moshi.Json

data class Collection(
	val id: Int?,
	val name: String?,
	@Json(name = "backdrop_path") val backdropPath: String?,
	@Json(name = "poster_path") val posterPath: String?,
)

