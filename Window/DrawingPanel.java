package Window;

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
    }
}