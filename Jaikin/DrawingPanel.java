package Jaikin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Click to add points  |  ENTER = start curve  |  C = clear  |  ESC = quit", 10, 20);

        List<Point> points = Window.points;
        List<Point> tmpPoints = Window.tmpPoints;

        for (Point point : points) {
            g.setColor(Color.YELLOW);
            g.drawOval(point.x, point.y, 5, 5);
        }

        if (!Window.isStart)
            return;

        for (int i = 0; i < tmpPoints.size() - 1; i++) {
            g.drawLine(tmpPoints.get(i).x, tmpPoints.get(i).y, tmpPoints.get(i + 1).x, tmpPoints.get(i + 1).y);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }

        if (Window.steps > 7) {
            Window.steps = 0;
            Window.tmpPoints = points;
        }

        this.Chaikin(tmpPoints);
    }

    void Chaikin(List<Point> points) {
        List<Point> tmp = new ArrayList<>();
        tmp.add(points.get(0));

        for (int i = 0; i < points.size() - 1; i++) {
            Point p0 = points.get(i);
            Point p1 = points.get(i + 1);

            Point q = new Point((int) Math.round(0.75 * p0.x + 0.25 * p1.x),
                    (int) Math.round(0.75 * p0.y + 0.25 * p1.y));
            Point r = new Point((int) Math.round(0.25 * p0.x + 0.75 * p1.x),
                    (int) Math.round(0.25 * p0.y + 0.75 * p1.y));

            tmp.add(q);
            tmp.add(r);
        }

        tmp.add(points.get(points.size() - 1));


        Window.tmpPoints = tmp;
        Window.steps++;

        this.repaint();
    }
}