package Objects;

import Msc.Sprite;
import Msc.Vector2;

public class Lion extends Animal{



    public Lion(Vector2 position) {
        super(position);
        randomRot();
        setScale(new Vector2(20,20));
        setHunger(50);
        setPosition(getPosition().add(getDirection().getNormelized().multiply(getCurrentSpeed())));
        setCurrentSpeed(1);
    }

    @Override
    public void Update() {
        super.Update();
        setHunger(getHunger()-0.01f);
    }

    @Override
    public void onCollision(Object collision) {
        super.onCollision(collision);
        if(collision.getTag().equals("Giraffe"))
        {
            Vector2 toLookAt = collision.getPosition();
            if(getHunger()<60) {
                float angle = (float) LookAt(toLookAt);
                setAngle(angle);
                setDirection(getDirection().getDirection((double) angle));
            }
            if(getPosition().getDistance(toLookAt)<100&&getHunger()<60)
            {
                //(Animal) collision.setCurrentSpeed();
            }
        }
    }
}
