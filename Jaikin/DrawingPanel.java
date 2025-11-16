package Jaikin;

import java.awt.*;
import javax.swing.*;

class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Click to add points  |  ENTER = start curve  |  C = clear  |  ESC = quit", 10, 20);

        for (Point point : Window.points) {
            g.setColor(Color.YELLOW);
            g.drawOval(point.x, point.y, 5, 5);
        }
    }
}