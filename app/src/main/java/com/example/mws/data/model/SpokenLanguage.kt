package com.example.mws.data.model

import com.squareup.moshi.Json

data class SpokenLanguage(
	val name: String?,
	@Json(name = "iso_3166_1") val iso: String?,
)

