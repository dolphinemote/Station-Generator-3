import java.awt.*;
import java.util.Random;

public class Misc_Methods
{
    static Random random = new Random();
    public static String number_to_string(int number)
    {
        String result = "!";
            switch (number) {
                case 0 -> result=("A");
                case 1 -> result=("B");
                case 2 -> result=("C");
                case 3 -> result=("D");
                case 4 -> result=("E");
                case 5 -> result=("F");
                case 6 -> result=("G");
                case 7 -> result=("H");
                case 8 -> result=("I");
                case 9 -> result=("J");
                case 10 -> result=("K");
                case 11 -> result=("L");
                case 12 -> result=("M");
                case 13 -> result=("N");
                case 14 -> result=("O");
                case 15 -> result=("P");
                case 16 -> result=("Q");
                case 17 -> result=("R");
                case 18 -> result=("S");
                case 19 -> result=("T");
            }
        return result;
    }



    public static boolean is_there_a_maker_nearby(int x, int y, Markers marker)
    {
        return (Game_Map.array[x][y - 1].marker == marker ||
                Game_Map.array[x + 1][y - 1].marker == marker ||
                Game_Map.array[x + 1][y].marker == marker ||
                Game_Map.array[x + 1][y + 1].marker == marker ||
                Game_Map.array[x][y + 1].marker == marker ||
                Game_Map.array[x - 1][y + 1].marker == marker ||
                Game_Map.array[x - 1][y].marker == marker ||
                Game_Map.array[x - 1][y - 1].marker == marker);
    }


    public static Color misc_get_random_color()
    {
        Color return_color = null;
        int number = random.nextInt(10);
        switch (number) {
            case 0 -> return_color = Color.blue;
            case 1 -> return_color = Color.red;
            case 2 -> return_color = Color.green;
            case 3 -> return_color = Color.yellow;
            case 4 -> return_color = Color.orange;
            case 5 -> return_color = Color.magenta;
            case 6 -> return_color = Color.cyan;
            case 7 -> return_color = Color.pink;
            case 8 -> return_color = Color.white;
            case 9 -> return_color = Color.gray;
        }
        return return_color;
    }


    String get_random_light_path(String direction)//lowercase direction without "," - north, south
    {
        String return_string = "";
        switch (random.nextInt(5))
        {
            case 0 -> return_string ="/obj/machinery/light/directional/"+direction+",";
            case 1 -> return_string="/obj/machinery/light/cold/directional/"+direction+",";
            case 2 -> return_string="/obj/machinery/light/warm/directional/"+direction+",";
            case 3 -> return_string="/obj/machinery/light/small/directional/"+direction+",";
            case 4 -> return_string=""; //20% chance to not place a light
        }
        return return_string;
    }

    static void place_wall_lights()
    {
        //horizontal
        for (int y = 0; y < Game_Map.size_of_the_map; y++)
        {
            for (int x = 0; x < Game_Map.size_of_the_map; x++)
            {
                if(Game_Map.array[x][y].marker == Markers.FLOOR)
                {
                    
                }
            }
        }
        //vertical
    }

    static void really_stupid_observer_start_placement()//i am so lazy
    {
        int random_x;
        int random_y;
        for(int i = 0; i < 10000; i++)
        {
            random_x = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            random_y = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            if(Game_Map.array[random_x][random_y].object.equals("") && Game_Map.array[random_x][random_y].marker == Markers.FLOOR)
            {
                Game_Map.array[random_x][random_y].object = "/obj/effect/landmark/observer_start,";
                break;
            }
        }
    }
    private Color getColorForAreaNumber(int number){
        number = number % 10;
        return switch (number) {
            case 1 -> Color.RED;
            case 2 -> Color.ORANGE;
            case 3 -> Color.YELLOW;
            case 4 -> Color.GREEN;
            case 5 -> Color.CYAN;
            case 6 -> Color.BLUE;
            case 7 -> Color.MAGENTA;
            case 8 -> Color.PINK;
            case 9 -> Color.WHITE;
            default -> Color.BLACK;
        };
    }

}
