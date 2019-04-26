package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity =null;
    @Before
    public void setUp() throws Exception {

        mainActivity =mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view= mainActivity.findViewById(R.id.app_slogan);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }
}