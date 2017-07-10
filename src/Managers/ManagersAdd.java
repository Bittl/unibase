package Managers;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romanegorov on 10.07.17.
 */
public class ManagersAdd extends JDialog {

    public ManagersAdd(JFrame owner){

        super (owner, "Новый сотрудник", true);

        setSize(500, 500);

        JPanel dataPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        add(dataPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        JButton buttonAdd = new JButton("Добавить сотрудника");
        JButton buttonCancel = new JButton("Отмена");

        dataPanel.setLayout(new GridLayout(7, 2));
        

    }
}
