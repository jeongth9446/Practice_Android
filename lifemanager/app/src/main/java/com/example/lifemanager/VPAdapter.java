package com.example.lifemanager;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentStatePagerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VPAdapter extends FragmentStatePagerAdapter {


    public ArrayList<String> data;
    public routineonething frag_rou;
    public timemoneydoc frag_time;
    public VPAdapter(FragmentManager fm, ArrayList<String> tmp) {
        super(fm);
        data = tmp;
        //frag_rou = new routineonething(data);
        frag_time = new timemoneydoc();
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return frag_rou;
            case 1:
                return frag_time;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
