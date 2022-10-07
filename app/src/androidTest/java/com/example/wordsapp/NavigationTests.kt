package com.example.wordsapp

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTests {

    lateinit var navController: TestNavHostController
    lateinit var letterListScenario: FragmentScenario<LetterListFragment>

    @Before
    fun setup() {

        // create a test instance of the navigation controller
        navController = TestNavHostController(
            // get context
            ApplicationProvider.getApplicationContext()
        )

        // Isolate a fragment for testing
        val letterListScenario = launchFragmentInContainer<LetterListFragment>(themeResId = R.style.Theme_Words)
        // We want to launch LetterListFragment. And we have to pass the app's theme so that
        // the UI component knows which theme to use or the test may crash.

        // Then we need to declare which navigation graph
        // we want the nav controller to use for the fragment launched.
        letterListScenario.onFragment{ fragment ->

            navController.setGraph(R.navigation.nav_graph)

            Navigation.setViewNavController(fragment.requireView(), navController)
        }
    }

    @Test
    fun navigate_to_words_nav_component() {
        // Trigger the event that prompts the navigation.
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click())
            )

        assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
    }
}