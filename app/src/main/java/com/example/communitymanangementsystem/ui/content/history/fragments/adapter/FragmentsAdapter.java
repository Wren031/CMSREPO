package com.example.communitymanangementsystem.ui.content.history.fragments.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.communitymanangementsystem.ui.content.history.fragments.HomeFragments;
import com.example.communitymanangementsystem.ui.content.history.fragments.MedicineFragments;

public class FragmentsAdapter extends FragmentStateAdapter {

    public FragmentsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public FragmentsAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public FragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragments();
            case 1:
                return new MedicineFragments();
            default:
                return new HomeFragments();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
