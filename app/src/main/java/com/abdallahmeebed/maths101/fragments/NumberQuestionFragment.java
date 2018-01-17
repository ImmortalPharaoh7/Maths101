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

    private int answer;
    private boolean valableClick = true;

    // setting up the question
    public void setupQuestion(String question, int answer){
        questionTextView.setText(question);
        this.answer = answer;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.number_question_fragment, container, false);
        questionTextView = (TextView) view.findViewById(R.id.numberQuestionPrompt);
        return view;
    }

    public void checkAnswer (){
        if (valableClick) {
           try{
               EditText answerEditText = getView().findViewById(R.id.numberQuestionAnswer);
               int answerUser = Integer.parseInt(answerEditText.getText().toString());

               if (answerUser == answer) {
                   valableClick = false;
                   Toast.makeText(getActivity(), R.string.correct, Toast.LENGTH_LONG).show();
               }else {
                   // goes to the incorrect answer fragment
                   FragmentManager fragmentManager = getFragmentManager();
                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   IncorrectAnswerFragment incorrectAnswerFragment = new IncorrectAnswerFragment();
                   fragmentTransaction.replace(android.R.id.content, incorrectAnswerFragment);
                   fragmentTransaction.commit();
               }
           }catch (Exception e){
               System.out.printf(e.toString());
               Toast.makeText(getActivity(), R.string.emtpyNumber, Toast.LENGTH_SHORT).show();
           }
        }
    }
}
