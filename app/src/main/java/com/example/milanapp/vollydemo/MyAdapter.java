package com.example.milanapp.vollydemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {


    private Context context;
    private User [] data;
    public MyAdapter(Context context,User [] data) {

        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // view holder ne return karva mate




        View view = LayoutInflater.from(context).inflate(R.layout.item_user_layout, viewGroup, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewholder myViewholder, int i) {

        User user = data[i];
        myViewholder.txtuser.setText(user.getLogin());// text view bind with viewholder
        Glide.with(myViewholder.imguser.getContext()).load(user.getAvatarUrl()).into(myViewholder.imguser); // image view bind karava
    }

    @Override
    public int getItemCount() {
        return data.length;
    }




//VIEW HOLDER CLASS

    public class MyViewholder extends RecyclerView.ViewHolder {

        ImageView imguser;
        TextView txtuser;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            imguser = (ImageView) itemView.findViewById(R.id.imguser);
            txtuser = (TextView) itemView.findViewById(R.id.txtuser);

        }
    }

    //END OF VIEW HOLDER CLASS
}
