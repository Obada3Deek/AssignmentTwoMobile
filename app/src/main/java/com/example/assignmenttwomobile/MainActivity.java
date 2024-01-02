package com.example.assignmenttwomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    public EditText editTextFullname, editTextUsername,editTextPassword,editTextAddress;
    private CheckBox checkBoxMale,checkBoxFemale;
    private Button buttonSave,buttonNextACT;

    public   String Username,Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setRequestedOrientation(M.SCREEN_ORIENTATION_PORTRAIT);
        queue = Volley.newRequestQueue(this);
        editTextFullname = findViewById(R.id.editTextFullNameACT1);
        editTextUsername = findViewById(R.id.editTextUSARNAMEACT1);
        editTextPassword = findViewById(R.id.editTextPasswordACT1);
        editTextAddress = findViewById(R.id.editTextAddressACT1);
        checkBoxMale = findViewById(R.id.checkBoxMaleACT1);
        checkBoxFemale = findViewById(R.id.checkBoxFemaleACT1);
        buttonSave = findViewById(R.id.buttonSave);
        buttonNextACT = findViewById(R.id.buttonGoToACT3);

        checkInstance(savedInstanceState);
        buttonNextACT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GOTOACT2 = new Intent(MainActivity.this,Second_Activity.class);
                Username = editTextUsername.getText().toString();
                Password = editTextPassword.toString().toString();
                GOTOACT2.putExtra("vales1",Username);
                GOTOACT2.putExtra("vales2",Password);

          //      GOTOACT2.putExtra("Username",editTextUsername.getText());
          //      GOTOACT2.putExtra("Password",editTextPassword.getText());
                startActivity(GOTOACT2);
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1 = editTextFullname.getText().toString();
                String str2 = editTextUsername.getText().toString();
                String str3 = editTextPassword.getText().toString();
                String str4 = editTextAddress.getText().toString();
           //   boolean male = checkBoxMale.isChecked();

                if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill out the required information",Toast.LENGTH_LONG).show();
                }else if ((checkBoxMale.isChecked()&&checkBoxFemale.isChecked())  ){
                    Toast.makeText(getApplicationContext(),"Please Select One Gender",Toast.LENGTH_LONG).show();

                }  else {
                    Toast.makeText(getApplicationContext(),"Saved Information , Thank You *_*",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public  void checkInstance(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            Username = savedInstanceState.getString("editTextUsername");
            Password = savedInstanceState.getString("editTextPassword");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("Username", Username);
        outState.putString("Password", Password);
        outState.putString("editTextFullname", String.valueOf(editTextFullname));
        outState.putString("editTextAddress", String.valueOf(editTextAddress));


    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}