package com.example.ecommercemyapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class CartActivityTestNextProcess {


    @Rule
    public ActivityTestRule<CartActivity> cartActivityActivityTestRule =new ActivityTestRule<CartActivity>(CartActivity.class);

    private CartActivity cartActivity=null;
    Instrumentation.ActivityMonitor monitor= getInstrumentation().addMonitor(ConfirmFinalOrderActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        cartActivity= cartActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button NextProcessBtn=cartActivity.findViewById(R.id.next_process_btn);



        assertNotNull(NextProcessBtn);

        onView(withId(R.id.next_process_btn)).perform(click());

        Activity confirmActivity= getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(confirmActivity);

    }

    @After
    public void tearDown() throws Exception {

        cartActivity=null;
    }
}