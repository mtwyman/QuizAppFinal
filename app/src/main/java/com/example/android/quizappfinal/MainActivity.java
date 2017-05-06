package com.example.android.quizappfinal;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String VALID_TAG_VALUE = "valid";
    private RadioGroup quizQuestion1, quizQuestion2, quizQuestion3, quizQuestion4, quizQuestion5, quizQuestion6,
            quizQuestion7, quizQuestion8, quizQuestion9;
    private EditText customerNameEditText;
    private CheckBox quizQuestion10a;
    private CheckBox quizQuestion10b;
    private CheckBox quizQuestion10c;
    private CheckBox quizQuestion10d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonPressed();
            }
        });

        quizQuestion1 = (RadioGroup) findViewById(R.id.answer_to_question_1);
        quizQuestion2 = (RadioGroup) findViewById(R.id.answer_to_question_2);
        quizQuestion3 = (RadioGroup) findViewById(R.id.answer_to_question_3);
        quizQuestion4 = (RadioGroup) findViewById(R.id.answer_to_question_4);
        quizQuestion5 = (RadioGroup) findViewById(R.id.answer_to_question_5);
        quizQuestion6 = (RadioGroup) findViewById(R.id.answer_to_question_6);
        quizQuestion7 = (RadioGroup) findViewById(R.id.answer_to_question_7);
        quizQuestion8 = (RadioGroup) findViewById(R.id.answer_to_question_8);
        quizQuestion9 = (RadioGroup) findViewById(R.id.answer_to_question_9);

        quizQuestion10a = (CheckBox) findViewById(R.id.answer_10a);
        quizQuestion10b = (CheckBox) findViewById(R.id.answer_10b);
        quizQuestion10c = (CheckBox) findViewById(R.id.answer_10c);
        quizQuestion10d = (CheckBox) findViewById(R.id.answer_10d);

        customerNameEditText = (EditText) findViewById(R.id.person_name);
    }

    private void submitButtonPressed() {
        int points = 0;
        if (quizQuestion1.getCheckedRadioButtonId() == R.id.answer_1a) {
            points += 10;
        } else if (quizQuestion1.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion2.getCheckedRadioButtonId() == R.id.answer_2a) {
            points += 10;
        } else if (quizQuestion2.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion3.getCheckedRadioButtonId() == R.id.answer_3c) {
            points += 10;
        } else if (quizQuestion3.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion4.getCheckedRadioButtonId() == R.id.answer_4a) {
            points += 10;
        } else if (quizQuestion4.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion5.getCheckedRadioButtonId() == R.id.answer_5a) {
            points += 10;
        } else if (quizQuestion5.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion6.getCheckedRadioButtonId() == R.id.answer_6c) {
            points += 10;
        } else if (quizQuestion6.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion7.getCheckedRadioButtonId() == R.id.answer_7c) {
            points += 10;
        } else if (quizQuestion7.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion8.getCheckedRadioButtonId() == R.id.answer_8c) {
            points += 10;
        } else if (quizQuestion8.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion9.getCheckedRadioButtonId() == R.id.answer_9c) {
            points += 10;
        } else if (quizQuestion9.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (quizQuestion10a.isChecked() == false && quizQuestion10b.isChecked() == false &&
                quizQuestion10c.isChecked() == false && quizQuestion10d.isChecked() == false) {
            showError();
            return;
        }

        if (quizQuestion10b.isChecked()) {
            points += 5;
        }
        if (quizQuestion10c.isChecked()) {
            points += 5;
        }

        if (customerNameEditText.getText().toString().isEmpty()) {
            showError();
            return;
        }


        displayMessage(points);
    }

    void displayMessage(int score) {
        String userName = customerNameEditText.getText().toString();
        String message = "Hi " + userName + ",\nYou scored " + String.valueOf(score) + " out of 100";
        message += "\n" + quizResultMessage(score);

        new AlertDialog.Builder(this).setMessage(message).show();
    }

    String quizResultMessage(int score) {
        if (score <= 40) {
            return getString(R.string.result_0_40);
        } else if (score > 40 && score <= 60) {
            return getString(R.string.result_50_60);
        } else if (score > 60 && score <= 90) {
            return getString(R.string.result_70_90);
        } else {
            return getString(R.string.result_90_100);
        }
    }

    void showError() {
        // Show toast error message if the quiz taker doesn't answer all questions on the quiz
        Toast.makeText(this, "Please Answer All Questions!", Toast.LENGTH_SHORT).show();
    }
}