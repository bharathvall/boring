package com.example.bharath.boring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class main2 extends AppCompatActivity {
    ImageView imageView;
    RequestOptions options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       imageView=findViewById(R.id.imageview);
        String url="https://yesno.wtf/assets/no/2-101be1e3d8a0ed407c4e3c001ef8fa66.gif";
       options=new RequestOptions().placeholder(R.drawable.giphy);
        EventBus.getDefault().register(this);

    }
@Subscribe
public void onEvent(eventBus bus1){
    Log.d("secondurl", "onEvent: "+bus1.getUrl());
    Glide.with(this).load(bus1.getUrl()).thumbnail(Glide.with(this).load(R.drawable.giphy)).into(imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        urlextract urlextracr=new urlextract();
urlextracr.execute("https://yesno.wtf/api/");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
