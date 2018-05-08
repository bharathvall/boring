package com.example.bharath.boring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        urlextract urlextract=new urlextract();
        urlextract.execute("https://yesno.wtf/api/");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cardView=findViewById(R.id.card);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),main2.class);
                startActivity(intent);
            }
        });
urbanD urbanD=new urbanD();
urbanD.execute("https://mashape-community-urban-dictionary.p.mashape.com/define?term=hey");

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void method(){


    }

}
