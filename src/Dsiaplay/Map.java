package Dsiaplay;

import Msc.Vector2;
import Objects.Giraff;
import Objects.Lion;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    Giraff giraff;
    Lion lion;
    long first;
    long last;
    JLabel fpscounter =new JLabel();
    public Map() {
        giraff = new Giraff(new Vector2(100,0));
        lion = new Lion(new Vector2(100,100));
        setBackground(Color.GRAY);
        add(fpscounter);
    }
    public void Update()
    {
        repaint();
        giraff.Update();
        lion.Update();
    }
    @Override
    protected void paintComponent(Graphics g) {
        //first = System.nanoTime();
        super.paintComponent(g);
        //g.drawRect(this.giraff.getPosition().getX(),this.giraff.getPosition().getY(),this.giraff.getScale().getX(),this.giraff.getScale().getY());
        g.drawImage(this.giraff.getAnimation(10),this.giraff.getPosition().getX(),this.giraff.getPosition().getY(),null);
        g.drawImage(this.lion.getAnimation(20),this.lion.getPosition().getX(),this.lion.getPosition().getY(),null);
        System.out.println(lion.getSprite().getGrid());
        //last = System.nanoTime();
        //fpscounter.setText(String.valueOf((last-first)/ 20));
    }
}
