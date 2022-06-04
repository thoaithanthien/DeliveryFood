package com.example.projectadvance1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectadvance1.object.FragmentCakes;
import com.example.projectadvance1.R;

import java.util.ArrayList;

public class AdapterCakes extends RecyclerView.Adapter<AdapterCakes.CakesViewHolder>{
    private Context context;
    private ArrayList<FragmentCakes> arrayListFoodMain;

    public AdapterCakes(Context context, ArrayList<FragmentCakes> arrayListFoodMain) {
        this.context = context;
        this.arrayListFoodMain = arrayListFoodMain;
    }

    @NonNull
    @Override
    public CakesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_fragment_cakes,parent, false);

        return new CakesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CakesViewHolder holder, int position) {
        holder.imgFood.setImageResource(arrayListFoodMain.get(position).getImgFood());
        holder.imgStar.setImageResource(arrayListFoodMain.get(position).getImgStar());
        holder.tvNameFood.setText(arrayListFoodMain.get(position).getNameFood());
        holder.tvMoTa.setText(arrayListFoodMain.get(position).getMoTa());
    }

    @Override
    public int getItemCount() {
        return arrayListFoodMain.size();
    }

    public class CakesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood, imgStar;
        private TextView tvNameFood, tvMoTa;

        public CakesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_Fragment_Cakes);
            imgStar = itemView.findViewById(R.id.img_Star_Cakes);
            tvNameFood = itemView.findViewById(R.id.tv_Title_Cakes);
            tvMoTa = itemView.findViewById(R.id.tv_moTa_Cakes);
        }
    }
}
