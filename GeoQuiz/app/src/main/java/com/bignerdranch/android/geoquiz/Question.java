package com.bignerdranch.android.geoquiz;

/**
 * Created by delmar on 6/4/2018.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mAnswered;


    public Question(int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

}
