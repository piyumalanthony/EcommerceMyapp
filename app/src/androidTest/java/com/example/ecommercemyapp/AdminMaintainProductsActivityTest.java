package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminMaintainProductsActivityTest {

    @Rule
    public ActivityTestRule<AdminMaintainProductsActivity> adminMaintainProductsActivityActivityTestRule= new ActivityTestRule<AdminMaintainProductsActivity>(AdminMaintainProductsActivity.class);

    private AdminMaintainProductsActivity adminMaintainProductsActivity =null;

    @Before
    public void setUp() throws Exception {
        adminMaintainProductsActivity= adminMaintainProductsActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button applyChangesBtn=adminMaintainProductsActivity.findViewById(R.id.apply_changes_btn);
        Button deleteButton=adminMaintainProductsActivity.findViewById(R.id.product_delete_btn);
        EditText name=adminMaintainProductsActivity.findViewById(R.id.product_name_maintain);
        EditText price=adminMaintainProductsActivity.findViewById(R.id.product_price_maintain);
        EditText description=adminMaintainProductsActivity.findViewById(R.id.product_description_maintain);
        ImageView imageView=adminMaintainProductsActivity.findViewById(R.id.product_image_maintain);

        assertNotNull(applyChangesBtn);
        assertNotNull(deleteButton);
        assertNotNull(name);
        assertNotNull(price);
        assertNotNull(description);
        assertNotNull(imageView);

    }

    @After
    public void tearDown() throws Exception {

        adminMaintainProductsActivity=null;
    }
}