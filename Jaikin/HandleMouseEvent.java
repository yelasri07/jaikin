package Jaikin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class HandleMouseEvent implements MouseListener {
    private JFrame frame;

    HandleMouseEvent(JFrame frame) {
        this.frame = frame;
    }

    public void mouseClicked(MouseEvent e) {
        Window.points.add(new Point(e.getX(), e.getY()));
        frame.repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
