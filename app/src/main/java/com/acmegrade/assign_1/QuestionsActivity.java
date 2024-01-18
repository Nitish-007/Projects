package com.acmegrade.assign_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    TextView txt;

    Button nxtbutton,quitbutton;

    RadioGroup radiogroup;

    RadioButton rbtn1,rbtn2,rbtn3,rbtn4;
    String questions[]={  "Which method can be defined only once in a program?","Which keyword is used by method to refer to the current object that\n" +
            "invoked it?", "Which of these access specifiers can be used for an interface?", "Which of the following is correct way of importing an entire package‘pkg’?",
            "What is the return type of Constructors?"};
    String options[]={"finalize method","main method","static method","private method","import","this","catch","abstract", "public","protected","private","All of the mentioned", "Import pkg.","import pkg.*","Import pkg.*","import pkg.","int","float","void","None of the mentioned"};
    String answers[]={ "main method","this","public","import pkg.*","None of the mentioned"};

     int flag=0;
     public static int correct=0,marks=0,wrong=0;
     TextView score,dname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        score=(TextView)findViewById(R.id.textView4) ;
        dname=(TextView) findViewById(R.id.DispName);
        Intent intent =getIntent();
        String name=intent.getStringExtra("My name");
        dname.setText("Hello "+name);

        nxtbutton=(Button) findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        txt=(TextView) findViewById(R.id.tvque);
        radiogroup=(RadioGroup)findViewById(R.id.answersgrp);
        rbtn1=(RadioButton)findViewById(R.id.radioButton);
        rbtn2=(RadioButton)findViewById(R.id.radioButton2);
        rbtn3=(RadioButton)findViewById(R.id.radioButton3);
        rbtn4=(RadioButton)findViewById(R.id.radioButton4);
        txt.setText(questions[flag]);
        rbtn1.setText(options[0]);
        rbtn2.setText(options[1]);
        rbtn3.setText(options[2]);
        rbtn4.setText(options[3]);

        nxtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radiogroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(),"Please select one option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton rbs=(RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
                String crtans=rbs.getText().toString();
                Toast.makeText(getApplicationContext(),crtans,Toast.LENGTH_SHORT).show();
                if(crtans.equals(answers[flag])){
                    correct++;
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
                flag++;

                if(score!=null)
                {
                    score.setText(""+correct);
                }
                if(flag<questions.length)
                {
                    txt.setText(questions[flag]);
                    rbtn1.setText(options[flag*4]);
                    rbtn2.setText(options[flag*4+1]);
                    rbtn3.setText(options[flag*4+2]);
                    rbtn4.setText(options[flag*4+3]);
                }
                else {
                    marks=correct;
                    Intent in=new Intent(getApplicationContext(),lastActivity.class);
                    startActivity(in);
                }
                radiogroup.clearCheck();
            }
        });
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),lastActivity.class);
                startActivity(intent);
            }
        });


    }
}