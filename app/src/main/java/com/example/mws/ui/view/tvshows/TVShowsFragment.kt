package com.example.mws.ui.view.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mws.R
import com.example.mws.databinding.FragmentTvshowsBinding

class TVShowsFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		val binding: FragmentTvshowsBinding = DataBindingUtil.inflate(
			inflater, R.layout.fragment_tvshows, container, false
		)

		val tvShowsViewModel =
			ViewModelProvider(this)[TVShowsViewModel::class.java]

		binding.viewModel = tvShowsViewModel
		binding.lifecycleOwner = this

		val root: View = binding.root

		val adapter = TVShowCardAdapter()
		binding.tvShowsList.adapter = adapter

		tvShowsViewModel.tvShow.observe(viewLifecycleOwner, Observer {
			it?.let {
				adapter.data = it
			}
		})

		tvShowsViewModel.response
		return root
	}
}