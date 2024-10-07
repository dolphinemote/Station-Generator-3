import java.util.Random;

public class WINDOWS_AND_AIRLOCKS {
    //
    static Random random = new Random();
    //should not be a new random object, fix this later

    static void alt_window_placement()
    {
        int amount_of_iterations = 0;
        int amount_of_windows_we_want = 128;
        int amount_of_windows_we_placed = 0;
        while (amount_of_windows_we_placed<amount_of_windows_we_want){
            amount_of_iterations++;
            int random_x = random.nextInt(Game_Map.size_of_the_map);
            int random_y = random.nextInt(Game_Map.size_of_the_map);

            //first window
            if(is_a_good_place_for_a_window(random_x,random_y))
            {
                switch (random.nextInt(4))//four directions
                {
                    case 0->{
                        if(
                            //second window
                                is_a_good_place_for_a_window(random_x,random_y-1)
                                        //first wall
                                        && (Game_Map.array[random_x][random_y-2].marker==Markers.WALL)
                                        //second wall
                                        && (Game_Map.array[random_x][random_y+1].marker==Markers.WALL))
                        {
                            Game_Map.array[random_x][random_y].marker=Markers.WINDOW;
                            Game_Map.array[random_x][random_y-1].marker=Markers.WINDOW;
                            amount_of_windows_we_placed+=2;
                        }
                    }
                    case 1->{
                        if(
                                is_a_good_place_for_a_window(random_x+1,random_y)
                                        && (Game_Map.array[random_x+2][random_y].marker==Markers.WALL)
                                        && (Game_Map.array[random_x-1][random_y].marker==Markers.WALL))
                        {
                            Game_Map.array[random_x][random_y].marker=Markers.WINDOW;
                            Game_Map.array[random_x+1][random_y].marker=Markers.WINDOW;
                            amount_of_windows_we_placed+=2;
                        }
                    }
                    case 2->{
                        if(
                                is_a_good_place_for_a_window(random_x,random_y+1)
                                        && (Game_Map.array[random_x][random_y+2].marker==Markers.WALL)
                                        && (Game_Map.array[random_x][random_y-1].marker==Markers.WALL))
                        {
                            Game_Map.array[random_x][random_y].marker=Markers.WINDOW;
                            Game_Map.array[random_x][random_y+1].marker=Markers.WINDOW;
                            amount_of_windows_we_placed+=2;
                        }
                    }
                    case 3->{
                        if(
                                is_a_good_place_for_a_window(random_x-1,random_y)
                                        && (Game_Map.array[random_x-2][random_y].marker==Markers.WALL)
                                        && (Game_Map.array[random_x+1][random_y].marker==Markers.WALL))
                        {
                            Game_Map.array[random_x][random_y].marker=Markers.WINDOW;
                            Game_Map.array[random_x-1][random_y].marker=Markers.WINDOW;
                            amount_of_windows_we_placed+=2;
                        }
                    }
                }
            }
            if(amount_of_iterations > 10000)
            {
                TopRightLogPanel.add_a_message("!!! WE WANTED "+amount_of_windows_we_want+" WINDOWS !!!");
                TopRightLogPanel.add_a_message("!!! BUT WE PLACED ONLY "+ amount_of_windows_we_placed+ "!!!");
                break;
            }

        }
    }

    static boolean is_space_or_floor(int x, int y)
    {
        return Game_Map.array[x][y].marker == Markers.SPACE || Game_Map.array[x][y].marker == Markers.FLOOR;
    }


    static boolean is_a_good_place_for_a_window(int x, int y)
    {
        boolean result = false;
        if(Game_Map.array[x][y].marker == Markers.WALL)
        {
            //horizontal check
            if(is_space_or_floor(x-1,y) && is_space_or_floor(x+1,y)){result = true;}
            //vertical check
            if(is_space_or_floor(x,y-1) && is_space_or_floor(x,y+1)){result = true;}
        }
        return result;
    }

    static boolean is_a_good_place_for_an_airlock(int x, int y){
        boolean result = false;
        if(Game_Map.array[x][y].marker == Markers.WALL)
        {
            //horizontal check
            if(Game_Map.array[x-1][y].marker == Markers.FLOOR &&
                    Game_Map.array[x+1][y].marker == Markers.FLOOR &&
                    Game_Map.array[x][y-1].marker == Markers.WALL &&
                    Game_Map.array[x][y+1].marker == Markers.WALL)
            {
                result = true;
            }
            //vertical check
            if(Game_Map.array[x][y-1].marker == Markers.FLOOR &&
                    Game_Map.array[x][y+1].marker == Markers.FLOOR&&
                    Game_Map.array[x-1][y].marker == Markers.WALL &&
                    Game_Map.array[x+1][y].marker == Markers.WALL)
            {
                result = true;
            }
        }
        return result;
    }

    static void shitty_airlock_placement()
    {
        int amount_of_iterations = 0;
        int amount_of_airlocks_we_want = AREA_NUMBER_ASSIGNING.amount_of_rooms;
        int amount_of_airlocks_we_placed = 0;
        while (amount_of_airlocks_we_placed < amount_of_airlocks_we_want)
        {
            amount_of_iterations++;
            if(amount_of_iterations > 10000)
            {
                TopRightLogPanel.add_a_message("WE WANTED "+amount_of_airlocks_we_want+" AIRLOCKS");
                TopRightLogPanel.add_a_message("BUT WE PLACED ONLY "+ amount_of_airlocks_we_placed);
                break;
            }
            int random_x = random.nextInt(Game_Map.size_of_the_map);
            int random_y = random.nextInt(Game_Map.size_of_the_map);
            if(is_a_good_place_for_an_airlock(random_x,random_y))
            {
                Game_Map.array[random_x][random_y].marker = Markers.AIRLOCK;
                amount_of_airlocks_we_placed++;
            }
        }
    }

    static void shitty_window_placement()
    {
        int amount_of_iterations = 0;
        int amount_of_windows_we_want = 128;
        int amount_of_windows_we_placed = 0;
        while (amount_of_windows_we_placed<amount_of_windows_we_want){
            amount_of_iterations++;
            int random_x = random.nextInt(Game_Map.size_of_the_map);
            int random_y = random.nextInt(Game_Map.size_of_the_map);
            if(is_a_good_place_for_a_window(random_x,random_y))
            {
                Game_Map.array[random_x][random_y].marker = Markers.WINDOW;
                amount_of_windows_we_placed++;
            }
            if(amount_of_iterations>10000)
            {
                TopRightLogPanel.add_a_message("!!! WE WANTED "+amount_of_windows_we_want+" WINDOWS !!!");
                TopRightLogPanel.add_a_message("!!! BUT WE PLACED ONLY "+ amount_of_windows_we_placed+ "!!!");
                break;
            }
        }
    }

    static boolean is_this_rectangle_made_out_of_marker(int x1, int x2, int y1, int y2, Markers Xmarker){
        for(int j = y1; j<y2;j++) {
            for(int i = x1; i<x2;i++) {
                if(Game_Map.array[i][j].marker != Xmarker) {return false;}
            }
        }
        return true;
    }

    static void fill_rectangle_with_markers(int x1, int x2, int y1, int y2, Markers Xmarker){
        for(int j = y1; j<y2;j++) {
            for(int i = x1; i<x2;i++) {
                Game_Map.array[i][j].marker = Xmarker;
            }
        }
    }
}
