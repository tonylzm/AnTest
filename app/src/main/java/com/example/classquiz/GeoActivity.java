package com.example.classquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GeoActivity extends AppCompatActivity {
    private TextView mTvQuestion;
    private Button mBtnTrue;
    private Button mBtnFalse;
    private Button mBtnPrev;
    private Button mBtnNext;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_america, true),
            new Question(R.string.question_asia, true)
    };
    private int mCurIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvQuestion = findViewById(R.id.txtQuestion);
        mBtnTrue = findViewById(R.id.btnTrue);
        mBtnFalse = findViewById(R.id.btnFalse);
        mBtnPrev = findViewById(R.id.btnPrev);
        mBtnNext = findViewById(R.id.btnNext);

        mTvQuestion.setText(mQuestionBank[mCurIdx].getTextResId());

        mBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GeoActivity.this,
                        R.string.click_true,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurIdx = (mCurIdx + 1) % mQuestionBank.length;
                mTvQuestion.setText(mQuestionBank[mCurIdx].getTextResId());
            }
        });
        mBtnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurIdx == 0) {
                    mCurIdx = mQuestionBank.length - 1;
                }
                else {
                    mCurIdx = (mCurIdx - 1) % mQuestionBank.length;
                }
                mTvQuestion.setText(mQuestionBank[mCurIdx].getTextResId());
            }
        });
    }
}