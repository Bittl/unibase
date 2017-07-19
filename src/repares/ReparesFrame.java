package repares;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ПКПК on 19.07.2017.
 */
public class ReparesFrame extends JFrame {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public ReparesFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(dimension.width - 35, dimension.height - 35);


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReparesFrame();
            }
        });
    }

}
