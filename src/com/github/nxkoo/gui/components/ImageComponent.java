package com.github.nxkoo.gui.components;

import javax.swing.*;
import java.net.URL;

public class ImageComponent extends JLabel {
    public ImageComponent(String name) {
        try {
            URL imgUrl = this.getClass().getResource("/assets/"+name);
            if (imgUrl != null) {
                ImageIcon icon = new ImageIcon(imgUrl);
                setIcon(icon);
                repaint();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
