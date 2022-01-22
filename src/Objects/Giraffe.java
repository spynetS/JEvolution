package Objects;

import Msc.Vector2;

import java.util.Random;

public class Giraffe extends Object{


    public Giraffe(Vector2 position) {
        super(position);
        setScale(new Vector2(20,20));
        getSprite().loadSprites(new Vector2[]{new Vector2(1,0),new Vector2(1,1)});setTimer(50);
    }




    @Override
    public void Update()
    {
        super.Update();
        randomRot();
        setPosition(getPosition().add(getDirection().getNormelized().multiply(getCurrentSpeed())));
        //setPosition(new Vector2(getPosition().getX()+1,getPosition().getY()));
    }


}
