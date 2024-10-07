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



    public static boolean is_surrounded_by_marker(int x, int y, Markers marker)
    {
        return (Game_Map.array[x][y - 1].marker == marker &&
                Game_Map.array[x + 1][y - 1].marker == marker &&
                Game_Map.array[x + 1][y].marker == marker &&
                Game_Map.array[x + 1][y + 1].marker == marker &&
                Game_Map.array[x][y + 1].marker == marker &&
                Game_Map.array[x - 1][y + 1].marker == marker &&
                Game_Map.array[x - 1][y].marker == marker &&
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

    static void place_wall_lights()
    {
        for(int i = 0;i<Game_Map.size_of_the_map;i+=4)
        {
            for(int j = 0;j<Game_Map.size_of_the_map;j+=4)
            {
                if(Game_Map.array[i][j].marker == Markers.FLOOR)
                {
                    //north
                    if(Game_Map.array[i][j-1].marker==Markers.WALL)
                    {
                        switch (random.nextInt(5))
                        {
                            case 0 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/directional/north,";
                            case 1 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/cold/directional/north,";
                            case 2 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/warm/directional/north,";
                            case 3 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/small/directional/north,";
                            case 4 -> Game_Map.array[i][j].north_wall_mount="";
                        }

                    }
                    //east
                    else if(Game_Map.array[i+1][j].marker==Markers.WALL)
                    {
                        switch (random.nextInt(5))
                        {
                            case 0 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/directional/east,";
                            case 1 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/cold/directional/east,";
                            case 2 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/warm/directional/east,";
                            case 3 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/small/directional/east,";
                            case 4 -> Game_Map.array[i][j].north_wall_mount="";
                        }
                    }
                    else if(Game_Map.array[i][j+1].marker==Markers.WALL)
                    {
                        switch (random.nextInt(5))
                        {
                            case 0 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/directional/south,";
                            case 1 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/cold/directional/south,";
                            case 2 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/warm/directional/south,";
                            case 3 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/small/directional/south,";
                            case 4 -> Game_Map.array[i][j].north_wall_mount="";
                        }
                    }
                    else if(Game_Map.array[i-1][j].marker==Markers.WALL)
                    {
                        switch (random.nextInt(5))
                        {
                            case 0 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/directional/west,";
                            case 1 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/cold/directional/west,";
                            case 2 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/warm/directional/west,";
                            case 3 -> Game_Map.array[i][j].north_wall_mount="/obj/machinery/light/small/directional/west,";
                            case 4 -> Game_Map.array[i][j].north_wall_mount="";
                        }
                    }
                }
            }
        }
    }

    static void really_stupid_observer_start_placement()//i am so lazy
    {
        for(int i = 0; i < 10000; i++)
        {
            int random_x = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            int random_y = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            if(Game_Map.array[random_x][random_y].object.equals("") && Game_Map.array[random_x][random_y].marker == Markers.FLOOR)
            {
                Game_Map.array[random_x][random_y].object = "/obj/effect/landmark/observer_start,";
                break;
            }
        }
    }

}
