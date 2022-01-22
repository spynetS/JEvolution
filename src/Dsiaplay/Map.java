package Dsiaplay;

import Msc.Vector2;
import Objects.Giraffe;
import Objects.Lion;
import Objects.Tree;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    Giraffe giraff;
    Lion lion;
    Tree tree = new Tree(new Vector2(400,300));

    public Map() {
        giraff = new Giraffe(new Vector2(600,500));
        lion = new Lion(new Vector2(600,500));
        setBackground(new Color(205, 171, 126));
        add(giraff.getInfoPanel());
        add(lion.getInfoPanel());
    }
    int x = 0;
    public void Update()
    {
        giraff.Update();
        repaint();
        Toolkit.getDefaultToolkit().sync();
        x+=1;
        lion.Update();
    }
    @Override
    protected void paintComponent(Graphics g) {
        long start = System.nanoTime();
        super.paintComponent(g);

        g.drawImage((Image) this.giraff.getAnimation(), (int) giraff.getSpritePosition().getX(), (int) giraff.getSpritePosition().getY(),null);
        g.drawImage((Image) this.lion.getAnimation(), (int) lion.getSpritePosition().getX(), (int) lion.getSpritePosition().getY(),null);
        g.drawImage((Image) this.tree.getAnimation(), (int) tree.getSpritePosition().getX(), (int) tree.getSpritePosition().getY(),null);

        g.drawRect((int) ((int) this.giraff.getPosition().getX()-giraff.getRadius()/2), (int) ((int) giraff.getPosition().getY()-giraff.getRadius()/2), (int) giraff.getRadius(), (int) giraff.getRadius());
        long end = System.nanoTime();
        //System.out.println((start-end)/1000000);

    }
}
