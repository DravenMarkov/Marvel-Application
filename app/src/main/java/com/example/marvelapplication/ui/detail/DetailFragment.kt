package com.example.marvelapplication.ui.detail

import com.example.marvelapplication.R
import com.example.marvelapplication.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    val viewModel by viewModel<DetailViewModel>()

    override fun bindLayout(): Int = R.layout.detail_fragment
}