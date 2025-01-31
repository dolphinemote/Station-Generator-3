import java.util.ArrayList;
import java.util.Random;

public class Tile
{
    Random random = new Random();
    Markers marker;

    //Area area;
    int number = 0;
    Area area;

    int random_object_icon_type = 100; //this sucks

    String turf="";
    String object="";

    String north_wall_mount="";
    String south_wall_mount="";
    String east_wall_mount="";
    String west_wall_mount="";

    int random_x_offset;
    int random_y_offset;

    ArrayList<String> items = new ArrayList<>();

    String get_string_of_all_combined_items(){
        StringBuilder ReturnString = new StringBuilder();
        for (String item : items) {
            ReturnString.append(item);

            random_x_offset = 0;
            random_y_offset = 0;
            if(GLOBAL_VARS.item_offset_allowed)
            {
                random_x_offset = random.nextInt(17)-8;
                random_y_offset = random.nextInt(9);
                //example: {pixel_y = 10; pixel_x = -6}
                ReturnString.append("{pixel_y = ").append(random_y_offset).append("; pixel_x = ").append(random_x_offset).append("}");
            }

            ReturnString.append(",");
        }
        return ReturnString.toString();
    }

}
