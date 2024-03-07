package com.github.nykoox.gui.panels;

import com.github.nykoox.gui.components.ButtonComponent;
import com.github.nykoox.gui.layout.MainLayout;

import javax.swing.*;

public class MainPanel extends MainLayout {
    public MainPanel(JPanel screens, JFrame window) {
        super(screens, window);

        ButtonComponent signIn = new ButtonComponent("Clique-me");

        signIn.setBounds(116, 402, 449, 72);

        signIn.addActionListener(e -> {
            System.out.println("Cliquei...");
        });

        this.add(signIn);
    }
}
