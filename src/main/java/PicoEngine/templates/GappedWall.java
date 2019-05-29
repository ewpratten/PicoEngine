package PicoEngine.templates;

import java.awt.Point;

import PicoEngine.Window;

/**
 * A collidable wall with a gap in it
 */
public interface GappedWall {
    void setGap(int min, int max);

    boolean isColliding(Point loc, int colliderWidth);

    void draw(Window win);
}