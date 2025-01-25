import java.awt.*;

public class GLOBAL_VARS
{


    //
    public static Map_Style[] list_of_styles = new Map_Style[5];
    //

    //this class should contain things that can be changed through settings

    //space tiles that can't be used for spawning and form a surrounding buffer zone
    public static int space_border_length = 1;//8-32
    public static int min_rectangle_length = 5;
    public static int maximum_rectangle_length = 12;
    public static int amount_of_object_markers = 256;

    public static int map_size = 80;      // 32-64-96-128-256
    public static int amount_of_rectangles = 96;

    //app colors
    public static Color main_background_color = Color.BLACK;//black
    public static Color second_background_color = Color.DARK_GRAY;//dark gray
    public static Color highlight_color = Color.YELLOW;//yellow
    public static Color main_text_color = Color.GRAY;//gray

    //gives items x and y offsets, 0-8,
    public static boolean item_offset_allowed = true;

    public static boolean infinite_cells_for_area_computers = true;
    public static boolean alt_generation_pools_nova_skyrat_bubber_only = false;
    public static boolean auto_rotation_of_airlocks = true;

    GLOBAL_VARS()
    {
        //
    }

    public static int highlight_color_number;
    public static void change_highlight_color()
    {
        switch (highlight_color_number)
        {
            case 0 -> highlight_color = Color.YELLOW;
            case 1 -> highlight_color = Color.CYAN;
            case 2 -> highlight_color = Color.RED;
            case 3 -> highlight_color = Color.ORANGE;
            case 4 -> highlight_color = Color.WHITE;
            case 5 -> highlight_color = Color.BLUE;
        }
    }

}
