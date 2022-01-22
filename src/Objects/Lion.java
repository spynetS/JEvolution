package Objects;

import Msc.Sprite;
import Msc.Vector2;

public class Lion extends Animal{



    public Lion(Vector2 position) {
        super(position);
        randomRot();
        setPosition(getPosition().add(getDirection().getNormelized().multiply(getCurrentSpeed())));
        setCurrentSpeed(1);
    }

}
