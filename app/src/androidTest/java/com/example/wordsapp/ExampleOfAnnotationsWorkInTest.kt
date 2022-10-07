package com.example.wordsapp

import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleOfAnnotationsWorkInTest {

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            println("Set up class")
        }

        @AfterClass
        @JvmStatic
        fun tearDownClass() {
            println("Tear down class")
        }
    }

    @Before
    fun setUpFunction() {
        println("Set up function")
    }

    @Test
    fun test_a() {
        print("Test a")
    }

    @Test
    fun test_b() {
        print("Test b")
    }

    @Test
    fun test_c() {
        print("Test c")
    }

    @After
    fun teatDownFunction() {
        println("Tear down function")
    }
}