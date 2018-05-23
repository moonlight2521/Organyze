package mu.organyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> itemlists;
    private Button buttonLogout;
    private Button buttonHomeScreen;
    private ArrayAdapter arrayAdapter;
    FirebaseDatabase dataBase;
    DatabaseReference databaseItems;
    ListView listFinal;

    ArrayList<ItemInventory> itemFinalList;
    ArrayAdapter adapter;
    ArrayAdapter<String> adapterSearch;

    private ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        itemFinalList = new ArrayList<>();
        dataBase = FirebaseDatabase.getInstance();
        buttonLogout = (Button) findViewById(R.id.buttonLogOut);
        buttonHomeScreen = (Button) findViewById(R.id.buttonHomeScreen);

        buttonLogout.setOnClickListener(this);
        buttonHomeScreen.setOnClickListener(this);

        databaseItems = FirebaseDatabase.getInstance().getReference();

        listFinal = (ListView) findViewById(R.id.listFinal);
        lv = (ListView) findViewById(R.id.listFinal);

    }

    @Override
    protected void onStart() {
        super.onStart();

        itemlists = new ArrayList<String>();
        databaseItems.child("items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot itemSnapShot : dataSnapshot.getChildren()) {
                    String itemname = itemSnapShot.child("itemName").getValue().toString();

                    itemlists.add(itemname);
                    adapter = new ArrayAdapter(SearchActivity.this,android.R.layout.simple_list_item_1,itemlists);
                    listFinal.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogout) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }
        if (view == buttonHomeScreen) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}



