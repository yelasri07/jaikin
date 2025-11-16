package Jaikin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class HandleKeyEvent implements KeyListener {

    private final JFrame frame;

    public HandleKeyEvent(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ENTER) {
            int n = Window.points.size();

            if (!Window.isStart) {
                if (n >= 3) {
                    Window.isStart = true;
                    Window.steps = 0;
                    Window.tmpPoints = copyPoints(Window.points);
                }
                frame.repaint();
            }
        }

        if (code == KeyEvent.VK_C) {
            Window.points.clear();
            Window.tmpPoints.clear();
            Window.steps = 0;
            Window.isStart = false;
            frame.repaint();
        }

        if (code == KeyEvent.VK_ESCAPE) {
            frame.dispose();
        }
    }

    private List<Point> copyPoints(List<Point> src) {
        List<Point> res = new ArrayList<>();
        for (Point p : src) {
            res.add(new Point(p.x, p.y));
        }
        return res;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
