package Managers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by romanegorov on 10.07.17.
 */
public class ManagersAdd extends JDialog {

    ArrayList<String> dataList = new ArrayList<>();

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


        JTextField secondName = new JTextField();
        dataPanel.add(new JLabel("Фамилия"));
        dataPanel.add(secondName);

        JTextField firstName = new JTextField();
        dataPanel.add(new JLabel("Имя"));
        dataPanel.add(firstName);

        JTextField thirdName = new JTextField();
        dataPanel.add(new JLabel("Отчество"));
        dataPanel.add(thirdName);

        JTextField eMail = new JTextField();
        dataPanel.add(new JLabel("Эл. почта"));
        dataPanel.add(eMail);

        JTextField phone = new JTextField();
        dataPanel.add(new JLabel("Телефон"));
        dataPanel.add(phone);

        JTextField password = new JTextField();
        dataPanel.add(new JLabel("Пароль"));
        dataPanel.add(password);

        JTextField privacy = new JTextField();
        dataPanel.add(new JLabel("Права"));
        dataPanel.add(privacy);

        buttonPanel.add(buttonAdd);
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

                String[] data = new String[dataList.size()];
                for (int i = 0; i < data.length; i++) {
                    data[i] = dataList.get(i);
                }
                System.out.println(data);
                ManagersTableModel.addToBase(data);
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
}
