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
private CardView log,set,soil,dise,about,agri,crops,tools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
        log=(CardView)findViewById(R.id.signout);
        dise=(CardView)findViewById(R.id.disease);
        tools=(CardView)findViewById(R.id.tools);
        soil=(CardView)findViewById(R.id.soil);
        set=(CardView)findViewById(R.id.setting);
        about=(CardView)findViewById(R.id.about);
        agri=(CardView)findViewById(R.id.agriculture);
        crops=(CardView)findViewById(R.id.crops);

        log.setOnClickListener(this);
        set.setOnClickListener(this);
        soil.setOnClickListener(this);
        dise.setOnClickListener(this);
        about.setOnClickListener(this);
        agri.setOnClickListener(this);
        crops.setOnClickListener(this);
        tools.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        { case R.id.signout:
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity3.this,MainActivity2.class));
            break;
            case R.id.disease:
                startActivity(new Intent(MainActivity3.this,diseases.class));
                break;
            case R.id.crops:
                startActivity(new Intent(MainActivity3.this,crops.class));
                break;
            case R.id.about:
                startActivity(new Intent(MainActivity3.this,about.class));
                break;
            case R.id.agriculture:
                startActivity(new Intent(MainActivity3.this,agriculture.class));
                break;
            case R.id.tools:
                startActivity(new Intent(MainActivity3.this,Tools.class));
                break;
            case R.id.soil:
                startActivity(new Intent(MainActivity3.this,soil.class));
                break;


    }}
}