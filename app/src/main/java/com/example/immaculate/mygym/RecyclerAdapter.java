package com.example.immaculate.mygym;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHoder>{

        List<InstructorsInformation> list;
        Context context;

        public RecyclerAdapter(List<InstructorsInformation> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.instructor_card,parent,false);
            MyHoder myHoder = new MyHoder(view);


            return myHoder;
        }

        @Override
        public void onBindViewHolder(MyHoder holder, int position) {
            InstructorsInformation mylist = list.get(position);
            holder.Iname.setText(mylist.getName());
            holder.phone.setText(mylist.getPhoneNumber());
            holder.locality.setText(mylist.getGym());
        }

        @Override
        public int getItemCount() {

            int arr = 0;

            try{
                if(list.size()==0){

                    arr = 0;

                }
                else{

                    arr=list.size();
                }



            }catch (Exception e){



            }

            return arr;

        }

        class MyHoder extends RecyclerView.ViewHolder {
            TextView Iname, phone, locality;


            public MyHoder(View itemView) {
                super(itemView);
                Iname = (TextView) itemView.findViewById(R.id.name);
                phone = (TextView) itemView.findViewById(R.id.phonenumber);
                locality = (TextView) itemView.findViewById(R.id.gym);

            }
        }
}
