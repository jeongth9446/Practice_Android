package com.example.lifemanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.FeatureGroupInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity implements calendar.OnApplySelectedListener {

    public static String saveStorage = ""; //저장된 파일 경로
    public static String saveData = ""; //저장된 파일 내용
    routineonething frag_rou;
    VPAdapter adapter;
    calendar cal;
    private Activity activity;
    public ArrayList<String> listA = new ArrayList<>();

    private ArrayList <String> tabNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        setDate();
        frag_rou  = new routineonething(listA);
        transaction.replace(R.id.fragment_container, frag_rou);
        transaction.commit();

    }

    private void setDate() {
        TextView textdate = (TextView)findViewById(R.id.textDate);
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 M월 dd일");
        String getTime = simpleDate.format(mDate);
        textdate.setText(getTime);
        scatter(getTime);
    }

    private void scatter(String filename) {
        InputStream iStream = null;
        try {
            iStream = openFileInput(filename);
        } catch (FileNotFoundException e) {

            try {
                FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
                PrintWriter writer = new PrintWriter(fos);

                for(int i = 1; i <= 5; i ++) {
                    writer.println("routine"+ i);
                    writer.println("null");
                    writer.println("null");
                }
                writer.println("onething");
                writer.println("null");
                writer.println("null");

                for(int i = 1; i <= 5; i ++) {
                    writer.println("goal"+ i);
                    writer.println("null");
                    writer.println("null");
                }

                for(int i = 0; i <24; i ++) {
                    for(int j = 0; j < 60; j += 30) {
                        writer.println(String.format("%02d:%02d", i, j));
                        writer.println("null");
                        writer.println("null");
                    }
                }
                writer.close();
                iStream = openFileInput(filename);
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
    public void WriteTextFile(String foldername, String filename, String contents){
        try{
            File dir = new File (foldername);
            //디렉토리 폴더가 없으면 생성함
            if(!dir.exists()){
                dir.mkdir();
            }
            //파일 output stream 생성
            FileOutputStream fos = new FileOutputStream(foldername+"/"+filename, true);
            //파일쓰기
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(contents);
            writer.flush();

            writer.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.N)



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    public void onClickedDate(View view) {
        cal = new calendar();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cal).commit();


    }


    @Override
    public void onCatagoryApplySelected(String dd) {
        TextView textdate = (TextView)findViewById(R.id.textDate);
        textdate.setText(dd);
    }

}