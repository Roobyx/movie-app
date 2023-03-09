package com.example.mws.data.model

import com.squareup.moshi.Json

data class Network(
	val name: String?,
	val id: Int?,
	@Json(name = "logo_path") val logoPath: String?,
	@Json(name = "origin_country") val originCountry: String?,
)