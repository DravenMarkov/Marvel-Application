package com.example.marvelapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class CoroutinesRules : TestWatcher() {


    val testDistpatcher = TestCoroutineDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDistpatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        testDistpatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}