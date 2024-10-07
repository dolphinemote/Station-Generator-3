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

    static void place_rectangles()        //rectangles that form the rooms
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
        //TopRightLogPanel.add_a_message("--------------------------");

        //
        number_of_stations_generated++;
        TopRightLogPanel.add_a_message("Generation number " + number_of_stations_generated);
        TopRightLogPanel.add_a_message("Map Size: " + GLOBAL_VARS.map_size);
        TopRightLogPanel.add_a_message("Number of Rooms: " + AREA_NUMBER_ASSIGNING.amount_of_rooms);

        //
        AREA_NUMBER_ASSIGNING.display_area_statistics();

        AREA_ASSIGNING.assign_basic_area();
        AREA_ASSIGNING.assign_other_areas();

        TopRightLogPanel.add_a_message("STYLE: " + Game_Map.map_style.name);
        DOUBLE_WALL_REMOVER.say_how_many_double_walls();
        TopRightLogPanel.add_a_message("");

        Misc_Methods.place_wall_lights();
        MARKER_HANDLER.process_all();
        Misc_Methods.really_stupid_observer_start_placement();
    }
}
