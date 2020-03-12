package com.example.survey;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class report extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    Question[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        showReport();
    }

    protected void showReport() {
        Intent intent = getIntent();
        int size = intent.getIntExtra("len", 0);
        questions = new Question[size];

        for(int i=0; i<size; i++) {
            //build questions
            try {
                String str = intent.getStringExtra("Question"+i);
                JSONObject jsonObject = new JSONObject(str);
                questions[i] = new Question(jsonObject, false);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //show questions
            String answer = new String();
            String[] ansArray = questions[i].getAnswers();
            for(int j=0; j<ansArray.length; j++) {
                answer += ansArray[j];
                answer += "\n";
            }
            addItem(Integer.toString(i+1) + ". " + questions[i].getQuestion(), answer);
        }
    }

    protected void addItem(String question, String answer) {
        LinearLayout layout = findViewById(R.id.answer_area);

        TextView q = new TextView(this);
        LinearLayout.LayoutParams param =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        param.gravity = Gravity.CENTER_HORIZONTAL;
        param.bottomMargin = 10;
        q.setLayoutParams(param);
        q.setText(question);
        q.setTextSize(20);

        TextView a = new TextView(this);
        LinearLayout.LayoutParams param2 =
                new LinearLayout.LayoutParams(650,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        param2.gravity = Gravity.CENTER_HORIZONTAL;
        param2.bottomMargin = 60;
        a.setLayoutParams(param2);
        a.setText(answer);
        a.setTextSize(16);

        layout.addView(q);
        layout.addView(a);
    }


    public void exit(android.view.View V) {
        System.exit(0);
    }

    public void storeInApp(android.view.View V) {
        Intent intent = getIntent();
        try {
            String output = getResultFileContent();

            File f = getFilesDir();
            File file = new File(f, "info.json");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            if(file.length() == 0) {
                raf.seek(file.length());
                raf.write(("{\"results\":[" + output + "]}").getBytes());
            }
            else {
                raf.seek(file.length()-2);
                raf.write((",\n" + output + "]}").getBytes());
            }
            raf.close();

            Toast.makeText(report.this, "Store in app: success", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(report.this, "failed: File Error", Toast.LENGTH_LONG).show();
        }
    }

    public void storeInSDCard(android.view.View V) {
        Intent intent = getIntent();
        askForPermission();
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_UNKNOWN)) {
            Toast.makeText(report.this, "You don't have a SD card!", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String output = getResultFileContent();

            File f = getExternalFilesDir(null);
            File file = new File(f, "info.json");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            if(file.length() == 0) {
                raf.seek(file.length());
                raf.write(("{\"results\":[" + output + "]}").getBytes());
            }
            else {
                raf.seek(file.length()-2);
                raf.write((",\n" + output + "]}").getBytes());
            }
            raf.close();

            Toast.makeText(report.this, "Store inside SD card: success", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(report.this, "failed: File Error", Toast.LENGTH_LONG).show();
        }
    }

    private String getResultFileContent() {
        String output = new String();
        try {
            JSONArray jarray = new JSONArray();
            for(int i=0; i<questions.length; i++) {
                JSONObject oneItem = questions[i].getResult();
                jarray.put(oneItem);
            }
            output = jarray.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return output;
    }

    public void askForPermission() {
        int permission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }


}
