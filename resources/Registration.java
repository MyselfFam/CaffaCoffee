package resources;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class Registration implements ActionListener
{

    private JFrame frame;

    private JPanel panel;

    private JLabel titleLabel, nameLabel, emailLabel, passwordLabel, genderLabel, loginLabel;

    private JTextField nameField, emailField;

    private JPasswordField passwordField;

    private JComboBox<String> genderBox;

    private Cursor cursor;
    private JButton exitButton, clearButton, registerButton; 

    Color btnColor = new Color(194,136,79);
    Color btnColor2 = new Color(180, 120, 65);


    public Registration()
    {

        // frame layout
        frame = new JFrame("Registration");
        frame.setLayout(null);
        frame.setSize(1000, 562);
        frame.setBackground(new Color(253,247,239));
        frame.setIconImage(new ImageIcon("./images/token/icon.png").getImage());
        frame.setResizable(false);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        panel = new JPanel();
        panel.setBounds(295, 10, 410, 410);
        panel.setLayout(null);
        panel.setBackground(new Color(233, 227, 219));
        panel.setBorder(BorderFactory.createLineBorder((new Color(180, 120, 65)),1));

        titleLabel = new JLabel("Registration");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(120, 40, 200, 40);
        panel.add(titleLabel);

        Font CP2 = new Font("Calibri", Font.PLAIN, 20);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(CP2);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(50, 110, 100, 30);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160, 110, 200, 30);
        panel.add(nameField);


        emailLabel = new JLabel("Email:");
        emailLabel.setFont(CP2);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(50, 150, 100, 30);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(160, 150, 200, 30);
        panel.add(emailField);


        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(CP2);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(50, 190, 100, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 190, 200, 30);
        panel.add(passwordField);


        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(CP2);
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setBounds(50, 230, 100, 30);
        panel.add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(160, 230, 200, 30);
        genderBox.setBorder(null);
        panel.add(genderBox);


        exitButton = new JButton("Exit");
        exitButton.setFont(CP2);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(btnColor);
        exitButton.setBounds(50, 270, 97,30);
        exitButton.setCursor(cursor);
        exitButton.setBorder(null);
        exitButton.setFocusable(false);
        //exitButton.addMouseListner(this);
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        panel.add(exitButton);

        
        registerButton = new JButton("Confirm");
        registerButton.setFont(CP2);
        registerButton.setForeground(Color.BLACK);
        registerButton.setBackground(btnColor);
        registerButton.setCursor(cursor);
        registerButton.setBounds(263, 270, 97, 30);
        registerButton.setBorder(null);
        registerButton.setFocusable(false);
        //register.addMouseListener(this);
        registerButton.addActionListener(this);
        panel.add(registerButton);


        clearButton = new JButton("Clear");
        clearButton.setFont(CP2);
        clearButton.setForeground(Color.BLACK);
        clearButton.setBackground(btnColor);
        clearButton.setBounds(157, 270, 96, 30);
        clearButton.setCursor(cursor);
        clearButton.setBorder(null);
        clearButton.setFocusable(false);
        //clearButton.addMouseListner(this);
        clearButton.addActionListener(this);
        panel.add(clearButton);


        JLabel loginLabel = new JLabel("Already Registered? Login");
        loginLabel.setForeground(new Color(0, 0, 238));
        loginLabel.setBounds(145, 330, 200, 30);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Login();
            }
        });
        panel.add(loginLabel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);


    }

    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() instanceof JButton)
        {

            JButton button = (JButton) e.getSource();

            if (button.getText().equals("Confirm")) {
    register();
}

 else if (button.getText().equals("Clear")) {

                clearFields();

            }

        }

    }

    private void register()
    {
             // System.out.println("Register button clicked!");
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String gender = (String) genderBox.getSelectedItem();


        // Check for empty fields
        if (name.isEmpty() || email.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            return;
        }

        // Check for existing email
        if (isEmailExists(email))
        {
            JOptionPane.showMessageDialog(frame, "User with this email already exists!");
            return;
        }

        User newUser = new User(name, email, password, gender);


        try (FileWriter writer = new FileWriter("userdata.txt", true))
        {
            writer.write(newUser.getName() + "," + newUser.getEmail() + "," + newUser.getPassword() + "," + newUser.getGender() + "\n");

            JOptionPane.showMessageDialog(frame, "Registration Successful!");

            frame.dispose();
            new Login();

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    private boolean isEmailExists(String email)
    {

        try (BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"))) {

            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");

                if (parts.length > 1 && parts[1].equals(email))
                {
                    return true;
                }

            }

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return false;

    }


    private void clearFields()
    {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        genderBox.setSelectedIndex(0);

    }

    public static void main(String[] args)
    {
        new Registration();
    }

}
