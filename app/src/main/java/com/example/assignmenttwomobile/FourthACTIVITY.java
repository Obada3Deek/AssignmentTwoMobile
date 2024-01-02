package com.example.assignmenttwomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class FourthACTIVITY extends AppCompatActivity {
    private Button buttonShowUNI,buttonNEXTACT5;
    private RequestQueue queue;
    private TextView TxtShowUniversity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        TxtShowUniversity = findViewById(R.id.textViewUNIACT4);
        buttonNEXTACT5 = findViewById(R.id.buttonGOTOACT5);
        buttonShowUNI = findViewById(R.id.buttonSHOWUNI);
        buttonNEXTACT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGOto5 = new Intent(FourthACTIVITY.this, Fifth_Activity.class);
                startActivity(intentGOto5);
            }
        });

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        buttonShowUNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Specify the URL for the API endpoint
                String url = "https://date.nager.at/api/v2/publicholidays/2020/US";

                // Request a JSON response from the provided URL.
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
                                // Handle errors
                                TxtShowUniversity.setText("Error: " + error.getMessage());
                            }
                        }
                );

                // Add the request to the RequestQueue.
                queue.add(jsonArrayRequest);
            }

        });
    }


    private void processData(JSONArray response) {
        // Process the JSON response and update the UI
        StringBuilder data = new StringBuilder();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject post = response.getJSONObject(i);
                String title = post.getString("name");
                String body = post.getString("date");

                // Append data to the StringBuilder
                data.append(" Date : ").append(title).append("\n");
                data.append(" Name :").append(body).append("\n\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Update the TextView with the processed data
        TxtShowUniversity.setText(data.toString());
    }
}