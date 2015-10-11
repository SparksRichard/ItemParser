package ItemParserTest;

import ItemParser.ItemParser;
import ItemParser.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rsparks on 10/11/15.
 */
public class ItemPricesTest {
    ItemParser itemParser = new ItemParser();
    Item item = new Item();
    String input = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:milk;price:3.23;type:Food%expiration:1/25/2016##name:milk;price:3.25;type:Food;expiration:1/14/2016";
    String[] itemList = itemParser.parseInput(input);
    ArrayList<Item> itemArrayList = item.buildItems(itemList);
    ItemPrices itemPrices = new ItemPrices("(?i)milk", "Milk", itemArrayList);

    @Test
    public void matchPricesTest(){
        assertTrue("Checks that the return of .matchPrices is an ArrayList",itemPrices.matchPrices(itemArrayList,"(?i)milk")instanceof ArrayList);
    }


    @Test
    public void itemPricesConstructorTest() {
        assertEquals("Should return Milk", "Milk", itemPrices.name);
        assertTrue("Should return 3.23f",3.23f == itemPrices.priceList.get(0)[0]);
        assertTrue("Should return 3.25f",3.25f== itemPrices.priceList.get(1)[0]);
        assertTrue("Should return 2f",2f== itemPrices.priceList.get(0)[1]);
        assertTrue("Should return 1f",1f== itemPrices.priceList.get(1)[1]);
    }

    @Test
    public void totalOfItemTest(){
        assertEquals("Should return the total number of that item scanned, in this case 3",3,itemPrices.totalOfItem());
    }
}
