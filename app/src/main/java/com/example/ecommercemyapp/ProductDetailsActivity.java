package com.example.ecommercemyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ecommercemyapp.Model.Products;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.Button;
import com.rey.material.widget.FloatingActionButton;
import com.rey.material.widget.ImageView;
import com.rey.material.widget.TextView;
import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {

    //private FloatingActionButton addToCartBtn;
    private ImageView productImage;
    //private Button viewInAR;
    private TextView productPrice, productDescription, productName;
    private String productID= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productID= getIntent().getStringExtra("pid");

        //addToCartBtn = (FloatingActionButton) findViewById(R.id.add_product_to_cart);
        //viewInAR = (Button) findViewById(R.id.view_in_ar);
        productPrice=(TextView) findViewById(R.id.product_price);
        productDescription=(TextView) findViewById(R.id.product_description);
        productName=(TextView) findViewById(R.id.product_name);
        productImage=(ImageView) findViewById(R.id.product_image_details);
        
        getProductDetails(productID);
    }

    private void getProductDetails(String productID) {

        DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Products");

        productsRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    Products products= dataSnapshot.getValue(Products.class);

                    productName.setText(products.getPname());
                    productPrice.setText(products.getPrice());
                    productDescription.setText(products.getDescription());
                    Picasso.get().load(products.getImage()).into(productImage);

                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
