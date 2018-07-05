package com.example.immaculate.mygym;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

        List<InstructorsInformation> list;
        Context context;


        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView Name, Phone, Gym;

            public MyViewHolder(View view) {
                super(view);
                Name = (TextView) view.findViewById(R.id.name);
                Phone = (TextView) view.findViewById(R.id.phonenumber);
                Gym = (TextView) view.findViewById(R.id.gym);
            }
        }


        public RecyclerAdapter(List<InstructorsInformation> InstructorList, InstructorsActivity instructorsActivity) {
            this.list = InstructorList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.instructor_list_view, parent, false);

            return new MyViewHolder(itemView);
        }



        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            InstructorsInformation instructorsInformation = list.get(position);
            holder.Name.setText(instructorsInformation.getName());
            holder.Phone.setText(instructorsInformation.getPhoneNumber());
            holder.Gym.setText(instructorsInformation.getGym());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
}
