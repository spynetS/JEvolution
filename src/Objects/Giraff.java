package Objects;

import Msc.Sprite;
import Msc.Vector2;

import java.util.Random;

public class Giraff extends Object{

    private Vector2 direction = new Vector2(1,0);

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
        if(ranTimer>100)
        {
            Random ran = new Random();
            int angle = ran.nextInt(360);
            direction = direction.getDirection((double)angle);
            System.out.println(direction.toString());
            System.out.println(angle);
            getSprite().rotate(angle);
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
        setPosition(getPosition().add(direction.multiply(direction.getNegative())));
    }


}
