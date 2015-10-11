package ItemParserTest;

import ItemParser.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rsparks on 10/11/15.
 */
public class ItemTest {
    ItemParser itemParser = new ItemParser();

    @Test
    public void testConstructor() {
        Item item = new Item();
        try {
            item = new Item( "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016" );
        }
        catch (Exception e){

        }
        assertEquals("Name should be MiLK", "MiLK", item.name);
        assertTrue("Price should be 3.23", 3.23f == item.price);
        assertEquals("Type should be Food", "Food", item.type);
        assertEquals("Expiration should be 1/11/2016", "1/11/2016", item.expiration);
    }

    @Test
    public void buildItemsTest(){
        Item item = new Item();
        ArrayList<Item> itemArrayList = item.buildItems(new String[]{"naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016","NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016"});
        assertEquals("Expected Array size of 2", 2, itemArrayList.size());
    }

}
