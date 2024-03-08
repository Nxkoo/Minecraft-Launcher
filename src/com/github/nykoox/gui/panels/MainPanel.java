package com.github.nykoox.gui.panels;

import com.github.nykoox.gui.Window;
import com.github.nykoox.gui.components.ButtonComponent;
import com.github.nykoox.gui.components.ImageComponent;
import com.github.nykoox.gui.components.InputComponent;
import com.github.nykoox.gui.layout.MainLayout;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends MainLayout {
    public MainPanel(JPanel screens, JFrame window) {
        super(screens, window);

        JLabel title = new JLabel("My Launcher".toUpperCase());

        title.setFont(new Font("Inter", Font.BOLD, 48));
        title.setForeground(Color.white);

        InputComponent nickname = new InputComponent("Digite seu nickname");
        ButtonComponent signIn = new ButtonComponent("Entrar".toUpperCase());
        ImageComponent skin = new ImageComponent("skin.png");

        skin.setBounds((Window.WIDTH / 2) + 200, 200, 187, 400);
        title.setBounds(137, 150, 408, 58);
        signIn.setBounds(116, 402, 449, 72);
        nickname.setBounds(116, 402 - 103, 449, 72);

        signIn.addActionListener(e -> {
            System.out.println("Clicou em entrar");
        });

        this.add(skin);
        this.add(title);
        this.add(nickname);
        this.add(signIn);
    }
}
