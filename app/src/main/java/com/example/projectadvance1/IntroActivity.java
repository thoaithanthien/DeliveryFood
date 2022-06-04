package com.example.projectadvance1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectadvance1.adapter.AdapterIntro;
import com.example.projectadvance1.object.ItemScreen;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private AdapterIntro adapterIntro;
    private TabLayout tabLayoutIntro;
    private Button btnNext, btnGetStarted;
    private int position = 0;
    private Animation btnAnim;
    private TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // make the activity on full screen
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // when this activity is about to be launch , need to check if its opened before or not
//        if (restorePrefData()) {
//
//            Intent mainActivity = new Intent(getApplicationContext(), Login.class);
//            startActivity(mainActivity);
//            finish();
//        }

        setContentView(R.layout.activity_intro);

//        // hide the action bar
//        getSupportActionBar().hide();

        // Anh xa views
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        tabLayoutIntro = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);
        tvSkip = findViewById(R.id.tv_skip);

        // fill list screen
        final List<ItemScreen> mList = new ArrayList<>();
        mList.add(new ItemScreen("Fresh Food", "Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore " +
                "magna aliqua, consectetur  consectetur adipiscing elit", R.drawable.img1));
        mList.add(new ItemScreen("Fast Delivery", "Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore " +
                "magna aliqua, consectetur  consectetur adipiscing elit", R.drawable.img2));
        mList.add(new ItemScreen("Easy Payment", "Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                "dolore magna aliqua, consectetur  consectetur adipiscing elit", R.drawable.img3));

        // setup viewpager
        viewPager = findViewById(R.id.screen_viewpager);
        adapterIntro = new AdapterIntro(this, mList);
        viewPager.setAdapter(adapterIntro);

        // setup tablayout with viewpager
        tabLayoutIntro.setupWithViewPager(viewPager);

        // next button click Listner
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = viewPager.getCurrentItem();
                if (position < mList.size()) {
                    position++;
                    viewPager.setCurrentItem(position);
                }
                if (position == mList.size()-1) { // khi chúng tôi chuyển đến màn hình cuối cùng
                    // TODO : show the GETSTARTED Button and hide the indicator and the next button
                    loaddLastScreen();
                }
            }
        });

        // tablayout add change listener
        tabLayoutIntro.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1) {

                    loaddLastScreen();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Get Started button click listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open main activity
                Intent mainActivity = new Intent(getApplicationContext(), Login.class);
                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
                startActivity(mainActivity);
                savePrefsData();
                finish();

            }
        });

        // skip button click listener
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mList.size());
            }
        });
    }
    private boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenBefore = pref.getBoolean("isIntroOpen",false);
        return  isIntroActivityOpenBefore;

    }

    private void savePrefsData() {
        // If da open activity thi lan sau se kh hien activity do nua
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpen",true);
        editor.commit();
    }

    // show the GETSTARTED Button and hide the indicator and the next button
    private void loaddLastScreen() {

        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabLayoutIntro.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation the getstarted button
        // setup animation
        btnGetStarted.setAnimation(btnAnim);
    }
}