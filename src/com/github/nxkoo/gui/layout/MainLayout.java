package com.github.nxkoo.gui.layout;

import com.github.nxkoo.gui.components.ImageComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainLayout extends JPanel {
    private final JPanel screens;
    private final JFrame window;
    private final CardLayout controllerScreen;
    public MainLayout(JPanel screens, JFrame window) {
        this.screens = screens;
        this.window = window;
        this.controllerScreen = (CardLayout) screens.getLayout();

        this.setBackground(Color.decode("#15151E"));
        this.setLayout(null);

        ImageComponent closeButton = new ImageComponent("x.png");
        ImageComponent minimizeButton = new ImageComponent("minus.png");

        registerEvents(closeButton, minimizeButton);

        this.add(closeButton);
        this.add(minimizeButton);
    }

    private void registerEvents(ImageComponent cl, ImageComponent min) {

        window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateButtonPositions();
            }
        });

        window.addWindowStateListener(e -> {
            updateButtonPositions();
        });

        cl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.dispose();
            }
        });

        min.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.setState(JFrame.ICONIFIED);
            }
        });
    }

    private void updateButtonPositions() {
        int buttonSize = 16; // Tamanho do botão 16 px
        int margin = 15; // Espaçamento entre um e outro

        ImageComponent closeButton = (ImageComponent) this.getComponent(0);
        ImageComponent minimizeButton = (ImageComponent) this.getComponent(1);

        int width = window.getWidth();

        closeButton.setBounds(width - buttonSize - margin, margin, buttonSize, buttonSize);
        minimizeButton.setBounds(width - 2 * (buttonSize + margin), margin, buttonSize, buttonSize);
    }

}
