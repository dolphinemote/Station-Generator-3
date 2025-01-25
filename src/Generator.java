import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Generator
{
    //there should be only one random for entire generation process
    public static Random random = new Random();
    static int number_of_stations_generated = 0;


    static void place_borders() {
        for(int x = 0; x < Game_Map.size_of_the_map; x++) {
            for(int y = 0; y < Game_Map.size_of_the_map; y++) {
                //need to add a variable to replace "magic numbers"
                if(
                        x < GLOBAL_VARS.space_border_length ||
                        x >= Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length ||
                        y < GLOBAL_VARS.space_border_length ||
                        y >= Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length)
                {
                    Game_Map.array[x][y].marker = Markers.SPACE_BORDER;
                }
            }
        }
    }

    static void place_rectangles()//rectangles that form the rooms
    {
        int rectangles_left_to_place = GLOBAL_VARS.amount_of_rectangles;
        while (rectangles_left_to_place > 0)
        {
            //x of the rectangle we place
            int x = GLOBAL_VARS.space_border_length +
                    random.nextInt(Game_Map.size_of_the_map
                            - GLOBAL_VARS.maximum_rectangle_length
                            - GLOBAL_VARS.space_border_length*2);
            //y of the rectangle we place
            int y = GLOBAL_VARS.space_border_length +
                    random.nextInt(Game_Map.size_of_the_map
                            - GLOBAL_VARS.maximum_rectangle_length
                            - GLOBAL_VARS.space_border_length*2);

            int rectangle_width = GLOBAL_VARS.min_rectangle_length + // 5 + 0-7
                    random.nextInt(GLOBAL_VARS.maximum_rectangle_length
                            - GLOBAL_VARS.min_rectangle_length);
            int rectangle_height = GLOBAL_VARS.min_rectangle_length +
                    random.nextInt(GLOBAL_VARS.maximum_rectangle_length
                            - GLOBAL_VARS.min_rectangle_length);


            for(int i = y; i <= y + rectangle_height;i++) {
                for(int j = x; j <= x + rectangle_width; j++) {
                    Game_Map.array[j][i].marker = Markers.WALL;
                }
            }
            for(int i = y + 1; i<=y+rectangle_height-1;i++) {
                for(int j = x + 1; j <= x+rectangle_width-1; j++) {
                    Game_Map.array[j][i].marker = Markers.FLOOR;
                }
            }
            rectangles_left_to_place--;
        }
    }

    static void place_lattices()
    {
        //horizontal first
        for(int y = GLOBAL_VARS.space_border_length+random.nextInt(5)+1;
            y < GLOBAL_VARS.map_size-GLOBAL_VARS.space_border_length-1; y++)
        {
            int first_x = GLOBAL_VARS.space_border_length;
            int last_x = GLOBAL_VARS.map_size-GLOBAL_VARS.space_border_length;
            //
            for(int x = first_x; x < last_x; x++)
            {
                if(Game_Map.array[x][y].marker == Markers.SPACE)
                {
                    if(x == first_x || x == last_x-1)
                    {
                        Game_Map.array[x][y].marker = Markers.GRILLE;
                    }
                    else if(random.nextInt(10) == 0)
                    {
                        Game_Map.array[x][y].marker = Markers.CATWALK;
                    }
                    else {
                        Game_Map.array[x][y].marker = Markers.LATTICE;
                    }
                }
            }
            if(y+5<Game_Map.size_of_the_map)
            {
                y = y+random.nextInt(10)+1;
            }
        }
        //vertical
        for(int x = GLOBAL_VARS.space_border_length+1+random.nextInt(5);
            x < GLOBAL_VARS.map_size-GLOBAL_VARS.space_border_length-1; x++)
        {
            int first_y = GLOBAL_VARS.space_border_length;
            int last_y = GLOBAL_VARS.map_size-GLOBAL_VARS.space_border_length;
            //
            for(int y = first_y; y < last_y; y++)
            {
                if(Game_Map.array[x][y].marker == Markers.SPACE)
                {
                    if(y == first_y || y == last_y-1)
                    {
                        Game_Map.array[x][y].marker = Markers.GRILLE;
                    }
                    else if(random.nextInt(10) == 0)
                    {
                        Game_Map.array[x][y].marker = Markers.CATWALK;
                    }
                    else {
                        Game_Map.array[x][y].marker = Markers.LATTICE;
                    }
                }
            }
            if(x+5<Game_Map.size_of_the_map)
            {
                x = x+random.nextInt(10)+1;
            }
        }
    }


    static void terrible_floor2_marker_placement() {
        int min_size = 2;
        int max_size = 8;
        int how_many_times_we_should_place_floor2 = GLOBAL_VARS.amount_of_rectangles / 2;
        int already_placed = 0;
        int attempts = 0;
        int maxAttempts = 100000;//yeah

        while (already_placed < how_many_times_we_should_place_floor2 && attempts < maxAttempts) {
            attempts++;

            int random_x = random.nextInt(GLOBAL_VARS.map_size - 2 * GLOBAL_VARS.space_border_length) + GLOBAL_VARS.space_border_length;
            int random_y = random.nextInt(GLOBAL_VARS.map_size - 2 * GLOBAL_VARS.space_border_length) + GLOBAL_VARS.space_border_length;

            int size_x = random.nextInt(max_size - min_size + 1) + min_size;
            int size_y = random.nextInt(max_size - min_size + 1) + min_size;

            size_x = Math.min(size_x, Game_Map.array.length - random_x - 1);
            size_y = Math.min(size_y, Game_Map.array[0].length - random_y - 1);

            boolean canReplace = true;
            for (int x = random_x; x <= random_x + size_x; x++) {
                for (int y = random_y; y <= random_y + size_y; y++) {
                    if (x >= Game_Map.array.length || y >= Game_Map.array[0].length
                            || Game_Map.array[x][y].marker != Markers.FLOOR) {
                        canReplace = false;
                        break;
                    }
                }
                if (!canReplace) break;
            }
            if (canReplace) {
                Markers selectedMarker = (random.nextInt(3) == 0) ? Markers.FLOOR_2 : Markers.FLOOR_2;//floor2
                for (int x = random_x; x <= random_x + size_x; x++) {
                    for (int y = random_y; y <= random_y + size_y; y++) {
                        Game_Map.array[x][y].marker = selectedMarker;
                    }
                }
                already_placed++;
            }
        }
    }



    //this function is called by pressing "full random" button
    static void generate(){

        //CHOOSE_MAP_STYLE.choose_randomly();

        //changes map size, chooses style, fills with space tiles
        Game_Map.initialize();

        //places space border markers
        place_borders();

        //places rectangles that from the shape of the station
        place_rectangles();

        //DOUBLE_WALL_REMOVER.replaceDoubleWallsWithFloor();

        //gives tiles room numbers
        AREA_NUMBER_ASSIGNING.assign();

        //places shitty two tile wide window markers
        WINDOWS_AND_AIRLOCKS.alt_window_placement();

        //
        WINDOWS_AND_AIRLOCKS.shitty_airlock_placement();

        //
        OBJECT_MARKER_PLACER.place_all_object_markers();

        //placing alternative floor
        terrible_floor2_marker_placement();

        //
        number_of_stations_generated++;
        TopRightLogPanel.add_a_message("Generation number " + number_of_stations_generated);
        TopRightLogPanel.add_a_message("Map Size: " + GLOBAL_VARS.map_size);
        TopRightLogPanel.add_a_message("---");

        //
        AREA_NUMBER_ASSIGNING.display_area_statistics();

        AREA_ASSIGNING.assign_basic_area();
        AREA_ASSIGNING.assign_other_areas();

        TopRightLogPanel.add_a_message("STYLE: " + Game_Map.map_style.name);
        DOUBLE_WALL_REMOVER.say_how_many_double_walls();
        //TopRightLogPanel.add_a_message("---");

        place_lattices();
        //Misc_Methods.place_wall_lights();
        MARKER_HANDLER.process_all();
        Misc_Methods.really_stupid_observer_start_placement();
    }
}
