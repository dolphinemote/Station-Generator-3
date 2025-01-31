import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Array_To_DMM {

    static Random random = new Random();
    //MARKER_HANDLER marker_handler = new MARKER_HANDLER();

    //tiles with just space, they take most of the space
    static String FinalString = "\"xxx\" = (/turf/open/space/basic,/area/space)\n";
    static String FileName = "";

    //"/obj/structure/cable <-- path examples
    //"/obj/machinery/light/floor,";
    //"/obj/effect/landmark/observer_start,";

    //is called from the Keyboard_Handler
    static public void simple_convert()
    {
        FinalString = "\"xxx\" = (/turf/open/space/basic,/area/space)\n";
        int number1 = 0;//0-20
        int number2 = 0;//0-20
        int number3 = 0;//0-20
        //total 20*20*20 = 8000 unique combinations that designate a unique tile
        //can be changed to 52*52*52 = 140608 unique tiles(a-z, A-Z)
        //256*256 map is 65536 tiles, with many of them not being unique

        for(int y = 0; y<Game_Map.size_of_the_map;y++) {
            for(int x = 0; x<Game_Map.size_of_the_map;x++) {
                if
                (Game_Map.array[x][y].marker!=Markers.SPACE && Game_Map.array[x][y].marker!=Markers.SPACE_BORDER) {
                    //it should look like: "AAA" = (/turf,/obj,/area)
                    FinalString += "\""
                            + Misc_Methods.number_to_string(number1)
                            + Misc_Methods.number_to_string(number2)
                            + Misc_Methods.number_to_string(number3)
                            + "\" = ("
                            + Game_Map.array[x][y].turf
                            + Game_Map.array[x][y].north_wall_mount
                            + Game_Map.array[x][y].east_wall_mount
                            + Game_Map.array[x][y].south_wall_mount
                            + Game_Map.array[x][y].west_wall_mount
                            + Game_Map.array[x][y].object
                            + Game_Map.array[x][y].get_string_of_all_combined_items()
                            + Game_Map.array[x][y].area.path
                            + ")\n";
                    number3++;
                    if(number3==20) {
                        number3=0;
                        number2++;
                    }
                    if(number2==20) {
                        number2=0;
                        number1++;
                    }
                }

                //object
                //turf
                //area
            }
        }

        //fully random name is temporary, it should contain the seed
        FileName = Game_Map.map_style.name + random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
        FinalString += "\n(1,1,1) = {\"\n";

        number1=0;
        number2=0;
        number3=0;

        //MAIN CONVERTING
        for(int j = 0; j<Game_Map.size_of_the_map;j++)//y
        {
            for(int i = 0; i<Game_Map.size_of_the_map;i++)//x
            {
                //main markers
                switch (Game_Map.array[i][j].marker)
                {
                    case SPACE, SPACE_BORDER -> FinalString += "xxx";
                    default -> {
                        FinalString +=
                                Misc_Methods.number_to_string(number1) +
                                Misc_Methods.number_to_string(number2) +
                                Misc_Methods.number_to_string(number3);
                        number3++;
                        if(number3==20)
                        {
                            number3=0;
                            number2++;
                        }
                        if(number2==20)
                        {
                            number2=0;
                            number1++;
                        }
                    }
                }
            }
            FinalString = FinalString +"\n";
        }
        FinalString = FinalString+ "\"}";


        System.out.println("Filename: " + FileName);
        //"D:\\A - Github\\MAPS\\"+FileName+".dmm"
        Path path = Path.of("D:\\"+FileName+".dmm");
        TopRightLogPanel.add_a_message("Saving file: "+FileName+".dmm (Location: Disk D://)");
        System.out.println(path);
        try
        {
            Files.createFile(path);
            Files.writeString(path, FinalString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
