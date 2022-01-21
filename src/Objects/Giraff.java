package Objects;

import Msc.Sprite;
import Msc.Vector2;

public class Giraff extends Object{


    public Giraff(Vector2 position) {
        super(position);
        setScale(new Vector2(20,20));
        Sprite s = new Sprite("/spritesheet.png");
        s.setGrid(new Vector2(1,0));
        setSprite(s);
        s.loadSprite();
        //getSprite().rotate(180);
        Vector2[] temp = new Vector2[]{new Vector2(1,0),new Vector2(1,1)};
        this.setSpriteVector(temp);
    }

    @Override
    public void Update()
    {
        //Vector2 pos = new Vector2(getPosition().getX()+1,getPosition().getY());
        //this.setPosition(pos);
        //System.out.println(pos.toString());
    }


}
