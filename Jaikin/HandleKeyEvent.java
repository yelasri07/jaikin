package Jaikin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

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
                if (n >= 2) {
                    Window.isStart = true;
                    Window.steps = 0;
                    Window.tmpPoints = copyPoints(Window.points);

                }
                frame.repaint();
                DrawingPanel.timer.start();
            }
        }

        if (code == KeyEvent.VK_C) {
            Window.points.clear();
            Window.tmpPoints.clear();
            Window.steps = 0;
            Window.isStart = false;
            frame.repaint();
            DrawingPanel.timer.stop();
        }

        if (code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    private List<Point> copyPoints(List<Point> src) {
        return new ArrayList<>(src);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
