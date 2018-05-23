package mu.organyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class ProfessionActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;

    private Button bartenderButton;
    private Button storeButton;
    private Button warehouseButton;
    private Button familyButton;
    private Button gymButton;
    private Button retailButton;
    private Button buttonLogOut;
    private TextView questionTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() == null) {
            //Log in screen
            finish();
            startActivity(new Intent(getApplicationContext(), LoginScreen.class));
        }


        buttonLogOut = (Button) findViewById(R.id.buttonLogOut) ;
        questionTextview = (TextView) findViewById(R.id.textViewWelcomeUser);

        bartenderButton = (Button) findViewById(R.id.bartender_button);
        storeButton = (Button) findViewById(R.id.store_button);
        warehouseButton = (Button) findViewById(R.id.warehouse_button);
        familyButton = (Button) findViewById(R.id.family_button);
        gymButton = (Button) findViewById(R.id.gym_button);
        retailButton = (Button) findViewById(R.id.retail_button);


        buttonLogOut.setOnClickListener(this);
        bartenderButton.setOnClickListener(this);
        storeButton.setOnClickListener(this);
        warehouseButton.setOnClickListener(this);
        familyButton.setOnClickListener(this);
        gymButton.setOnClickListener(this);
        retailButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == buttonLogOut) {
            auth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            Log.d("onClick" ,"-----------LogOut-------------");
        }

        if (view == bartenderButton) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
            Log.d("onClick" ,"-----------Bartender-------------");
        }

        if (view == storeButton) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
            Log.d("onClick" ,"-----------Store Manager-------------");

        }

        if (view == warehouseButton) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
            Log.d("onClick" ,"-----------WareHouse Manager-------------");

        }

        if (view == familyButton) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
            Log.d("onClick" ,"-----------Family-------------");

        }

        if (view == gymButton) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
            Log.d("onClick" ,"-----------Gym-------------");

        }

        if (view == retailButton) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
            Log.d("onClick" ,"-----------Retail-------------");

        }

    }

}