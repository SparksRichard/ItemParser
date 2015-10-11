package ItemParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jguevara on 10/9/15.
 * Matches items using regex. Creates item objects from item strings. Makes an ArrayList from all the items.
 */
public class Item {
    public String name;
    public float price;
    public String type;
    public String expiration;
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private int exceptionCount = 0;

    //Regex to store name, price, type, and expiration as group 1, 2, 3, and 4.
    Pattern itemPattern = Pattern.compile("name:([\\w\\d]+)[;^*%@!]price:(\\d+\\.\\d+)[;^*%@!]type:(\\w+)[;^*%@!]expiration:(.+)", Pattern.CASE_INSENSITIVE);

    //default constructor
    public Item() {}

    //getter for exceptionCount
    public int getExceptionCount() {
        return exceptionCount;
    }

    /**
     * Converts String item into an item object, throws Exception if pattern isn't matched.
     * @param input String item representation
     * @throws ItemException if all of the pattern isn't matched
     */
    public Item(String input) throws ItemException {
        Matcher separateFields = itemPattern.matcher(input);
        separateFields.find();
        this.name = separateFields.group(1);
        this.price = Float.valueOf(separateFields.group(2));
        this.type = separateFields.group(3);
        this.expiration = separateFields.group(4);
    }

    /**
     * Cycles through our parsedData and makes an object for each item, then puts all the items in an Arraylist.
     * Catches an error if the item doesn't have enough info to be constructed. Keeps a count of exceptions.
     * @param parsedList List of items as strings
     * @return list of Item objects
     */
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
}


