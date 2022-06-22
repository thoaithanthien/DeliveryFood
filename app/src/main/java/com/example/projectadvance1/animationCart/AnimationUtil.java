package com.example.projectadvance1.animationCart;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class AnimationUtil {
    private static final int ANIMATION_DURATION = 1000;
    private static boolean isAnimationStar;

    public static void translateAnimation(final ImageView viewAnimation, final View starView, View endView,
                                          final Animation.AnimationListener animationListener) {
        starView.setDrawingCacheEnabled(true);
        Bitmap cache = starView.getDrawingCache();
        if (cache == null) {
            return;
        } else {
            Bitmap bitmap = Bitmap.createBitmap(cache);
            starView.setDrawingCacheEnabled(false);
            viewAnimation.setImageBitmap(bitmap);

            float starViewWidthCenter =  starView.getWidth() / 2;
            float starViewHeightCenter = starView.getHeight() / 2;

            float endViewWidthCenter =  endView.getWidth() * 0.75f;
            float endViewHeightCenter = endView.getHeight() / 2f;

            final int[] starPos = new int[2];
            starView.getLocationOnScreen(starPos);

            final int[] endPos = new int[2];
            endView.getLocationOnScreen(endPos);

            float fromX = starPos[0];
            float toX = endPos[0] + endViewWidthCenter - starViewWidthCenter;
            float fromY =  starPos[1] - starViewHeightCenter;
            float toY =  endPos[1] - endViewHeightCenter + starViewHeightCenter;

            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setInterpolator(new AccelerateInterpolator());

            int animationDuration = 200;

            ScaleAnimation starScaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f,
                    1.5f, starViewWidthCenter, starViewHeightCenter);
            starScaleAnimation.setDuration(animationDuration);

            TranslateAnimation translateAnimation = new TranslateAnimation(fromX, toX, fromY, toY);
            translateAnimation.setStartOffset(animationDuration);
            translateAnimation.setDuration(ANIMATION_DURATION);

            ScaleAnimation translateScaleAnimation = new ScaleAnimation(1.0f, 0.0f,1.0f, 0.0f, toX, toY);
            translateScaleAnimation.setStartOffset(animationDuration);
            translateScaleAnimation.setDuration(ANIMATION_DURATION);

            animationSet.addAnimation(starScaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(translateScaleAnimation);

            // defaul true
            if (isAnimationStar) {
                viewAnimation.clearAnimation();
                if (animationListener != null) {
                    animationListener.onAnimationEnd(null);
                }
            }

            viewAnimation.startAnimation(animationSet);

            animationSet.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    isAnimationStar = true;

                    viewAnimation.setVisibility(View.VISIBLE);
                    starView.setVisibility(View.VISIBLE);

                    if (animationListener != null) {
                        animationListener.onAnimationStart(animation);
                    }
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    viewAnimation.setVisibility(View.INVISIBLE);
                    starView.setVisibility(View.INVISIBLE);

                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation);
                    }
                    isAnimationStar = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                    if (animationListener != null) {
                        animationListener.onAnimationRepeat(animation);
                    }

                }
            });

        }
    }
}
