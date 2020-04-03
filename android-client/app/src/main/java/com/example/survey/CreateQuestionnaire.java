package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CreateQuestionnaire extends AppCompatActivity {
    LinearLayout linearLayout;
    int questionCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_questionnaire);
        linearLayout = findViewById(R.id.linearlayout);
        linearLayout.addView(new QuestionCard(this), 0);
    }

    public void addQuestion(View v) {
        linearLayout.addView(new QuestionCard(this), linearLayout.getChildCount()-3);
        questionCount++;
    }

    public void delQuestion(View v) {
        if(questionCount == 1)
            return;
        linearLayout.removeViewAt(linearLayout.getChildCount()-4);
        questionCount--;
    }

    public void commitQuestionnaire(View v) {
        for(int i=0; i<questionCount; i++) {
            if(!((QuestionCard)linearLayout.getChildAt(i)).isValid()) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.questionnaire_invalid_warning), Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Question[] questionnaire = new Question[questionCount];
        for(int i=0; i<questionCount; i++) {
            questionnaire[i] = ((QuestionCard)linearLayout.getChildAt(i)).toQuestion();
        }

        Intent intent = new Intent(this, QuestionnaireActivity.class);
        intent.putExtra("count", questionCount);
        for(int i=0; i<questionCount; i++) {
            intent.putExtra("question"+i, questionnaire[i]);
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
