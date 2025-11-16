

import javax.swing.JFrame;

import Jaikin.Panel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jaikin Animation");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Panel canvas = new Panel();
        frame.add(canvas);

        frame.setVisible(true);
    }
}