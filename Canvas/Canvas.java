package Canvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    private boolean isRunning = false;
    private final ArrayList<Point> points = new ArrayList<>();

    public Canvas() {
        this.setBackground(Color.BLACK);
        if (!isRunning) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
            });
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        for (Point p : points) {
            g.fillOval(p.x - 4, p.y - 4, 5, 5);
        }
    }

}