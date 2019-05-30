package com.example.ecommercemyapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTestLogin {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity =null;
    Instrumentation.ActivityMonitor monitor= getInstrumentation().addMonitor(LoginActivity2.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {

        mainActivity =mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view= mainActivity.findViewById(R.id.app_slogan);
        Button joinNowButton= mainActivity.findViewById(R.id.main_join_now_btn);
        Button loginButton=mainActivity.findViewById(R.id.main_login_btn);
        assertNotNull(view);
        assertNotNull(joinNowButton);
        assertNotNull(loginButton);

        onView(withId(R.id.main_login_btn)).perform(click());

        Activity loginActivity= getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(loginActivity);
    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }
}