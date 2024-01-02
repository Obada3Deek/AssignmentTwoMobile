package com.example.assignmenttwomobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Third_Activity extends AppCompatActivity {
    private RequestQueue queue;
    private TextView txt;
    private Button buttonSHOW,buttonNextACT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        buttonSHOW = findViewById(R.id.buttonSHOW);
        txt = findViewById(R.id.myTextView);
        buttonNextACT = findViewById(R.id.buttonNextACT);
        buttonNextACT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Third_Activity.this , FourthACTIVITY.class);
                startActivity(intent);
            }
        });



        RequestQueue queue = Volley.newRequestQueue(this);
        buttonSHOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false";
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Request.Method.GET, url,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                // Handle the JSON response
                                processData(response);
                                Toast.makeText(getApplicationContext(),"Successful!!",Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                txt.setText("Error: " + error.getMessage());
                            }
                        }
                );
                queue.add(jsonArrayRequest);
            }

        });
    }


    private void processData(JSONArray response) {
        StringBuilder data = new StringBuilder();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject post = response.getJSONObject(i);
                String title = post.getString("name");
                String title2 = post.getString("current_price");

                data.append("Title : ").append(title).append("\n");
                data.append("current_price : ").append(title2).append("\n\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Update the TextView with the processed data
        txt.setText(data.toString());
    }
}