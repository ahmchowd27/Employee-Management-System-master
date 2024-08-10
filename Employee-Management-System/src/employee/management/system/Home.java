package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton btnViewEmployees, btnAddEmployee, btnUpdateEmployee, btnRemoveEmployee;

    Home() {
        setLayout(null);

        try {
            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
            Image scaledImage = icon.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel backgroundImage = new JLabel(scaledIcon);
            backgroundImage.setBounds(0, 0, 1120, 630);
            add(backgroundImage);

            JLabel lblHeading = new JLabel("Employee Management System");
            lblHeading.setBounds(620, 20, 400, 40);
            lblHeading.setFont(new Font("Raleway", Font.BOLD, 25));
            backgroundImage.add(lblHeading);

            btnAddEmployee = new JButton("Add Employee");
            btnAddEmployee.setBounds(650, 80, 150, 40);
            btnAddEmployee.addActionListener(this);
            backgroundImage.add(btnAddEmployee);

            btnViewEmployees = new JButton("View Employees");
            btnViewEmployees.setBounds(820, 80, 150, 40);
            btnViewEmployees.addActionListener(this);
            backgroundImage.add(btnViewEmployees);

            btnUpdateEmployee = new JButton("Update Employee");
            btnUpdateEmployee.setBounds(650, 140, 150, 40);
            btnUpdateEmployee.addActionListener(this);
            backgroundImage.add(btnUpdateEmployee);

            btnRemoveEmployee = new JButton("Remove Employee");
            btnRemoveEmployee.setBounds(820, 140, 150, 40);
            btnRemoveEmployee.addActionListener(this);
            backgroundImage.add(btnRemoveEmployee);

            setSize(1120, 630);
            setLocation(250, 100);
            setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading the home screen: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == btnAddEmployee) {
                setVisible(false);
                new AddEmployee();
            } else if (ae.getSource() == btnViewEmployees) {
                setVisible(false);
                new ViewEmployee();
            } else if (ae.getSource() == btnUpdateEmployee) {
                setVisible(false);
                new ViewEmployee();
            } else if (ae.getSource() == btnRemoveEmployee) {
                setVisible(false);
                new RemoveEmployee();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error processing action: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
