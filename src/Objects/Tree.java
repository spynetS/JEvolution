package Objects;

import Msc.Vector2;

public class Tree extends Object{

    public Tree(Vector2 position) {
        super(position);
        setScale(new Vector2(20,20));
        getSprite().loadSprites(new Vector2[]{new Vector2(2,0),new Vector2(2,1)});
        setTag("Tree");
    }
}
