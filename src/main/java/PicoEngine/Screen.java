package PicoEngine;

/**
 * Just a template for a screen
 */
public interface Screen {

    public void draw(Window win);

    public void feed(Window win);

    public void setup(Window win);
}