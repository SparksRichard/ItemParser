package ItemParser;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by jguevara on 10/9/15.
 */
public class ItemParserSpec {
    ItemParser itemParser;
    @Test
    public void parseInputTest(){
        itemParser = new ItemParser("hello ## gabe");
        String[] parseArray = itemParser.parseInput();
        Assert.assertTrue("make sure that it is not null",parseArray != null);
        Assert.assertEquals("test that it returns array",2,parseArray.length);
    }

    @Test
    public void secondTest(){
        itemParser = new ItemParser("hello ## gabe ##");
        String[] parseArray = itemParser.parseInput();
        Assert.assertTrue("make sure that it is not null",parseArray != null);
        Assert.assertEquals("test that it returns length",2,parseArray.length);
    }
}
