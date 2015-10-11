package ItemParser;

import java.util.ArrayList;

/**
 * Created by rsparks on 10/10/15.
 * ItemPrices object - there will be a unique one for each item and it will keep track of different prices and how often it was seen
 */
public class ItemPrices {
    public String name;
    public ArrayList<float[]> priceList;

    /**
     * Constructor that keeps track of different prices and counts, also associates a name
     * @param regex item that you're searching for
     * @param itemName Name of the item
     * @param itemList List of all of the items
     */
    public ItemPrices(String regex, String itemName, ArrayList<Item> itemList) {
        this.name = itemName;
        this.priceList = matchPrices(itemList, regex);
    }

    /**
     * Matches the item you search for and keeps a list of prices and count
     * @param itemListParam List of items to search
     * @param regex of item to match
     * @return Arraylist of floats[] that contain [Price, Count]
     */
    public ArrayList<float[]> matchPrices(ArrayList<Item> itemListParam, String regex) {
        ArrayList<float[]> itemPriceArray = new ArrayList<float[]>();
        for (Item item : itemListParam) {
            if (item.name.matches(regex)) {
                if (!itemPriceArray.isEmpty()) {
                    for (int j = 0; j < itemPriceArray.size(); j++) {
                        if (itemPriceArray.get(j)[0] == item.price) {
                            itemPriceArray.get(j)[1]++;
                            break;
                        } else if(j == itemPriceArray.size()-1){
                            itemPriceArray.add(new float[]{item.price, 1});
                          break;
                        }

                    }
                } else {
                    itemPriceArray.add(new float[]{item.price, 1});

                }
            }
        }
        return itemPriceArray;
    }

    /**
     * Gets how many times a particular item was seen
     * @return total times seen
     */
    public int totalOfItem(){
        int itemTotal = 0;
        for(float[] price: this.priceList){
            itemTotal+=price[1];
        }
        return itemTotal;
    }

}
