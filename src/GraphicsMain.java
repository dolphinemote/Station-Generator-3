import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GraphicsMain extends JFrame
{

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static public int width = (int)screenSize.getWidth();
    static public int height = (int)screenSize.getHeight();

    static Escape_Menu escape_menu = new Escape_Menu(width, height);
    static TopRightLogPanel topRightPanel = new TopRightLogPanel(width, height);
    static BottomRightMenuPanel bottomRightMenuPanel = new BottomRightMenuPanel(width, height);
    static LeftMapPanel leftMapPanel = new LeftMapPanel(height);
    static Settings_Panel settings_panel = new Settings_Panel(width,height);

    //Image appIcon = Toolkit.getDefaultToolkit().getImage("appIconOBJ-256.png");
    Image appIcon = Toolkit.getDefaultToolkit().getImage("appIconTILE-256.png");

    GraphicsMain()
    {
        System.out.println("Graphics_Main");

        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        KeyAdapter keyAdapter = new KeyAdapter()
        {
            public void keyPressed(KeyEvent keyEvent)
            {
                Main.keyboard_handler.key_pressed(keyEvent);
            }
        };

        addKeyListener(keyAdapter);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setUndecorated(true);
        setSize(width, height);
        getContentPane().setBackground(GLOBAL_VARS.second_background_color);

        setIconImage(appIcon);

        setVisible(true);


        add(escape_menu);
        add(settings_panel);
        add(topRightPanel);
        add(bottomRightMenuPanel);
        add(leftMapPanel);


        System.out.println("Graphics_Main:\tAmount of elements in the root container = "
                +this.getContentPane().getComponentCount());
    }
}
