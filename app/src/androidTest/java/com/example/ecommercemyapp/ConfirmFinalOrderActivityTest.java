package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfirmFinalOrderActivityTest {

    @Rule
    public ActivityTestRule<ConfirmFinalOrderActivity> confirmFinalOrderActivityActivityTestRule= new ActivityTestRule<ConfirmFinalOrderActivity>(ConfirmFinalOrderActivity.class);

    private ConfirmFinalOrderActivity confirmFinalOrderActivity =null;

    @Before
    public void setUp() throws Exception {
        confirmFinalOrderActivity= confirmFinalOrderActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){



        Button confirmOrderBtn=confirmFinalOrderActivity.findViewById(R.id.confirm_final_order_btn);
        EditText nameEditText=confirmFinalOrderActivity.findViewById(R.id.shippment_name);
        EditText phoneEditText=confirmFinalOrderActivity.findViewById(R.id.shippment_phone_number);
        EditText addressEditText=confirmFinalOrderActivity.findViewById(R.id.shippment_address);
        EditText cityEditText=confirmFinalOrderActivity.findViewById(R.id.shippment_city);

        assertNotNull(confirmOrderBtn);
        assertNotNull(nameEditText);
        assertNotNull(phoneEditText);
        assertNotNull(addressEditText);
        assertNotNull(cityEditText);
    }

    @After
    public void tearDown() throws Exception {

        confirmFinalOrderActivity=null;
    }
}