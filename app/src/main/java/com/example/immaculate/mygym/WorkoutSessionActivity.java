package com.example.immaculate.mygym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WorkoutSessionActivity extends AppCompatActivity implements View.OnClickListener {
private FirebaseAuth auth;
private EditText day,gym,typeOfexercise,set,rep;
private Button buttonSave;
private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_session);
        auth = FirebaseAuth.getInstance();



        databaseReference = FirebaseDatabase.getInstance().getReference();
        day = (EditText)findViewById(R.id.Date);
        gym = (EditText)findViewById(R.id.location);
        typeOfexercise=(EditText)findViewById(R.id.exercise);
        set=(EditText)findViewById(R.id.sets);
        rep=(EditText)findViewById(R.id.reps);
        buttonSave=(Button)findViewById(R.id.save);
        FirebaseUser user= auth.getCurrentUser();
        buttonSave.setOnClickListener(this );
    }
public void saveWorkout()
{
    String workoutDay = day.getText().toString().trim();
    String gymLocation = gym.getText().toString().trim();
    String workoutType = typeOfexercise.getText().toString().trim();
    String SetNo = set.getText().toString().trim();
    String RepNo=rep.getText().toString().trim();

    WorkoutInformation workoutInformation = new WorkoutInformation(workoutDay,gymLocation,workoutType,RepNo,SetNo);
    FirebaseUser user= auth.getCurrentUser();
    databaseReference.child(user.getUid()).setValue(workoutInformation);
    Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show();
}
    @Override
    public void onClick(View view) {
    if(view== buttonSave)
    {
        saveWorkout();
    }
    }
}
