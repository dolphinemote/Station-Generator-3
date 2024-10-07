public class Game_Map
{

    public static int size_of_the_map; //32 minimum
    public static Map_Style map_style;
    public static Tile[][] array;
    public static int amount_of_object_markers = 99;

    public static void initialize()
    {
        size_of_the_map = GLOBAL_VARS.map_size;

        map_style = CHOOSE_MAP_STYLE.choose_randomly();

        array = new Tile[size_of_the_map][size_of_the_map];
        for(int i = 0; i < size_of_the_map; i++)
        {
            for (int j = 0; j < size_of_the_map; j++)
            {
                array[i][j] = new Tile();
                array[i][j].marker = Markers.SPACE;
            }
        }
    }

    Game_Map()
    {
        initialize();
    }
}
