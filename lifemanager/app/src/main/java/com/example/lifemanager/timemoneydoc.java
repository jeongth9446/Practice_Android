package com.example.lifemanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link timemoneydoc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class timemoneydoc extends Fragment {
    View view;
    public timemoneydoc() {

    }

    public static timemoneydoc newInstance() {
        timemoneydoc r = new timemoneydoc();
        return r;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timemoneydoc, container, false);
        return view;
    }
}