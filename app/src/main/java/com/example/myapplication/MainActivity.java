package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SA=5000;
Animation top,bottom;
ImageView image;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        top= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom);
        image=findViewById(R.id.imageView);
        text=findViewById(R.id.textView);
        image.setAnimation(top);
        text.setAnimation(bottom);
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent in =new Intent(MainActivity.this,MainActivity2.class);
        startActivity(in);
        finish();
    }
},SA);
    }
}