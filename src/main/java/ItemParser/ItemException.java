package ItemParser;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by rsparks on 10/6/15.
 * Custom exception class
 */
public class ItemException extends Exception {
    /*private static Logger logger = Logger.getLogger("Blah");
    private StringWriter trace;
    public ItemException(String message){
        super(message);
        trace = new StringWriter();
        super.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }*/

    public ItemException(){
    }
}
