package Objects;

import Msc.Vector2;

import java.util.Random;

public class Giraffe extends Animal{


    public Giraffe(Vector2 position) {
        super(position);
        setScale(new Vector2(20,20));
        getSprite().loadSprites(new Vector2[]{new Vector2(1,0),new Vector2(1,1)});setTimer(50);
        setHunger(50);
        setTag("Giraffe");
    }

    @Override
    public void onCollision(Object collision) {
        super.onCollision(collision);
        if(collision.getTag().equals("Tree"))
        {
            Vector2 toLookAt = collision.getPosition();
            if(getHunger()<60) {
                float angle = (float) LookAt(toLookAt);
                setAngle(angle);
                setDirection(getDirection().getDirection((double) angle));
            }
            if(getPosition().getDistance(toLookAt)<100&&getHunger()<60)
            {
                setCurrentSpeed(0);
                setHunger(getHunger()+1);
            }
        }

    }

    @Override
    public void Update() {
        super.Update();
        if(getState()==AnimalStates.NORMAL)
        {
            setCurrentSpeed(getCruisingSpeed());
        }
        setHunger(getHunger()-0.01f);



    }
}
