package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
private EditText email;
    private Button register;
  private   ProgressBar prg;
  FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgotpassword);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress2);
        register=(Button)findViewById(R.id.button3);
        prg=(ProgressBar)findViewById(R.id.pre);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpassword();
            }
        });
    }

    private void resetpassword() {
        String email1=email.getText().toString().trim();
        if(email1.isEmpty())
        {email.setError("Email is empty");
            email.requestFocus();return;}
        if(Patterns.EMAIL_ADDRESS.matcher(email1).matches()==false)
        {email.setError("Enter valid email");
            email.requestFocus();
            return;}
    prg.setVisibility(View.VISIBLE);
    auth.sendPasswordResetEmail(email1).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if(task.isSuccessful())
            {
                Toast.makeText(forgotpassword.this,"Check your email",Toast.LENGTH_LONG).show();
                prg.setVisibility(View.GONE);
            }
            else
            {Toast.makeText(forgotpassword.this,"Try Again",Toast.LENGTH_LONG).show();prg.setVisibility(View.GONE);}
        }
    });}
    }

