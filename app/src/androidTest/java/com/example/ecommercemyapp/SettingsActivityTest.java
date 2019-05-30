package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import de.hdodenhof.circleimageview.CircleImageView;

import static org.junit.Assert.*;

public class SettingsActivityTest {

    @Rule
    public ActivityTestRule<SettingsActivity> settingsActivityActivityTestRule= new ActivityTestRule<SettingsActivity>(SettingsActivity.class);

    private SettingsActivity settingsActivity =null;

    @Before
    public void setUp() throws Exception {
       settingsActivity= settingsActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        CircleImageView profileImageView = settingsActivity.findViewById(R.id.settings_profile_image);
        EditText fullNameEditText = settingsActivity.findViewById(R.id.settings_full_name);
        EditText userPhoneEditText = settingsActivity.findViewById(R.id.settings_phone_number);
        EditText addressEditText = settingsActivity.findViewById(R.id.settings_address);
        TextView profileChangeTextBtn = settingsActivity.findViewById(R.id.profile_image_change_btn);
        TextView closeTextBtn = settingsActivity.findViewById(R.id.close_settings_btn);
        TextView saveTextButton = settingsActivity.findViewById(R.id.update_account_settings_btn);


        assertNotNull(profileImageView);
        assertNotNull(fullNameEditText);
        assertNotNull(userPhoneEditText);
        assertNotNull(addressEditText);
        assertNotNull(profileChangeTextBtn);
        assertNotNull(closeTextBtn);
        assertNotNull(saveTextButton);

    }

    @After
    public void tearDown() throws Exception {

        settingsActivity=null;
    }
}