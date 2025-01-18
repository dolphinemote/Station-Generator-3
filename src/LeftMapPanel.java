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

    //
    int last_drawn_area_number;
    //
    Image tileIcon = Toolkit.getDefaultToolkit().getImage("scuffedTileIcon.png");

    Image window = Toolkit.getDefaultToolkit().getImage("scuffedWindowIcon.png");
    Image airlock = Toolkit.getDefaultToolkit().getImage("scuffedAirlockIcon.png");
    Image wall = Toolkit.getDefaultToolkit().getImage("scuffedWallIcon.png");

    Image crate = Toolkit.getDefaultToolkit().getImage("scuffedYellowLockerIcon.png");
    Image locker = Toolkit.getDefaultToolkit().getImage("scuffedYellowTableIcon.png");
    Image table = Toolkit.getDefaultToolkit().getImage("scuffedYellowCrateIcon.png");

    Image chairDown = Toolkit.getDefaultToolkit().getImage("scuffedDownChairIcon.png");
    Image chairUp = Toolkit.getDefaultToolkit().getImage("scuffedUpChairIcon.png");
    Image chairLeft = Toolkit.getDefaultToolkit().getImage("scuffedLeftChairIcon.png");
    Image chairRight = Toolkit.getDefaultToolkit().getImage("scuffedRightChairIcon.png");

    Image scrubber = Toolkit.getDefaultToolkit().getImage("scuffedScrubberIcon.png");
    Image vent = Toolkit.getDefaultToolkit().getImage("scuffedVentIcon.png");
    Image pipes = Toolkit.getDefaultToolkit().getImage("scuffedPipesIcon.png");

    Image otherObject = Toolkit.getDefaultToolkit().getImage("scuffedObjectIcon.png");

    Image lattice = Toolkit.getDefaultToolkit().getImage("scuffedLatticeIcon.png");
    Image grille = Toolkit.getDefaultToolkit().getImage("scuffedGrilleIcon.png");
    Image plating = Toolkit.getDefaultToolkit().getImage("scuffedPlatingIcon.png");

    Image decal = Toolkit.getDefaultToolkit().getImage("decalIcon.png");

    Image catwalk = Toolkit.getDefaultToolkit().getImage("catwalkIcon.png");
    Image rock = Toolkit.getDefaultToolkit().getImage("rockIcon.png");
    Image effect = Toolkit.getDefaultToolkit().getImage("effectIcon.png");

    Image blueLocker = Toolkit.getDefaultToolkit().getImage("blueLockerIcon.png");
    Image redLocker = Toolkit.getDefaultToolkit().getImage("redLockerIcon.png");
    Image greyLocker = Toolkit.getDefaultToolkit().getImage("greyLockerIcon.png");




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
    }

    public void changeScale(){
        leftBorder = 0;
        topBorder = 0;
        if (scale == GLOBAL_VARS.map_size) {
            scale = 32;
        } else if (scale == 32) {
            scale = 16;
        } else if (scale == 16) {
            scale = GLOBAL_VARS.map_size;
        }
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

    private Color getColorForAreaNumber(int number){
        number = number % 10;
        return switch (number) {
            case 1 -> Color.RED;
            case 2 -> Color.ORANGE;
            case 3 -> Color.YELLOW;
            case 4 -> Color.GREEN;
            case 5 -> Color.CYAN;
            case 6 -> Color.BLUE;
            case 7 -> Color.MAGENTA;
            case 8 -> Color.PINK;
            case 9 -> Color.WHITE;
            default -> Color.BLACK;
        };
    }

    private void drawAreaNumber(Graphics g, int x, int y){
        if(last_drawn_area_number < Game_Map.array[x + leftBorder][y + topBorder].number){
            g.setColor(getColorForAreaNumber(Game_Map.array[x + leftBorder][y + topBorder].number));
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

        tileSideLength = panelSideLength / scale; // Начальный размер клеточки
        //padding = (panelSideLength - (scale*tileSideLength));
        //padding = 1;
        //System.out.println("SCREEN HEIGHT = "+panelSideLength);
        //System.out.println("scale*TILE SIDE LENGTH = "+scale*tileSideLength);
        //System.out.println("TOTAL PADDING NEEDED = "+(panelSideLength-scale*tileSideLength));
        //System.out.println(padding);
        TopRightLogPanel.add_a_message("");
        for (int y = 0; y < scale; y++) {
            for (int x = 0; x < scale; x++) {
                int posX = x * tileSideLength;
                int posY = y * tileSideLength;
                //System.out.println(posX+","+posY);
                drawTile(g, x, y, posX, posY); // Передаем позицию и индексы
                drawAreaNumber(g, x, y); // Передаем позицию и индексы
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
            case CARPET -> {
                g.setColor(Color.ORANGE);
                g.fillRect(posX, posY, tileSideLength, tileSideLength);
            }
            case SPACE ->
                    {
                        //
                    }
            case WALL -> {
                //g.setColor(Color.DARK_GRAY);
                //g.fillRect(x*tileSideLength, y*tileSideLength, tileSideLength, tileSideLength);
                g.drawImage(wall,posX, posY, tileSideLength, tileSideLength, this);
            }
            case WINDOW -> {
                //g.setColor(Color.BLUE);
                //g.fillRect(x* tileSideLength, y*tileSideLength, tileSideLength, tileSideLength);
                g.drawImage(window,posX, posY , tileSideLength, tileSideLength, this);
            }
            case AIRLOCK -> {
                g.drawImage(airlock,posX, posY, tileSideLength, tileSideLength, this);
                //g.setColor(Color.DARK_GRAY);
                //g.fillRect(x*(tileSideLength), y*(tileSideLength), tileSideLength, tileSideLength);
                //g.setColor(Color.GREEN);
                //g.drawLine(x * tileSideLength + (tileSideLength / 2), y * tileSideLength, x * tileSideLength + (tileSideLength / 2), (y + 1) * tileSideLength);
            }
            case FLOOR -> {
                //g.setColor(Color.GRAY);
                //g.fillRect(x * tileSideLength, y * tileSideLength, tileSideLength, tileSideLength);
                g.drawImage(tileIcon, posX, posY, tileSideLength, tileSideLength, this);
            }
            case SPACE_BORDER -> {
                g.setColor(Color.BLUE);
                g.drawLine(posX, posY, posX + tileSideLength, posY + tileSideLength);
                g.drawLine(posX, posY + tileSideLength, posX + tileSideLength, posY);
            }
            case OBJECT -> {
                //g.setColor(Color.GRAY);
                //g.fillRect(x* tileSideLength, y* tileSideLength, tileSideLength, tileSideLength);
                //g.setColor(Color.RED);
                //g.drawLine(x* tileSideLength, y* tileSideLength, (x+1)* tileSideLength, (y+1)* tileSideLength);
                //g.drawLine((x+1)* tileSideLength, y* tileSideLength, x* tileSideLength, (y+1)* tileSideLength);

                if(Game_Map.array[x+leftBorder][y+topBorder].random_object_icon_type == 0)
                {
                    Game_Map.array[x+leftBorder][y+topBorder].random_object_icon_type = random.nextInt(18)+1;
                }

                g.drawImage(tileIcon, posX, posY, tileSideLength, tileSideLength, this);
                //g.drawImage(otherObject, posX, posY, tileSideLength, tileSideLength, this);

                switch (Game_Map.array[x+leftBorder][y+topBorder].random_object_icon_type)
                {

                    case 1 -> g.drawImage(crate,posX, posY, tileSideLength, tileSideLength, this);
                    case 2 -> g.drawImage(table,posX, posY, tileSideLength, tileSideLength, this);
                    case 3 -> g.drawImage(chairUp,posX , posY, tileSideLength, tileSideLength, this);
                    case 4 -> g.drawImage(chairDown,posX , posY, tileSideLength, tileSideLength, this);
                    case 5 -> g.drawImage(scrubber,posX, posY, tileSideLength, tileSideLength, this);
                    case 6 -> g.drawImage(vent,posX, posY, tileSideLength, tileSideLength, this);
                    case 7 -> g.drawImage(pipes,posX, posY, tileSideLength, tileSideLength, this);
                    case 8 -> g.drawImage(chairRight,posX , posY, tileSideLength, tileSideLength, this);
                    case 9 -> g.drawImage(chairLeft,posX, posY, tileSideLength, tileSideLength, this);
                    case 10 -> g.drawImage(otherObject,posX, posY, tileSideLength, tileSideLength, this);
                    case 11 -> g.drawImage(locker,posX, posY, tileSideLength, tileSideLength, this);
                    case 12 -> g.drawImage(lattice,posX , posY, tileSideLength, tileSideLength, this);
                    case 13 -> g.drawImage(plating,posX, posY, tileSideLength, tileSideLength, this);
                    case 14 -> g.drawImage(grille,posX, posY, tileSideLength, tileSideLength, this);
                    case 15 -> g.drawImage(decal,posX, posY, tileSideLength, tileSideLength, this);
                    case 16 -> g.drawImage(effect,posX, posY, tileSideLength, tileSideLength, this);
                    case 17 -> g.drawImage(catwalk,posX, posY, tileSideLength, tileSideLength, this);
                    case 18 -> g.drawImage(rock,posX, posY, tileSideLength, tileSideLength, this);

                }
                //g.drawImage(otherObject,x * tileSideLength, y * tileSideLength, tileSideLength, tileSideLength, this);
            }
//            case PIPES -> {
//                g.setColor(Color.GRAY);
//                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
//                g.setColor(Color.RED);
//                g.drawLine(x * (height / scale) + (height / scale) / 3, y * (height / scale),
//                        x * (height / scale) + (height / scale) / 3, (y + 1) * (height / scale));
//                g.drawLine(x * (height / scale), y * (height / scale) + (height / scale) / 3,
//                        (x + 1) * (height / scale), y * (height / scale) + (height / scale) / 3);
//                g.setColor(Color.BLUE);
//                g.drawLine(x * (height / scale) + (height / scale) / 3 * 2, y * (height / scale),
//                        x * (height / scale) + (height / scale) / 3 * 2, (y + 1) * (height / scale));
//                g.drawLine(x * (height / scale), y * (height / scale) + (height / scale) / 3 * 2,
//                        (x + 1) * (height / scale), y * (height / scale) + (height / scale) / 3 * 2);
//            }
        }
    }
}
