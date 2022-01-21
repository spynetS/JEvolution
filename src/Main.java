import Dsiaplay.Map;

import javax.swing.*;

public class Main {

    public static final int DELAY = 20;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("JEvolution");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Map m = new Map();
        frame.add(m);
        frame.setVisible(true);

        while(true)
        {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            m.Update();
        }


    }

}
