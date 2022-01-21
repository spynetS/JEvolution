package Objects;

import Msc.Sprite;
import Msc.Vector2;

public class Lion extends Object{



    public Lion(Vector2 position) {
        super(position);
        setScale(new Vector2(20,20));
        Sprite s = new Sprite("/spritesheet.png");
        s.setGrid(new Vector2(0,0));
        setSprite(s);
        s.loadSprite();
        //getSprite().rotate(180);
        Vector2[] temp = new Vector2[]{new Vector2(0,0),new Vector2(0,1)};
        this.setSpriteVector(temp);
    }

    @Override
    public void Update() {
        super.Update();
    }
}
