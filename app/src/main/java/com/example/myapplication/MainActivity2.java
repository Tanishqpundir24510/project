package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    private Button b,b1;
    private TextView fp,f1;
    private EditText email,pass;
    private FirebaseAuth mAuth;
    private ProgressBar pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        b=(Button) findViewById(R.id.button);
        b1=(Button) findViewById(R.id.button1);
        f1=(TextView)findViewById(R.id.textView6);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openh4();
            }
        });
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)

            {openh();
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)

            {openh1();
            }
        });
        email=(EditText) findViewById(R.id.editTextTextPersonName);
        pass=(EditText) findViewById(R.id.editTextTextPassword);
        pro=(ProgressBar) findViewById(R.id.progressBar2);
        fp=(TextView)findViewById(R.id.textView3);
        fp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)

            {openh3();
            }
        });
        mAuth=FirebaseAuth.getInstance();
    }

    private void openh3() {
        Intent i=new Intent(MainActivity2.this,forgotpassword.class);
        startActivity(i);
    }
private void openh4()
{Intent  i=new Intent(MainActivity2.this,MainActivity3.class);
startActivity(i);}
    public void openh()
    {
        userlogin();
    }
public void openh1()
{Intent i=new Intent(this,MainActivity4.class);
startActivity(i);}

    public void userlogin()
    {String email1=email.getText().toString().trim();
    String pass1=pass.getText().toString().trim();
    if(email1.isEmpty())
    {email.setError("Email is empty");
    email.requestFocus();return;}
        if(Patterns.EMAIL_ADDRESS.matcher(email1).matches()==false)
        {email.setError("Enter valid email");
            email.requestFocus();
            return;}
        if (pass1.isEmpty()) {
            pass.setError("Password is required");
            pass.requestFocus();
            return;
        }
        if(pass1.length()<6)
        {pass.setError("Password is too short");
            pass.requestFocus();
            return;}
pro.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

                    startActivity(new Intent(MainActivity2.this,MainActivity3.class));


                } else
                {
                    Toast.makeText(MainActivity2.this,"Failed to login please check your credentials",Toast.LENGTH_LONG).show();
                } pro.setVisibility(View.GONE);
            }
        });
}}
