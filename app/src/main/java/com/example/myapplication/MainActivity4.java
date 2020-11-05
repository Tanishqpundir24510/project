package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.RegionIterator;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class MainActivity4 extends AppCompatActivity {
    private FirebaseAuth mAuth;
private EditText name,email,username,phone,password;
private Button submit;
private ProgressBar prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);
        mAuth = FirebaseAuth.getInstance();
    submit=(Button)findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)

            {openh();
            }
        });
    name=(EditText) findViewById(R.id.editTextTextPersonName2);
        email=(EditText) findViewById(R.id.editTextTextEmailAddress);
        username=(EditText) findViewById(R.id.editTextTextPersonName3);
        phone=(EditText) findViewById(R.id.editTextPhone);
        password=(EditText) findViewById(R.id.editTextTextPassword2);
        prog=(ProgressBar)findViewById(R.id.progressBar);


    }
    public void registerUser() {
        final String name1 = name.getText().toString().trim();
        final String phone1 = phone.getText().toString().trim();
        final String username1 = username.getText().toString().trim();
        final String email1 = email.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        if (name1.isEmpty()) {
            name.setError("Full Name is required");
            name.requestFocus();
            return;
        }

        if (username1.isEmpty()) {
            username.setError("User name is required");
            username.requestFocus();
            return;
        }
        if (email1.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email1).matches()==false)
        {email.setError("Enter valid email");
            email.requestFocus();
            return;}
        if (phone1.isEmpty()) {
            phone.setError("Phone number is required");
            phone.requestFocus();
            return;
        }
        if (pass1.isEmpty()) {
            password.setError("Password is required");
           password.requestFocus();
            return;
        }
        if(pass1.length()<6)
        {password.setError("Password is too short");
        password.requestFocus();
        return;}
        prog.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email1,pass1)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                           @Override
                                           public void onComplete(@NonNull Task<AuthResult> task) {
                                               if (task.isSuccessful()) {
                                                   user use = new user(name1, email1, username1, phone1);
                                                   FirebaseDatabase.getInstance().getReference("User")
                                                           .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                           .setValue(use).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                       @Override
                                                       public void onComplete(@NonNull Task<Void> task) {
                                                           if (task.isSuccessful()) {
                                                               Toast.makeText(MainActivity4.this, "user has been registered", Toast.LENGTH_LONG).show();
                                                               prog.setVisibility(View.GONE);
                                                           } else {
                                                               Toast.makeText(MainActivity4.this, "user has not been registered!try Again.", Toast.LENGTH_LONG).show();
                                                           }
                                                           prog.setVisibility(View.GONE);
                                                       }
                                                   });
                                               }
                                               else
                                               {Toast.makeText(MainActivity4.this,"user has been not registered!try Again.",Toast.LENGTH_LONG).show();}
                                               prog.setVisibility(View.GONE);}
                                                  }


    );



    }
    public void openh()
    {
        registerUser();
    }
}
