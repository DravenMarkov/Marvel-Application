package com.example.marvelapplication.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapplication.R
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import com.example.marvelapplication.ui.base.BaseFragment
import com.example.marvelapplication.ui.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment() {

    val viewModel by viewModel<HomeViewModel>()

    private lateinit var adapter: HomeAdapter

    override fun bindLayout(): Int = R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getListCharacters()
        showProgressBar()

        setAdapter()

        setViewModel()

        character_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    showProgressBar()
                    viewModel.getListCharacters()
                }
            }
        })

    }

    private fun setAdapter() {
        adapter = HomeAdapter(requireContext())
        character_recycler.adapter = this.adapter
        adapter.onItemClick = {
            findNavController().navigate(
                R.id.action_home_to_detail_dest,
                bundleOf("character_id" to it.id)
            )
        }
    }

    private fun setViewModel() {
        viewModel.getListCharactersLiveData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it as MutableList<MarvelCharactersEntity.Data.Result>)
            adapter.notifyDataSetChanged()
            hideProgressBar()
        })
    }
}