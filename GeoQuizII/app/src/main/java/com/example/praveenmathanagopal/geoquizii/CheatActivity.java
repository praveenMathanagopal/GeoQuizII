package com.example.praveenmathanagopal.geoquizii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Button show_answer;
    private TextView answer_text ;
    private Question q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        q = QuestionBank.question_bank.get(getIntent().getIntExtra("INDEX", 0));
        show_answer = (Button)findViewById(R.id.show_answer);
        answer_text = (TextView)findViewById(R.id.answer_text);
        show_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(q.isAnswer())
                    answer_text.setText("True");
                else
                    answer_text.setText("False");
                Intent i = new Intent();
                i.putExtra("RESULT_SHOWN", true);
                setResult(RESULT_OK, i);
            }
        });

    }

}
