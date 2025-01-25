import javax.swing.*;
import java.awt.*;

public class TopRightLogPanel extends JPanel {
    private static final int MESSAGE_CAPACITY = 1000;
    public static String[] text_array = new String[MESSAGE_CAPACITY];
    private static int lastIndex = -1;
    private static int totalMessages = 0;

    private final int width;
    private final int height;

    public TopRightLogPanel(int screen_width, int screen_height) {

        setBackground(GLOBAL_VARS.main_background_color);

        this.width = Math.max(200, screen_width - screen_height);
        this.height = screen_height / 3;
        int x = screen_width - width;
        this.setBounds(x, 0, width, height);

        add_a_message("Start");
        add_a_message("For now we use a primitive method of placing random rectangles");
        add_a_message("instead of decent room generation");
        add_a_message("Object marker icons have been replaced with random icons");
        add_a_message("of the objects themselves for testing them");
    }

    private MessageData getMessageFromEnd(int reverseIndex) {
        int found = 0;
        for (int i = lastIndex; i >= 0; i--) {
            if (text_array[i] != null) {
                if (found == reverseIndex) {
                    return new MessageData(text_array[i], totalMessages - (lastIndex - i));
                }
                found++;
            }
        }
        return new MessageData("", 0);
    }

    public static void add_a_message(String message) {
        if (lastIndex < MESSAGE_CAPACITY - 1) {
            text_array[++lastIndex] = message;
        } else {
            System.arraycopy(text_array, 1, text_array, 0, MESSAGE_CAPACITY - 1);
            text_array[MESSAGE_CAPACITY - 1] = message;
        }
        totalMessages++;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                g.setColor(GLOBAL_VARS.second_background_color.darker());
                g.fillRect(0, height / 10 * i, width, height / 10);
            }

            MessageData msgData = getMessageFromEnd(9 - i);
            if (!msgData.message.isEmpty()) {
                g.setColor(Color.lightGray);

                g.drawString(msgData.number + ": " + msgData.message,
                        width / 40,
                        height / 10 * i + height / 10 / 3 * 2);
            }
        }

        g.setColor(Color.GRAY);
        g.drawRect(1, 1, width-2, height-2);
    }

    private static class MessageData {
        String message;
        int number;

        MessageData(String message, int number) {
            this.message = message;
            this.number = number;
        }
    }
}