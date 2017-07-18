package Managers;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ПКПК on 10.07.2017.
 */
public class ManagersTable extends JFrame {

    private int row;

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public ManagersTable(){
        setSize(dimension.width - 35, dimension.height - 35);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        ManagersTableModel tableModel = new ManagersTableModel();
        JTable table = getTable();
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
                ManagersAdd managersAdd = new ManagersAdd(getThis());
                table.setModel(getModel());
                table.repaint();

            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                System.out.println(table.getSelectedColumn() + " - " + table.getSelectedRow());
                row = table.getSelectedRow();

            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagersTableModel.deleteFromBase(ManagersTableModel.getId(table.getSelectedRow()));
                table.setModel(getModel());
                table.repaint();

            }
        });

        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                int row = table.getSelectedRow();
//                System.out.println(row);
//                int id = ManagersTableModel.getId(row);
//                System.out.println(id);



                String[] changeData = ManagersTableModel.getFromBase(ManagersTableModel.getId(table.getSelectedRow()));


//                System.out.println(changeData);
                ManagersChange managersChange = new ManagersChange(getThis(), changeData );
                table.setModel(getModel());
                table.repaint();

            }
        });







        setVisible(true);
    }

    private JFrame getThis(){
        return this;
    }

    private ManagersTableModel getModel(){
        ManagersTableModel myTableModel = new ManagersTableModel();
        return myTableModel;
    }

    private JTable getTable(){


        JTable myTable = new JTable(getModel());


        return myTable;

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
