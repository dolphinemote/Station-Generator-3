import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LeftMapPanel extends JPanel {
    private static final int MIN_SCALE = 15;
    private static final int MEDIUM_SCALE = 30;
    private static final int BORDER_WIDTH = 2;


    private static int tileSize;
    private static int panelSize;
    private static int padding;
    private static int scale;
    private static int leftBorder = 0;
    private static int topBorder = 0;
    private static boolean isPanelActive = false;

    // resources
    private Image tile, tile_big, plating, window, airlock, wall, lattice, grille, catwalk;
    private final Image[] object_icon_array;

    private final Random random = new Random();
    private int last_drawn_area_number;

    public LeftMapPanel(int screenHeight) {
        loadBaseImages();
        object_icon_array = createObjectIconsArray();
        initializePanel(screenHeight);
    }

    private void initializePanel(int screenHeight) {
        scale = GLOBAL_VARS.map_size;
        panelSize = screenHeight;
        setBackground(GLOBAL_VARS.main_background_color);
        setBounds(0, 0, panelSize, panelSize);
        recalculateTileSize();
    }



    private void loadBaseImages() {
        tile = safeLoadImage("icons/tile.png");
        tile_big = safeLoadImage("icons/tileBIG.png");
        plating = safeLoadImage("icons/plating.png");
        window = safeLoadImage("icons/window.png");
        airlock = safeLoadImage("icons/airlock.png");
        wall = safeLoadImage("icons/wall.png");
        lattice = safeLoadImage("icons/lattice.png");
        grille = safeLoadImage("icons/grille.png");
        catwalk = safeLoadImage("icons/catwalk.png");
    }

    private Image[] createObjectIconsArray() {
        return new Image[] {
                safeLoadImage("icons/yellow_closet.png"),
                safeLoadImage("icons/yellow_table.png"),
                safeLoadImage("icons/yellow_crate.png"),
                safeLoadImage("icons/chair_down.png"),
                safeLoadImage("icons/chair_up.png"),
                safeLoadImage("icons/chair_left.png"),
                safeLoadImage("icons/chair_right.png"),
                safeLoadImage("icons/scrubber.png"),
                safeLoadImage("icons/vent.png"),
                safeLoadImage("icons/object.png"),
                safeLoadImage("icons/decal.png"),
                safeLoadImage("icons/effect.png"),
                safeLoadImage("icons/console_up.png"),
                safeLoadImage("icons/console_down.png"),
                safeLoadImage("icons/console_right.png"),
                safeLoadImage("icons/console_left.png"),
                safeLoadImage("icons/sleeper_right.png"),
                safeLoadImage("icons/sleeper_left.png"),
                safeLoadImage("icons/canister.png"),
        };
    }

    private Image safeLoadImage(String path) {

            return Toolkit.getDefaultToolkit().getImage((path));

    }

    private void recalculateTileSize() {
        tileSize = panelSize / scale;
        padding = (panelSize - (scale * tileSize)) / 2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        renderMapGrid(g2d);
        drawActiveBorder(g2d);
    }

    private void renderMapGrid(Graphics2D g) {
        last_drawn_area_number = 0;
        for (int y = 0; y < scale; y++) {
            for (int x = 0; x < scale; x++) {
                int posX = x * tileSize + padding;
                int posY = y * tileSize + padding;
                drawTile(g, x, y, posX, posY);
            }
        }
    }

    private void drawTile(Graphics2D g, int x, int y, int posX, int posY) {
        int mapX = x + leftBorder;
        int mapY = y + topBorder;

        if (mapX >= Game_Map.size_of_the_map || mapY >= Game_Map.size_of_the_map) return;

        Markers marker = Game_Map.array[mapX][mapY].marker;
        drawTileBackground(g, marker, posX, posY);
        drawAreaNumber(g, mapX, mapY, posX, posY);
        drawTileObject(g, mapX, mapY, posX, posY);
    }

    private void drawTileBackground(Graphics2D g, Markers marker, int x, int y) {
        switch (marker) {
            case WALL -> g.drawImage(wall, x, y, tileSize, tileSize, this);
            case WINDOW -> g.drawImage(window, x, y, tileSize, tileSize, this);
            case AIRLOCK -> g.drawImage(airlock, x, y, tileSize, tileSize, this);
            case FLOOR -> g.drawImage(tile, x, y, tileSize, tileSize, this);
            case FLOOR_2 -> g.drawImage(tile_big, x, y, tileSize, tileSize, this);
            case PLATING -> g.drawImage(plating, x, y, tileSize, tileSize, this);
            case LATTICE -> g.drawImage(lattice, x, y, tileSize, tileSize, this);
            case GRILLE -> g.drawImage(grille, x, y, tileSize, tileSize, this);
            case CATWALK -> g.drawImage(catwalk, x, y, tileSize, tileSize, this);
            case SPACE_BORDER -> drawSpaceBorder(g, x, y);
        }
    }

    private void drawSpaceBorder(Graphics2D g, int x, int y) {
        g.setColor(Color.BLUE);
        g.drawLine(x, y, x + tileSize, y + tileSize);
        g.drawLine(x, y + tileSize, x + tileSize, y);
    }

    private void drawAreaNumber(Graphics2D g, int mapX, int mapY, int posX, int posY) {
        if (Game_Map.array[mapX][mapY].marker == Markers.FLOOR) {
            if (Game_Map.array[mapX][mapY].number > last_drawn_area_number) {
                g.setColor(Color.GREEN);
                g.drawString(String.valueOf(Game_Map.array[mapX][mapY].number),
                        posX, posY + tileSize);
                last_drawn_area_number = Game_Map.array[mapX][mapY].number;
            }
        }
    }

    private void drawTileObject(Graphics2D g, int mapX, int mapY, int posX, int posY) {
        if (Game_Map.array[mapX][mapY].marker == Markers.OBJECT) {
            if (Game_Map.array[mapX][mapY].random_object_icon_type == 100) {
                Game_Map.array[mapX][mapY].random_object_icon_type = random.nextInt(object_icon_array.length);
            }
            int iconIndex = Game_Map.array[mapX][mapY].random_object_icon_type;
            if (iconIndex < object_icon_array.length) {
                g.drawImage(tile, posX, posY, tileSize, tileSize, this);
                g.drawImage(object_icon_array[iconIndex], posX, posY, tileSize, tileSize, this);
            }
        }
    }

    private void drawActiveBorder(Graphics2D g) {
        if (isPanelActive) {
            g.setColor(GLOBAL_VARS.highlight_color);
            g.setStroke(new BasicStroke(BORDER_WIDTH));
            g.drawRect(BORDER_WIDTH, BORDER_WIDTH, panelSize - BORDER_WIDTH*2, panelSize - BORDER_WIDTH*2);
        }
    }

    //
    public void changeScale() {
        leftBorder = 0;
        topBorder = 0;
        if (scale == GLOBAL_VARS.map_size) {
            scale = MEDIUM_SCALE;
        } else if (scale == MEDIUM_SCALE) {
            scale = MIN_SCALE;
        } else {
            scale = GLOBAL_VARS.map_size;
        }
        recalculateTileSize();
        repaint();
    }

    public void handleUpButtonPress() {
        if (topBorder > 0) topBorder--;
        repaint();
    }

    public static void handleLeftButtonPress() {
        if (leftBorder > 0) leftBorder--;

    }

    public void handleDownButtonPress() {
        if (scale + topBorder < Game_Map.size_of_the_map) topBorder++;

    }

    public static void handleRightButtonPress() {
        if (scale + leftBorder < Game_Map.size_of_the_map) leftBorder++;

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
}