package com.example.mws.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mws.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

	private var _binding: FragmentMoviesBinding? = null

	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val moviesViewModel =
			ViewModelProvider(this).get(MoviesViewModel::class.java)

		_binding = FragmentMoviesBinding.inflate(inflater, container, false)
		val root: View = binding.root

		val textView: TextView = binding.textMovies
		moviesViewModel.text.observe(viewLifecycleOwner) {
			textView.text = it
		}
		return root
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}