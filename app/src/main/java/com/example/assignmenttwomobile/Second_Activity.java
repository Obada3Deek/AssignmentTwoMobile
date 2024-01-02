package com.example.assignmenttwomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    private EditText editTextUsername1,editTextPassword1;
    private Button buttonLOGIN;
    private CheckBox checkBoxRememberMe;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextUsername1 = findViewById(R.id.editTextUSERNAME);
        editTextPassword1 = findViewById(R.id.editTextTextPassword);
        buttonLOGIN = findViewById(R.id.buttonlog);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        // SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        // Check if user credentials are stored
        if (sharedPreferences.contains("username") && sharedPreferences.contains("password")) {
            editTextUsername1.setText(sharedPreferences.getString("username", ""));
            editTextPassword1.setText(sharedPreferences.getString("password", ""));
            checkBoxRememberMe.setChecked(true);
        }


        buttonLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receivedStringOne = getIntent().getStringExtra("vales1");
                String receivedStringTwo = getIntent().getStringExtra("vales2");

                String str1 = editTextUsername1.getText().toString();
                String str2 = editTextPassword1.getText().toString();

                if(str1.isEmpty() || str2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please enter both Username and Password",Toast.LENGTH_LONG).show();

                }else {

                            loginUser();
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                            Intent GOTOACT3 = new Intent(Second_Activity.this, Third_Activity.class);
                            startActivity(GOTOACT3);


                    }
                }


        });
    }


    private void loginUser() {
        // Get username and password
        String username = editTextUsername1.getText().toString();
        String password = editTextPassword1.getText().toString();

        // Save credentials if "Remember Me" is checked
        if (checkBoxRememberMe.isChecked()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();
        } else {
            // Clear saved credentials if "Remember Me" is unchecked
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("username");
            editor.remove("password");
            editor.apply();
        }

    }



}