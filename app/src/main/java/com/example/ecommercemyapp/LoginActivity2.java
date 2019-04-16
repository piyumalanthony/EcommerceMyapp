package com.example.ecommercemyapp;

import android.app.ProgressDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommercemyapp.Model.Users;
import com.example.ecommercemyapp.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import io.paperdb.Paper;

public class LoginActivity2 extends AppCompatActivity {

    //create input fields
    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink;

    //declare varible for database reference
    private String parentDbName="Users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //create components for events
        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPhoneNumber=(EditText) findViewById(R.id.login_phone_number_input);
        InputPassword=(EditText) findViewById(R.id.login_password_input);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView) findViewById(R.id.not_admin_panel_link);
        loadingBar= new ProgressDialog(this);


        //Paper.init(this);

        // login event
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";
            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }
    //implement LoginUser method
    private void LoginUser(){
        String phone= InputPhoneNumber.getText().toString();
        String password= InputPassword.getText().toString();

        //check whether phone field is empty
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        //check whether password field is empty
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        //load the loading bar
        else{
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking credentials.....");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            //method for account details verification
            AllowAccessToAccount(phone,password);
        }

    }
    //implementation of account verification method
    private void AllowAccessToAccount(final String phone, final String password) {

        //if(chkBoxRememberMe.isChecked()){
        //Paper.book().write(Prevalent.UserPhoneKey,phone);
        //Paper.book().write(Prevalent.UserPasswordKey,password);
        //}

        //take database reference
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(parentDbName).child(phone).exists()) {

                    Users usersData= dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);

                    if(usersData.getPhone().equals(phone)){
                        if(usersData.getPassword().equals(password)){
                            if(parentDbName.equals("Admins")){
                                Toast.makeText(LoginActivity2.this, "Logged in successfully....", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent=new Intent(LoginActivity2.this,AdminCatergoryActivity.class);
                                startActivity(intent);
                            }
                            else if(parentDbName.equals("Users")){
                                Toast.makeText(LoginActivity2.this, "Logged in successfully....", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent=new Intent(LoginActivity2.this,HomeActivity.class);
                                Prevalent.currentOnlineUser=usersData;
                                startActivity(intent);
                            }
                        }
                        else{
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity2.this, "Incorrect password....", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(LoginActivity2.this, "Account with this phone number do not exists..", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity2.this, "Try to create new account.....", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
