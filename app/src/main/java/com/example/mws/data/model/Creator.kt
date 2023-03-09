package com.example.mws.data.model

import com.squareup.moshi.Json

data class Creator(
	val id: Int?,
	@Json(name = "credit_id") val creditId: String?,
	val name: String?,
	val gender: Int?,
	@Json(name = "profile_path") val profilePath: String?,
)