package com.example.marvelapplication.ui.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.marvelapplication.R
import com.example.marvelapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.detail_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private val viewModel by viewModel<DetailViewModel>()

    override fun bindLayout(): Int = R.layout.detail_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showProgressBar()

        val characterId: Int = requireArguments().getInt("character_id")

        viewModel.getCharacter(characterId)

        setViewModel()
    }

    private fun setViewModel() {
        viewModel.getCharacterLiveData().observe(viewLifecycleOwner, Observer {
            Glide.with(context)
                .load(it[0].thumbnail.path + "." + it[0].thumbnail.extension)
                .placeholder(R.mipmap.ic_placeholder)
                .centerCrop()
                .into(character_image_iv)
            character_name_value_tv.text = it[0].name
            character_description_tv.text = it[0].description
            hideProgressBar()
        })
    }
}