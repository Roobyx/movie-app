package com.example.mws.data.model

import com.squareup.moshi.Json

data class ProductionCountry(
	val name: String?,
	@Json(name = "iso_639_1") val iso: String?,
)

