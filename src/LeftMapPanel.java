import javax.swing.*;
import java.awt.*;

public class LeftMapPanel extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;

    private static int scale;
    private static int leftBorder = 0;
    private static int topBorder = 0;

    private boolean isPanelActive = false;

    //
    int last_drawn_area_number;
    //

    public LeftMapPanel(int screenHeight){
        scale = Game_Map.size_of_the_map;
        System.out.println("Map_Panel");
        setBackground(GLOBAL_VARS.main_background_color);
        x = 0;
        y = 0;
        width = screenHeight;
        height = width;
        this.setBounds(x, y, width, height);
    }

    public void changeScale(){
        leftBorder = 0;
        topBorder = 0;
        if (scale == Game_Map.size_of_the_map) {
            scale = 32;
        } else if (scale == 32) {
            scale = 16;
        } else if (scale == 16) {
            scale = Game_Map.size_of_the_map;
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
                        x * (height / scale), (y + 1) * (height / scale));

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
        for (int y = 0; y < scale; y++) {
            for (int x = 0; x < scale; x++) {
                drawTile(g, x, y);
                drawAreaNumber(g, x, y);
            }
        }
        if (isPanelActive) {
            g.setColor(GLOBAL_VARS.highlight_color);
            g.drawRect(0, 0, height, height);
        }
    }

    private void drawTile(Graphics g, int x, int y) {
        switch (Game_Map.array[x + leftBorder][y + topBorder].marker) {
            case CARPET -> {
                g.setColor(Color.ORANGE);
                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
            }
            case SPACE -> {
            }
            case WALL -> {
                g.setColor(Color.DARK_GRAY);
                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
            }
            case WINDOW -> {
                g.setColor(Color.BLUE);
                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
            }
            case AIRLOCK -> {
                g.setColor(Color.DARK_GRAY);
                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
                g.setColor(Color.GREEN);
                g.drawLine(x * (height / scale) + (height / scale / 2), y * (height / scale),
                        x * (height / scale) + (height / scale / 2), (y + 1) * (height / scale));
            }
            case FLOOR -> {
                g.setColor(Color.GRAY);
                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
            }
            case SPACE_BORDER -> {
                g.setColor(Color.BLUE);
                g.drawLine(x * (height / scale), y * (height / scale), (x + 1) * (height / scale), (y + 1) * (height / scale));
                g.drawLine((x + 1) * (height / scale), y * (height / scale), x * (height / scale), (y + 1) * (height / scale));
            }
            case OBJECT -> {
                g.setColor(Color.GRAY);
                g.fillRect(x * (height / scale), y * (height / scale), height / scale, height / scale);
                g.setColor(Color.RED);
                g.drawLine(x * (height / scale), y * (height / scale), (x + 1) * (height / scale), (y + 1) * (height / scale));
                g.drawLine((x + 1) * (height / scale), y * (height / scale), x * (height / scale), (y + 1) * (height / scale));
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
