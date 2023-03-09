package com.example.mws.ui.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mws.R
import com.example.mws.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {
//	private var _binding: FragmentMoviesBinding? = null
//	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		val binding: FragmentMoviesBinding = DataBindingUtil.inflate(
			inflater, R.layout.fragment_movies, container, false
		)

		val moviesViewModel =
			ViewModelProvider(this)[MoviesViewModel::class.java]

		binding.viewModel = moviesViewModel
		binding.lifecycleOwner = this

//		_binding = FragmentMoviesBinding.inflate(inflater, container, false)
		val root: View = binding.root

		val adapter = MoviesAdapter()
		binding.moviesList.adapter = adapter

		moviesViewModel.movie.observe(viewLifecycleOwner, Observer {
			it?.let {
				adapter.data = it
			}
		})

//		val textView: TextView = binding.textMediaTitle
//		moviesViewModel.response.observe(viewLifecycleOwner) {
//			textView.text = it
//		}

		moviesViewModel.response
		return root
	}

//	override fun onDestroyView() {
//		super.onDestroyView()
//		_binding = null
//	}
}