package ItemParser;

import java.util.ArrayList;

/**
 * Created by rsparks on 10/10/15.
 */
public class ItemPrices {
    public String name;
    public ArrayList<float[]> priceList;


    public ItemPrices(String regex, String itemName, ArrayList<Item> itemList) {
        this.name = itemName;
        this.priceList = matchPrices(itemList, regex);

    }

    public ArrayList<float[]> matchPrices(ArrayList<Item> itemListParam, String regex) {
        ArrayList<float[]> itemPriceArray = new ArrayList<float[]>();
        for (Item item : itemListParam) {
            if (item.name.matches(regex)) {
                if (!itemPriceArray.isEmpty()) {
                    for (int j = 0; j < itemPriceArray.size(); j++) {
                        //for (float[] price : itemPriceArray) {
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

    public int totalOfItem(){
        int itemTotal = 0;
        for(float[] price: this.priceList){
            itemTotal+=price[1];
        }
        return itemTotal;
    }

}
