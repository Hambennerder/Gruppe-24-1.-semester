package sduul;

public class ItemInventory {
    
    private int[] items;
    private int[] amount_of_items;

    public void setItems(int[] items, int[] amount_of_items) {
        
        this.items = items;
        this.amount_of_items = amount_of_items;
        
    }

    public int[] getItems() {
        
        return this.items;
        
    }

    public int[] getAmount() {
        
        return this.amount_of_items;
        
    }

}

