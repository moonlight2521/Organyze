package mu.organyze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StoreData extends AppCompatActivity implements View.OnClickListener {

    TextView textViewCategory;
    TextView textViewNameItem;
    TextView textViewCost;
    TextView textViewCount;
    public String countItem;
    public String costItem;
    public String categoryItem;
    public String nameItem;

    Spinner spinnerCategoryItems;

    EditText editTextNameItem;
    EditText editTextCost;
    EditText editTextCount;

    Button buttonSubmitData;
    Button buttonHomeScreen;

    DatabaseReference databaseItems;
    ListView listFinal;

    List<ItemInventory> itemFinalList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);



        databaseItems = FirebaseDatabase.getInstance().getReference("items");

        spinnerCategoryItems = (Spinner) findViewById(R.id.spinnerCategoryItems);
        editTextNameItem = (EditText) findViewById(R.id.editTextNameItem);
        editTextCost = (EditText) findViewById(R.id.editTextCost);
        editTextCount = (EditText) findViewById(R.id.editTextCount);

        buttonSubmitData = (Button) findViewById(R.id.buttonSubmitData);
        buttonHomeScreen = (Button) findViewById(R.id.buttonHomeScreen);

        buttonHomeScreen.setOnClickListener(this);
        buttonSubmitData.setOnClickListener(this);

        listFinal = (ListView) findViewById(R.id.listFinal);

        itemFinalList = new ArrayList<>();

    }


    @Override
    public void onClick(View view) {
        if (view == buttonHomeScreen) {
            finish();
            startActivity(new Intent(this, HomeScreen.class));
        }
        if (view == buttonSubmitData) {
            addItem();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseItems.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                itemFinalList.clear();

                for (DataSnapshot itemSnapShot : dataSnapshot.getChildren()) {
                    ItemInventory itemInventoryTest = itemSnapShot.getValue(ItemInventory.class);

                    itemFinalList.add(itemInventoryTest);
                }

                ItemList adapter = new ItemList(StoreData.this, itemFinalList);
                listFinal.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addItem() {
        nameItem = editTextNameItem.getText().toString().trim();
        categoryItem = spinnerCategoryItems.getSelectedItem().toString();
        costItem = editTextCost.getText().toString().trim();
        countItem = editTextCount.getText().toString().trim();

        if (!TextUtils.isEmpty(nameItem)) {
            String uniqueId = databaseItems.push().getKey();
            ItemInventory itemInventory = new ItemInventory(categoryItem, nameItem, costItem , countItem);
            databaseItems.child(uniqueId).setValue(itemInventory);
            editTextNameItem.setText("");
            editTextCount.setText("");
            editTextCost.setText("");
            Toast.makeText(this, "Item added to inventory", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please fill everything!", Toast.LENGTH_LONG).show();
        }
    }

    public void setCountItem(String countItem) {
        this.countItem = countItem;
    }

    public String getCountItem() {
        return countItem;
    }
}
