package com.android.elabcare.geoquiz;

/**
 * Created by runningwater on 2016/10/20.
 */

public class Question {
    private int mTextResId; //问题文本
    private boolean mAnswerTrue; //问题答案(true/false)

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }


    public Question(int textResId,boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }
}
