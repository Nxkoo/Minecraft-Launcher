package com.github.nxkoo.gui.components.handlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HandlerAction {
    private IHoverHandler hoverHandler;
    private IClickHandler clickHandler;
    private final JComponent component;

    public HandlerAction(JComponent c) {
        this.component = c;
    }

    public void addClickListener(IClickHandler clickHandler) {
        this.clickHandler = clickHandler;
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick();
            }
        });
    }

    public void addHoverListener(IHoverHandler hoverHandler) {
        this.hoverHandler = hoverHandler;
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                handleHover(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                handleHover(false);
            }
        });
    }

    private void handleHover(boolean isHovering) {
        if (isHovering) {
            hoverHandler.onHover();
            component.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }else {
            hoverHandler.onExitHover();
            component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void handleClick() {
        if (clickHandler != null) {
            clickHandler.onClick(component);
        }
    }
}
