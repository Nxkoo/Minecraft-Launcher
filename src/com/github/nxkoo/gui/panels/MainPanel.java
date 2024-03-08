package com.github.nxkoo.gui.panels;

import com.github.nxkoo.gui.Window;
import com.github.nxkoo.gui.components.ButtonComponent;
import com.github.nxkoo.gui.components.ImageComponent;
import com.github.nxkoo.gui.components.InputComponent;
import com.github.nxkoo.gui.layout.MainLayout;
import com.github.nxkoo.launcher.thread.LaunchThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MainPanel extends MainLayout {
    private final JFrame window;
    public MainPanel(JPanel screens, JFrame window) {
        super(screens, window);
        this.window = window;

        JLabel title = new JLabel("My Launcher".toUpperCase());

        title.setFont(new Font("Inter", Font.BOLD, 48));
        title.setForeground(Color.white);

        InputComponent nickname = new InputComponent("Digite seu nickname");
        ButtonComponent login = new ButtonComponent("Entrar".toUpperCase());
        ImageComponent skin = new ImageComponent("skin.png");

        skin.setBounds((Window.WIDTH / 2) + 200, 200, 187, 400);
        title.setBounds(137, 150, 408, 58);
        login.setBounds(116, 402, 449, 72);
        nickname.setBounds(116, 402 - 103, 449, 72);

        nickname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    startMine(nickname.getText());
                }
            }
        });

        login.addActionListener(e -> {
            startMine(nickname.getText());
        });

        this.add(skin);
        this.add(title);
        this.add(nickname);
        this.add(login);
    }

    private void startMine(String nick) {

        if (nick.isEmpty() || nick.equalsIgnoreCase("Digite seu nickname")) {
            JOptionPane.showMessageDialog(null, "Digite um nickname para iniciar", "Atenção...", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LaunchThread launch = new LaunchThread(nick);
        launch.setName("MyLauncher-Thread");
        launch.start();
        window.dispose();
    }
}
