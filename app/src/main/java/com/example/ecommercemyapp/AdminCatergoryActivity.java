package com.example.ecommercemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCatergoryActivity extends AppCompatActivity {

    private ImageView chair, table, cupboard;
    private ImageView beds, table_and_chair;
    private ImageView sofa, lamp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_catergory);


        chair = (ImageView) findViewById(R.id.chair);
        table = (ImageView) findViewById(R.id.table);
        cupboard = (ImageView) findViewById(R.id.cupboard);

        beds= (ImageView) findViewById(R.id.beds);
        table_and_chair= (ImageView) findViewById(R.id.table_and_chair);


        sofa= (ImageView) findViewById(R.id.sofa);
        lamp= (ImageView) findViewById(R.id.lamp);


        chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });


        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "Sports tShirts");
                startActivity(intent);
            }
        });


        cupboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "Female Dresses");
                startActivity(intent);
            }
        });


        beds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });


        table_and_chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });


        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "Hats Caps");
                startActivity(intent);
            }
        });



        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "Wallets Bags Purses");
                startActivity(intent);
            }
        });



    }
}
