package com.example.ecommercemyapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.ImageView;
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

public class ProductDetailsActivity3TestarView {

    @Rule
    public ActivityTestRule<ProductDetailsActivity3> productDetailsActivity3ActivityTestRule= new ActivityTestRule<ProductDetailsActivity3>(ProductDetailsActivity3.class);

    private ProductDetailsActivity3 productDetailsActivity3 =null;
    Instrumentation.ActivityMonitor monitor= getInstrumentation().addMonitor(ArViewActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        productDetailsActivity3= productDetailsActivity3ActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button arView= productDetailsActivity3.findViewById(R.id.ar_view);

        assertNotNull(arView);
        onView(withId(R.id.ar_view)).perform(click());

        Activity arViewActivity= getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(arViewActivity);


    }

    @After
    public void tearDown() throws Exception {

        productDetailsActivity3=null;
    }
}