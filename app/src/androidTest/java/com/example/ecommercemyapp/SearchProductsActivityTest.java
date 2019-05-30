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

public class SearchProductsActivityTest {

    @Rule
    public ActivityTestRule<SearchProductsActivity> searchProductsActivityActivityTestRule= new ActivityTestRule<SearchProductsActivity>(SearchProductsActivity.class);

    private SearchProductsActivity searchProductsActivity=null;

    @Before
    public void setUp() throws Exception {
        searchProductsActivity= searchProductsActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        Button SearchBtn=searchProductsActivity.findViewById(R.id.search_btn);
        EditText inputText=searchProductsActivity.findViewById(R.id.search_product_name);
        RecyclerView searchList=searchProductsActivity.findViewById(R.id.search_list);

        assertNotNull(SearchBtn);
        assertNotNull(inputText);
        assertNotNull(searchList);


    }

    @After
    public void tearDown() throws Exception {

       searchProductsActivity=null;
    }
}