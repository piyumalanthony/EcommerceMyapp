package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminCatergoryActivityTest {

    @Rule
    public ActivityTestRule<AdminCatergoryActivity> adminCatergoryActivityActivityTestRule= new ActivityTestRule<AdminCatergoryActivity>(AdminCatergoryActivity.class);

    private AdminCatergoryActivity adminCatergoryActivity =null;

    @Before
    public void setUp() throws Exception {
        adminCatergoryActivity= adminCatergoryActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button LogOutButton  = adminCatergoryActivity.findViewById(R.id.admin_log_out);
        Button CheckOrderButton  = adminCatergoryActivity.findViewById(R.id.check_orders_btn);
        Button MaintainProductsButton  = adminCatergoryActivity.findViewById(R.id.maintain_orders_btn);
        ImageView chair = adminCatergoryActivity.findViewById(R.id.chair);
        ImageView table = adminCatergoryActivity.findViewById(R.id.table);
        ImageView cupboard = adminCatergoryActivity.findViewById(R.id.cupboard);
        ImageView beds= adminCatergoryActivity.findViewById(R.id.beds);
        ImageView table_and_chair= adminCatergoryActivity.findViewById(R.id.table_and_chair);
        ImageView sofa= adminCatergoryActivity.findViewById(R.id.sofa);

        assertNotNull(LogOutButton);
        assertNotNull(CheckOrderButton);
        assertNotNull(MaintainProductsButton);
        assertNotNull(chair);
        assertNotNull(table);
        assertNotNull(cupboard);
        assertNotNull(beds);
        assertNotNull(table_and_chair);
        assertNotNull(sofa);

    }

    @After
    public void tearDown() throws Exception {

        adminCatergoryActivity=null;
    }
}