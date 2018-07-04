package com.example.immaculate.mygym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PastWorkoutActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private TextView day,gym,typeOfexercise,set,rep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_workout);
        day = (TextView) findViewById(R.id.Date);
        gym = (TextView) findViewById(R.id.location);
        typeOfexercise=(TextView) findViewById(R.id.exercise);
        set=(TextView) findViewById(R.id.sets);
        rep=(TextView) findViewById(R.id.reps);

        loadPastWorkoutInformation();

    }
    private void loadPastWorkoutInformation()
    {
        FirebaseUser user = auth.getCurrentUser();


        if(user.getDisplayName()!=null)
        {
            day.setText(user.getDisplayName());
            gym.setText(user.getDisplayName());
            typeOfexercise.setText(user.getDisplayName());
            set.setText(user.getDisplayName());
            rep.setText(user.getDisplayName());

        }
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        if(auth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this, PastWorkoutActivity.class));
        }
    }
}
