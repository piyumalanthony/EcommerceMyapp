package com.example.ecommercemyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    //Register and create account
    private Button CreateAccountButton;
    private EditText InputName,InputPhoneNumber,InputPassword;
    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //create components for events
        CreateAccountButton = (Button) findViewById(R.id.register_btn);
        InputName=(EditText) findViewById(R.id.register_username_input);
        InputPhoneNumber=(EditText) findViewById(R.id.register_phone_number_input);
        InputPassword=(EditText) findViewById(R.id.register_password_input);
        loadingBar= new ProgressDialog(this);

        //create event listener to the createAccount button
        CreateAccountButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               CreateAccount();
            }
        });
    }
    private void CreateAccount(){
        //Input field for account creation
        String name= InputName.getText().toString();
        String phone= InputPhoneNumber.getText().toString();
        String password= InputPassword.getText().toString();


        //check whether name field is empty
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please write your name...", Toast.LENGTH_SHORT).show();
        }
        //check whether phone field is empty
        else if(TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        //check whether password field is empty
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking credentials.....");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            // call for validation method
            ValidatePhoneNumber(name,phone,password);
        }
    }

    //Implementation of validation method
    private void ValidatePhoneNumber(final String name, final String phone, final String password) {

        //take database reference
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        //store values to database
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(phone).exists())){
                    HashMap<String,Object> userdataMap= new HashMap<>();
                    userdataMap.put("phone", phone);
                    userdataMap.put("password",password);
                    userdataMap.put("name",name);

                    // update the user account with data provided
                    RootRef.child("Users").child(phone).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Your account has been created successfully.", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                loadingBar.dismiss();
                                Toast.makeText(RegisterActivity.this, "Try again in another time.....", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
                else{
                    Toast.makeText(RegisterActivity.this, "This Phone number already exists, Try again with another number.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                    //change the register view to main view
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
