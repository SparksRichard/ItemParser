package ItemParserTest;

import ItemParser.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsparks on 10/11/15.
 */


public class ItemParserTest {

    @Test
    public void parseInputTest() {

        String input = "this##is##a##test##to##split";

        ItemParser itemParser = new ItemParser();
        String[] parsedInput = itemParser.parseInput(input);

        assertEquals("Should return length of input after split at ##", 6, parsedInput.length);
    }
}