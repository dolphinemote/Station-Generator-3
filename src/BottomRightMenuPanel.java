import javax.swing.*;
import java.awt.*;

public class BottomRightMenuPanel extends JPanel {

    int x;
    int y;
    int width;
    int height;

    public int current_selected_menu_button = 0;

    String[] menuButtons;

    String getMapName()
    {
        String ReturnString = "";
        if(Game_Map.map_style != null)
        {ReturnString = Game_Map.map_style.name;}
        return ReturnString;
    }

    void button_W_or_UP_pressed()
    {
        if (GraphicsMain.bottomRightMenuPanel.current_selected_menu_button > 0)
        {GraphicsMain.bottomRightMenuPanel.current_selected_menu_button--;}
        else {GraphicsMain.bottomRightMenuPanel.current_selected_menu_button = menuButtons.length-1;}
    }
    void button_S_or_DOWN_pressed()
    {
        if (GraphicsMain.bottomRightMenuPanel.current_selected_menu_button < menuButtons.length-1)
        {GraphicsMain.bottomRightMenuPanel.current_selected_menu_button++;}
        else {GraphicsMain.bottomRightMenuPanel.current_selected_menu_button = 0;}
    }

    void button_Enter_or_Space_pressed()
    {
        switch (current_selected_menu_button)
        {
            case 0 -> Generator.generate();
            case 1 -> Array_To_DMM.simple_convert();
            case 2 -> GraphicsMain.settings_panel.menu_called();
            case 3 -> GraphicsMain.leftMapPanel.changeScale();
            case 4 -> GraphicsMain.leftMapPanel.togglePanel();
            case 5 -> GraphicsMain.escape_menu.menu_called();
        }
    }

    BottomRightMenuPanel(int screen_width, int screen_height)
    {
        setBackground(Color.BLACK);
        x = screen_height;
        y = screen_height/3;
        width = screen_width - screen_height;
        height = screen_height/3*2;
        this.setBounds(x, y, width, height);

        menuButtons = new String[]
                {"Generate","Convert to DMM","Settings","Change Scale","Move Camera","Exit"};
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //black background of the menu
        g.setColor(GLOBAL_VARS.main_background_color);
        g.fillRect(0, 0, width, height);

        //gray outline of the menu
        g.setColor(GLOBAL_VARS.main_text_color);
        g.drawRect(1, 1, width-2, height-2);

        for(y=0;y<6;y++)//menu buttons
        {
            {
                g.setColor(GLOBAL_VARS.main_text_color);

                if (y == current_selected_menu_button)
                {g.setColor(GLOBAL_VARS.highlight_color);}

                g.drawRect(width / 10, height / 7 * y + height/14, width / 10 * 8, height / 7-1);
                g.drawString(menuButtons[y],width/10*2,height/7 * y + height/7);
            }
        }
    }
}
