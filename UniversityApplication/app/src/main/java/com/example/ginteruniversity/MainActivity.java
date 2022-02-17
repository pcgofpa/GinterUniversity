package com.example.ginteruniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView subject1, subject2, subject3, maxGrade, minGrade, avgGrade, maxGradeOutput,
            minGradeOutput, avgGradeOutput;
    Button submitButton;
    EditText subject1Grade, subject2Grade, subject3Grade;
    int grade1, grade2, grade3, average, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find Textviews and set text
        subject1 =(TextView)findViewById(R.id.subject1);
        subject1.setText("Subject 1:");
        subject2 = (TextView) findViewById((R.id.subject2));
        subject2.setText("Subject 2");
        subject3 = (TextView) findViewById(R.id.subject3);
        subject3.setText("Subject 3");
        maxGrade = (TextView)findViewById(R.id.maxGrade);
        maxGrade.setText("Highest Grade");
        minGrade = (TextView) findViewById(R.id.minGrade);
        minGrade.setText("Lowest Grade");
        avgGrade = (TextView) findViewById(R.id.avgGrade);
        avgGrade.setText("Average Grade:");

        //Find input and convert to int
        subject1Grade = (EditText) findViewById(R.id.subject1Grade);
        grade1 = Integer.parseInt(subject1Grade.getText().toString());
        subject2Grade = (EditText) findViewById(R.id.subject2Grade);
        grade2 = Integer.parseInt(subject2Grade.getText().toString());
        subject3Grade = (EditText) findViewById(R.id.subject3Grade);
        grade3 = Integer.parseInt(subject3Grade.getText().toString());

        //Grade Output
        maxGradeOutput = (TextView) findViewById(R.id.maxGradeOutput);
        minGradeOutput = (TextView) findViewById(R.id.minGradeOutput);
        avgGradeOutput = (TextView) findViewById(R.id.avgGradeOutput);


        //Declare Button
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (grade1 > 90){
                    subject1Grade.setText("A");}
                else if (80 < grade1 && grade1 < 90){
                    subject1Grade.setText("B");
                } else if (70 < grade1 && grade1 < 80){
                    subject1Grade.setText("C");
                } else{
                    subject1Grade.setText("F");
                }

                //set maxGrade
                if (grade1 > grade2 && grade1 > grade3){
                    maxGradeOutput.setText(grade1);
                } else if (grade2 > grade1 && grade2 > grade3) {
                    maxGrade.setText(grade2);
                } else {
                    maxGrade.setText(grade3);
                }

                //set lowest grade
                if (grade1 < grade2 && grade1 < grade3) {
                    minGrade.setText(grade1);
                } else if (grade2 < grade1 && grade2 < grade3){
                    minGrade.setText(grade2);
                } else {
                    minGrade.setText(grade3);
                }

                //set average grade
                result = grade1 + grade2 + grade3;
                average = result /3;
                avgGradeOutput.setText(average);
            }
        });
    }
}

