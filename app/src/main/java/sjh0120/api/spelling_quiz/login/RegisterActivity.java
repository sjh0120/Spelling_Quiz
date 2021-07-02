package sjh0120.api.spelling_quiz.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Response;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import sjh0120.api.spelling_quiz.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_name, reg_age;
    private Button btn_register;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        reg_name = findViewById(R.id.reg_name);
        reg_age = findViewById(R.id.reg_age);

        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(v -> {
            sendEmail();
        });

    }
    private void sendEmail() {
        String email = ((EditText) findViewById(R.id.reg_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.reg_password)).getText().toString();
        String password_check = ((EditText) findViewById(R.id.reg_password_check)).getText().toString();

        if (email.contains("@naver.com") | email.contains("@hanmail.net") | email.contains("@gmail.com")) {
            if (email.length() > 0 && password.length() > 0 && password_check.length() > 0) {
                if (password.equals(password_check)) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    mAuth.getCurrentUser().sendEmailVerification()
                                            .addOnCompleteListener(task1 -> {
                                                if (task1.isSuccessful()) {
                                                    FirebaseUser user = mAuth.getCurrentUser();
                                                    Toast.makeText(RegisterActivity.this, "이메일을 확인해주세요", Toast.LENGTH_LONG).show();
                                                    RegisterActivity.this.goActivity(LoginActivity.class);
                                                } else {
                                                    Toast.makeText(RegisterActivity.this, "인터넷 연결 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                                                }
                                            });
                                } else {
                                    Toast.makeText(RegisterActivity.this, "이미등록된 이메일입니다", Toast.LENGTH_LONG).show();
                                }
                            });
                } else {
                    Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "이메일 또는 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(RegisterActivity.this, "올바른 이메일형식을 사용해주세요!", Toast.LENGTH_SHORT).show();
        }
    }

    private void goActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}