package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {


    Button cancelR;
    Button enterR;
    EditText userR;
    EditText passR;
    EditText repass;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        enterR = findViewById(R.id.enterR);
        userR = (EditText) findViewById(R.id.userR);
        passR = (EditText) findViewById(R.id.passR);
        repass = (EditText) findViewById(R.id.repass);
        enterR.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent x = new Intent(Registration.this,LoginPage.class);
                startActivity(x);
                mAuth.createUserWithEmailAndPassword(userR.toString(), passR.toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent x = new Intent(Registration.this,LoginPage.class);
                                    startActivity(x);

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }
        });
        cancelR = findViewById(R.id.cancelR);
        cancelR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z  = new Intent(Registration.this, LoginPage.class);
                startActivity(z);

            }
        });
    }
    }
