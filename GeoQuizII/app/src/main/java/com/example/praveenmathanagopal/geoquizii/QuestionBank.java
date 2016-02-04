package com.example.praveenmathanagopal.geoquizii;

import java.util.ArrayList;

/**
 * Created by praveen.mathanagopal on 2/3/2016.
 */
public class QuestionBank {
    public static ArrayList<Question> question_bank = new ArrayList<>();

//    public Question getQuestionofId(String qid){
//        for(Question q: question_bank){
//            if(q.getQuestionid().equals(qid))
//                return q;
//        }
//        return null;
//    }

    static {
        question_bank.add(new Question("My name is Praveen", true));
        question_bank.add(new Question("I am Male", true));
        question_bank.add(new Question("I am an Idiot", false));
        question_bank.add(new Question("I like tennis", true));
        question_bank.add(new Question("I am a US citizen", false));
    }
}
