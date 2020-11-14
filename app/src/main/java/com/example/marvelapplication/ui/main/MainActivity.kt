package com.example.marvelapplication.ui.main


import androidx.appcompat.widget.Toolbar
import com.example.marvelapplication.R
import com.example.marvelapplication.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getContentView(): Int = R.layout.activity_main

    override fun getMyActionBar(): Toolbar = toolbar

}