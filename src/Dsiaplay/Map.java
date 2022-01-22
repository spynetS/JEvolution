package Dsiaplay;

import Msc.AnimalHandler;
import Msc.Vector2;
import Objects.*;
import Objects.Object;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map extends JPanel {

    public Map() {
        AnimalHandler.AddAnimal(new Tree(new Vector2(400,300)));
        AnimalHandler.AddAnimal(new Giraffe(new Vector2(600,500)));
        AnimalHandler.AddAnimal(new Giraffe(new Vector2(600,500)));
        AnimalHandler.AddAnimal(new Giraffe(new Vector2(600,500)));
        AnimalHandler.AddAnimal(new Giraffe(new Vector2(600,500)));
        AnimalHandler.AddAnimal(new Lion(new Vector2(600,700)));


        setBackground(new Color(205, 171, 126));
    }
    int x = 0;
    public void CollisionHandler()
    {
        for(Object obj : AnimalHandler.getObjects()) {
            for(Object obj2 : AnimalHandler.getObjects()) {
                if(obj.getPosition().getDistance(obj2.getPosition())<=obj.getRadius()&&!obj.equals(obj2))
                {
                    obj.onCollision(obj2);
                }
            }
        }
    }
    private void UpdateObjects()
    {
        for(Object obj:AnimalHandler.getObjects())
        {
            obj.Update();
        }
    }

    public void Update()
    {
        UpdateObjects();
        CollisionHandler();
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }
    @Override
    protected void paintComponent(Graphics g) {
        long start = System.nanoTime();
        super.paintComponent(g);

        for(Object animal : AnimalHandler.getObjects())
        {
            g.drawImage((Image) animal.getAnimation(), (int) animal.getSpritePosition().getX(), (int) animal.getSpritePosition().getY(),null);
            g.drawOval((int) ((int) animal.getPosition().getX()-animal.getRadius()/2), (int) ((int) animal.getPosition().getY()-animal.getRadius()/2), (int) animal.getRadius(), (int) animal.getRadius());

        }

        long end = System.nanoTime();
        //System.out.println((start-end)/1000000);

    }
}
