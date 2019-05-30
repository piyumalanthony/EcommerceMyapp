package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import com.google.ar.sceneform.ux.ArFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArViewActivityTest {

    @Rule
    public ActivityTestRule<ArViewActivity> arViewActivityActivityTestRule= new ActivityTestRule<ArViewActivity>(ArViewActivity.class);

    private ArViewActivity arViewActivity =null;

    @Before
    public void setUp() throws Exception {
        arViewActivity= arViewActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        ArFragment arFragment= (ArFragment) arViewActivity.getSupportFragmentManager().findFragmentById(R.id.arFragment);

        assertNotNull(arFragment);

    }

    @After
    public void tearDown() throws Exception {

        arViewActivity=null;
    }
}