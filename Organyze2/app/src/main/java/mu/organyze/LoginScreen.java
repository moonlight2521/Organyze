package mu.organyze;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfessionActivity.class));
        }

        buttonSignin = (Button) findViewById(R.id.buttonSignin);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);

        buttonSignin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == buttonSignin) {
            userLogIn();
        }

        if (view == textViewSignUp) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void userLogIn() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email empty
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //password empty
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Start home screen
                    finish();
                    startActivity(new Intent(getApplicationContext(), ProfessionActivity.class));
                } else {
                    Toast.makeText(LoginScreen.this, "Try again! Wrong Password or email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
