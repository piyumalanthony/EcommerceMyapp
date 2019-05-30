package com.example.ecommercemyapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommercemyapp.Model.Products;
import com.example.ecommercemyapp.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class ProductDetailsActivity3 extends AppCompatActivity {

    private Button arView,addToCart;
    private TextView textView,productName,productDescription,productPrice;
    private ImageView productImage;
    private String productID= "", state="Normal";
    private String productNameAR="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details3);

        productID= getIntent().getStringExtra("pid");
        productNameAR= getIntent().getStringExtra("pName");


        arView= (Button)findViewById(R.id.ar_view);
        addToCart= (Button)findViewById(R.id.add_to_cart);
        textView=(TextView)findViewById(R.id.textView2);
        productName=(TextView)findViewById(R.id.product_name_details1);
        productPrice=(TextView)findViewById(R.id.product_price_details1);
        productDescription=(TextView)findViewById(R.id.product_description_details1);
        productImage= (ImageView) findViewById(R.id.product_image_details1);

        getProductDetails(productID);

        arView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductDetailsActivity3.this,ArViewActivity.class);
                intent.putExtra("productNameForFetch",productNameAR);
                startActivity(intent);
            }
        });
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                


                if(state.equals("Order Placed") || state.equals("Order Shipped")){
                    Toast.makeText(ProductDetailsActivity3.this, "You can purchase more orders once you recieve your order", Toast.LENGTH_LONG).show();
                }
                else{
                    addingToCartList();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        CheckOrderState();
    }

    private void addingToCartList() {

        String saveCurrentTime, saveCurrentDate;

        Calendar calForDate= Calendar.getInstance();
        SimpleDateFormat currentDate= new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate=currentDate.format(calForDate.getTime());


        SimpleDateFormat currentTime= new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentDate.format(calForDate.getTime());

        final DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("Cart List");

        final HashMap<String, Object>  cartMap= new HashMap<>();
        cartMap.put("pid", productID);
        cartMap.put("pname", productName.getText().toString());
        cartMap.put("price", productPrice.getText().toString());
        cartMap.put("date", saveCurrentDate);
        cartMap.put("time", saveCurrentTime);
        cartMap.put("discount", "");

        cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone())
                .child("Products").child(productID)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){

                            cartListRef.child("Admin View").child(Prevalent.currentOnlineUser.getPhone())
                                    .child("Products").child(productID)
                                    .updateChildren(cartMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(ProductDetailsActivity3.this, "Added to cart List", Toast.LENGTH_SHORT).show();

                                                Intent intent=new Intent(ProductDetailsActivity3.this, HomeActivity.class);
                                                startActivity(intent);
                                            }
                                        }
                                    });

                        }

                    }
                });
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

    private void CheckOrderState(){

        DatabaseReference ordersRef;
        ordersRef= FirebaseDatabase.getInstance().getReference().child("orders")
                .child(Prevalent.currentOnlineUser.getPhone());


        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    String shippingState = dataSnapshot.child("state").getValue().toString();

                    if(shippingState.equals("shipped")){

                        state= "Order Shipped";
                    }
                    else if(shippingState.equals("not shipped")){

                        state ="Order Placed";

                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
