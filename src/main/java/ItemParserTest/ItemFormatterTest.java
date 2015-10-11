package ItemParserTest;

import ItemParser.ItemFormatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsparks on 10/11/15.
 */
public class ItemFormatterTest {
    @Test
    public void timeOrTimesTest(){
        ItemFormatter itemFormatter = new ItemFormatter();
        assertEquals("Should return time","time",itemFormatter.timeOrTimes(1));
        assertEquals("Should return times","times",itemFormatter.timeOrTimes(2));
    }
}
