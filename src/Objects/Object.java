package Objects;
import Dsiaplay.ObjectInfoPanel;
import Msc.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Object {

    private Sprite sprite;
    private Vector2 position;
    private Vector2 scale;
    private Vector2 direction = new Vector2(1,0);

    private float angle=180;

    private int spriteCounter;
    private int currentSprite;

    private float topSpeed = 2;
    private float cruisingSpeed=0.5f;
    private float currentSpeed=0.5f;

    private float health=100; //full health
    private float hunger=100; // no hunger
    private float thirst=100; // no thirst
    private float stamina=100; // full stamina

    private int ranTimer = 0;

    Random ran = new Random();


    private ObjectInfoPanel infoPanel = new ObjectInfoPanel();

    private float timer = 30;

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public Object(Vector2 position) {
        this.position = position;
        sprite = new Sprite();
        sprite.setPath("/spritesheet.png");
        sprite.loadSprites(new Vector2[]{new Vector2(0,0),new Vector2(0,1)});

    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
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
        float x = (getPosition().getX()-((sprite.getTILE_SIZE()/2)));
        float y = (getPosition().getY()-((sprite.getTILE_SIZE()/2)));

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

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(float cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(float currentSpeed) {
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

    public void randomRot()
    {
        if(ranTimer>200)
        {
            int angle = ran.nextInt(360);
            System.out.println(angle);
            setAngle(angle);
            setDirection(getDirection().getDirection((double)angle));

            ranTimer = 0;

        }
        ranTimer+=1;
    }

    public void Update()
    {
       // getInfoPanel().setLocation(new Point((int) (getPosition().getX()-100), (int) (getPosition().getY()-80)));
        //infoPanel.setData(this);
         //this.setHunger((this.getHunger()-0.01f));

    }

    public void Die()
    {

    }

    public BufferedImage getAnimation()
    {

        int spritesLen = getSprite().getSprites().length;
        //System.out.println(spritesLen);
        //Adds until timer then 0
        spriteCounter = (spriteCounter+1>=timer) ? 0 :spriteCounter+1;
        //Sets the current sprite index
        currentSprite = (currentSprite+1>=spritesLen&&spriteCounter>=timer-1) ?0:(spriteCounter>=timer-1)? (currentSprite+1): currentSprite;
        //Sprite.resize(getSprite().getSpriteImage(),new Vector2(100,100));
        getSprite().setSpriteImage(getSprite().getSprites()[currentSprite]);

        return (getSprite().rotate(angle));
    }

}

