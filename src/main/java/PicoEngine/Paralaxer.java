package PicoEngine;

import java.awt.image.BufferedImage;

public class Paralaxer {
    double speed;

    double fgx, mgx, bgx = 0;

    BufferedImage foreground;
    BufferedImage midground;
    BufferedImage background;

    public Paralaxer(double masterSpeed, String fgPath, String mgPath, String bgPath) {
        this.speed = masterSpeed;

        this.foreground = ImageUtils.getInstance().loadImageFromResources(fgPath);
        this.midground = ImageUtils.getInstance().loadImageFromResources(mgPath);
        this.background = ImageUtils.getInstance().loadImageFromResources(bgPath);

    }

    public void scroll() {
        this.fgx -= this.speed;
        this.mgx -= this.speed * 0.50;
        this.bgx -= this.speed * 0.25;
    }

    public void draw(Window win) {
        // Draw each layer
        bgx = drawImg(background, win, bgx);
        mgx = drawImg(midground, win, mgx);
        fgx = drawImg(foreground, win, fgx);
    }
    
    private double drawImg(BufferedImage img, Window win, double x){
        // This allows the images to "wrap" around the screen
        if (x <= win.getWidth() * -1) {
            x = 0;
        }

        win.drawImage(img, (int)x, 0);
        win.drawImage(img, (int)x + win.getWidth(), 0);

        return x;
    }
}