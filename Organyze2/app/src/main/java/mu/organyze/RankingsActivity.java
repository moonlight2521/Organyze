package mu.organyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> itemlists;

    private ArrayAdapter arrayAdapter;
    FirebaseDatabase dataBase;
    DatabaseReference databaseItems;
    ListView listFinalCount;
    ListView listFinalCost;

    private Button buttonLogout;
    private Button buttonHomeScreen;

    ArrayList<ItemInventory> itemFinalList;
    ArrayList<ItemInventory> itemFinalCostList = new ArrayList<>();

    ArrayAdapter adapter;
    ArrayAdapter<String> adapterSearch;

    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        buttonLogout = (Button) findViewById(R.id.buttonLogOut);
        buttonHomeScreen = (Button) findViewById(R.id.buttonHomeScreen);


        itemFinalList = new ArrayList<>();
        dataBase = FirebaseDatabase.getInstance();
        databaseItems = FirebaseDatabase.getInstance().getReference();


        listFinalCost = (ListView) findViewById(R.id.listFinalCost);
        lv = (ListView) findViewById(R.id.listFinal);

        buttonLogout.setOnClickListener(this);
        buttonHomeScreen.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseItems.child("items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot itemSnapShot : dataSnapshot.getChildren()) {
                    String itemName = itemSnapShot.child("itemName").getValue().toString();
                    String itemCost = itemSnapShot.child("itemCost").getValue().toString();

                    itemFinalCostList.add(new ItemInventory(itemName, itemCost));
                }

                itemFinalCostList.sort(new Comparator<ItemInventory>() {
                    @Override
                    public int compare(ItemInventory item1, ItemInventory item2) {
                        int cost1 = Integer.parseInt(item1.getItemCost());
                        int cost2 = Integer.parseInt(item2.getItemCost());

                        return Integer.compare(cost1, cost2) * (-1);
                    }
                });

                Log.i("SORT", itemFinalCostList.toString());
                ItemCostAdapter costAdapter = new ItemCostAdapter(RankingsActivity.this, itemFinalCostList);
                listFinalCost.setAdapter(costAdapter);
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


}
