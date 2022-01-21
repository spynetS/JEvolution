package Objects;

import Msc.Sprite;
import Msc.Vector2;

import java.util.Random;

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
        setTimer(20);
    }

    private int ranTimer = 0;
    //Implemt forward
    private void randomRot()
    {
        if(ranTimer>200)
        {
            Random ran = new Random();
            int test = ran.nextInt(360);
            System.out.println(test);
            getSprite().rotate(test);
            ranTimer = 0;
        }
        ranTimer+=1;
    }

    @Override
    public void Update()
    {
        super.Update();
        int test = (int) (this.getHunger()-0.01f);
        this.setHunger(test);
        randomRot();
        //setPosition(new Vector2(getPosition().getX()+1,getPosition().getY()));
    }


}
