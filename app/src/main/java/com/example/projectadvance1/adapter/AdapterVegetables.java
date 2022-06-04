package com.example.projectadvance1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectadvance1.object.FragmentVegetables;
import com.example.projectadvance1.R;

import java.util.ArrayList;

public class AdapterVegetables extends RecyclerView.Adapter<AdapterVegetables.VegetablesViewHolder>{
    private Context context;
    private ArrayList<FragmentVegetables> arrayListFoodMain;

    public AdapterVegetables(Context context, ArrayList<FragmentVegetables> arrayListFoodMain) {
        this.context = context;
        this.arrayListFoodMain = arrayListFoodMain;
    }

    @NonNull
    @Override
    public VegetablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_fragment_vegetables,parent, false);

        return new VegetablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetablesViewHolder holder, int position) {
        holder.imgFood.setImageResource(arrayListFoodMain.get(position).getImgFood());
        holder.imgStar.setImageResource(arrayListFoodMain.get(position).getImgStar());
        holder.tvNameFood.setText(arrayListFoodMain.get(position).getNameFood());
        holder.tvMoTa.setText(arrayListFoodMain.get(position).getMoTa());
    }

    @Override
    public int getItemCount() {
        return arrayListFoodMain.size();
    }

    public class VegetablesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood, imgStar;
        private TextView tvNameFood, tvMoTa;

        public VegetablesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_Fragment_Vegetables);
            imgStar = itemView.findViewById(R.id.img_Star_Vegetables);
            tvNameFood = itemView.findViewById(R.id.tv_Title_Vegetables);
            tvMoTa = itemView.findViewById(R.id.tv_moTa_Vegetables);
        }
    }
}
