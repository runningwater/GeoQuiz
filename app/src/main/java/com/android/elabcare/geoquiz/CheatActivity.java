package com.android.elabcare.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String TAG = "CheatActivity";
    private static final String EXTRA_ANSWER_IS_TRUE = "com.android.elabcare.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.android.elabcare.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private TextView mApiTextView;
    private Button mShowAnswer;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShow(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Log.i(TAG, "########" + String.valueOf(Build.VERSION.SDK_INT));
        mApiTextView = (TextView) findViewById(R.id.api_textview);
        mApiTextView.setText("API Level " + String.valueOf(Build.VERSION.SDK_INT));
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

    }

    private void setAnswerShownResult(boolean b) {
        Intent d = new Intent();
        d.putExtra(EXTRA_ANSWER_SHOWN, b);
        setResult(RESULT_OK, d);
    }
}
