import java.util.Random;

public class OBJECT_MARKER_PLACER {
    static Random random = new Random();

    void check_for_surroundings(int... ass)
    {

    }

    static void place_all_object_markers() {
        int amount_of_object_groups_we_should_place = GLOBAL_VARS.amount_of_object_markers;

        while (amount_of_object_groups_we_should_place > 0) {
            int how_many_objects_in_one_group = random.nextInt(4) + 1;
            if (amount_of_object_groups_we_should_place >= how_many_objects_in_one_group) {
                switch (how_many_objects_in_one_group) {
                    case 1 -> place_one_object_marker();
                    case 2 -> place_two_object_markers();
                    case 3 -> place_three_object_markers();
                    case 4 -> place_four_object_markers();
                }
                amount_of_object_groups_we_should_place -= how_many_objects_in_one_group;
            }
        }
    }

    static void place_one_object_marker() {
        while (true) {
            int random_x = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            int random_y = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            if (!does_cell_have_an_airlock_neighbour(random_x, random_y) &&
                    !does_cell_have_an_object_neighbour(random_x, random_y) &&
                    Game_Map.array[random_x][random_y].marker == Markers.FLOOR) {
                Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                break;
            }
        }
    }

    static void place_two_object_markers() {

        while (true) {
            int random_x = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            int random_y = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;

            if (Game_Map.array[random_x][random_y].marker == Markers.FLOOR &&
                    !does_cell_have_an_object_neighbour(random_x, random_y) &&
                    !does_cell_have_an_airlock_neighbour(random_x, random_y)) {

                int direction = random.nextInt(4);
                switch (direction) {
                    case 0: // North
                        if (Game_Map.array[random_x][random_y - 1].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x, random_y - 1) &&
                                !does_cell_have_an_airlock_neighbour(random_x, random_y - 1)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x][random_y - 1].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                    case 1: // East
                        if (Game_Map.array[random_x + 1][random_y].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x + 1, random_y) &&
                                !does_cell_have_an_airlock_neighbour(random_x + 1, random_y)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x + 1][random_y].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                    case 2: // South
                        if (Game_Map.array[random_x][random_y + 1].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x, random_y + 1) &&
                                !does_cell_have_an_airlock_neighbour(random_x, random_y + 1)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x][random_y + 1].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                    case 3: // West
                        if (Game_Map.array[random_x - 1][random_y].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x - 1, random_y) &&
                                !does_cell_have_an_airlock_neighbour(random_x - 1, random_y)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x - 1][random_y].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                }
            }
        }
    }

    static void place_three_object_markers() {
        while (true) {
            int random_x = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            int random_y = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;

            if (Game_Map.array[random_x][random_y].marker == Markers.FLOOR &&
                    !does_cell_have_an_object_neighbour(random_x, random_y) &&
                    !does_cell_have_an_airlock_neighbour(random_x, random_y)) {

                int direction = random.nextInt(4);
                switch (direction) {
                    case 0: // North
                        if (Game_Map.array[random_x][random_y - 1].marker == Markers.FLOOR &&
                                Game_Map.array[random_x][random_y - 2].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x, random_y - 1) &&
                                !does_cell_have_an_object_neighbour(random_x, random_y - 2) &&
                                !does_cell_have_an_airlock_neighbour(random_x, random_y - 1) &&
                                !does_cell_have_an_airlock_neighbour(random_x, random_y - 2)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x][random_y - 1].marker = Markers.OBJECT;
                            Game_Map.array[random_x][random_y - 2].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                    case 1: // East
                        if (Game_Map.array[random_x + 1][random_y].marker == Markers.FLOOR &&
                                Game_Map.array[random_x + 2][random_y].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x + 1, random_y) &&
                                !does_cell_have_an_object_neighbour(random_x + 2, random_y) &&
                                !does_cell_have_an_airlock_neighbour(random_x + 1, random_y) &&
                                !does_cell_have_an_airlock_neighbour(random_x + 2, random_y)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x + 1][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x + 2][random_y].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                    case 2: // South
                        if (Game_Map.array[random_x][random_y + 1].marker == Markers.FLOOR &&
                                Game_Map.array[random_x][random_y + 2].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x, random_y + 1) &&
                                !does_cell_have_an_object_neighbour(random_x, random_y + 2) &&
                                !does_cell_have_an_airlock_neighbour(random_x, random_y + 1) &&
                                !does_cell_have_an_airlock_neighbour(random_x, random_y + 2)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x][random_y + 1].marker = Markers.OBJECT;
                            Game_Map.array[random_x][random_y + 2].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                    case 3: // West
                        if (Game_Map.array[random_x - 1][random_y].marker == Markers.FLOOR &&
                                Game_Map.array[random_x - 2][random_y].marker == Markers.FLOOR &&
                                !does_cell_have_an_object_neighbour(random_x - 1, random_y) &&
                                !does_cell_have_an_object_neighbour(random_x - 2, random_y) &&
                                !does_cell_have_an_airlock_neighbour(random_x - 1, random_y) &&
                                !does_cell_have_an_airlock_neighbour(random_x - 2, random_y)) {
                            Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x - 1][random_y].marker = Markers.OBJECT;
                            Game_Map.array[random_x - 2][random_y].marker = Markers.OBJECT;
                            return;
                        }
                        break;
                }
            }
        }
    }

    static void place_four_object_markers() {
        while (true) {
            int random_x = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;
            int random_y = random.nextInt(Game_Map.size_of_the_map - GLOBAL_VARS.space_border_length * 2) + GLOBAL_VARS.space_border_length;

            if (Game_Map.array[random_x][random_y].marker == Markers.FLOOR &&
                    !does_cell_have_an_object_neighbour(random_x, random_y) &&
                    !does_cell_have_an_airlock_neighbour(random_x, random_y)) {

                // 2x2 square
                if (Game_Map.array[random_x + 1][random_y].marker == Markers.FLOOR &&
                        Game_Map.array[random_x][random_y + 1].marker == Markers.FLOOR &&
                        Game_Map.array[random_x + 1][random_y + 1].marker == Markers.FLOOR &&
                        !does_cell_have_an_object_neighbour(random_x + 1, random_y) &&
                        !does_cell_have_an_object_neighbour(random_x, random_y + 1) &&
                        !does_cell_have_an_object_neighbour(random_x + 1, random_y + 1) &&
                        !does_cell_have_an_airlock_neighbour(random_x + 1, random_y) &&
                        !does_cell_have_an_airlock_neighbour(random_x, random_y + 1) &&
                        !does_cell_have_an_airlock_neighbour(random_x + 1, random_y + 1)) {

                    Game_Map.array[random_x][random_y].marker = Markers.OBJECT;
                    Game_Map.array[random_x + 1][random_y].marker = Markers.OBJECT;
                    Game_Map.array[random_x][random_y + 1].marker = Markers.OBJECT;
                    Game_Map.array[random_x + 1][random_y + 1].marker = Markers.OBJECT;
                    return;
                }
            }
        }
    }

    static boolean does_cell_have_an_object_neighbour(int x, int y) {
        return (Game_Map.array[x][y - 1].marker == Markers.OBJECT ||
                Game_Map.array[x + 1][y - 1].marker == Markers.OBJECT ||
                Game_Map.array[x + 1][y].marker == Markers.OBJECT ||
                Game_Map.array[x + 1][y + 1].marker == Markers.OBJECT ||
                Game_Map.array[x][y + 1].marker == Markers.OBJECT ||
                Game_Map.array[x - 1][y + 1].marker == Markers.OBJECT ||
                Game_Map.array[x - 1][y].marker == Markers.OBJECT ||
                Game_Map.array[x - 1][y - 1].marker == Markers.OBJECT);
    }

    static boolean does_cell_have_an_airlock_neighbour(int x, int y) {
        return (Game_Map.array[x][y - 1].marker == Markers.AIRLOCK ||
                Game_Map.array[x + 1][y].marker == Markers.AIRLOCK ||
                Game_Map.array[x][y + 1].marker == Markers.AIRLOCK ||
                Game_Map.array[x - 1][y].marker == Markers.AIRLOCK);
    }
}