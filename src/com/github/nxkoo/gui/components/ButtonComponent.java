package com.github.nxkoo.gui.components;

import com.github.nxkoo.gui.components.handlers.HandlerAction;
import com.github.nxkoo.gui.components.handlers.IHoverHandler;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.github.nxkoo.gui.consts.*;

public class ButtonComponent extends JButton {
    private Graphics2D g2d;
    public ButtonComponent(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(FOREGROUND);

        this.setFont(new Font("Inter", Font.BOLD, 24));

        HandlerAction action = new HandlerAction(this);
        action.addHoverListener(new IHoverHandler() {
            @Override
            public void onHover() {
                setBackground(PRIMARY_HOVER);
                setForeground(Color.decode("#4d7c0f"));
            }

            @Override
            public void onExitHover() {
                setBackground(PRIMARY);
                setForeground(FOREGROUND);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g2d.setColor(PRIMARY);
        g2d.fillRoundRect(0, 0, width, height, 5, 5);

        super.paintComponent(g);
        g2d.dispose();
    }
}
