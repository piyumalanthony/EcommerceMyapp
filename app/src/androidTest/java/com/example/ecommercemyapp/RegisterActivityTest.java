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

public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> registerActivityActivityTestRule= new ActivityTestRule<RegisterActivity>(RegisterActivity.class);

    private RegisterActivity registerActivity =null;

    @Before
    public void setUp() throws Exception {
        registerActivity= registerActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button CreateAccountButton = registerActivity.findViewById(R.id.register_btn);
        EditText InputName=registerActivity.findViewById(R.id.register_username_input);
        EditText InputPhoneNumber=registerActivity.findViewById(R.id.register_phone_number_input);
        EditText InputPassword=registerActivity.findViewById(R.id.register_password_input);
        assertNotNull(CreateAccountButton);
        assertNotNull(InputName);
        assertNotNull(InputPhoneNumber);
        assertNotNull(InputPassword);


    }

    @After
    public void tearDown() throws Exception {

        registerActivity=null;
    }
}