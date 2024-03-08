package com.github.nxkoo;

import com.github.nxkoo.gui.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Window::new);
    }
}
