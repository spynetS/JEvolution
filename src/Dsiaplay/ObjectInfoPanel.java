package Dsiaplay;

import Objects.Animal;
import Objects.Object;

import javax.swing.*;

public class ObjectInfoPanel extends JPanel {

    JLabel health = new JLabel();
    JLabel hunger = new JLabel();
    JLabel thirst = new JLabel();
    JLabel stamina = new JLabel();

    public ObjectInfoPanel() {

        setSize(200,100);
        add(health);
        add(hunger);
        add(thirst);
        add(stamina);
    }

    public void setData(Animal object)
    {
        health.setText(String.valueOf(object.getHealth()));
        hunger.setText(String.valueOf(object.getHunger()));
        thirst.setText(String.valueOf(object.getThirst()));
        stamina.setText(String.valueOf(object.getStamina()));
    }

}
