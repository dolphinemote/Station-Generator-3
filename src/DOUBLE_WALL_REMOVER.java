public class DOUBLE_WALL_REMOVER {


    static int amount_of_double_walls = 0;

    public static void detect_double_walls()
    {
        for(int x = 0; x < Game_Map.size_of_the_map; x++)
        {
            for(int y = 0; y < Game_Map.size_of_the_map; y++)
            {
                if(Game_Map.array[x][y].marker == Markers.WALL)
                {
                    //we found a wall
                    if(Game_Map.array[x+1][y].marker == Markers.WALL &&
                            Game_Map.array[x+1][y+1].marker == Markers.WALL &&
                            Game_Map.array[x][y+1].marker == Markers.WALL)
                    {
                        amount_of_double_walls++;
                        //nope we're not removing anything yet
                    }
                }
            }
        }
    }

    static void say_how_many_double_walls()
    {
        amount_of_double_walls = 0;
        detect_double_walls();
        TopRightLogPanel.add_a_message(amount_of_double_walls+" DOUBLE WALLS WERE FOUND");
    }





}
