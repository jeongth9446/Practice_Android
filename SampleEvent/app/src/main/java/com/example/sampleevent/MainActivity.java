package com.example.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import static java.sql.DriverManager.println;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        View view = findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림 : " + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 : " + curX + ", " + curY);

                }
                return true;
            }
        });

        GestureDetector detector;

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨.");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨.");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨.");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨 : " + v + ", " + v1);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨.");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling() 호출됨 : " + v + ", " + v1);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }

        });

    }
    public void println(String data) {
        textView.append(data + "\n");
    }


}