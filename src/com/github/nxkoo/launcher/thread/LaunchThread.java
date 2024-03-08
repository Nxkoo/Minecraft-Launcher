package com.github.nxkoo.launcher.thread;

import com.github.nxkoo.launcher.Launcher;

public class LaunchThread extends Thread {

    public LaunchThread(String username) {
        this.username = username;
    }

    private String username;
    @Override
    public void run() {
        try {
//            Launcher.update();
            System.out.println("Launcher atualizado com sucesso!");

            Launcher.launch(username);
            System.out.println("Launcher carregado com sucesso!");
        } catch (Exception e) {
            Launcher.logger.printStackTrace(e);
        }
    }
}
