package Managers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ПКПК on 17.07.2017.
 */
public class ManagersChange extends JDialog {

    ArrayList<String> dataList = new ArrayList<>();
    String[] oldData;

    public ManagersChange(JFrame owner, String[] oldData){

        super (owner, "Изменить данные сотрудника", true);
        this.oldData = oldData;

        setSize(500, 500);

        JPanel dataPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        add(dataPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        JButton buttonAdd = new JButton("Изменить сотрудника");
        JButton buttonDelete = new JButton("Удалить сотрудника");
        JButton buttonCancel = new JButton("Отмена");

        dataPanel.setLayout(new GridLayout(7, 2));


        JTextField secondName = new JTextField();
        secondName.setText(oldData[1]);
        dataPanel.add(new JLabel("Фамилия"));
        dataPanel.add(secondName);

        JTextField firstName = new JTextField();
        firstName.setText(oldData[2]);
        dataPanel.add(new JLabel("Имя"));
        dataPanel.add(firstName);

        JTextField thirdName = new JTextField();
        thirdName.setText(oldData[3]);
        dataPanel.add(new JLabel("Отчество"));
        dataPanel.add(thirdName);

        JTextField eMail = new JTextField();
        eMail.setText(oldData[4]);
        dataPanel.add(new JLabel("Эл. почта"));
        dataPanel.add(eMail);

        JTextField phone = new JTextField();
        phone.setText(oldData[5]);
        dataPanel.add(new JLabel("Телефон"));
        dataPanel.add(phone);

        JTextField password = new JTextField();
        password.setText(oldData[6]);
        dataPanel.add(new JLabel("Пароль"));
        dataPanel.add(password);

        JTextField privacy = new JTextField();
        privacy.setText(oldData[7]);
        dataPanel.add(new JLabel("Права"));
        dataPanel.add(privacy);

        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonDelete);
        buttonPanel.add(buttonCancel);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataList.add(secondName.getText());
                dataList.add(firstName.getText());
                dataList.add(thirdName.getText());
                dataList.add(eMail.getText());
                dataList.add(phone.getText());
                dataList.add(password.getText());
                dataList.add(privacy.getText());

//                String[] data = new String[dataList.size()];
//                for (int i = 0; i < data.length; i++) {
//                    data[i] = dataList.get(i);
//                }
//                System.out.println(data);
//                ManagersTableModel.addToBase(data);
                pushAdd();
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagersTableModel.deleteFromBase(Integer.parseInt(oldData[0]));
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pushCancel();
            }
        });


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);



    }

    private void pushCancel(){
        this.setVisible(false);
        dispose();
    }

    private void pushAdd(){

        String[] data = new String[dataList.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = dataList.get(i);
        }
        System.out.println(data);
        ManagersTableModel.changeInBase(data, Integer.parseInt(oldData[0]));
        this.setVisible(false);
        this.dispose();
    }
}
