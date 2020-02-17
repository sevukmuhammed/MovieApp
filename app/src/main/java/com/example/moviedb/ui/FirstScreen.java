package com.example.moviedb.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Intent;

import com.example.moviedb.R;

public class FirstScreen extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_first_screen);


        iv = findViewById(R.id.first);
        Animation a = AnimationUtils.loadAnimation(this,R.anim.animation);
       final Intent i = new Intent(this,MainActivity.class);
       Thread timer = new Thread()
       {
           public void run()
           {
               try
               {
                   sleep(3000);
               }catch(InterruptedException e)
               {
                   e.printStackTrace();
               }
               finally {
                   startActivity(i);
                   finish();
               }
           }
       };
       timer.start();
    }

}
