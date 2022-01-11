package com.example.lifemanager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendar extends Fragment {

    View view;

    private ArrayList<String> listA = new ArrayList<>();
    private Activity activity;
    private Activity activity2;
    private Fragment frag;
    routineonething frag_rou;
    CalendarView mCalendarView;
    public static calendar newInstance() {
        calendar r = new calendar();
        return r;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);

        mCalendarView = (CalendarView) view.findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayofMonth) {
                String date = year + "년 " + (month + 1) + "월 " + dayofMonth + "일";
                //Toast.makeText(container.getContext(), date, Toast.LENGTH_SHORT).show();
                ((OnApplySelectedListener)activity).onCatagoryApplySelected(date);
                scatter(date);
                frag_rou = new routineonething(listA);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,frag_rou).commit();
            }
        });

        return view;
    }


    private void scatter(String filename) {
        InputStream iStream = null;
        try {
            iStream = getActivity().openFileInput(filename);
        } catch (FileNotFoundException e) {

            try {
                FileOutputStream fos = getActivity().openFileOutput(filename, Context.MODE_APPEND);
                PrintWriter writer = new PrintWriter(fos);

                for(int i = 1; i <= 5; i ++) {
                    writer.println("routine"+ i);
                    writer.println("null");
                    writer.println("null");
                }
                writer.println("onething");
                writer.println("null");
                writer.println("null");
                for(int i = 0; i <24; i ++) {
                    for(int j = 0; j < 60; j += 30) {
                        writer.println(String.format("%02d:%02d", i, j));
                        writer.println("null");
                        writer.println("null");
                    }
                }
                writer.close();
                iStream = getActivity().openFileInput(filename);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            e.printStackTrace();
        }

        InputStreamReader iStreamReader = new InputStreamReader(iStream);
        BufferedReader bufferedReader = new BufferedReader(iStreamReader);
        String temp = "";
        StringBuffer sBuffer = new StringBuffer();

        while(true) {
            try {
                if (!((temp = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sBuffer.append(temp);
            listA.add(temp);
        }

        try {
            iStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        sBuffer.toString();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            // 사용될 activity의 context 정보 가져오는 부분
            this.activity = (Activity) context;
        }
    }



    public interface OnApplySelectedListener {
        public void onCatagoryApplySelected(String dd);
    }


}