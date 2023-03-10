package com.example.mws.data.parcels

import android.os.Parcelable

abstract class MovieData(
	val id: String,
	val title: String,
) : Parcelable