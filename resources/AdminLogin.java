package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class AdminLogin extends JFrame implements ActionListener
{
    private Container c;
    private JLabel userNameLabel, passwordLabel, imageLabel, titleLabel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton, backButton, exitButton;

    public AdminLogin()
    {
        this.setTitle("Admin login");
        this.setSize(750, 510);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
		this.setIconImage(new ImageIcon("./images/token/icon.png").getImage());
		
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FFE3CA"));

        titleLabel = new JLabel("Login as Admin");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(260, 60, 250, 70);
        c.add(titleLabel);

        // Username label and field
        userNameLabel = new JLabel("Username");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        userNameLabel.setBounds(220, 190, 100, 30);
        c.add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(340, 190, 200, 30);
        c.add(userNameField);

        // Password label and field
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setBounds(220, 250, 100, 30);
        c.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(340, 250, 200, 30);
        c.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setBounds(300, 370, 120, 40);
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.decode("#2C7865"));
        loginButton.setForeground(Color.WHITE);
        c.add(loginButton);

        //Back button
        backButton = new JButton("Go Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBounds(80, 370, 120, 40);
        backButton.addActionListener(this);
        backButton.setBackground(Color.decode("#31363F"));
        backButton.setForeground(Color.WHITE);
        c.add(backButton);

        //Exit Button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBounds(520, 370, 120, 40);
        exitButton.addActionListener(this);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#C40C0C"));
        c.add(exitButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == loginButton) {
            String username = userNameField.getText().toLowerCase();
            String password = new String(passwordField.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (username.equals("admin") && password.equals("admin")) {
                setVisible(false);
                double[] prices = {150.0, 200.0, 300.0, 400.0, 500.0, 800.0, 850.0, 1500.0};
                new AdminPanel(prices);
            } else {
                showMessageDialog(null, "Invalid Username or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
        else if (e.getSource() == backButton) {

            this.dispose();
            double[] prices = {990.0, 60.0, 70.0, 80.0, 40.0, 30.0, 20.0, 90.0};
            new Cart1(prices);

        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }

}
