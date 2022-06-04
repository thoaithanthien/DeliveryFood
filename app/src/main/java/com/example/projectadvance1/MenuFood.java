package com.example.projectadvance1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.projectadvance1.adapter.AdapterMenuFood;
import com.example.projectadvance1.detail.FoodDetailActivity;
import com.example.projectadvance1.listen.FoodMenuItemClickListener;
import com.example.projectadvance1.object.FoodMenu;

import java.util.ArrayList;
import java.util.Collections;

public class MenuFood extends AppCompatActivity implements FoodMenuItemClickListener {
    private RecyclerView rcvMenu;
    private EditText edtSearch;
    private ArrayList<FoodMenu> arrayListMenu;
    private AdapterMenuFood adapterMenuFood;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_food);



        rcvMenu = findViewById(R.id.rcv_menu);
        edtSearch = findViewById(R.id.edt_SearchMenu);
        imgBack = findViewById(R.id.img_backFoodMenu);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuFood.this, MainActivity.class);
                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
                startActivity(intent);
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
        arrayListMenu = new ArrayList<>();

        // Add data
        arrayListMenu.add(new FoodMenu(R.drawable.food1, "Roll Cake", "20$",
                "Roll cake Ha Noi","Roll Cake", R.drawable.food1, R.drawable.food1,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food2, "Fried chicken", "15$",
                "Fried chicken Korea","Fried chicken", R.drawable.food2, R.drawable.food2,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food3, "Lettuce squeeze", "10$",
                "Lettuce squeeze Hue","Lettuce squeeze", R.drawable.food3, R.drawable.food3,R.drawable.fooddetaill));

        arrayListMenu.add(new FoodMenu(R.drawable.food1, "Roll Cake", "20$",
                "Roll cake Ha Noi","Roll Cake", R.drawable.food1, R.drawable.food1,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food2, "Fried chicken", "15$",
                "Fried chicken Korea","Fried chicken", R.drawable.food2, R.drawable.food2,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food3, "Lettuce squeeze", "10$",
                "Lettuce squeeze Hue","Lettuce squeeze", R.drawable.food3, R.drawable.food3,R.drawable.fooddetaill));

        arrayListMenu.add(new FoodMenu(R.drawable.food1, "Roll Cake", "20$",
                "Roll cake Ha Noi","Roll Cake", R.drawable.food1, R.drawable.food1,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food2, "Fried chicken", "15$",
                "Fried chicken Korea","Fried chicken", R.drawable.food2, R.drawable.food2,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food3, "Lettuce squeeze", "10$",
                "Lettuce squeeze Hue","Lettuce squeeze", R.drawable.food3, R.drawable.food3,R.drawable.fooddetaill));

        arrayListMenu.add(new FoodMenu(R.drawable.food1, "Roll Cake", "20$",
                "Roll cake Ha Noi","Roll Cake", R.drawable.food1, R.drawable.food1,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food2, "Fried chicken", "15$",
                "Fried chicken Korea","Fried chicken", R.drawable.food2, R.drawable.food2,R.drawable.fooddetaill));
        arrayListMenu.add(new FoodMenu(R.drawable.food3, "Lettuce squeeze", "10$",
                "Lettuce squeeze Hue","Lettuce squeeze", R.drawable.food3, R.drawable.food3,R.drawable.fooddetaill));

        adapterMenuFood = new AdapterMenuFood(this, arrayListMenu, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                RecyclerView.VERTICAL,false);
        rcvMenu.setLayoutManager(linearLayoutManager);
        rcvMenu.setAdapter(adapterMenuFood);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder dragged, @NonNull
                                          RecyclerView.ViewHolder target) {
                int positionDragged = dragged.getAbsoluteAdapterPosition();
                int positionTarget = target.getAbsoluteAdapterPosition();

                Collections.swap(arrayListMenu, positionDragged,positionTarget);

                adapterMenuFood.notifyItemMoved(positionDragged, positionTarget);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

        helper.attachToRecyclerView(rcvMenu);
    }

    @Override
    public void onFoodMenuClick(FoodMenu foodMenu, ImageView foodMenuImage) {
        Intent intent = new Intent(this, FoodDetailActivity.class);
        // send food information to detailActivity
        intent.putExtra("title",foodMenu.getNameMenu());
        intent.putExtra("imgURL",foodMenu.getImgMenu());
        intent.putExtra("imgCover",foodMenu.getImgCover());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MenuFood.this,
                foodMenuImage,"sharedName");

        startActivity(intent,options.toBundle());
    }

    // Tim kiem
    public void filter(String text) {
        ArrayList<FoodMenu> filterList = new ArrayList<>();
        for (FoodMenu FM: arrayListMenu){
            if (FM.getNameMenu().toLowerCase().contains(text.toLowerCase())){
                filterList.add(FM);
            }
        }
            adapterMenuFood.filterFM(filterList);
    }
}