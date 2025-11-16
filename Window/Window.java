package Window;

import javax.swing.*;
public class Window {
    private JFrame frame;

    public Window() {
        this.frame = new JFrame("Jaikin");

        this.frame.setSize(800, 600);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        // Crée un JPanel directement dans la fenêtre
        DrawingPanel canvas = new DrawingPanel();

        frame.addMouseListener(new HandleMouseEvent());

        this.frame.add(canvas);
        this.frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
