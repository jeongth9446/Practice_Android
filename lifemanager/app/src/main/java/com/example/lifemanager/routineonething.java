package com.example.lifemanager;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class routineonething extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10, chk11;
    View view;
    TextView txtDate;
    ArrayList<String> str;

    public routineonething(ArrayList<String> tmp) {
        str = tmp;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_routineonething, container, false);
        txtDate = (TextView)getActivity().findViewById(R.id.textDate);
        editText1 = view.findViewById(R.id.editText_routine1);
        editText2 = view.findViewById(R.id.editText_routine2);
        editText3 = view.findViewById(R.id.editText_routine3);
        editText4 = view.findViewById(R.id.editText_routine4);
        editText5 = view.findViewById(R.id.editText_routine5);
        editText6 = view.findViewById(R.id.editText_onething1);
        chk1 = view.findViewById(R.id.checkBox_routine1);
        chk2 = view.findViewById(R.id.checkBox_routine2);
        chk3 = view.findViewById(R.id.checkBox_routine3);
        chk4 = view.findViewById(R.id.checkBox_routine4);
        chk5 = view.findViewById(R.id.checkBox_routine5);
        chk6 = view.findViewById(R.id.checkBox_onething1);
        editText7 = view.findViewById(R.id.editText_goal1);
        editText8 = view.findViewById(R.id.editText_goal2);
        editText9 = view.findViewById(R.id.editText_goal3);
        editText10 = view.findViewById(R.id.editText_goal4);
        editText11 = view.findViewById(R.id.editText_goal5);
        chk7 = view.findViewById(R.id.checkBox_goal1);
        chk8 = view.findViewById(R.id.checkBox_goal2);
        chk9 = view.findViewById(R.id.checkBox_goal3);
        chk10 = view.findViewById(R.id.checkBox_goal4);
        chk11 = view.findViewById(R.id.checkBox_goal5);



        //Toast.makeText(getContext(), txtDate.getText()+"open", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), str.get(1)+"open", Toast.LENGTH_SHORT).show();
        if(!str.get(1).equals("null"))
            editText1.setText(str.get(1));
        if(!str.get(4).equals("null"))
            editText2.setText(str.get(4));
        if(!str.get(7).equals("null"))
            editText3.setText(str.get(7));
        if(!str.get(10).equals("null"))
            editText4.setText(str.get(10));
        if(!str.get(13).equals("null"))
            editText5.setText(str.get(13));
        if(!str.get(16).equals("null"))
            editText6.setText(str.get(16));

        if(str.get(2).equals("True"))
            chk1.setChecked(true);
        else chk1.setChecked(false);
        if(str.get(5).equals("True"))
            chk2.setChecked(true);
        else chk2.setChecked(false);
        if(str.get(8).equals("True"))
            chk3.setChecked(true);
        else chk3.setChecked(false);
        if(str.get(11).equals("True"))
            chk4.setChecked(true);
        else chk4.setChecked(false);
        if(str.get(14).equals("True"))
            chk5.setChecked(true);
        else chk5.setChecked(false);
        if(str.get(17).equals("True"))
            chk6.setChecked(true);
        else chk6.setChecked(false);



        if(!str.get(19).equals("null"))
            editText7.setText(str.get(19));
        if(!str.get(22).equals("null"))
            editText8.setText(str.get(22));
        if(!str.get(25).equals("null"))
            editText9.setText(str.get(25));
        if(!str.get(28).equals("null"))
            editText10.setText(str.get(28));
        if(!str.get(31).equals("null"))
            editText11.setText(str.get(31));


        if(str.get(20).equals("True"))
            chk7.setChecked(true);
        else chk7.setChecked(false);
        if(str.get(23).equals("True"))
            chk8.setChecked(true);
        else chk8.setChecked(false);
        if(str.get(26).equals("True"))
            chk9.setChecked(true);
        else chk9.setChecked(false);
        if(str.get(29).equals("True"))
            chk10.setChecked(true);
        else chk10.setChecked(false);
        if(str.get(32).equals("True"))
            chk11.setChecked(true);
        else chk11.setChecked(false);

        return view;
    }


    @Override
    public void onStop() {



        scatter(txtDate.getText().toString());
        Toast.makeText(getContext(), "저장완료", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
    public void setTextroutine1(String str) {
        //editText1.setText(str);
    }

    private void scatter(String filename) {
        InputStream iStream = null;

            try {
                FileOutputStream fos = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
                PrintWriter writer = new PrintWriter(fos);

                writer.println("routine1");
                writer.println(editText1.getText().toString());
                if(chk1.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("routine2");
                writer.println(editText2.getText().toString());
                if(chk2.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("routine3");
                writer.println(editText3.getText().toString());
                if(chk3.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("routine4");
                writer.println(editText4.getText().toString());
                if(chk4.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("routine5");
                writer.println(editText5.getText().toString());
                if(chk5.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("onething");
                writer.println(editText6.getText().toString());
                if(chk6.isChecked()) writer.println("True");
                else writer.println("False");


                writer.println("goal1");
                writer.println(editText7.getText().toString());
                if(chk7.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("goal2");
                writer.println(editText8.getText().toString());
                if(chk8.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("goal3");
                writer.println(editText9.getText().toString());
                if(chk9.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("goal4");
                writer.println(editText10.getText().toString());
                if(chk10.isChecked()) writer.println("True");
                else writer.println("False");

                writer.println("goal5");
                writer.println(editText11.getText().toString());
                if(chk11.isChecked()) writer.println("True");
                else writer.println("False");


                for(int i = 0; i <24; i ++) {
                    for(int j = 0; j < 60; j += 30) {
                        writer.println(String.format("%02d:%02d", i, j));
                        writer.println("null");
                        writer.println("null");
                    }
                }



                writer.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
        }


    }



}
