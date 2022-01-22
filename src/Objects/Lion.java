package Objects;

import Msc.Sprite;
import Msc.Vector2;

public class Lion extends Object{



    public Lion(Vector2 position) {
        super(position);
        randomRot();
        setPosition(getPosition().add(getDirection().getNormelized().multiply(getCurrentSpeed())));

    }

    @Override
    public void Update() {
        super.Update();
    }
}
