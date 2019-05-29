package PicoEngine;

import PicoEngine.hsa2.GraphicsConsole;
import java.awt.Color;

import PicoEngine.GridSystem;

public class Window extends GraphicsConsole {
    static final long serialVersionUID = 1L;

    GridSystem gridsys;

    public Window(int width, int height, int gridW, int gridH, String name) {
        super(width, height, name);
        gridsys = new GridSystem(height, width, gridH, gridW);
    }

    public int getWidth() {
        return this.getDrawWidth();
    }

    public int getHeight() {
        return this.getDrawHeight();
    }

    public void centre() {
        this.setLocationRelativeTo(null);
    }

    public void autoConfig(Color bg) {
        this.setAntiAlias(true);
        this.enableMouse();
        centre();
        this.setBackgroundColor(bg);
        this.clear();
    }

    public GridSystem getGrid() {
        return gridsys;
    }
    
    public void line(int x1, int y1, int x2, int y2) {
        this.drawLine(x1, y1, x2, y2);
    }

    public void rect(int x, int y, int w, int h, boolean fill) {
        if (fill) {
            this.fillRect(x, y, w, h);
        } else {
            this.drawRect(x, y, w, h);
        }
    }
}
