package com.acmegrade.assign_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button btnstart,btnabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstart=(Button) findViewById(R.id.button);
        btnabout=(Button)findViewById(R.id.button2);
        name=(EditText)findViewById(R.id.editName);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametext=name.getText().toString();
                if(nametext.length()!=0) {
                    Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
                    Toast.makeText(getApplicationContext(), "You can start quiz", Toast.LENGTH_LONG).show();
                    intent.putExtra("My name", nametext);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please Enter your name", Toast.LENGTH_LONG).show();
                }
            }
        });
           btnabout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent=new Intent (getApplicationContext(),DeveloperActivity.class);
                   startActivity(intent);
               }
           });

    }
}