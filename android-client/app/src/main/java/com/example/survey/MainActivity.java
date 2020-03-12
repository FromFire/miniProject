package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSurvey(android.view.View V) {
        CheckBox cb_accept = findViewById(R.id.accept);
        if(!cb_accept.isChecked())
            return;
        Intent intent = new Intent(this, question_page.class);
        startActivity(intent);
    }
}
