package com.example.ecommercemyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDetailsActivity3Test {

    @Rule
    public ActivityTestRule<ProductDetailsActivity3> productDetailsActivity3ActivityTestRule= new ActivityTestRule<ProductDetailsActivity3>(ProductDetailsActivity3.class);

    private ProductDetailsActivity3 productDetailsActivity3 =null;

    @Before
    public void setUp() throws Exception {
        productDetailsActivity3= productDetailsActivity3ActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){


        Button arView= productDetailsActivity3.findViewById(R.id.ar_view);
        Button addToCart= productDetailsActivity3.findViewById(R.id.add_to_cart);
        TextView textView=productDetailsActivity3.findViewById(R.id.textView2);
        TextView productName=productDetailsActivity3.findViewById(R.id.product_name_details1);
        TextView productPrice=productDetailsActivity3.findViewById(R.id.product_price_details1);
        TextView productDescription=productDetailsActivity3.findViewById(R.id.product_description_details1);
        ImageView productImage= productDetailsActivity3.findViewById(R.id.product_image_details1);

        assertNotNull(arView);
        assertNotNull(addToCart);
        assertNotNull(textView);
        assertNotNull(productName);
        assertNotNull(productPrice);
        assertNotNull(productDescription);
        assertNotNull(productImage);


    }

    @After
    public void tearDown() throws Exception {

        productDetailsActivity3=null;
    }
}