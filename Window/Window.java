package Window;

import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame frame;

    public Window() {
        frame = new JFrame("Chaikin");

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Crée un JPanel directement dans la fenêtre
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.BLACK);  

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.PLAIN, 16));
                g.drawString("Click to add points  |  ENTER = start curve  |  C = clear  |  ESC = quit", 10, 20);

            }
        };

        frame.add(canvas);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
