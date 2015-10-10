package ItemParser;

import java.util.ArrayList;

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

    private ArrayList<Item> itemList = new ArrayList<Item>();
    private int exceptionCount = 0;


    /**
     * @return
     */
    public String[] parseInput() {
        String[] parsed = input.split("##");
        for (int i = 0; i < parsed.length; i++) {
            System.out.println(parsed[i]);
        }

        return parsed;

    }

    /**
     * @param _input
     */
    public ItemParser(String _input) {
        this.input = _input;
    }

    public ItemParser() {

    }

    public ArrayList<Item> buildItems(String[] parsedList) {
        for (String item : parsedList) {
            try {
                Item item00 = new Item(item);
                itemList.add(item00);
            } catch (Exception e) {
                exceptionCount++;
            }

        }
        return itemList;
    }


    public static void main(String[] args) {
        int exceptionCount = 0;
        ItemParser itemParser = new ItemParser();
        String[] parsed = itemParser.parseInput();
        ArrayList<Item> itemList = itemParser.buildItems(parsed);

        ItemPrices cookiePrices = new ItemPrices("(?i)(c.*)", "Cookies", itemList);
        ItemPrices applesPrices = new ItemPrices("(?i)apples.*", "Apples", itemList);
        ItemPrices breadPrices = new ItemPrices("(?i)(bread)", "Bread", itemList);
        ItemPrices milkPrices = new ItemPrices("(?i)(milk)", "Milk", itemList);


    }
}