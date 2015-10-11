package ItemParser;

import java.util.ArrayList;
import java.util.Formatter;

/**
 * Created by rsparks on 10/10/15.
 */
public class ItemFormatter {
    private Formatter f = new Formatter(System.out);

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

    public void printErrors(int errorCount){
        f.format("%-21s %-5s %1d %-6s\n","Errors","seen:",errorCount,timeOrTimes(errorCount));
    }

    public String timeOrTimes(int amount){
        if(amount==1){
            return "time";
        }
        else{
            return "times";
        }
    }
}
