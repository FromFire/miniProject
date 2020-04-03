package com.example.survey;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class QuestionCard extends ConstraintLayout {
    //0: multiple, 1:single, 2:filling
    int type = 0;
    int option_number = 1;

    ConstraintLayout parent;
    Spinner type_spinner;
    TextView option_intro;
    Button new_option;
    Button del_option;
    EditText lastOption;

    Context context;

    public QuestionCard(Context _context) {
        super(_context);
        context = _context;
        LayoutInflater.from(context).inflate(R.layout.question_card, this, true);

        option_intro = findViewById(R.id.option_intro);
        new_option = findViewById(R.id.add_option);
        del_option = findViewById(R.id.del_option);
        type_spinner = findViewById(R.id.question_type);
        lastOption = findViewById(R.id.option1);
        parent = findViewById(R.id.constraint_layout);

        initSpinner();
        initButton();
    }

    public void initSpinner() {
        type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EditText option1 = findViewById(R.id.option1);
                switch(position) {
                    case 0: //multiple
                    case 1: //single
                        if(type == 2) {
                            option_intro.setVisibility(VISIBLE);
                            option1.setVisibility(VISIBLE);
                            option1.setText("");
                            new_option.setVisibility(VISIBLE);
                            del_option.setVisibility(VISIBLE);
                            option_number = 1;
                        }
                        break;

                    case 2: //filling
                        ConstraintLayout prnt = findViewById(R.id.constraint_layout);

                        int begin = 0;
                        for(int i=0; i<prnt.getChildCount(); i++) {
                            if(prnt.getChildAt(i).getId() == option1.getId()) {
                                begin = i+1;
                                break;
                            }
                        }
                        while(begin != prnt.getChildCount()-1)
                            prnt.removeViewAt(begin);

                        option_intro.setVisibility(GONE);
                        option1.setVisibility(GONE);
                        new_option.setVisibility(GONE);
                        del_option.setVisibility(GONE);
                }
                type = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void initButton() {
        new_option.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addOption(v);
            }
        });

        del_option.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOption(v);
            }
        });
    }

    public void addOption(View v) {
        int insertIndex = 0;
        for (int i = parent.getChildCount()-1; i >= 0; i--) {
            if (parent.getChildAt(i).getId() == new_option.getId()) {
                insertIndex = i;
                break;
            }
        }
        Log.i("index", insertIndex + "");

        EditText editText = new EditText(context);
        editText.setId(View.generateViewId());
        int editTextId = editText.getId();
        LinearLayout.LayoutParams paramEdit = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(paramEdit);
        editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        editText.setSingleLine(false);

        parent.addView(editText, insertIndex);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(parent);
        constraintSet.connect(editTextId, ConstraintSet.START, lastOption.getId(), ConstraintSet.START);
        constraintSet.connect(editTextId, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        constraintSet.connect(editTextId, ConstraintSet.TOP, lastOption.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(new_option.getId(), ConstraintSet.TOP, editTextId, ConstraintSet.BOTTOM);
        constraintSet.applyTo(parent);

        lastOption = editText;
        option_number++;
    }

    public void deleteOption(View v) {
        if(option_number == 1)
            return;
        int index = 0;
        for(int i=parent.getChildCount()-1; i>=0; i--) {
            if(parent.getChildAt(i).getId() == lastOption.getId()) {
                index = i-1;
                break;
            }
        }
        parent.removeView(lastOption);
        lastOption = (EditText) parent.getChildAt(index);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(parent);
        constraintSet.connect(new_option.getId(), ConstraintSet.TOP, lastOption.getId(), ConstraintSet.BOTTOM);
        constraintSet.applyTo(parent);
        option_number--;
    }

    public boolean isValid() {
        if(((EditText)findViewById(R.id.question)).getText().toString().equals(""))
            return false;
        if(type == 2)
            return true;

        int begin = 0;
        for(int i=0; i<parent.getChildCount(); i++) {
            if(parent.getChildAt(i).getId() == R.id.option1)
                begin = i;
        }
        for(int i=begin; i<begin+option_number; i++) {
            EditText editText = (EditText) parent.getChildAt(i);
            if(editText.getText().toString().equals(""))
                return false;
        }
        return true;
    }

    public Question toQuestion() {
        int begin = 0;
        for(int i=0; i<parent.getChildCount(); i++) {
            if(parent.getChildAt(i).getId() == R.id.option1)
                begin = i;
        }

        String typeStr;
        switch (type) {
            case 0:
                typeStr = "multi"; break;
            case 1:
                typeStr = "single"; break;
            case 2:
            default:
                typeStr = "fill-in"; break;
        }
        String question = ((EditText)findViewById(R.id.question)).getText().toString();
        String[] options = new String[option_number];
        for(int i=begin; i<begin+option_number; i++) {
            options[i-begin] = ((EditText)parent.getChildAt(i)).getText().toString();
        }
        return new Question(typeStr, question, options);
    }

}
