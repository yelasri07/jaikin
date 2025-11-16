package Jaikin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Window {
    private JFrame frame;
    public static List<Point> points = new ArrayList<>(); 

    public Window() {
        this.frame = new JFrame("Jaikin");

        this.frame.setSize(800, 600);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        // Crée un JPanel directement dans la fenêtre
        JPanel canvas = new JPanel() {
            
        };

        canvas.addMouseListener(new HandleMouseEvent(frame));

        this.frame.add(canvas);
        this.frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}