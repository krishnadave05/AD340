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
    public void checkWithMissingUsername() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("23"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("krishna555")).check(doesNotExist());

    }

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



    @Test
    public void checkWithMissingEmail() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("23"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("krishnadave@gmail.com")).check(doesNotExist());

    }

    @Test
    public void checkWithWrongEmail() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("23"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("krishnadave@gmail.com")).check(doesNotExist());

    }

    @Test
    public void checkWithMissingBio() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("23"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("Hey, I am ready for friendship.")).check(doesNotExist());

    }

    @Test
    public void checkWithMissingAge() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("23")).check(doesNotExist());

    }

    @Test
    public void checkWithWrongAge() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("12"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("23")).check(doesNotExist());

    }

    @Test
    public void checkWithMissingOccupation() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("12"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("9929988288"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("Software Developer")).check(doesNotExist());

    }

    @Test
    public void checkWithMissingMobileNumber() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("12"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("9929988288")).check(doesNotExist());

    }

    @Test
    public void checkWithWrongMobileNumber() {

        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"), closeSoftKeyboard());
        onView(withId(R.id.et_email_addr)).perform(replaceText("krishnadave1234@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.et_bio)).perform(replaceText("Hey, I am ready for friendship."), closeSoftKeyboard());
        onView(withId(R.id.et_user_name)).perform(replaceText("krishna111"), closeSoftKeyboard());
        onView(withId(R.id.et_age)).perform(replaceText("12"), closeSoftKeyboard());
        onView(withId(R.id.et_occupation)).perform(replaceText("Software Developer"), closeSoftKeyboard());
        onView(withId(R.id.et_mobile)).perform(replaceText("99299882889999"), closeSoftKeyboard());

        onView(withId(R.id.btn_register))
                .perform(scrollTo(), click());

        onView(withText("9929988288")).check(doesNotExist());

    }

}