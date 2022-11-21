package com.example.helpmelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Register extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://help-me-5dfcb-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final AppCompatButton signUpBtn = findViewById(R.id.signUpBtn);
        final TextView loginBtn2 = findViewById(R.id.loginBtn);

        final EditText username = findViewById(R.id.username);
        final EditText phone = findViewById(R.id.phone);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //login activity
                startActivity(new Intent(Register.this, Login.class));
                finish();
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //sign up settings here!!
                //then open up main activity after successful sign up
                final String usernametxt = username.getText().toString();
                final String emailtxt = email.getText().toString();
                final String phonetxt = phone.getText().toString();
                final String passwordtxt = password.getText().toString();

                if (usernametxt.isEmpty() || emailtxt.isEmpty() || phonetxt.isEmpty() || passwordtxt.isEmpty()) {
                    Toast.makeText(Register.this, "Please fill all the field", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if the username is not registered
                            if (snapshot.hasChild(usernametxt)) {

                                Toast.makeText(Register.this, "Username already registered", Toast.LENGTH_SHORT).show();

                            } else {
                                databaseReference.child("users").child(usernametxt).child("email").setValue(emailtxt);
                                databaseReference.child("users").child(usernametxt).child("phone").setValue(phonetxt);
                                databaseReference.child("users").child(usernametxt).child("password").setValue(passwordtxt);
                                Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }


        });

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}