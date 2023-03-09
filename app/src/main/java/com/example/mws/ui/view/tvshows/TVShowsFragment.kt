package com.example.mws.ui.view.tvshows

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mws.databinding.FragmentTvshowsBinding
import io.github.cdimascio.dotenv.dotenv

val dotenv = dotenv {
	directory = "/assets"
	filename = "env"
}
val mwsApiKey: String = dotenv["TMDB_API_KEY"]

class TVShowsFragment : Fragment() {

	private var _binding: FragmentTvshowsBinding? = null
	private val binding get() = _binding!!

	@SuppressLint("LogNotTimber")
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		val tvShowsViewModel =
			ViewModelProvider(this)[TVShowsViewModel::class.java]


		_binding = FragmentTvshowsBinding.inflate(inflater, container, false)
		val root: View = binding.root

		val textView: TextView = binding.textTvshows
		tvShowsViewModel.text.observe(viewLifecycleOwner) {
			textView.text = it
		}
		Log.i("DEBUG", "mws env key?: ---------------------> $mwsApiKey")
		return root
	}


	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}