package com.example.parsedata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com";

        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Main", "onResponse: "+ response.substring(0, 500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "onErrorResponse: " + "Failed to get info!");
            }
        });

        // Add request to the RequestQueue
        queue.add(stringRequest);
    }
}