package com.acmegrade.assign_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lastActivity extends AppCompatActivity {

    TextView tv, tv2, tv3, correctAnswersTextView,wrongAnswersTextView,finalScoreTextView;
    Button btnrestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnrestart = (Button) findViewById(R.id.btnRestart);


        correctAnswersTextView =(TextView) findViewById(R.id.tvres);
         wrongAnswersTextView =(TextView) findViewById(R.id.tvres2);
        finalScoreTextView =(TextView) findViewById(R.id.tvres3);

        correctAnswersTextView.setText("Correct answers: " + QuestionsActivity.correct);
        wrongAnswersTextView.setText("Wrong Answers: " + QuestionsActivity.wrong);
        finalScoreTextView.setText("Final Score: " + QuestionsActivity.correct);


        QuestionsActivity.correct=0;
        QuestionsActivity.wrong=0;

        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}