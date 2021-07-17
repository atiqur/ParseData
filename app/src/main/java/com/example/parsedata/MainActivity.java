package com.example.parsedata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue  = MySingleton.getInstance(this).getRequestQueue();
//        Other equivalent implementations of the above statement:
//        queue  = MySingleton.getInstance(MainActivity.this).getRequestQueue();
//        queue  = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        String apiUrl = "https://jsonplaceholder.typicode.com/todos";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiUrl, null, 
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Log.d("JSON", "onCreate: " + jsonObject.getString("title"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> Log.d("JSON Error", "onErrorResponse: " + "Fetch failed!"));

        queue.add(jsonArrayRequest);

    }
}