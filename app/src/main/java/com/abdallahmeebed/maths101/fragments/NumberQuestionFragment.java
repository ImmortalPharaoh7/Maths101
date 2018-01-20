package com.abdallahmeebed.maths101.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abdallahmeebed.maths101.R;
import com.abdallahmeebed.maths101.WelcomeActivity;

public class NumberQuestionFragment extends Fragment {

    TextView questionTextView;

    private int answerImageID = 0;
    private double answer;
    private String question = "Empty";
    private boolean valableClick = true;

    // setting up the question
    public void setupQuestion(String question, double answer){
        this.question = question;
        this.answer = answer;
    }

    public void setupQuestion(String question, double answer, int answerImageId){
        setupQuestion(question, answer);
        this.answerImageID = answerImageId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.number_question_fragment, container, false);
        questionTextView = view.findViewById(R.id.numberQuestionPrompt);
        questionTextView.setText(question);
        return view;
    }

    public void checkAnswer (){
        System.out.println("Checking the answer");
        if (valableClick) {
           try{
               EditText answerEditText = getView().findViewById(R.id.numberQuestionAnswer);
               int answerUser = Integer.parseInt(answerEditText.getText().toString());

               if (answerUser == answer) {
                   valableClick = false;
                   Toast.makeText(getActivity(), getString(R.string.correct), Toast.LENGTH_LONG).show();
               }else {
                   // goes to the incorrect answer fragment
                   FragmentManager fragmentManager = getFragmentManager();
                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   IncorrectAnswerFragment incorrectAnswerFragment = new IncorrectAnswerFragment();
                   if (answerImageID != 0) {

                       incorrectAnswerFragment.setAnswerImage(answerImageID);
                   }
                   fragmentTransaction.replace(android.R.id.content, incorrectAnswerFragment);
                   fragmentTransaction.commit();

               }
           }catch (Exception e){
               Toast.makeText(getActivity(), getString(R.string.emptyNumber), Toast.LENGTH_SHORT).show();
           }
        }
    }
}
