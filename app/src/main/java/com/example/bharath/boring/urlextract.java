package com.example.bharath.boring;

import android.app.usage.UsageEvents;
import android.os.AsyncTask;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class urlextract extends AsyncTask<String, Void, String> {

    String result = " ";
    eventBus eventBus=new eventBus();
    URL url;
    HttpURLConnection httpURLConnection=null;
    @Override
    protected String doInBackground(String... urls) {
        try {
            this.url=new URL(urls[0]);
            httpURLConnection=(HttpURLConnection) url.openConnection();

httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data = inputStreamReader.read();

            while (data != -1) {
                char d = (char) data;

                result = result + d;

                data = inputStreamReader.read();


            }
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {
            JSONObject jsonObject=new JSONObject(this.result);

eventBus.setUrl(jsonObject.getString("image"));
            EventBus.getDefault().post(eventBus);
            Log.d("httpd", "onPostExecute: "+jsonObject.getString("image"));




        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
