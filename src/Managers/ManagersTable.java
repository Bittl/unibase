package Managers;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ПКПК on 10.07.2017.
 */
public class ManagersTable extends JFrame {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public ManagersTable(){
        setSize(dimension.width - 35, dimension.height - 35);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ManagersTableModel tableModel = new ManagersTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JButton buttonAdd = new JButton("Добавить сотрудника");
        JButton buttonChange = new JButton("Изменить сотрудника");
        JButton buttonDelete = new JButton("Удалить сотрудника");


        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonChange);
        buttonPanel.add(buttonDelete);
        add(buttonPanel, BorderLayout.NORTH);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });





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
