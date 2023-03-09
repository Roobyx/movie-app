package com.example.mws.data.model

import com.squareup.moshi.Json

data class Movie(
	val adult: Boolean?,
	@Json(name = "backdrop_path") val backdropPath: String?,
	@Json(name = "belongs_to_collection") val belongsToCollection: Collection?,
	val budget: Int?,
	val genres: List<Genre>?,
	val homepage: String?,
	val id: Int?,
	@Json(name = "imdb_id") val imdbId: String?,
	@Json(name = "original_language") val originalLanguage: String?,
	@Json(name = "original_title") val originalTitle: String?,
	val overview: String?,
	val popularity: Double?,
	@Json(name = "poster_path") val posterPath: String?,
	@Json(name = "production_companies") val productionCompanies: List<ProductionCompany>?,
	@Json(name = "production_countries") val productionCountry: List<ProductionCountry>?,
	@Json(name = "release_date") val releaseDate: String?,
	val revenue: Int?,
	val runtime: Int?,
	@Json(name = "spokne_languages") val spokenLanguages: List<SpokenLanguage>?,
	val status: String?,
	val tagline: String?,
	val title: String?,
	val video: Boolean?,
	@Json(name = "vote_average") val voteAvarage: Double?,
	@Json(name = "vote_count") val voteCount: Int?,
)

