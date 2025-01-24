import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LeftMapPanel extends JPanel {

    int tileSideLength;
    int panelSideLength;

    int padding;


    private static int scale;
    private static int leftBorder = 0;
    private static int topBorder = 0;

    private boolean isPanelActive = false;

    Random random = new Random();

    int last_drawn_area_number;

    Image tile = Toolkit.getDefaultToolkit().getImage("icons/tile.png");
    Image tile_big = Toolkit.getDefaultToolkit().getImage("icons/tileBIG.png");

    Image window = Toolkit.getDefaultToolkit().getImage("icons/window.png");
    Image airlock = Toolkit.getDefaultToolkit().getImage("icons/airlock.png");
    Image wall = Toolkit.getDefaultToolkit().getImage("icons/wall.png");

    Image lattice = Toolkit.getDefaultToolkit().getImage("icons/lattice.png");
    Image grille = Toolkit.getDefaultToolkit().getImage("icons/grille.png");
    Image catwalk = Toolkit.getDefaultToolkit().getImage("icons/catwalk.png");

    //Image blueLocker = Toolkit.getDefaultToolkit().getImage("blueLockerIcon.png");
    //Image redLocker = Toolkit.getDefaultToolkit().getImage("redLockerIcon.png");
    //Image greyLocker = Toolkit.getDefaultToolkit().getImage("greyLockerIcon.png");



    Image[] object_icon_array;

    public void initialize(int panelSideLength){
        scale = GLOBAL_VARS.map_size;
        this.panelSideLength =  panelSideLength;
        System.out.println("Map_Panel");
        setBackground(GLOBAL_VARS.main_background_color);
        int x = 0;
        int y = 0;

        this.setBounds(x, y, panelSideLength, panelSideLength);
    }

    LeftMapPanel(int screenHeight){
        initialize(screenHeight);
        object_icon_array = new Image[]
                {
                    Toolkit.getDefaultToolkit().getImage("icons/yellow_closet.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/yellow_table.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/yellow_crate.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/chair_down.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/chair_up.png"),
                    //5
                    Toolkit.getDefaultToolkit().getImage("icons/chair_left.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/chair_right.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/scrubber.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/vent.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/pipes.png"),
                    //10
                    Toolkit.getDefaultToolkit().getImage("icons/object.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/decal.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/plating.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/effect.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/rock.png"),
                    //15
                    Toolkit.getDefaultToolkit().getImage("icons/console_up.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/console_down.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/console_right.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/console_left.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/wire.png"),
                    //20
                    Toolkit.getDefaultToolkit().getImage("icons/sleeper_right.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/sleeper_left.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/tempPIPESandWIRE.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/red_closet.png"),
                    Toolkit.getDefaultToolkit().getImage("icons/blue_closet.png"),
                    //23
                };
    }

    public void changeScale(){
        leftBorder = 0;
        topBorder = 0;
        if (scale == GLOBAL_VARS.map_size) {
            scale = 30;
        } else if (scale == 30) {
            scale = 15;
        } else if (scale == 15) {
            scale = GLOBAL_VARS.map_size;
        }
        repaint();
    }

    public void handleUpButtonPress(){
        if (topBorder > 0) {
            topBorder--;
        }
    }

    public static void handleLeftButtonPress(){
        if (leftBorder > 0) {
            leftBorder--;
        }
    }

    public void handleDownButtonPress(){
        if (scale + topBorder < Game_Map.size_of_the_map) {
            topBorder++;
        }
    }

    public static void handleRightButtonPress(){
        if (scale + leftBorder < Game_Map.size_of_the_map) {
            leftBorder++;
        }
    }

    public void togglePanel(){
        if (!isPanelActive) {
            Main.keyboard_handler.previous_active_panel = Main.keyboard_handler.active_panel;
            Main.keyboard_handler.active_panel = "LeftMapPanel";
        } else {
            Main.keyboard_handler.active_panel = Main.keyboard_handler.previous_active_panel;
        }
        isPanelActive = !isPanelActive;
    }



    private void drawAreaNumber(Graphics g, int x, int y){
        if(last_drawn_area_number < Game_Map.array[x + leftBorder][y + topBorder].number){
            //g.setColor(getColorForAreaNumber(Game_Map.array[x + leftBorder][y + topBorder].number));
            g.setColor(Color.GREEN);
            if (Game_Map.array[x + leftBorder][y + topBorder].marker == Markers.FLOOR){
                g.drawString("" + (Game_Map.array[x + leftBorder][y + topBorder].number),
                        x*tileSideLength, (y+1)*tileSideLength);
            }
        }
        if(Game_Map.array[x + leftBorder][y + topBorder].number>last_drawn_area_number){
            last_drawn_area_number = Game_Map.array[x + leftBorder][y + topBorder].number;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        last_drawn_area_number = 0;
        super.paintComponent(g);

        //tileSideLength = panelSideLength / scale;
        //padding = (panelSideLength - (scale*tileSideLength));

        //padding = 1;
        //System.out.println("SCREEN HEIGHT = "+panelSideLength);
        //System.out.println("scale*TILE SIDE LENGTH = "+scale*tileSideLength);
        //System.out.println("TOTAL PADDING NEEDED = "+(panelSideLength-scale*tileSideLength));

        //System.out.println(panelSideLength);

        //System.out.println(padding);
        for (int y = 0; y < scale; y++) {
            for (int x = 0; x < scale; x++) {
                int posX = x * tileSideLength + padding/2;
                int posY = y * tileSideLength + padding/2;
                //System.out.println(posX+","+posY);
                drawTile(g, x, y, posX, posY);
                drawAreaNumber(g, x, y);
            }
        }
        if (isPanelActive) {
            g.setColor(GLOBAL_VARS.highlight_color);
            g.drawRect(1, 1, panelSideLength - 2, panelSideLength - 2);
        }
    }




    private void drawTile(Graphics g, int x, int y, int posX, int posY) {
        tileSideLength = panelSideLength / scale;
        switch (Game_Map.array[x + leftBorder][y + topBorder].marker) {
            case SPACE -> { }
            case WALL -> g.drawImage(wall,posX, posY, tileSideLength, tileSideLength, this);
            case WINDOW -> {
                //g.drawImage(plating, posX, posY, tileSideLength, tileSideLength, this);
                g.drawImage(window, posX, posY, tileSideLength, tileSideLength, this);
            }
            case AIRLOCK -> g.drawImage(airlock,posX, posY, tileSideLength, tileSideLength, this);
            case FLOOR -> g.drawImage(tile, posX, posY, tileSideLength, tileSideLength, this);
            case FLOOR_2 -> g.drawImage(tile_big, posX, posY, tileSideLength, tileSideLength, this);
            case PLATING -> g.drawImage(object_icon_array[12], posX, posY, tileSideLength, tileSideLength, this);
            case LATTICE -> g.drawImage(lattice, posX, posY, tileSideLength, tileSideLength, this);
            case GRILLE -> g.drawImage(grille, posX, posY, tileSideLength, tileSideLength, this);
            case CATWALK -> g.drawImage(catwalk, posX, posY, tileSideLength, tileSideLength, this);
            case SPACE_BORDER -> {
                g.setColor(Color.BLUE);
                g.drawLine(posX, posY, posX + tileSideLength, posY + tileSideLength);
                g.drawLine(posX, posY + tileSideLength, posX + tileSideLength, posY);
            }
            case OBJECT -> {
                if(Game_Map.array[x+leftBorder][y+topBorder].random_object_icon_type == 100)
                {
                    Game_Map.array[x+leftBorder][y+topBorder].random_object_icon_type = random.nextInt(object_icon_array.length);
                }
                g.drawImage(tile, posX, posY, tileSideLength, tileSideLength, this);
                g.drawImage(object_icon_array[Game_Map.array[x+leftBorder][y+topBorder].random_object_icon_type],posX, posY, tileSideLength, tileSideLength, this);
                //g.drawImage(otherObject,x * tileSideLength, y * tileSideLength, tileSideLength, tileSideLength, this);
            }

        }
    }
}
