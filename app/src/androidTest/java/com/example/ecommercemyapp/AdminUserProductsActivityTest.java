package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminUserProductsActivityTest {

    @Rule
    public ActivityTestRule<AdminUserProductsActivity> adminUserProductsActivityActivityTestRule= new ActivityTestRule<AdminUserProductsActivity>(AdminUserProductsActivity.class);

    private AdminUserProductsActivity adminUserProductsActivity =null;

    @Before
    public void setUp() throws Exception {
        adminUserProductsActivity= adminUserProductsActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        RecyclerView productsList= adminUserProductsActivity.findViewById(R.id.product_list);

        assertNotNull(productsList);

    }

    @After
    public void tearDown() throws Exception {

        adminUserProductsActivity=null;
    }
}