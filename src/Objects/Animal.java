package Objects;

import Msc.Vector2;

import java.util.Random;

public class Animal extends Object{

    private float topSpeed = 2;
    private float cruisingSpeed=0.5f;
    private float currentSpeed=0.5f;

    private float health=100; //full health
    private float hunger=100; // no hunger
    private float thirst=100; // no thirst
    private float stamina=100; // full stamina


    
    private int ranTimer = 0;
    Random ran = new Random();

    public Animal(Vector2 position) {
        super(position);
    }

    @Override
    public void Update() {
        super.Update();
        randomRot();
        setPosition(getPosition().add(getDirection().getNormelized().multiply(getCurrentSpeed())));

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
}
