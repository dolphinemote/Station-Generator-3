import java.awt.event.KeyEvent;

public class Keyboard_Handler {
    String active_panel = "Main";
    String previous_active_panel = "Main";

    void key_pressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                switch (active_panel) {
                    case "Main":
                        GraphicsMain.bottomRightMenuPanel.button_W_or_UP_pressed();
                        break;
                    case "LeftMapPanel":
                        GraphicsMain.leftMapPanel.handleUpButtonPress();
                        break;
                    case "Settings_Panel":
                        GraphicsMain.settings_panel.button_W_or_UP_pressed();
                        break;
                    case "Something_else":
                        break;
                }
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                switch (active_panel) {
                    case "Main":
                        GraphicsMain.bottomRightMenuPanel.button_S_or_DOWN_pressed();
                        break;
                    case "LeftMapPanel":
                        GraphicsMain.leftMapPanel.handleDownButtonPress();
                        break;
                    case "Settings_Panel":
                        GraphicsMain.settings_panel.button_S_or_DOWN_pressed();
                        break;
                    case "Something_else":
                        break;
                }
            }
            case KeyEvent.VK_ESCAPE -> {
                switch (active_panel) {
                    case "Main", "Escape_Menu" -> GraphicsMain.escape_menu.menu_called();
                    case "LeftMapPanel" -> GraphicsMain.leftMapPanel.togglePanel();
                    case "Settings_Panel" -> GraphicsMain.settings_panel.menu_called();
                }
            }
            case KeyEvent.VK_LEFT, KeyEvent.VK_A  -> {
                switch (active_panel)
                    {
                        case "Escape_Menu" -> Escape_Menu.key_left_or_right_pressed();
                        case "LeftMapPanel" -> LeftMapPanel.handleLeftButtonPress();
                        case "Settings_Panel" ->
                                Settings_Panel.list_of_settings[Settings_Panel.chosen_button].previous_option();
                    }
                }

            case KeyEvent.VK_RIGHT, KeyEvent.VK_D  -> {
                switch (active_panel)
                    {
                        case "Escape_Menu" -> Escape_Menu.key_left_or_right_pressed();
                        case "LeftMapPanel" -> LeftMapPanel.handleRightButtonPress();
                        case "Settings_Panel" ->
                                Settings_Panel.list_of_settings[Settings_Panel.chosen_button].next_option();
                    }
                }

            case KeyEvent.VK_ENTER, KeyEvent.VK_SPACE ->
                {
                    switch (active_panel)
                    {
                        case "Main" -> GraphicsMain.bottomRightMenuPanel.button_Enter_or_Space_pressed();
                        case "Escape_Menu" -> GraphicsMain.escape_menu.key_Enter_or_Space_pressed();
                        case "Settings_Panel" -> Settings_Panel.list_of_settings[Settings_Panel.chosen_button].next_option();
                    }
                }
        }
        Main.graphics_main.repaint();
    }
}
