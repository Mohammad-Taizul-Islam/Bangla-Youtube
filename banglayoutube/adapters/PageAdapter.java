package com.example.banglayoutube.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.banglayoutube.fragments.ChannelFragment;
import com.example.banglayoutube.fragments.HomeFragment;
import com.example.banglayoutube.fragments.LiveFragment;
import com.example.banglayoutube.fragments.PlayListFragment;

public class PageAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;
    public PageAdapter(FragmentManager fm,int numOfTab) {
        super(fm);
        this.mNumOfTabs=numOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment tab1=new HomeFragment();
                return tab1;
            case 1:
                ChannelFragment tab2=new ChannelFragment();
                return tab2;
            case 2:
                PlayListFragment tab3=new PlayListFragment();
                return tab3;
            case  3:
                LiveFragment tab4=new LiveFragment();
                return tab4;
            default:
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
