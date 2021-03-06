package com.example.marvelapplication.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.marvelapplication.R
import com.example.marvelapplication.presentation.base.BaseFragment
import com.example.marvelapplication.utils.Consts
import kotlinx.android.synthetic.main.detail_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private val viewModel by viewModel<DetailViewModel>()

    override fun bindLayout(): Int = R.layout.detail_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()

        setViewModel()
    }

    private fun setViewModel() {
        viewModel.getCharacterFromDB(requireArguments().getInt(Consts.CHARACTER_ID_TEXT))

        viewModel.getCharacterLiveData().observe(viewLifecycleOwner, Observer {
            Glide.with(context)
                .load(it.thumbnail)
                .placeholder(R.mipmap.ic_placeholder)
                .centerCrop()
                .into(character_image_iv)
            character_name_value_tv.text = it.name
            character_description_tv.text = it.description
            hideProgressBar()
        })
    }
}