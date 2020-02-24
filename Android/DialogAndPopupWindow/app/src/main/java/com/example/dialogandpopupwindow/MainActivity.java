package com.example.dialogandpopupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dialogandpopupwindow.Dialog.FragmentDialog;
import com.example.dialogandpopupwindow.Dialog.GeneralDialog;
import com.example.dialogandpopupwindow.window.MyWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button position = findViewById(R.id.position);
        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyWindow.builder(MainActivity.this)
//                        .build()
//                        .showAsDropDown(position);
                GeneralDialog.builder(MainActivity.this)
                        .build()
                        .show();
//                FragmentDialog fragmentDialog = new FragmentDialog();
//                fragmentDialog.show(getSupportFragmentManager(), "");
            }
        });

        final Button position2 = findViewById(R.id.position2);
        position2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWindow.builder(MainActivity.this)
                        .build()
                        .showAsDropDown(position2);
//                GeneralDialog.builder(MainActivity.this)
//                        .build()
//                        .show();
//                FragmentDialog fragmentDialog = new FragmentDialog();
//                fragmentDialog.show(getSupportFragmentManager(), "");
            }
        });
    }
}
