package Objects;
import Msc.*;

import java.awt.image.BufferedImage;

public class Object {

    private Sprite sprite;
    private Vector2 position;
    private Vector2 scale;
    private Vector2[] spriteVector;
    private int spriteCounter;
    private int currentSprite;


    public Vector2[] getSpriteVector() {
        return spriteVector;
    }

    public void setSpriteVector(Vector2[] spriteVector) {
        this.spriteVector = spriteVector;
    }

    public Object(Vector2 position) {
        this.position = position;
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void Update()
    {

    }
    public BufferedImage getAnimation(float timer)
    {
        getSprite().setGrid(spriteVector[currentSprite]);
        getSprite().loadSprite();
        //Adds until timer then 0
        spriteCounter = (spriteCounter+1>=timer) ? 0 :spriteCounter+1;
        //Sets the current sprite index
        currentSprite = currentSprite+1>=spriteVector.length&&spriteCounter>=timer-1?0:spriteCounter>=timer-1?currentSprite+1:currentSprite;

        return getSprite().getSpriteImage();
    }

}
