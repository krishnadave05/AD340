
package com.example.helloworld;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void displaysAge(){
        onView(withId(R.id.et_age)).check(matches(withText("Enter your age")));
    }
    @Test
    public void MissingUsername() {
        onView(withId(R.id.et_full_name)).perform(replaceText("Krishna Dave"));
        onView(withId(R.id.et_email_addr)).perform(replaceText("abc@xyz.com"));
        onView(withId(R.id.et_bio)).perform(replaceText("This is bio"));
        onView(withId(R.id.et_user_name)).perform(replaceText("KD05"));
        onView(withId(R.id.et_age)).perform(replaceText("23"));
        onView(withId(R.id.et_occupation)).perform(replaceText("Student"));
        onView(withId(R.id.et_mobile)).perform(replaceText("1122334455"));
        onView(withId(android.R.id.button1)).perform(click());
    }}