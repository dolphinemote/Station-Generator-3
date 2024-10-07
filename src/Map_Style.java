import java.util.ArrayList;

public class Map_Style
{
    String name;
    Area basic_area;


    //
    int vent_pipe_layer;
    int scrubber_pipe_layer;
    int additional_pipe_layer;
    String vent_pipe_COLOR;
    String scrubber_pipe_COLOR;
    String additional_pipe_COLOR;
    //

    ArrayList<Area> list_of_areas = new ArrayList<>();

    Map_Style(Area basic_area, String name)
    {
        this.name = name;
        this.basic_area = basic_area;
        this.list_of_areas.add(basic_area);
    }



}
