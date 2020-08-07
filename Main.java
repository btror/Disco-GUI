package ColorBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author brorie3
 */
public class Main {

    private static JFrame frame;
    private static JPanel[] list = new JPanel[100];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setSize(new Dimension(500, 500));
        frame.setTitle("DISCO GUI");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        GridLayout layout = new GridLayout(10, 10);
        frame.setLayout(layout);

        defaultSetup();

        runAnimation();

    }

    public static void defaultSetup() {
        for (int i = 0; i < 100; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(generateRandomColor());
            frame.add(panel);
            list[i] = panel;
        }
    }

    public static Color generateRandomColor() {
        Color color = Color.BLACK;
        int random = (int) (Math.random() * 13) - 0;
        switch (random) {
            case 0:
                color = Color.WHITE;
                break;
            case 1:
                color = Color.BLACK;
                break;
            case 2:
                color = Color.GRAY;
                break;
            case 3:
                color = Color.DARK_GRAY;
                break;
            case 4:
                color = Color.LIGHT_GRAY;
                break;
            case 5:
                color = Color.ORANGE;
                break;
            case 6:
                color = Color.RED;
                break;
            case 7:
                color = Color.YELLOW;
                break;
            case 8:
                color = Color.PINK;
                break;
            case 9:
                color = Color.BLUE;
                break;
            case 10:
                color = Color.CYAN;
                break;
            case 11:
                color = Color.MAGENTA;
                break;
            case 12:
                color = Color.GREEN;
                break;  
        }
        return color;
    }

    public static void runAnimation() {
        Thread thread = new Thread(() -> {
            while (true) {
                int random = (int) (Math.random() * 100) + 0;
                int random1 = (int) (Math.random() * 100) + 0;
                int random2 = (int) (Math.random() * 100) + 0;
                list[random].setBackground(generateRandomColor());
                list[random1].setBackground(generateRandomColor());
                list[random2].setBackground(generateRandomColor());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        thread.start();
    }

}
