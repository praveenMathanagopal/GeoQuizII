package com.example.praveenmathanagopal.geoquizii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView question_textview;
    private Button true_button;
    private Button false_button;
    private Button next_button;
    private Button prev_button;
    private Button cheat_button;
    private int currentIndex = 0;
    private boolean cheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("CURRENT_INDEX", 0);
        }
        question_textview = (TextView) findViewById(R.id.question_text);
        true_button = (Button) findViewById(R.id.true_button);
        false_button = (Button) findViewById(R.id.false_button);
        next_button = (Button) findViewById(R.id.next_button);
        prev_button = (Button) findViewById(R.id.prev_button);
        cheat_button = (Button) findViewById(R.id.cheat_button);

        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % QuestionBank.question_bank.size();
                updateQuestion();
            }
        });

        prev_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = currentIndex - 1;
                if (currentIndex < 0)
                    currentIndex = QuestionBank.question_bank.size() - 1;
                updateQuestion();
            }
        });

        cheat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                i.putExtra("INDEX", currentIndex);
                startActivityForResult(i, 0);
            }
        });

        updateQuestion();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK)
            return;
        if(requestCode == 0){
            boolean result_shown = data.getBooleanExtra("RESULT_SHOWN", false);
            if(result_shown)
                cheater = true;
        }
    }

    private void updateQuestion() {
        cheater = false;
        Question q = QuestionBank.question_bank.get(currentIndex);
        question_textview.setText(q.getQuestionid());
    }

    private void checkAnswer(boolean clickedAnswer) {
        Question q = QuestionBank.question_bank.get(currentIndex);
        if(cheater)
            Toast.makeText(QuizActivity.this, "You Cheated", Toast.LENGTH_LONG).show();
        else if (q.isAnswer() == clickedAnswer)
            Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(QuizActivity.this, "InCorrect", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CURRENT_INDEX", currentIndex);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
