package com.example.assignmenttwomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Fifth_Activity extends AppCompatActivity {

    private Button buttonSubmit;
    private TextView txtRESULT;
    private RatingBar ratingBarStars;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        txtRESULT = findViewById(R.id.textViewFINALRESULT);
        ratingBarStars = findViewById(R.id.ratingBar);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueTotal = ratingBarStars.getNumStars()+"";
                String Rating = ratingBarStars.getRating()+"";
                txtRESULT.setText("Thank You For Rating!\n" + "Your Rating : "+Rating+"/"+valueTotal);
            }
        });




    }
}