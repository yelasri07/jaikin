package Window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HandleMouseEvent implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
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
