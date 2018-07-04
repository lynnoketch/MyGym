package com.example.immaculate.mygym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InstructorsActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<InstructorsInformation> list;
    RecyclerView recycle;
    Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructors);
        view = (Button) findViewById(R.id.InstructorView);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list = new ArrayList<InstructorsInformation>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    InstructorsInformation value = dataSnapshot1.getValue(InstructorsInformation.class);
                    InstructorsInformation fire = new InstructorsInformation();
                    String Iname = value.getName();
                    String phone = value.getPhoneNumber();
                    String locality = value.getGym();
                    fire.setName(Iname);
                    fire.setPhoneNumber(phone);
                    fire.setGym(locality);
                    list.add(fire);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,InstructorsActivity.this);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(InstructorsActivity.this,2);
                /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator( new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);




            }
        });


    }
}
