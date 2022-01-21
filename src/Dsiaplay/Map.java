package Dsiaplay;

import Msc.Vector2;
import Objects.Giraff;
import Objects.Lion;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    Giraff giraff;
    Lion lion;
    long first;
    long last;
    public Map() {
        giraff = new Giraff(new Vector2(200,100));
        lion = new Lion(new Vector2(200,200));
        setBackground(Color.GRAY);
        add(giraff.getInfoPanel());
        add(lion.getInfoPanel());
    }
    public void Update()
    {
        repaint();
        giraff.Update();

        lion.Update();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(this.giraff.getPosition().getX(),this.giraff.getPosition().getY(),this.giraff.getScale().getX(),this.giraff.getScale().getY());
        g.drawImage(this.giraff.getAnimation(),giraff.getSpritePosition().getX(),giraff.getSpritePosition().getY(),null);
        g.drawImage(this.lion.getAnimation(),lion.getSpritePosition().getX(),lion.getSpritePosition().getY(),null);
        //System.out.println(lion.getSprite().getGrid());
    }
}
