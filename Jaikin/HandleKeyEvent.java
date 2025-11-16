package Jaikin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class HandleKeyEvent implements KeyListener {
    private JFrame frame;

    HandleKeyEvent(JFrame frame) {
        this.frame = frame;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Window.isStart = true;
            frame.repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
