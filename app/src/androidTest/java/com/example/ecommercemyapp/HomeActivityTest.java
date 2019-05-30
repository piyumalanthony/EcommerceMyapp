package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule= new ActivityTestRule<HomeActivity>(HomeActivity.class);

    private HomeActivity homeActivity =null;

    @Before
    public void setUp() throws Exception {
        homeActivity= homeActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        RecyclerView recyclerView= homeActivity.findViewById(R.id.recycler_menu);

        assertNotNull(recyclerView);

    }

    @After
    public void tearDown() throws Exception {

        homeActivity=null;
    }
}