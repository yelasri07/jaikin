package Jaikin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

class DrawingPanel extends JPanel {

    private static final int MAX_STEPS = 6;
    public static Timer timer;

    DrawingPanel() {
        setBackground(Color.BLACK);

        timer = new Timer(1000, e -> {
            this.repaint();
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("steps " + Window.steps, 10, 40);
        g.drawString("Click to add points  |  ENTER = start curve  |  C = clear  |  ESC = quit", 10, 20);

        List<Point> points = Window.points;
        List<Point> tmpPoints = Window.tmpPoints;

        for (Point point : points) {
            g.setColor(Color.YELLOW);
            g.drawOval(point.x - 3, point.y - 3, 6, 6);
        }

        int n = points.size();

        if (n < 2) {
            return;
        }

        if (!Window.isStart)
            return;

        if (n == 2) {
            g.setColor(Color.WHITE);
            Point p0 = points.get(0);
            Point p1 = points.get(1);
            g.drawLine(p0.x, p0.y, p1.x, p1.y);
            DrawingPanel.timer.stop();
            return;
        }

        g.setColor(Color.WHITE);
        for (int i = 0; i < tmpPoints.size() - 1; i++) {
            Point a = tmpPoints.get(i);
            Point b = tmpPoints.get(i + 1);
            g.drawLine(a.x, a.y, b.x, b.y);
        }

        if (Window.steps >= MAX_STEPS) {
            Window.steps = 0;
            Window.tmpPoints = points;
        } else {
            Window.tmpPoints = chaikin(tmpPoints);
            Window.steps++;
        }
    }

    private List<Point> chaikin(List<Point> points) {
        List<Point> tmp = new ArrayList<>();

        tmp.add(new Point(points.get(0).x, points.get(0).y));

        for (int i = 0; i < points.size() - 1; i++) {
            Point p0 = points.get(i);
            Point p1 = points.get(i + 1);

            Point q = new Point(
                    (int) Math.round(0.75 * p0.x + 0.25 * p1.x),
                    (int) Math.round(0.75 * p0.y + 0.25 * p1.y));

            Point r = new Point(
                    (int) Math.round(0.25 * p0.x + 0.75 * p1.x),
                    (int) Math.round(0.25 * p0.y + 0.75 * p1.y));

            tmp.add(q);
            tmp.add(r);
        }

        tmp.add(points.get(points.size() - 1));

        return tmp;
    }
}
