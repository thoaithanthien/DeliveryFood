package com.example.projectadvance1.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectadvance1.R;
import com.example.projectadvance1.animationCart.AnimationUtil;

public class FoodMenuDetail extends AppCompatActivity {
    private ImageView imgDetail,imgCover, endAnimation;
    private TextView tv_title,tv_description;
    private Button btnOrder;
    private ImageView viewAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu_detail);
        viewAnimation = findViewById(R.id.view_animation);
        endAnimation = findViewById(R.id.endAnimation);
        btnOrder = findViewById(R.id.btn_orderFoodMenu);
        // ini views
        iniViews();
        addToCart();


    }

    public void iniViews() {
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        imgDetail = findViewById(R.id.detail_foodMenu_img);
        Glide.with(this).load(imageResourceId).into(imgDetail);
        imgDetail.setImageResource(imageResourceId);
        imgCover= findViewById(R.id.detail_foodMenu_cover);
        Glide.with(this).load(imagecover).into(imgCover);
        tv_title = findViewById(R.id.detail_foodMenu_title);
        tv_title.setText(movieTitle);
        tv_description = findViewById(R.id.detail_foodMenu_desc);
        // setup animation
        imgCover.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        btnOrder.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
    }

    private void addToCart() {
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationUtil.translateAnimation(viewAnimation, btnOrder, endAnimation, new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}