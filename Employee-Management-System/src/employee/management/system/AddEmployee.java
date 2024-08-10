package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    Random random = new Random();
    int employeeNumber = random.nextInt(999999);

    JTextField tfName, tfFatherName, tfAddress, tfPhone, tfAadhar, tfEmail, tfSalary, tfDesignation;
    JDateChooser dcDOB;
    JComboBox<String> cbEducation;
    JLabel lblEmployeeId;
    JButton btnAddDetails, btnBack;

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblHeading = new JLabel("Add Employee Detail");
        lblHeading.setBounds(320, 30, 500, 50);
        lblHeading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(lblHeading);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 150, 150, 30);
        lblName.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 150, 150, 30);
        add(tfName);

        JLabel lblFatherName = new JLabel("Father's Name");
        lblFatherName.setBounds(400, 150, 150, 30);
        lblFatherName.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblFatherName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(600, 150, 150, 30);
        add(tfFatherName);

        JLabel lblDOB = new JLabel("Date of Birth");
        lblDOB.setBounds(50, 200, 150, 30);
        lblDOB.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblDOB);

        dcDOB = new JDateChooser();
        dcDOB.setBounds(200, 200, 150, 30);
        add(dcDOB);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setBounds(400, 200, 150, 30);
        lblSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblSalary);

        tfSalary = new JTextField();
        tfSalary.setBounds(600, 200, 150, 30);
        add(tfSalary);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(50, 250, 150, 30);
        lblAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        add(tfAddress);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(400, 250, 150, 30);
        lblPhone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(600, 250, 150, 30);
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 300, 150, 30);
        lblEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        JLabel lblEducation = new JLabel("Highest Education");
        lblEducation.setBounds(400, 300, 150, 30);
        lblEducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEducation);

        String[] courses = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbEducation = new JComboBox<>(courses);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(600, 300, 150, 30);
        add(cbEducation);

        JLabel lblDesignation = new JLabel("Designation");
        lblDesignation.setBounds(50, 350, 150, 30);
        lblDesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblDesignation);

        tfDesignation = new JTextField();
        tfDesignation.setBounds(200, 350, 150, 30);
        add(tfDesignation);

        JLabel lblAadhar = new JLabel("Aadhar Number");
        lblAadhar.setBounds(400, 350, 150, 30);
        lblAadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblAadhar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(600, 350, 150, 30);
        add(tfAadhar);

        JLabel lblEmployeeIdLabel = new JLabel("Employee ID");
        lblEmployeeIdLabel.setBounds(50, 400, 150, 30);
        lblEmployeeIdLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEmployeeIdLabel);

        lblEmployeeId = new JLabel("" + employeeNumber);
        lblEmployeeId.setBounds(200, 400, 150, 30);
        lblEmployeeId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEmployeeId);

        btnAddDetails = new JButton("Add Details");
        btnAddDetails.setBounds(250, 550, 150, 40);
        btnAddDetails.addActionListener(this);
        btnAddDetails.setBackground(Color.BLACK);
        btnAddDetails.setForeground(Color.WHITE);
        add(btnAddDetails);

        btnBack = new JButton("Back");
        btnBack.setBounds(450, 550, 150, 40);
        btnBack.addActionListener(this);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAddDetails) {
            String name = tfName.getText().trim();
            String fatherName = tfFatherName.getText().trim();
            String dob = ((JTextField) dcDOB.getDateEditor().getUiComponent()).getText().trim();
            String salaryStr = tfSalary.getText().trim();
            String address = tfAddress.getText().trim();
            String phone = tfPhone.getText().trim();
            String email = tfEmail.getText().trim();
            String education = (String) cbEducation.getSelectedItem();
            String designation = tfDesignation.getText().trim();
            String aadhar = tfAadhar.getText().trim();
            String empId = lblEmployeeId.getText();

            // Validate user input
            if (name.isEmpty() || fatherName.isEmpty() || dob.isEmpty() || salaryStr.isEmpty() ||
                address.isEmpty() || phone.isEmpty() || email.isEmpty() || designation.isEmpty() || aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number.");
                return;
            }

            if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                return;
            }

            if (!aadhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit Aadhar number.");
                return;
            }

            double salary;
            try {
                salary = Double.parseDouble(salaryStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid salary amount.");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO employee VALUES('" + name + "', '" + fatherName + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + aadhar + "', '" + empId + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error adding employee details: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
