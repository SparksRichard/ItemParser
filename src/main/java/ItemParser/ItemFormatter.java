package ItemParser;

import java.util.ArrayList;
import java.util.Formatter;

/**
 * Created by rsparks on 10/10/15.
 * This class takes ItemPrices objects, formats and prints them to the screen,
 */
public class ItemFormatter {
    private Formatter f = new Formatter(System.out);

    /**
     * Formats and prints the name of item, how many times it was seen, then cycles through and prints price and how many items at that particular price
     * @param itemPrices object for particular item
     */
    public void printItem(ItemPrices itemPrices) {
        int itemTotal = itemPrices.totalOfItem();
        ArrayList<float[]> itemAmount = itemPrices.priceList;
        f.format("%-5s %8s %6s %-5s %1d %-6s\n", "name:",itemPrices.name,"","seen:",itemTotal,timeOrTimes(itemTotal));
        f.format("%14s %6s %13s\n","==============","","=============");
        for(float[] price: itemAmount){
            f.format("%-9s %4.2f %6s %-5s %1d %-6s\n","Price:",price[0],"","seen:",(int)price[1],timeOrTimes((int)price[1]));
            if(price!=itemAmount.get(itemAmount.size()-1)||itemAmount.size()==1){
                f.format("%14s %6s %13s\n","--------------","","-------------");
            }
        }
        f.format("\n");
    }

    /**
     * Formats and prints the total number of errors in input to the screen.
     * @param errorCount total number of items that failed to be constructed
     */
    public void printErrors(int errorCount){
        f.format("%-21s %-5s %1d %-6s\n","Errors","seen:",errorCount,timeOrTimes(errorCount));
    }

    /**
     * Checks for singular or plural and returns corresponding word
     * @param amount of item
     * @return time or times depending on singular or plural
     */
    public String timeOrTimes(int amount){
        if(amount==1){
            return "time";
        }
        else{
            return "times";
        }
    }
}
