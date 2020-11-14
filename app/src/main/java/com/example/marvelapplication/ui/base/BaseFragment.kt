package com.example.marvelapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(bindLayout(), container, false)
    }

    @LayoutRes
    abstract fun bindLayout(): Int

    protected fun showProgressBar() {
        activity?.progressbar?.visibility = View.VISIBLE
    }

    protected fun hideProgressBar() {
        activity?.progressbar?.visibility = View.GONE
    }
}