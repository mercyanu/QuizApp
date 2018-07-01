package com.example.aimitechsolutions.quizapp;

        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import static android.support.v4.os.LocaleListCompat.create;
        import static android.text.TextUtils.isEmpty;

public class TestActivity extends AppCompatActivity {

    private int totalScore = 0;
    //answers to questions
    private String ans1 = "Elon Musk";
    private String ans2 = "Innovative center";
    private String ans3 = "Facebook, Whatsapp and Instagram";
    private String ans4 = "Virtual Reality";
    private String ans5 = "Local Area Network";
    private String ans6 = "Text File";
    private String ans7 = "Alan Turing";

    //user selected answer
    private String selectedAns1;
    private String selectedAns2;
    private String selectedAns3;
    private String selectedAns4;
    private String selectedAns5;
    private String selectedAns6;
    private String selectedAns7;

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioGroup radioGroup6;
    private RadioGroup radioGroup7;

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;

    private TextView exp1;
    private TextView exp2;
    private TextView exp3;
    private TextView exp4;
    private TextView exp5;
    private TextView exp6;
    private TextView exp7;

    private Button subButton;
    private Button resButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        subButton = findViewById(R.id.subButton);
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for question One
                radioGroup1 = findViewById(R.id.radio_group1);
                int rg1 = radioGroup1.getCheckedRadioButtonId();
                radioButton1 = findViewById(rg1);
                if (radioButton1 != null)
                    selectedAns1 = radioButton1.getText().toString();

                //for question Two
                radioGroup2 = findViewById(R.id.radio_group2);
                int rg2 = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = findViewById(rg2);
                if (radioButton2 != null)
                    selectedAns2 = radioButton2.getText().toString();

                //for question Three
                radioGroup3 = findViewById(R.id.radio_group3);
                int rg3 = radioGroup3.getCheckedRadioButtonId();
                radioButton3 = findViewById(rg3);
                if (radioButton3 != null)
                    selectedAns3 = radioButton3.getText().toString();

                //for question Four
                radioGroup4 = findViewById(R.id.radio_group4);
                int rg4 = radioGroup4.getCheckedRadioButtonId();
                radioButton4 = findViewById(rg4);
                if (radioButton4 != null)
                    selectedAns4 = radioButton4.getText().toString();

                //for question Five
                radioGroup5 = findViewById(R.id.radio_group5);
                int rg5 = radioGroup5.getCheckedRadioButtonId();
                radioButton5 = findViewById(rg5);
                if (radioButton5 != null)
                    selectedAns5 = radioButton5.getText().toString();

                //for question Six
                radioGroup6 = findViewById(R.id.radio_group6);
                int rg6 = radioGroup6.getCheckedRadioButtonId();
                radioButton6 = findViewById(rg6);
                if (radioButton6 != null)
                    selectedAns6 = radioButton6.getText().toString();

                //for question Seven
                radioGroup7 = findViewById(R.id.radio_group7);
                int rg7 = radioGroup7.getCheckedRadioButtonId();
                radioButton7 = findViewById(rg7);
                if (radioButton7 != null)
                    selectedAns7 = radioButton7.getText().toString();


                if (isEmpty(selectedAns1) || isEmpty(selectedAns2) || isEmpty(selectedAns3)
                        || isEmpty(selectedAns4) || isEmpty(selectedAns5)
                        || isEmpty(selectedAns6) || isEmpty(selectedAns7)){
                    Toast.makeText(getApplicationContext(), "Please answer all questions!!!", Toast.LENGTH_LONG).show();
                }
                else
                    checkAnswer();
            }
        });
    }

    public void checkAnswer(){
        //TextView textView = findViewById(R.id.textGini);
        //textView.setText("The chosen thing is " + selectedAns);

        if (selectedAns1.equals(ans1))
            totalScore+=1;
        else {
            exp1 = findViewById(R.id.exp1);
            exp1.setVisibility(View.VISIBLE);
        }

        if (selectedAns2.equals(ans2))
            totalScore+=1;
        else {
            exp2 = findViewById(R.id.exp2);
            exp2.setVisibility(View.VISIBLE);
        }

        if (selectedAns3.equals(ans3))
            totalScore+=1;
        else {
            exp3 = findViewById(R.id.exp3);
            exp3.setVisibility(View.VISIBLE);
        }

        if (selectedAns4.equals(ans4))
            totalScore+=1;
        else {
            exp4 = findViewById(R.id.exp4);
            exp4.setVisibility(View.VISIBLE);
        }

        if (selectedAns5.equals(ans5))
            totalScore+=1;
        else {
            exp5 = findViewById(R.id.exp5);
            exp5.setVisibility(View.VISIBLE);
        }

        if (selectedAns6.equals(ans6))
            totalScore+=1;
        else {
            exp6 = findViewById(R.id.exp6);
            exp6.setVisibility(View.VISIBLE);
        }

        if (selectedAns7.equals(ans7))
            totalScore+=1;
        else {
            exp7 = findViewById(R.id.exp7);
            exp7.setVisibility(View.VISIBLE);
        }

        showPerf();
    }

    public void showPerf(){

        subButton.setVisibility(View.GONE);
        resButton = findViewById(R.id.resButton);
        resButton.setVisibility(View.VISIBLE);

        AlertDialog.Builder dialogBuild = new AlertDialog.Builder(TestActivity.this);
        dialogBuild.setTitle("Thanks for trying the app out")
                .setIcon(R.drawable.imessage)
                .setMessage("Score: "+(int) Math.floor(totalScore*14.29)+"%")
                .setCancelable(false)
                .setPositiveButton("View Answers", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        Dialog dialog = dialogBuild.create();
        dialog.show();
}

    public void reset(View v){
        Intent i = getIntent();
        finish();
        startActivity(i);
    }
}
