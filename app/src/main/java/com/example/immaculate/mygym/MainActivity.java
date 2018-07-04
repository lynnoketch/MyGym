package com.example.immaculate.mygym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private EditText names,age,currentWeight,targetWeight,homeWorkout,gender,useremail;
private ImageView profilePicture;
private FirebaseAuth auth;
private Button buttonSave;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();

        names = (EditText)findViewById(R.id.fullnames);
        age = (EditText)findViewById(R.id.Age);
        gender = (EditText) findViewById(R.id.Gender);
        homeWorkout =(EditText)findViewById(R.id.homeGym);
        currentWeight = (EditText)findViewById(R.id.current_weight);
        targetWeight = (EditText)findViewById(R.id.target_weight);
        //profilePicture =(EditText)findViewById(R.id.profile_picture);
        //progressBar = (ProgressBar)findViewById(R.id.progressbar);
        useremail = (EditText)findViewById(R.id.email);
        loadUserInformation();
    }
    private void loadUserInformation()
    {

        FirebaseUser user = auth.getCurrentUser();
        if(user.getPhotoUrl()!=null)
        {
            String photo = user.getPhotoUrl().toString();
            Glide.with(this).load(user.getPhotoUrl().toString()).into(profilePicture);

        }

        if(user.getDisplayName()!=null)
        {
            names.setText(user.getDisplayName());
            age.setText(user.getDisplayName());
            gender.setText(user.getDisplayName());
            homeWorkout.setText(user.getDisplayName());
            currentWeight.setText(user.getDisplayName());
            useremail.setText(user.getDisplayName());
            currentWeight.setText(user.getDisplayName());
            targetWeight.setText(user.getDisplayName());
        }


    }
    @Override
    protected void onStart()
    {
        super.onStart();
        if(auth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

}
