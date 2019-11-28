package com.example.milanapp.vollydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

      private static final String URL = "https://api.github.com/users";

    private DividerItemDecoration dividerItemDecoration;
    RecyclerView userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userList= findViewById(R.id.userList);

        userList.setLayoutManager(new LinearLayoutManager(this));


      /***
       *
       * LinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(userList.getContext(),LinearLayoutManager.getOrientation());

       ***/

        // STRING REQUEST  0......0

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("code",response);
            // gson object create
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                // pass response
               User[] users=  gson.fromJson(response,User[].class);

               userList.setAdapter(new MyAdapter(MainActivity.this,users));   // recycler view ne adepter sathe bind karu

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                 Toast.makeText(MainActivity.this,"something error",Toast.LENGTH_SHORT);

            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }

}
