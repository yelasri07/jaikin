package Jaikin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    private boolean isRunning = false;
    private int step = 0;
    private final int maxSteps = 7;
    private final int delayMs = 500;
    private Timer timer;
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Point> linePoints = new ArrayList<>();

    public Panel() {
        this.setBackground(Color.BLACK);
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isRunning) {
                    points.add(e.getPoint());
                    repaint();
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER && !isRunning) {
                    startAnimation();
                }

                if (e.getKeyCode() == KeyEvent.VK_R) {
                    resetAll();
                }
            }
        });

        timer = new Timer(delayMs, e -> {
            if (step < maxSteps && points.size() > 2) {
                linePoints = Algo.chaikinAlgorithm(linePoints);
                step++;
                repaint();
            } else {
                startAnimation();
            }
        });
    }

    public void startAnimation() {
        if (points.size() < 2) {
            return;
        }

        linePoints = new ArrayList<>(points);
        repaint();
        
        step = 0;
        isRunning = true;
        timer.start();
    }

    private void resetAll() {
        timer.stop();
        isRunning = false;
        points.clear();
        linePoints.clear();
        step = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        for (Point p : points) {
            g.fillOval(p.x - 4, p.y - 4, 5, 5);
        }

        if (linePoints.size() >= 2) {
            g.setColor(Color.BLUE);
            for (int i = 0; i < linePoints.size() - 1; i++) {
                Point a = linePoints.get(i);
                Point b = linePoints.get(i + 1);
                g.drawLine(a.x, a.y, b.x, b.y);
            }
        }
    }

}