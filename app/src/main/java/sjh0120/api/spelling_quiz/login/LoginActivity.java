package sjh0120.api.spelling_quiz.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.api.Response;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import sjh0120.api.spelling_quiz.MainActivity;
import sjh0120.api.spelling_quiz.R;

public class LoginActivity extends AppCompatActivity {
    private EditText login_email, login_password;
    private Button btn_login, btn_register;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);

        login_email = (EditText)findViewById(R.id.login_email);
        login_password = (EditText)findViewById(R.id.login_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        mAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(view -> {
            //ProgressBar pb_login = (ProgressBar) findViewById(R.id.pb_login);
            //pb_login.setVisibility(View.VISIBLE);
            if (login_email.length() > 0 && login_password.length() > 0) {
                mAuth.signInWithEmailAndPassword(login_email.getText().toString(), login_password.getText().toString()).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        if (mAuth.getCurrentUser().isEmailVerified()) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            //pb_login.setVisibility(View.INVISIBLE);
                            Toast.makeText(LoginActivity.this, "이메일을 통해 계정 인증을 해주세요", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        //pb_login.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginActivity.this,"계정 정보, 이메일 인증을 확인해 주세요", Toast.LENGTH_SHORT).show();
                        login_email.setText(null);
                        login_password.setText(null);
                    }
                });
            } else {
                //pb_login.setVisibility(View.INVISIBLE);
                Toast.makeText(LoginActivity.this, "이메일, 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });
    }
}