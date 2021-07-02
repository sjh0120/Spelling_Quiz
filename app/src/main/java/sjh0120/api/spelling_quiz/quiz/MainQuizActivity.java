package sjh0120.api.spelling_quiz.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import sjh0120.api.spelling_quiz.R;


public class MainQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_main_quiz);



        Button buttonQuiz = findViewById((R.id.goNormal));
        buttonQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), QuizNormal.class);
                startActivityForResult(intent, 203);
            }
        });

        Button buttongoChall = findViewById((R.id.goChall));
        buttongoChall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(getApplicationContext(), QuizChallTest.class );
                //startActivityForResult(intent, 2031);
            }
        });

        Button buttongoAnswer = findViewById((R.id.goAnswer));
        buttongoAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(getApplicationContext(), QuizAnswerTest.class);
                //startActivityForResult(intent, 2032);



            }
        });

        Button buttongoRank = findViewById((R.id.goRank));
        buttongoRank.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(getApplicationContext(), QuizRankTest.class);
                //startActivityForResult(intent, 2033);

            }
        });

        Button buttonback = findViewById((R.id.backbutton));
        buttonback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
