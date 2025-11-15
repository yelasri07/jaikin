

import javax.swing.JFrame;

import Canvas.Canvas;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jaikin Animation");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Canvas canvas = new Canvas();
        frame.add(canvas);

        frame.setVisible(true);
    }
}