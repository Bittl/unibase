package Managers;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ПКПК on 10.07.2017.
 */
public class ManagersTable extends JFrame implements  {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public ManagersTable(){
        setSize(dimension.width - 35, dimension.height - 35);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ManagersTableModel tableModel = new ManagersTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);




        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManagersTable();
            }
        });
    }

}
