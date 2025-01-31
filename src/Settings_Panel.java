import javax.swing.*;
import java.awt.*;


public class Settings_Panel extends JPanel
{
    int x;
    int y;
    int width;
    int height;
    public static int chosen_button;

    public static boolean repaint_allowed;

    static class Setting
    {
        String name;
        int[] options;
        int default_option_index;
        Setting(String name, int[] options, int default_option_index)
        {
            this.name = name;
            this.options = options;
            this.default_option_index = default_option_index;
        }
        void next_option()
        {
            if(default_option_index < options.length-1)
            {default_option_index++;}
            else
            {default_option_index=0;}
            repaint_allowed = true;

        }
        void previous_option()
        {
            if(default_option_index > 0)
            {default_option_index--;}
            else
            {default_option_index=options.length-1;}
            repaint_allowed = true;
        }
    }

    public static Setting[] list_of_settings = new Setting[6];
    //Setting map_size = new Setting("Map Size", new int[]{64, 80, 96, 128, 256}, 1);
    Setting temp_setting = new Setting("Map Size (change is disabled for now)", new int[]{80}, 0);
    Setting amount_of_object_markers = new Setting("Amount of Object Markers", new int[]{0, 64, 128, 256}, 3);
    Setting amount_of_rectangles = new Setting("Amount of Rectangles", new int[]{64, 96, 128, 256}, 1);
    Setting border_length = new Setting("Border Length", new int[]{1, 8, 16}, 0);
    Setting highlight_color = new Setting("Highlight Color", new int[]{0,1,2,3,4,5}, 0);

    Settings_Panel(int screen_width, int screen_height)
    {
        chosen_button = 0;
        x = screen_width / 6;
        y = screen_height / 6;
        width = screen_width / 3 * 2;
        height = screen_height / 3 * 2;
        this.setBackground(GLOBAL_VARS.main_background_color);
        this.setBounds(x,y,width,height);
        this.setVisible(false);

        //list_of_settings[0] = map_size;
        list_of_settings[0] = temp_setting;
        list_of_settings[1] = amount_of_object_markers;
        list_of_settings[2] = amount_of_rectangles;
        list_of_settings[3] = border_length;
        list_of_settings[4] = highlight_color;


    }

    void menu_called()
    {
        //if visible makes un-visible and vice versa
        chosen_button = 0;
        this.setVisible(!isVisible());
        if(isVisible())
        {
            Main.keyboard_handler.previous_active_panel = Main.keyboard_handler.active_panel;
            Main.keyboard_handler.active_panel = "Settings_Panel";
        }
        else{Main.keyboard_handler.active_panel = Main.keyboard_handler.previous_active_panel;}
    }

    void button_W_or_UP_pressed()
    {
        if (chosen_button > 0)
        {chosen_button--;}
        else {chosen_button = list_of_settings.length-2;}
    }
    void button_S_or_DOWN_pressed()
    {
        if (chosen_button < list_of_settings.length-2)
        {chosen_button++;}
        else {chosen_button = 0;}
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(GLOBAL_VARS.highlight_color);
        g.drawRect(1,1,width-2,height-2);
        {
            g.setColor(GLOBAL_VARS.highlight_color);
        }

        g.drawString("SETTINGS",width / 40,height / 20);

        for(int i = 0; i < list_of_settings.length-1; i++)
        {

            g.setColor(GLOBAL_VARS.main_text_color);

            String displayed_string = list_of_settings[i].name + ": "
                    + list_of_settings[i].options[list_of_settings[i].default_option_index];

            if(chosen_button == i)
            {
                g.setColor(GLOBAL_VARS.highlight_color);
            }

            g.drawRect(width/20,height/list_of_settings.length*i+height/list_of_settings.length/2,width/20*18,
                    height/list_of_settings.length-1);
            g.drawString(displayed_string, width/20*2, height/list_of_settings.length*i+
                    height/list_of_settings.length);

        }


        GLOBAL_VARS.map_size = list_of_settings[0].options[list_of_settings[0].default_option_index];
        GLOBAL_VARS.amount_of_object_markers = list_of_settings[1].options[list_of_settings[1].default_option_index];
        GLOBAL_VARS.amount_of_rectangles = list_of_settings[2].options[list_of_settings[2].default_option_index];
        GLOBAL_VARS.space_border_length = list_of_settings[3].options[list_of_settings[3].default_option_index];
        GLOBAL_VARS.highlight_color_number = list_of_settings[4].options[list_of_settings[4].default_option_index];
        GLOBAL_VARS.change_highlight_color();

        if(repaint_allowed)
        {
            repaint_allowed = false;
            Main.graphics_main.repaint();
        }

    }
}
