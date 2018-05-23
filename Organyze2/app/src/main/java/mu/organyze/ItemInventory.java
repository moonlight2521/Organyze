package mu.organyze;


public class ItemInventory {
    private String itemCategory;
    private String itemName;
    private String itemCost;
    private String itemCount;

    public ItemInventory(){

    }

    public ItemInventory(String itemName, String itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public ItemInventory(String itemCategory, String itemName, String itemCost, String itemCount) {
        this(itemName, itemCost);
        this.itemCategory = itemCategory;
        this.itemCount = itemCount;
    }

    public String getItemCategory() {

        return itemCategory;
    }

    public String getItemName() {

        return itemName;
    }

    public String getItemCost() {

        return itemCost;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public String toString() {
        return "ItemInventory{"
                + "itemCategory='" + itemCategory + '\''
                + ", itemName='" + itemName + '\''
                + ", itemCost='" + itemCost + '\''
                + ", itemCount='" + itemCount + '\''
                + '}';
    }
}
