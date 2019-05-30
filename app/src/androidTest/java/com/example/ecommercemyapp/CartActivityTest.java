package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartActivityTest {


    @Rule
    public ActivityTestRule<CartActivity> cartActivityActivityTestRule =new ActivityTestRule<CartActivity>(CartActivity.class);

    private CartActivity cartActivity=null;

    @Before
    public void setUp() throws Exception {
        cartActivity= cartActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        RecyclerView recyclerView= cartActivity.findViewById(R.id.cart_list);
        Button NextProcessBtn=cartActivity.findViewById(R.id.next_process_btn);
        TextView txtTotalAmount=cartActivity.findViewById(R.id.total_price);
        TextView txtMsg1=cartActivity.findViewById(R.id.msg1);

        assertNotNull(recyclerView);
        assertNotNull(NextProcessBtn);
        assertNotNull(txtTotalAmount);
        assertNotNull(txtMsg1);
    }

    @After
    public void tearDown() throws Exception {

        cartActivity=null;
    }
}