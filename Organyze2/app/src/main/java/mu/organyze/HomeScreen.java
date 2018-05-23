package mu.organyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;

    private TextView textHomeMessage;
    private Button buttonLogOut;
    private TextView textViewWelcomeUser;
    private Button buttonStoreData;
    private TextView professionPageButton;
    private Button buttonSearch;
    private Button buttonRankings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() == null) {
            //Log in screen
            finish();
            startActivity(new Intent(getApplicationContext(), LoginScreen.class));
        }

        final FirebaseUser currentUser = auth.getCurrentUser();
        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        buttonStoreData = (Button) findViewById(R.id.buttonStoreData);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonRankings = (Button) findViewById(R.id.buttonRankings);

        professionPageButton = (TextView) findViewById(R.id.professionPageButton);
        textHomeMessage = (TextView) findViewById(R.id.textHomeMessage);
        textViewWelcomeUser = (TextView) findViewById(R.id.textViewWelcomeUser);
        textViewWelcomeUser.setText("Welcome: " + currentUser.getEmail());

        buttonLogOut.setOnClickListener(this);
        buttonStoreData.setOnClickListener(this);
        professionPageButton.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        buttonRankings.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if (view == buttonLogOut) {
            auth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            Log.d("onClick" ,"-----------LogOut-------------");
        }
        if (view == buttonStoreData) {
            finish();
            startActivity(new Intent(this, StoreData.class));
            Log.d("onClick" ,"-----------Storing-------------");
        }
        if (view == professionPageButton) {
            finish();
            startActivity(new Intent(this, ProfessionActivity.class));
            Log.d("onClick" ,"-----------professions-------------");
        }
        if (view == buttonSearch) {
            finish();
            startActivity(new Intent(this, SearchActivity.class));
            Log.d("onClick" ,"-----------Searching-------------");
        }
        if (view == buttonRankings) {
            finish();
            startActivity(new Intent(this, RankingsActivity.class));
            Log.d("onClick" ,"-----------Ranking-------------");
        }

    }
}
