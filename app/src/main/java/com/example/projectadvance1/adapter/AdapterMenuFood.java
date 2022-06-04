package com.example.projectadvance1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectadvance1.listen.FoodMenuItemClickListener;
import com.example.projectadvance1.object.FoodMenu;
import com.example.projectadvance1.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class AdapterMenuFood extends RecyclerView.Adapter<AdapterMenuFood.MenuViewHolder>{
    private Context context;
    private ArrayList<FoodMenu> arrayListMenu;
    private FoodMenuItemClickListener listener;

    public AdapterMenuFood(Context context, ArrayList<FoodMenu> arrayListMenu, FoodMenuItemClickListener listener) {
        this.context = context;
        this.arrayListMenu = arrayListMenu;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_food_menu,parent, false);

        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        FoodMenu foodMenu = arrayListMenu.get(position);
        if (foodMenu == null) {
            return;
        }
        holder.imgMenu.setImageResource(foodMenu.getImgMenu());
        holder.imgTitleMenu.setImageResource(foodMenu.getImgTitleMenu());
        holder.imgMenuCollapse.setImageResource(foodMenu.getImgMenuCollapse());
        holder.tvName.setText(foodMenu.getNameMenu());
        holder.tvPrice.setText(foodMenu.getPriceMenu());
        holder.tvMoTa.setText(foodMenu.getMoTaMenu());
        holder.tvTitleCollapse.setText(foodMenu.getTitleMenuCollapse());

        holder.btn_Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFoodMenuClick(arrayListMenu.get(holder.getBindingAdapterPosition()),holder.imgMenu);
            }
        });

        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.foldingCell.toggle(false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListMenu.size();

    }

    // Tim kiem

    public void filterFM(ArrayList<FoodMenu> filterList) {
        arrayListMenu = filterList;
        notifyDataSetChanged();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMenu,imgTitleMenu, imgMenuCollapse, imgCover;
        private TextView tvName, tvPrice, tvMoTa, tvTitleCollapse;
        private FoldingCell foldingCell;
        private Button btn_Order;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMenu = itemView.findViewById(R.id.img_foodMenu);
            imgTitleMenu = itemView.findViewById(R.id.img_TitleMenu);
            imgMenuCollapse = itemView.findViewById(R.id.img_menuCollapse);
            tvName = itemView.findViewById(R.id.tv_name_foodMenu1);
            tvPrice = itemView.findViewById(R.id.tv_price_foodMenu);
            tvMoTa = itemView.findViewById(R.id.tv_moTa_foodMenu);
            tvTitleCollapse = itemView.findViewById(R.id.tv_title_menuCollapse);
            foldingCell = itemView.findViewById(R.id.foldingCell);
            btn_Order = itemView.findViewById(R.id.btn_foodMenu);

        }
    }
}
