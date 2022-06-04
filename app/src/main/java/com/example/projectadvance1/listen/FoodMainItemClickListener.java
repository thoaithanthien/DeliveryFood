package com.example.projectadvance1.listen;

import android.widget.ImageView;
import com.example.projectadvance1.object.FoodMain;
import com.example.projectadvance1.object.FoodMenu;

public interface FoodMainItemClickListener {

    void onFoodMainClick(FoodMain foodMain, ImageView foodImageView);
    // we will need the imageview to make the shared animation between the two activity

}
