package com.example.mws.data.model

import com.squareup.moshi.Json

data class ProductionCompany(
	val id: Int?,
	val name: String?,
	@Json(name = "logo_path") val logoPath: String?,
	@Json(name = "origin_country") val originCountry: String?,
)

