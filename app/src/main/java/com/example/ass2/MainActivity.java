package com.example.ass2;

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
    Animation topAni,buttomAni;
    ImageView image ;
    TextView text;
    private static int SPLASH_TIME=5000;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAni = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        buttomAni = AnimationUtils.loadAnimation(this,R.anim.buttom_animation);

        image=findViewById(R.id.img);
        text=findViewById(R.id.title);

        image.setAnimation(topAni);
        text.setAnimation(buttomAni);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Second.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        },SPLASH_TIME);
    }
}