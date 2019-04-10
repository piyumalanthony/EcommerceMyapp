package com.example.ecommercemyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminAddProductActivity extends AppCompatActivity {

    //create components to add new items
    private String CategoryName;
    private Button AddNewProductionButton;
    private ImageView InputproductImage;
    private EditText InputProductName,InputProductDescription,InputProductPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_product);

        // craete componenets with respect to layout
        AddNewProductionButton=(Button) findViewById(R.id.add_new_product);
        InputproductImage=(ImageView) findViewById(R.id.select_product_image);
        InputProductName=(EditText) findViewById(R.id.product_name);
        InputProductDescription=(EditText) findViewById(R.id.product_description);
        InputProductPrice=(EditText) findViewById(R.id.product_price);



    }
}
