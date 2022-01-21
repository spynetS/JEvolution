package Objects;
import Dsiaplay.ObjectInfoPanel;
import Msc.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Object {

    private Sprite sprite;
    private Vector2 position;
    private Vector2 scale;
    private Vector2[] spriteVector;
    private int spriteCounter;
    private int currentSprite;
    
    private int topSpeed = 10;
    private int cruisingSpeed=5;
    private int currentSpeed=5;

    private float health=100; //full health
    private float hunger=100; // no hunger
    private float thirst=100; // no thirst
    private float stamina=100; // full stamina

    private ObjectInfoPanel infoPanel = new ObjectInfoPanel();

    private float timer = 10;

    public Object(Vector2 position) {
        this.position = position;
    }



    public ObjectInfoPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(ObjectInfoPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

    public Vector2 getSpritePosition(){
        int x = (getPosition().getX()-((getAnimation().getWidth()/2)));
        int y = (getPosition().getY()-((getAnimation().getHeight()/2)));

         return new Vector2(x,y);
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getCurrentSprite() {
        return currentSprite;
    }

    public void setCurrentSprite(int currentSprite) {
        this.currentSprite = currentSprite;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(int cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getHunger() {
        return hunger;
    }

    public void setHunger(float hunger) {
        this.hunger = hunger;
    }

    public float getThirst() {
        return thirst;
    }

    public void setThirst(float thirst) {
        this.thirst = thirst;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public AnimalStates getState() {
        return state;
    }

    public void setState(AnimalStates state) {
        this.state = state;
    }

    private AnimalStates state;

    public Vector2[] getSpriteVector() {
        return spriteVector;
    }

    public void setSpriteVector(Vector2[] spriteVector) {
        this.spriteVector = spriteVector;
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
        getInfoPanel().setLocation(new Point(getPosition().getX()-100,getPosition().getY()-80));
        infoPanel.setData(this);
    }

    public void Die()
    {

    }

    public BufferedImage getAnimation()
    {
        getSprite().setGrid(spriteVector[currentSprite]);
        getSprite().loadSprite();
        //Adds until timer then 0
        spriteCounter = (spriteCounter+1>=timer) ? 0 :spriteCounter+1;
        //Sets the current sprite index
        currentSprite = currentSprite+1>=spriteVector.length&&spriteCounter>=timer-1?0:spriteCounter>=timer-1?currentSprite+1:currentSprite;
        Sprite.resize(getSprite().getSpriteImage(),new Vector2(100,100));

        return Sprite.resize(getSprite().getSpriteImage(),new Vector2(100,100));
    }

}
