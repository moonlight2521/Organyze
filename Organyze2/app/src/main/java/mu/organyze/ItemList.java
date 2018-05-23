package mu.organyze;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ItemList extends ArrayAdapter<ItemInventory> {

    private Activity context;
    private List<ItemInventory> items;

    public ItemList(Activity context, List<ItemInventory> items) {
        super(context, R.layout.list_layout, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewCategory = (TextView) listViewItem.findViewById(R.id.textViewCategory);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewCost = (TextView) listViewItem.findViewById(R.id.textViewCost);
        final TextView textViewCount = (TextView) listViewItem.findViewById(R.id.textViewCount);

        ItemInventory itemInventoryTest = items.get(position);

        textViewCategory.setText(itemInventoryTest.getItemCategory());
        textViewName.setText(itemInventoryTest.getItemName());
        textViewCost.setText(itemInventoryTest.getItemCost());
        textViewCount.setText(itemInventoryTest.getItemCount());

        return listViewItem;

    }
}
