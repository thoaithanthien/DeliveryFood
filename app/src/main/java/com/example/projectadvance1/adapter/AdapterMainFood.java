package com.example.projectadvance1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectadvance1.listen.FoodMainItemClickListener;
import com.example.projectadvance1.object.FoodMain;
import com.example.projectadvance1.R;

import java.util.List;

public class AdapterMainFood extends RecyclerView.Adapter<AdapterMainFood.FoodMainViewHolder>{
    private Context context;
    private List<FoodMain> arrayListFoodMain;
    private FoodMainItemClickListener listener;

    public AdapterMainFood(Context context, List<FoodMain> arrayListFoodMain, FoodMainItemClickListener listener) {
        this.context = context;
        this.arrayListFoodMain = arrayListFoodMain;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_main,parent,false);
        return new FoodMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodMainViewHolder holder, int position) {
        holder.tvNameFood.setText(arrayListFoodMain.get(position).getNameFood());
        holder.imgFood.setImageResource(arrayListFoodMain.get(position).getImgFood());
//        holder.btn_Order.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onMovieClick(arrayListFoodMain.get(holder.getAdapterPosition()),holder.imgFood);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrayListFoodMain.size();
    }

    public class FoodMainViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView tvNameFood;

        public FoodMainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameFood = itemView.findViewById(R.id.tv_Name_main);
            imgFood = itemView.findViewById(R.id.imgFoodMain);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onFoodMainClick(arrayListFoodMain.get(getBindingAdapterPosition()),imgFood);


                }
            });
        }
    }
}
