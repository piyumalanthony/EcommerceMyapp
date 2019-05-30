package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminNewOrdersActivityTest {

    @Rule
    public ActivityTestRule<AdminNewOrdersActivity> adminNewOrdersActivityActivityTestRule= new ActivityTestRule<AdminNewOrdersActivity>(AdminNewOrdersActivity.class);

    private AdminNewOrdersActivity adminNewOrdersActivity =null;

    @Before
    public void setUp() throws Exception {
        adminNewOrdersActivity= adminNewOrdersActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        RecyclerView ordersList= adminNewOrdersActivity.findViewById(R.id.orders_list);

        assertNotNull(ordersList);

    }

    @After
    public void tearDown() throws Exception {

        adminNewOrdersActivity=null;
    }
}