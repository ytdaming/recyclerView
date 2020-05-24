package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Fruitadapter extends RecyclerView.Adapter<Fruitadapter.Viewholder> {
    private List<Fruit> mFruitList;
    static class Viewholder extends RecyclerView.ViewHolder{
        View fruitview;
        ImageView fruitImage;
        TextView fruitName;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            fruitview=itemView;
            fruitImage=itemView.findViewById(R.id.fruit_image);
            fruitName=itemView.findViewById(R.id.fruit_name);
        }
    }


    @NonNull
    @Override
    public Viewholder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        final Viewholder holder=new Viewholder(view);
        holder.fruitview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(v.getContext(),"你点击了View"+fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(v.getContext(),"你点击了图片"+fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Fruit fruit=mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public Fruitadapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }
}
