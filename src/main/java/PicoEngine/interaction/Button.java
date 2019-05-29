package PicoEngine.interaction;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import PicoEngine.Window;
import PicoEngine.ImageUtils;

public class Button extends Rectangle {
    static final long serialVersionUID = 0;

    BufferedImage sprite;

    public Button(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public Button(int x, int y, int w, int h, String spritePath) {
        super(x, y, w, h);
        this.sprite = ImageUtils.getInstance().loadImageFromResources(spritePath);
    }

    public boolean isHovering(Point loc) {
        // Make sure program dosent crash on unfocus
        try {
            return this.contains(loc);
        } catch (Exception e) {
            return false;
        }
        
    }

    public boolean wasPressed(Point loc, int mouseInput) {
        if (mouseInput >= 1) {
            return this.contains(loc);
        } else {
            return false;
        }
    }

    /**
     * Draw buton for debug
     */
    public void debug(Window gc) {
        gc.setColor(Color.pink);
        gc.fillRect(x, y, width, height);
    }

    public void draw(Window win) {
        win.drawImage(sprite, x, y, width, height);
    }

}