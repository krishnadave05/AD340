package com.example.helloworld;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);



    @Test
    public void checkWithWrongUsername() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna555"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("23"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("krishna111")).check(doesNotExist());

    }

    @Test
    public void checkWithMissingName() {

        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("23"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("Krishna Dave")).check(doesNotExist());

    }



}