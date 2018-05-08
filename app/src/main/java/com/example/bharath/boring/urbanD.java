package com.example.bharath.boring;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class urbanD extends AsyncTask<String, Void, String> {

    URL url;
    HttpURLConnection connection;
    String result;


    @Override
    protected String doInBackground(String... urls) {

        try {
            this.url = new URL(urls[0]);

            connection = (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("X-Mashape-Key", "ciup2mfnyXmshAfVlenrkg8ecCs9p1scZJZjsnokYQvu7XmneG");

            connection.addRequestProperty("Accept", "text/plain");

            InputStream inputStream = connection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data = inputStreamReader.read();

            while (data != -1) {
                char d = (char) data;

                result = result + d;

                data = inputStreamReader.read();


            }
            result=result.replace("null","");
            Log.d("result", "doInBackground: " + result);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        ArrayList<String> tags=new ArrayList<>();
        super.onPostExecute(s);
        Log.d("loop00", "onPostExecute: " );
        try {
            JSONObject jsonObject = new JSONObject(this.result);
            Log.d("loop0", "onPostExecute: " );

            JSONArray jsonArray = jsonObject.getJSONArray("tags");
            Log.d("loop2", "onPostExecute: " );
            String st = jsonArray.getString(0);
            Log.d("loop1", "onPostExecute: " );
            for (int i = 0; i < jsonArray.length(); i++) {
               tags.add(jsonArray.getString(i));
                Log.d("tags", "onPostExecute: "+tags);


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
