package sjh0120.api.spelling_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import sjh0120.api.spelling_quiz.quiz.MainQuizActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_main);

        Button buttonQuiz = findViewById((R.id.goQuiz));
        buttonQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainQuizActivity.class);
                startActivityForResult(intent, 102);
            }
        });

        Button buttongoSet = findViewById((R.id.goSet));
        buttongoSet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(getApplicationContext(), ManageActivity.class);
                //startActivityForResult(intent, 111);
            }
        });

        Button buttongoTakePicture = findViewById((R.id.goTakePicture));
        buttongoTakePicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(getApplicationContext(), Takecam.class);
                //startActivityForResult(intent, 105);
            }
        });
    }
}
