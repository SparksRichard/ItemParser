package ItemParser;

import java.util.ArrayList;

/**
 * Our Main Class
 * contains input
 * parses data
 */
public class ItemParser {
    private String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##" +
            "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##" +
            "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##" +
            "naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##" +
            "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
            "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
            "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##" +
            "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##" +
            "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##" +
            "naMe:;price:3.23;type:Food^expiration:1/04/2016##";


    /**
     * parses input at ##
     * @return parsedinput
     */
    public String[] parseInput(String input0) {
        String[] parsed = input0.split("##");
        return parsed;
    }

    //getter for input
    public String getInput(){return input;}

    public static void main(String[] args) {

        ItemParser itemParser = new ItemParser();
        Item item = new Item();
        String input = itemParser.getInput();
        String[] parsed = itemParser.parseInput(input);
        ArrayList<Item> itemList = item.buildItems(parsed);
        ItemFormatter itemFormatter = new ItemFormatter();
        ItemPrices cookiePrices = new ItemPrices("(?i)(c.*)", "Cookies", itemList);
        ItemPrices applesPrices = new ItemPrices("(?i)apples.*", "Apples", itemList);
        ItemPrices breadPrices = new ItemPrices("(?i)(bread)", "Bread", itemList);
        ItemPrices milkPrices = new ItemPrices("(?i)(milk)", "Milk", itemList);

        itemFormatter.printItem(milkPrices);
        itemFormatter.printItem(breadPrices);
        itemFormatter.printItem(cookiePrices);
        itemFormatter.printItem(applesPrices);
        itemFormatter.printErrors(item.getExceptionCount());
    }
}
