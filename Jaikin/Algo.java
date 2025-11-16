package Jaikin;

import java.awt.Point;
import java.util.ArrayList;

public class Algo {

    public static class PointF {
        public double x, y;

        public PointF(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static ArrayList<Point> chaikinAlgorithm(ArrayList<Point> points) {
        ArrayList<PointF> newPoints = new ArrayList<>();

        if (points.size() < 2) {
            return new ArrayList<>(points); 
        }

        newPoints.add(new PointF(points.get(0).x, points.get(0).y));

        for (int i = 0; i < points.size() - 1; i++) {
            Point a =  points.get(i);
            Point b = points.get(i + 1);

            PointF p0 = new PointF(a.getX(), a.getY());
            PointF p1 = new PointF(b.getX(), b.getY());

            // Q point (75% p0, 25% p1)
            newPoints.add(new PointF(
                0.75 * p0.x + 0.25 * p1.x,
                0.75 * p0.y + 0.25 * p1.y
            ));

            // R point (25% p0, 75% p1)
            newPoints.add(new PointF(
                0.25 * p0.x + 0.75 * p1.x,
                0.25 * p0.y + 0.75 * p1.y
            ));
        }

        // Add last point
        Point l = points.get(points.size() - 1);
        PointF last = new PointF(l.getX(), l.getY());

        newPoints.add(new PointF(last.x, last.y));

        ArrayList<Point> linePoints = new ArrayList<>();
        for (PointF pf : newPoints) {
            int x = (int) Math.round(pf.x);
            int y = (int) Math.round(pf.y);
            linePoints.add(new Point(x, y));
        }

        return linePoints;
    }
}