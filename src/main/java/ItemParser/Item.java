package ItemParser;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jguevara on 10/9/15.
 */
public class Item {
    public String name;
    public float price;
    public String type;
    public String expiration;




    @Override
    public String toString(){
        return this.name+" "+ this.price+" "+this.type+" "+this.expiration;

    }
    Pattern itemPattern = Pattern.compile("name:([\\w\\d]+)[;^*%@!]price:(\\d+\\.\\d+)[;^*%@!]type:(\\w+)[;^*%@!]expiration:(.+)", Pattern.CASE_INSENSITIVE);

    public Item(String input) throws ItemException{

        Matcher separateFields = itemPattern.matcher(input);
        separateFields.find();

           this.name = separateFields.group(1);
           this.price = Float.valueOf(separateFields.group(2));
           this.type = separateFields.group(3);
           this.expiration = separateFields.group(4);
    }
}


