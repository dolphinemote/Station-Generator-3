import java.util.Random;

public class AREA_NUMBER_ASSIGNING
{
    //Random random = new Random();
    static public int amount_of_rooms;

    public static void assign() {
        amount_of_rooms = 0;
        for (int y = 0; y < Game_Map.size_of_the_map; y++)
        {
            for (int x = 0; x < Game_Map.size_of_the_map; x++)
            {
                if (Game_Map.array[x][y].marker == Markers.FLOOR
                    && Game_Map.array[x][y].number == 0)
                {
                    amount_of_rooms++;
                    we_found_an_unassigned_tile(x, y);
                    x = 0;
                    y = 0;
                }
            }
        }
    }



    //gives number to all tiles without an area
    static void we_found_an_unassigned_tile(int x, int y)
    {
        Game_Map.array[x][y].number = amount_of_rooms;

        //north tile check
        if (Game_Map.array[x][y - 1].number==0 && Game_Map.array[x][y - 1].marker == Markers.FLOOR)
        {we_found_an_unassigned_tile(x, y-1);}

        //east tile check
        if (Game_Map.array[x + 1][y].number==0 && Game_Map.array[x + 1][y].marker == Markers.FLOOR)
        {we_found_an_unassigned_tile(x+1, y);}

        //south tile check
        if (Game_Map.array[x][y + 1].number==0  && Game_Map.array[x][y + 1].marker == Markers.FLOOR)
        {we_found_an_unassigned_tile(x, y+1);}

        //west tile check
        if (Game_Map.array[x - 1][y].number==0  && Game_Map.array[x - 1][y].marker == Markers.FLOOR)
        {we_found_an_unassigned_tile(x-1, y); }
    }

    //shows some stats
    static void display_area_statistics()
    {
        int amount_of_floor_tiles_with_area = 0;
        int amount_of_floor_tiles_without_an_area = 0;

        for (int y = 0; y < Game_Map.size_of_the_map; y++) {
            for (int x = 0; x < Game_Map.size_of_the_map; x++) {
                if(Game_Map.array[x][y].marker==Markers.FLOOR)
                {
                    if(Game_Map.array[x][y].number == 0) {//IF FLOOR, remember
                        amount_of_floor_tiles_without_an_area++;
                    }
                    if(Game_Map.array[x][y].number != 1) {
                        amount_of_floor_tiles_with_area++;
                    }
                }
            }
        }
        TopRightLogPanel.add_a_message("Area number of tile x32y32: "+Game_Map.array[32][32].number);
        TopRightLogPanel.add_a_message("Floors with AREA NUBMER: "+amount_of_floor_tiles_with_area);
        TopRightLogPanel.add_a_message("Floors without AREA NUMBER : "+amount_of_floor_tiles_without_an_area);
        TopRightLogPanel.add_a_message("Amount of rooms: "+amount_of_rooms);
    }

}
