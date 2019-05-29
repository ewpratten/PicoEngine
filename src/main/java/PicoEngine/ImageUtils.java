package PicoEngine;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageUtils {
    static ImageUtils instance = null;

    public static ImageUtils getInstance() {
        if (instance == null) {
            instance = new ImageUtils();
        }

        return instance;
    }

    public BufferedImage loadImageFromResources(String file) {
        try {
            return ImageIO.read(new File(getClass().getClassLoader().getResource(file).getFile()));
        } catch (Exception e) {
            System.out.println("loadImageFromResources encountered an error: " + e);
            return new BufferedImage(0, 0, 0);
        }
        
    }
}