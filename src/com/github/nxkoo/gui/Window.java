package com.github.nxkoo.gui;

import com.github.nxkoo.gui.panels.MainPanel;
import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Window extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    private int mouseX, mouseY;
    public Window() {
        CardLayout controllerScreen = new CardLayout();
        JPanel screens = new JPanel(controllerScreen);
        MainPanel mainPanel = new MainPanel(screens, this);

        this.setTitle("Launcher | Version 1");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setUndecorated(true);

        // Deixando a janela com borda redonda
        AWTUtilities.setWindowShape(this, new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        screens.add(mainPanel);
        setDraggable();

        this.add(screens);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void setDraggable() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                setLocation(x, y);
            }
        });
    }
}
