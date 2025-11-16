package Jaikin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HandleKeyEvent implements KeyListener {
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !Window.isStart && Window.points.size() > 1) {
            Window.isStart = true;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
