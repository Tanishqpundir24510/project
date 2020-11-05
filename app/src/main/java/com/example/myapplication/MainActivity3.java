package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
private CardView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
        log=(CardView)findViewById(R.id.signout);
        log.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        { case R.id.signout:
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity3.this,MainActivity2.class));
            break;

    }}
}