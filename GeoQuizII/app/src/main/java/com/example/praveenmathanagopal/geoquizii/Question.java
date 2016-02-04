package com.example.praveenmathanagopal.geoquizii;

/**
 * Created by praveen.mathanagopal on 2/3/2016.
 */
public class Question {
    private String questionid;
    private boolean answer;

    public Question(String questionid, boolean answer){
        this.questionid = questionid;
        this.answer = answer;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }






}
