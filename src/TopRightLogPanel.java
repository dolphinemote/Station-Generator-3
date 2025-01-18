import javax.swing.*;
import java.awt.*;

public class TopRightLogPanel extends JPanel
{
    int x;
    int y;
    int width;
    int height;

    //0-999
    public static String[] text_array = new String[1000];

    String get_X_NonEmptyMessageFromTheEnd(int search_index)//0-10
    {
        String displayed_message = "";
        for (int i = 10; i < text_array.length; i++)
        {
            if(text_array[i] == null)
            {
                if(text_array[search_index + i - 10] != null)
                {
                    return text_array[search_index + i - 10];
                }
                else
                {
                    return "";
                }
            }
        }
        return displayed_message;
    }
    public static void add_a_message(String message)
    {
        for(int i = 0; i < text_array.length; i++)
        {
            if(text_array[i] == null)
            {
                text_array[i] = message;
                break;
            }
            if(i == 999)
            {
                text_array = new String[1000];
                text_array[0] = message;
                break;
            }
        }
    }


    TopRightLogPanel(int screen_width, int screen_height)
    {
        text_array[0] = "Start";
        setBackground(GLOBAL_VARS.main_background_color);
        x = screen_height;
        y = 0;
        width = screen_width-screen_height;
        height = screen_height / 3;
        this.setBounds(x, y, width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < 10; i++)
        {
            if(i % 2 != 0)
            {
                g.setColor(GLOBAL_VARS.second_background_color.darker());
                g.fillRect(0,height / 10 * i,width,height / 10);
            }
            g.setColor(Color.lightGray);
            g.drawString(i + "",width / 40,height / 10 * i + height / 10 / 3 * 2);

            //g.setColor(Misc_Methods.misc_get_random_color());
            g.drawString("          "+get_X_NonEmptyMessageFromTheEnd(i),
                    width / 40,height/10 * i + height / 10 / 3 * 2);
        }
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, width-1, height);
    }
}
