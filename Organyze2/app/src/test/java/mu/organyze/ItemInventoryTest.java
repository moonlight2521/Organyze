package mu.organyze;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zunlin on 11/17/17.
 * jUnit test for the ItemInventory class.
 */
public class ItemInventoryTest {
    private ItemInventory item;

//before the test
    @Before
    public void setUp() throws Exception {
        item =  new ItemInventory();
        item.setItemCategory("Fast Food");
        item.setItemName("pizza");
        item.setItemCost("10");
        item.setItemCount("1");
        System.out.println("ready for testing............");

    }
//after the test
    @After
    public void tearDown() throws Exception {
        System.out.println("done with unit test............");

    }
//testing:

    @Test
    public void getItemCategory() throws Exception {
        String itemCategory = item.getItemCategory();
        assertEquals("Test didn't match ","Fast Food", itemCategory);
    }

    @Test
    public void getItemName() throws Exception {
        String itemName = item.getItemName();
        assertEquals("Test didn't match ","pizza", itemName);
    }

    @Test
    public void getItemCost() throws Exception {
        String itemCost = item.getItemCost();
        assertEquals("Test didn't match ","10", itemCost);
    }

    @Test
    public void getItemCount() throws Exception {
        String itemCount = item.getItemCount();
        assertEquals("Test didn't match ","1", itemCount);
    }


}