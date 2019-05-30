package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivity2Test {

    @Rule
    public ActivityTestRule<LoginActivity2> loginActivity2ActivityTestRule= new ActivityTestRule<LoginActivity2>(LoginActivity2.class);

    private LoginActivity2 loginActivity2=null;

    @Before
    public void setUp() throws Exception {
        loginActivity2= loginActivity2ActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button LoginButton = loginActivity2.findViewById(R.id.login_btn);
        EditText InputPhoneNumber=loginActivity2.findViewById(R.id.login_phone_number_input);
        EditText InputPassword=loginActivity2.findViewById(R.id.login_password_input);
        TextView AdminLink = loginActivity2.findViewById(R.id.admin_panel_link);
        TextView NotAdminLink = loginActivity2.findViewById(R.id.not_admin_panel_link);

        assertNotNull(LoginButton);
        assertNotNull(InputPassword);
        assertNotNull(InputPhoneNumber);
        assertNotNull(AdminLink);
        assertNotNull(NotAdminLink);

    }

    @After
    public void tearDown() throws Exception {

        loginActivity2=null;
    }
}