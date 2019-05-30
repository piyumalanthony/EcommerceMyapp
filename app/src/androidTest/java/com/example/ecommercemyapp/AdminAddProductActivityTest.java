package com.example.ecommercemyapp;

import android.app.ProgressDialog;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminAddProductActivityTest {

    @Rule
    public ActivityTestRule<AdminAddProductActivity> adminProductActivityActivityActivityTestRule= new ActivityTestRule<AdminAddProductActivity>(AdminAddProductActivity.class);

    private AdminAddProductActivity adminAddProductActivity =null;

    @Before
    public void setUp() throws Exception {

        adminAddProductActivity= adminProductActivityActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button AddNewProductButton = adminAddProductActivity.findViewById(R.id.add_new_product);
        ImageView InputProductImage = adminAddProductActivity.findViewById(R.id.select_product_image);
        EditText InputProductName = adminAddProductActivity.findViewById(R.id.product_name);
        EditText InputProductDescription = adminAddProductActivity.findViewById(R.id.product_description);
        EditText InputProductPrice = adminAddProductActivity.findViewById(R.id.product_price);
        EditText ARname = adminAddProductActivity.findViewById(R.id.ar_name);
        assertNotNull(AddNewProductButton);
        assertNotNull(InputProductImage);
        assertNotNull(InputProductName);
        assertNotNull(InputProductDescription);
        assertNotNull(InputProductPrice);
        assertNotNull(ARname);


    }

    @After
    public void tearDown() throws Exception {

        adminAddProductActivity=null;
    }
}