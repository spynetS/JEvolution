package Objects;

import Msc.Vector2;

import java.util.Random;

public class Giraffe extends Animal{


    public Giraffe(Vector2 position) {
        super(position);
        setScale(new Vector2(20,20));
        getSprite().loadSprites(new Vector2[]{new Vector2(1,0),new Vector2(1,1)});setTimer(50);
    }

    @Override
    public void Update() {
        super.Update();
        Vector2 toLookAt = new Vector2(400,300);
        System.out.println(getPosition().getDistance(toLookAt));

        float angle = (float) LookAt(toLookAt);
        setAngle(angle);
        setDirection(getDirection().getDirection((double)angle));

        if(getPosition().getDistance(toLookAt)<100)
        {
            setCurrentSpeed(0);
        }


    }
}
