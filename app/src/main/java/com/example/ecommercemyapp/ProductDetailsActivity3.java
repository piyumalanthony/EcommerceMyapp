package com.example.ecommercemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProductDetailsActivity3 extends AppCompatActivity {

    private Button arView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details3);

        arView= (Button)findViewById(R.id.ar_view);
        textView=(TextView)findViewById(R.id.textView2);

        arView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductDetailsActivity3.this,ArViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
