package com.example.ecommercemyapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class AdminMaintainProductsActivity extends AppCompatActivity {


    private Button applyChangesBtn, deleteButton;
    private EditText name,price, description;
    private ImageView imageView;

    private String productID="";
    DatabaseReference productsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maintain_products);

        productID=getIntent().getStringExtra("pid");
        productsRef= FirebaseDatabase.getInstance().getReference().child("Products").child(productID);


        applyChangesBtn=(Button)findViewById(R.id.apply_changes_btn);
        deleteButton=(Button)findViewById(R.id.product_delete_btn);
        name=(EditText)findViewById(R.id.product_name_maintain);
        price=(EditText)findViewById(R.id.product_price_maintain);
        description=(EditText)findViewById(R.id.product_description_maintain);
        imageView=(ImageView)findViewById(R.id.product_image_maintain);
        
        displaySpecificProductInfo();

        applyChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                applyChanges();
                
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                deleteProduct();
                
            }
        });
    }

    private void deleteProduct() {

        productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCatergoryActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(AdminMaintainProductsActivity.this, "Product is deleted successfully.", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void applyChanges() {

        String pName = name.getText().toString();
        String pPrice = price.getText().toString();
        String pDescription = description.getText().toString();

        if(pName.equals("")){
            Toast.makeText(this, "Please write down the product name.", Toast.LENGTH_LONG).show();
        }
        else if(pPrice.equals("")){
            Toast.makeText(this, "Please write down the product price.", Toast.LENGTH_LONG).show();
        }
        else if(pDescription.equals("")){
            Toast.makeText(this, "Please write down the product description.", Toast.LENGTH_LONG).show();
        }
        else{

            HashMap<String, Object> productMap = new HashMap<>();
            productMap.put("pid", productID);
            productMap.put("description", pDescription);
            productMap.put("price", pPrice);
            productMap.put("pname", pName);

            productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful()){
                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCatergoryActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            });

        }

    }

    private void displaySpecificProductInfo() {

        productsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    String pName= dataSnapshot.child("pname").getValue().toString();
                    String pPrice= dataSnapshot.child("price").getValue().toString();
                    String pDescription= dataSnapshot.child("description").getValue().toString();
                    String pImage= dataSnapshot.child("image").getValue().toString();

                    name.setText(pName);
                    price.setText(pPrice);
                    description.setText(pDescription);
                    Picasso.get().load(pImage).into(imageView);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
