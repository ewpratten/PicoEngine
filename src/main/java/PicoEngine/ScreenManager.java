package PicoEngine;

import java.util.HashMap;
import PicoEngine.Screen;
import PicoEngine.Window;

public class ScreenManager {
    static ScreenManager instance = null;

    HashMap<String, Screen> screens = new HashMap<String, Screen>();
    String currentScreen;

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        
        return instance;
    }
    
    public void register(String name, Screen screen) {
        this.screens.put(name, screen);
    }

    public void setScreen(String name, Window win) {
        this.currentScreen = name;
        this.screens.get(currentScreen).setup(win);
    }

    public void feed(Window gc) {
        this.screens.get(currentScreen).feed(gc);
    }

    public void draw(Window gc) {
        this.screens.get(currentScreen).draw(gc);
    }

}