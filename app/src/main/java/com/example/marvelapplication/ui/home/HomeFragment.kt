package com.example.marvelapplication.ui.home

import android.os.Bundle
import android.view.View
import com.example.marvelapplication.R
import com.example.marvelapplication.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    val viewModel by viewModel<HomeViewModel>()

    override fun bindLayout(): Int = R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()
    }
}