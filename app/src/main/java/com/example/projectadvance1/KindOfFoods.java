package com.example.projectadvance1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.projectadvance1.adapter.AdapterViewPage;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

public class KindOfFoods extends AppCompatActivity {
    // Initialize variable
    DrawerLayout drawerLayout;
    private TabLayout mTabLayout;
    private ViewPager mViewPage;
    private AdapterViewPage mViewPagerAdapter;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind_of_foods);
        initToolbal();
        // ViewFlipper
        viewFlipper = findViewById(R.id.viewPlipper);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

//        drawerLayout = findViewById(R.id.drawer_layoutDashBoard);

        mTabLayout = findViewById(R.id.tablayout);
        mViewPage = findViewById(R.id.viewpager);

        mViewPagerAdapter = new AdapterViewPage(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPage.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPage);
        setmTabLayoutAnimation();
    }

    private void initToolbal() {
        Toolbar toolbar = findViewById(R.id.toolbal);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KindOfFoods.this, MainActivity.class));
            }
        });
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setmTabLayoutAnimation() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.phamngocphuong);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int mycolor = palette.getVibrantColor(getResources().getColor(R.color.black));
                int myDarkcolor = palette.getVibrantColor(getResources().getColor(R.color.backgroundBottomColor));
                collapsingToolbarLayout.setContentScrimColor(mycolor);
                collapsingToolbarLayout.setStatusBarScrimColor(myDarkcolor);
            }
        });
    }
}

//    public void ClickMenu(View view) {
//        // Open drawer
//        MainActivity.openDrawer(drawerLayout);
//    }
//
//    public void ClickLogo(View view) {
//        // Close drawer
//        MainActivity.closeDrawer(drawerLayout);
//    }
//
//    public void ClickHome(View view) {
//        // Redirect activity to home
//        MainActivity.redirectActivity(this, MainActivity.class);
//    }
//
//    public void ClickDashBoard(View view) {
//        // Recreate activity
//        recreate();
//    }
//
//    public void ClickAboutUs(View view) {
//        // Redirect activity to about us
//        MainActivity.redirectActivity(this, AboutUs.class);
//    }
//
//    public void ClickLogout(View view) {
//        // Close app
//        MainActivity.logout(this);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // Close drawer
//        MainActivity.closeDrawer(drawerLayout);
//    }