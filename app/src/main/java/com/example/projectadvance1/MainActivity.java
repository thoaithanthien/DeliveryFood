package com.example.projectadvance1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.projectadvance1.adapter.AdapterMainFood;
import com.example.projectadvance1.detail.FoodDetailActivity;
import com.example.projectadvance1.listen.FoodMainItemClickListener;
import com.example.projectadvance1.object.FoodMain;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FoodMainItemClickListener {
    // Initialize variable
    private DrawerLayout drawerLayout;
    private RecyclerView rcv_food;
    private List<FoodMain> arrayList;
    private AdapterMainFood adapterMainFood;
    private RelativeLayout rtlMain;
    private Animation animation;

    // Bottom navigation
    private final int ID_HOME = 1;
    private final int ID_MENU = 2;
    private final int ID_NOTIFICATION = 3;
    private final int ID_ACCOUNT = 4;

    private MeowBottomNavigation mMeowBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMeowBottom = findViewById(R.id.bottomNavigation);
        drawerLayout = findViewById(R.id.drawLayout);
        rcv_food = findViewById(R.id.rcv_main);
        rtlMain = findViewById(R.id.rtl_main);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        rtlMain.startAnimation(animation);


        arrayList = new ArrayList<>();

        // ListView Food
        arrayList.add(new FoodMain("Potato Fingers", R.drawable.menu_img1,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Roasted Salad",R.drawable.menu_img2,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Sandwich",R.drawable.menu_img3,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Grilled beef",R.drawable.menu_img4,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Fried foods",R.drawable.menu_img1,
                R.drawable.fooddetaill));

        arrayList.add(new FoodMain("Potato Fingers", R.drawable.menu_img1,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Roasted Salad",R.drawable.menu_img2,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Sandwich",R.drawable.menu_img3,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Grilled beef",R.drawable.menu_img4,
                R.drawable.fooddetaill));
        arrayList.add(new FoodMain("Fried foods",R.drawable.menu_img1,
                R.drawable.fooddetaill));


        AdapterMainFood movieAdapter = new AdapterMainFood(this,arrayList,this);
        rcv_food.setAdapter(movieAdapter);
        rcv_food.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        mMeowBottom.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        mMeowBottom.add(new MeowBottomNavigation.Model(ID_MENU, R.drawable.ic_restaurant_menu));
        mMeowBottom.add(new MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notifi));
        mMeowBottom.add(new MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account));


        // BottomNavigation

        mMeowBottom.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(MainActivity.this, "Clicked item :" + item.getId(), Toast.LENGTH_SHORT).show();
                // kh co dong nay se bi close app
            }
        });

        mMeowBottom.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String name;
                switch (item.getId()) {
                    case ID_HOME:
                        name = "Home";
                        break;
                    case ID_MENU:
                        name = "Menu";
                        Intent intentMenu = new Intent(MainActivity.this, MenuFood.class);
                        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                        startActivity(intentMenu);
                        break;
                    case ID_NOTIFICATION:
                        name = "Notification";
                        Intent intentNotification = new Intent(MainActivity.this, Notification.class);
                        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                        startActivity(intentNotification);
                        break;
                    case ID_ACCOUNT:
                        name = "Account";
                        Intent intentProfile = new Intent(MainActivity.this, Profile.class);
                        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                        startActivity(intentProfile);
                        break;
                    default:
                        name = "";
                }
//                tv_selected.setText(getString(R.string.main_page_selected, name));
            }
        });

        mMeowBottom.setCount(ID_NOTIFICATION, "4");
        mMeowBottom.show(ID_HOME, true);
    }

    // Food Detail
    @Override
    public void onFoodMainClick(FoodMain foodMain, ImageView foodImageView) {
        // tạo hoạt ảnh chuyển tiếp giữa hai activity

        Intent intent = new Intent(this, FoodDetailActivity.class);
        // send food information to deatilActivity
        intent.putExtra("title",foodMain.getNameFood());
        intent.putExtra("imgURL",foodMain.getImgFood());
        intent.putExtra("imgCover",foodMain.getCoverPhoto());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                foodImageView,"sharedName");

        startActivity(intent,options.toBundle());
    }

    // DrawLayout
    public void ClickMenu(View view) {
        // Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        // Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        // Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        // Close drawer layout
        // Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // When drawer is open
            // Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        // Recreate activity
        recreate();
    }

    public void ClickKindOfFood(View view) {
        // Redirect activity to kindoffood
        redirectActivity(this, KindOfFoods.class);
    }

    public void ClickAboutUs(View view) {
        // Redirect activity to about us
        redirectActivity(this, AboutUs.class);
    }

    public void ClickLogout(View view) {
        // Close app
        logout(this);
    }

    public static void logout(Activity activity) {
        // Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure want to logout");
        // Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Finish activity
                activity.finishAffinity();
                // Exit app
                System.exit(0);
            }
        });
        // Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Dismiss dialog
                dialogInterface.dismiss();
            }
        });
        // Show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class mClass) {
        // Initialize intent
        Intent intent = new Intent(activity, mClass);
        // Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Close drawer
        closeDrawer(drawerLayout);
    }
}