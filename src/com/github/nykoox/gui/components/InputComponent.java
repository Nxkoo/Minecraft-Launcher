package com.github.nykoox.gui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import static com.github.nykoox.gui.consts.*;

public class InputComponent extends JTextField {
    private final String placeholder;
    public InputComponent(String placeholder) {
        super(placeholder);

        this.placeholder = placeholder;

        this.setOpaque(false);
        this.setBorder(new EmptyBorder(10, 20, 10, 10));
        this.setFont(new Font("Inter", Font.PLAIN, 24));
        this.setForeground(FOREGROUND);

        addPlaceholderBehavior();
    }

    private void addPlaceholderBehavior() {
        this.setText(placeholder);
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equalsIgnoreCase(placeholder)) {
                    setForeground(FOREGROUND_HOVER);
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                setForeground(FOREGROUND);
                setText(placeholder);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g2d.setColor(new Color(255, 255, 255, 20));
        g2d.fillRoundRect(0, 0, width, height, 5, 5);

        super.paintComponent(g);
    }
}
