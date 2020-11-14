package com.example.marvelapplication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        setSupportActionBar(getMyActionBar())
    }

    protected abstract fun getMyActionBar(): Toolbar
    protected abstract fun getContentView(): Int
}