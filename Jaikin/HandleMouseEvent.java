package Jaikin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class HandleMouseEvent implements MouseListener {
    private JFrame frame;

    HandleMouseEvent(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (!Window.isStart) {
            int x = e.getX();
            int y = e.getY();

            Window.points.add(new Point(x, y));
            Window.tmpPoints.add(new Point(x, y));

            frame.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
