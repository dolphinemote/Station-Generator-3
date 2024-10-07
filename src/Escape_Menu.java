import javax.swing.*;
import java.awt.*;


public class Escape_Menu extends JPanel
{
    int x;
    int y;
    int width;
    int height;
    int chosen_button = 0;

    Escape_Menu(int screen_width, int screen_height)
    {
        x = screen_width/3;
        y = screen_height/3;
        width = screen_width/3;
        height = screen_height/3;
        this.setBackground(GLOBAL_VARS.main_background_color);
        this.setBounds(x,y,width,height);
        this.setVisible(false);
    }
    void menu_called()
    {
        this.chosen_button=0;

        //if visible makes un-visible and vice versa
        this.setVisible(!isVisible());
        if(isVisible())
        {
            Main.keyboard_handler.previous_active_panel = Main.keyboard_handler.active_panel;
            Main.keyboard_handler.active_panel = "Escape_Menu";
        }
        else{Main.keyboard_handler.active_panel = Main.keyboard_handler.previous_active_panel;}
    }

    static void key_left_or_right_pressed()
    {
        if (GraphicsMain.escape_menu.chosen_button == 0)
        {GraphicsMain.escape_menu.chosen_button = 1;}
        else {GraphicsMain.escape_menu.chosen_button = 0;}
    }


    void key_Enter_or_Space_pressed()
    {
        if(chosen_button==1)
        {System.exit(0);}
        else{this.menu_called();}
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(GLOBAL_VARS.highlight_color);
        g.drawRect(0,0,width,height);

        g.drawString("EXIT",width/20,height/10);

        if(chosen_button==0){
            g.setColor(GLOBAL_VARS.highlight_color);
            g.fillRect(0,height/2,width/2,height/2);
            g.drawString("Yes", width/4*3, height/4*3);
            g.setColor(GLOBAL_VARS.main_background_color);
            g.drawString("No", width/4, height/4*3);
        }
        else {
            g.setColor(GLOBAL_VARS.highlight_color);
            g.fillRect(width/2,height/2,width/2,height/2);
            g.drawString("No", width/4, height/4*3);
            g.setColor(GLOBAL_VARS.main_background_color);
            g.drawString("Yes", width/4*3, height/4*3);

        }
    }
}
