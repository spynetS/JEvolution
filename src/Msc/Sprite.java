package Msc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Sprite {

    private BufferedImage spriteImage;
    private BufferedImage spriteSheet;

    private String path;
    private Vector2 grid;
    private static int TILE_SIZE = 255;

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Vector2 getGrid() {
        return grid;
    }

    public void setGrid(Vector2 grid) {
        this.grid = grid;
    }

    public static int getTileSize() {
        return TILE_SIZE;
    }

    public static void setTileSize(int tileSize) {
        TILE_SIZE = tileSize;
    }

    public Sprite(String path) {
        this.path = path;
    }

    public void loadSprite() {

        BufferedImage sprite = null;

        try {
            InputStream in = this.getClass().getResourceAsStream(path);
            sprite = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (spriteSheet == null) {
            spriteSheet = sprite;
        }

        spriteImage = spriteSheet.getSubimage(grid.getX() * TILE_SIZE, grid.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public BufferedImage getSpriteImage() {
        return spriteImage;
    }

    public void setSpriteImage(BufferedImage spriteImage) {
        this.spriteImage = spriteImage;
    }

    public Sprite() {
    }
    public void rotate(double angle)
    {

        // Getting Dimensions of image
        int width = getSpriteImage().getWidth();
        int height = getSpriteImage().getHeight();

        // Creating a new buffered image
        BufferedImage newImage = new BufferedImage(
                getSpriteImage().getWidth(), getSpriteImage().getHeight(), getSpriteImage().getType());

        // creating Graphics in buffered image
        Graphics2D g2 = newImage.createGraphics();

        // Rotating image by degrees using toradians()
        // method
        // and setting new dimension t it
        g2.rotate(Math.toRadians(angle), width / 2,
                height / 2);
        g2.drawImage(getSpriteImage(), null, 0, 0);

        // Return rotated buffer image
        setSpriteImage((newImage));
    }
    public static BufferedImage resize(BufferedImage img,Vector2 scale) {
        Image tmp = img.getScaledInstance(scale.getX(), scale.getY(), Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(scale.getX(), scale.getY(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
