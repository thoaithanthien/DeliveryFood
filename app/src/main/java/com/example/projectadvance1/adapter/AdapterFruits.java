package com.example.projectadvance1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectadvance1.object.FragmentFruits;
import com.example.projectadvance1.R;

import java.util.ArrayList;

public class AdapterFruits extends RecyclerView.Adapter<AdapterFruits.FruitsViewHolder>{
    private Context context;
    private ArrayList<FragmentFruits> arrayListFoodMain;

    public AdapterFruits(Context context, ArrayList<FragmentFruits> arrayListFoodMain) {
        this.context = context;
        this.arrayListFoodMain = arrayListFoodMain;
    }

    @NonNull
    @Override
    public FruitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_fragment_fruits,parent, false);

        return new FruitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsViewHolder holder, int position) {
        holder.imgFood.setImageResource(arrayListFoodMain.get(position).getImgFood());
        holder.imgStar.setImageResource(arrayListFoodMain.get(position).getImgStar());
        holder.tvNameFood.setText(arrayListFoodMain.get(position).getNameFood());
        holder.tvMoTa.setText(arrayListFoodMain.get(position).getMoTa());
    }

    @Override
    public int getItemCount() {
        return arrayListFoodMain.size();
    }

    public class FruitsViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood, imgStar;
        private TextView tvNameFood, tvMoTa;

        public FruitsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_Fragment_Fruits);
            imgStar = itemView.findViewById(R.id.img_Star_Fruits);
            tvNameFood = itemView.findViewById(R.id.tv_Title_Fruits);
            tvMoTa = itemView.findViewById(R.id.tv_moTa_Fruits);
        }
    }
}
