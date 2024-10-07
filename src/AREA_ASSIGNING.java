import java.util.Random;

public class AREA_ASSIGNING
{

    static Random random = new Random();


    static void assign_basic_area(){
            for(int y = 0; y < Game_Map.size_of_the_map; y++){
                for(int x = 0; x<Game_Map.size_of_the_map; x++){
                    Game_Map.array[x][y].area = Game_Map.map_style.basic_area;
                }
            }

    }


    //this method should assign Area
    // objects to the tiles based on their number
    static void assign_other_areas() //MUST BE REWRITTEN JESUS it's bad
    {
        for(int i = 1; i < Game_Map.map_style.list_of_areas.size(); i++)
        {
            int room_index = random.nextInt(AREA_NUMBER_ASSIGNING.amount_of_rooms)+1;
            for(int y = 0; y < Game_Map.size_of_the_map; y++)
            {
                for(int x = 0; x < Game_Map.size_of_the_map; x++)
                {
                    if(Game_Map.array[x][y].number==room_index)
                    {
                        Game_Map.array[x-1][y-1].area = Game_Map.map_style.list_of_areas.get(i);
                        Game_Map.array[x][y-1].area = Game_Map.map_style.list_of_areas.get(i);
                        Game_Map.array[x+1][y-1].area = Game_Map.map_style.list_of_areas.get(i);

                        Game_Map.array[x-1][y].area = Game_Map.map_style.list_of_areas.get(i);
                        Game_Map.array[x][y].area = Game_Map.map_style.list_of_areas.get(i);
                        Game_Map.array[x+1][y].area = Game_Map.map_style.list_of_areas.get(i);

                        Game_Map.array[x-1][y+1].area = Game_Map.map_style.list_of_areas.get(i);
                        Game_Map.array[x][y+1].area = Game_Map.map_style.list_of_areas.get(i);
                        Game_Map.array[x+1][y+1].area = Game_Map.map_style.list_of_areas.get(i);
                    }
                }
            }
        }

    }

}

