package com.example.projectadvance1.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.projectadvance1.fragment.CakesFragment;
import com.example.projectadvance1.fragment.FruitFragment;
import com.example.projectadvance1.fragment.VegetablesFragment;

public class AdapterViewPage extends FragmentStatePagerAdapter {
    public AdapterViewPage(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FruitFragment();
            case 1:
                return new CakesFragment();
            case 2:
                return new VegetablesFragment();
            default:
                return new FruitFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        // Set title cho Tablayout
        String title = "";
        switch (position) {
            case 0:
                title = "FRUITS";
                break;
            case 1:
                title = "CAKES";
                break;
            case 2:
                title = "VEGETABLES";
                break;
        }
        return title;
    }
}
