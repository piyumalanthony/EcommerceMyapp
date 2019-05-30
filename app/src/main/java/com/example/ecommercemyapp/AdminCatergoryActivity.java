package com.example.ecommercemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCatergoryActivity extends AppCompatActivity {

    private ImageView chair, table, cupboard;
    private ImageView beds, table_and_chair;
    private ImageView sofa;// lamp;

    private Button LogOutButton, CheckOrderButton, MaintainProductsButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_catergory);

        LogOutButton  = (Button)findViewById(R.id.admin_log_out);
        CheckOrderButton  = (Button)findViewById(R.id.check_orders_btn);
        MaintainProductsButton  = (Button)findViewById(R.id.maintain_orders_btn);



        chair = (ImageView) findViewById(R.id.chair);
        table = (ImageView) findViewById(R.id.table);
        cupboard = (ImageView) findViewById(R.id.cupboard);

        beds= (ImageView) findViewById(R.id.beds);
        table_and_chair= (ImageView) findViewById(R.id.table_and_chair);


        sofa= (ImageView) findViewById(R.id.sofa);
        //lamp= (ImageView) findViewById(R.id.lamp);


        MaintainProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AdminCatergoryActivity.this, HomeActivity.class);
                intent.putExtra("Admin","Admin");
                startActivity(intent);

            }
        });

        //set onclick listeners to products storing
        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminCatergoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        CheckOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminCatergoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);


            }
        });


        chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "chair");
                startActivity(intent);
            }
        });


        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "table");
                startActivity(intent);
            }
        });


        cupboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "cupboards");
                startActivity(intent);
            }
        });


        beds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "beds");
                startActivity(intent);
            }
        });


        table_and_chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "table_and_chair");
                startActivity(intent);
            }
        });


        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "sofa");
                startActivity(intent);
            }
        });



        /*lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCatergoryActivity.this, AdminAddProductActivity.class);
                intent.putExtra("category", "lamp");
                startActivity(intent);
            }
        });*/



    }
}
