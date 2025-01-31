import java.util.Random;

public class MARKER_HANDLER
{
    static Random random = new Random();

    static void process_all(){
        for(int j = 0; j < Game_Map.size_of_the_map; j++){
            for(int i = 0; i < Game_Map.size_of_the_map; i++){
                switch (Game_Map.array[i][j].marker){
                    case AIRLOCK->{
                        Game_Map.array[i][j].object = Game_Map.array[i][j].area.airlock_path;
                        Game_Map.array[i][j].turf = Game_Map.array[i][j].area.floor_path;
                    }
                    // String lattice_insead_of_window = "/turf/open/space/basic, /obj/structure/lattice,";
                    // String grille_instead_of_window = "/turf/open/floor/plating, /obj/structure/grille,";
                    case CATWALK -> {
                        Game_Map.array[i][j].turf = "/turf/open/space/basic,/obj/structure/lattice/catwalk,";
                    }
                    case LATTICE -> {
                        Game_Map.array[i][j].turf = "/turf/open/space/basic,/obj/structure/lattice,";
                    }
                    case PLATING -> {
                        Game_Map.array[i][j].turf = "/turf/open/floor/plating,";
                    }
                    case GRILLE -> {
                        Game_Map.array[i][j].turf = "/turf/open/space/basic,/obj/structure/lattice,/obj/structure/grille,";
                    }
                    case WALL -> {
                        Game_Map.array[i][j].turf = Game_Map.array[i][j].area.wall_path;
                    }
                    case FLOOR -> {
                        Game_Map.array[i][j].turf = Game_Map.array[i][j].area.floor_path;
                    }
                    case FLOOR_2 -> {
                        Game_Map.array[i][j].turf = Game_Map.array[i][j].area.floor2_path;
                    }
                    case WINDOW -> {
                        //Game_Map.array[i][j].turf = "/turf/open/floor/plating,";
                        Game_Map.array[i][j].object = Game_Map.array[i][j].area.window_spawner_path;
                    }
                    case OBJECT -> {
                        Game_Map.array[i][j].turf = Game_Map.array[i][j].area.floor_path;
                        process_an_object_marker(i,j);
                    }
                }
            }
        }
    }

    //method that returns a string
    static void process_an_object_marker(int x, int y)
    {

        int amount_of_items = 0;
        switch (random.nextInt(10))
        {
            case 0,1 -> amount_of_items = 0;
            case 2,3,4 -> amount_of_items = 1;
            case 5,6,7 -> amount_of_items = 2;
            case 8,9 -> amount_of_items = random.nextInt(6);
        }

        int storage_or_object = random.nextInt(10);

        if(storage_or_object==0 || storage_or_object==1)//20% - if object
        {
            int which_object = random.nextInt(Game_Map.array[x][y].area.object_pool.length);
            Game_Map.array[x][y].object = Game_Map.array[x][y].area.object_pool[which_object];

        }
        else // 80% - if storage
        {
            int which_storage = random.nextInt(3);
            switch (which_storage)
            {
                //TABLE
                case 0 -> {
                    int which_table = random.nextInt(Game_Map.array[x][y].area.table_pool.length);
                    Game_Map.array[x][y].object = Game_Map.array[x][y].area.table_path;
                    if(amount_of_items>0){amount_of_items=1;}
                }
                //RACK
                case 1 -> Game_Map.array[x][y].object = ("/obj/structure/rack,");

                //CLOSET
                case 2 -> {
                    int which_crate = random.nextInt(Game_Map.array[x][y].area.crate_pool.length);
                    Game_Map.array[x][y].object = (Game_Map.array[x][y].area.crate_pool[which_crate]);
                }
            }
            if(amount_of_items>0) {
                while (amount_of_items > 0) {

                    int which_item = random.nextInt(Game_Map.array[x][y].area.loot_pool.length);
                    Game_Map.array[x][y].items.add((Game_Map.array[x][y].area.loot_pool[which_item]));
                    amount_of_items--;
                }
            }
        }
    }
}
