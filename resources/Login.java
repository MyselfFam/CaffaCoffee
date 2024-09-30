package resources;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Login implements ActionListener, MouseListener
{
    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel, emailLabel, passwordLabel;
    private JPasswordField pa1;
    JButton loginButton, registerButton, back, exitBtn;

    JCheckBox c1;
    private ImageIcon icon, logo;
    private JTextField emailField;
    private JPasswordField passwordField;

    private Cursor cursor;

    Color btnColor = new Color(194, 136, 79);
    Color btnColor2 = new Color(180, 120, 65);


    public Login()
    {
        frame = new JFrame("Login");
        frame.setLayout(null);
        frame.setSize(1000, 562);
        frame.setBackground(new Color(253, 247, 239));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon("./images/token/icon.png").getImage());
        frame.setResizable(false);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        panel = new JPanel();
        panel.setBounds(295, 70, 410, 380);
        panel.setLayout(null);
        panel.setBackground(new Color(233, 227, 219));
        panel.setBorder(BorderFactory.createLineBorder((new Color(180, 120, 65)), 1));

        titleLabel = new JLabel("Customer Login");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(100, 40, 250, 40);
        panel.add(titleLabel);

        Font CP2 = new Font("Calibri", Font.PLAIN, 20);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(CP2);
        emailLabel.setForeground(Color.black);
        emailLabel.setBounds(50, 110, 100, 30);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(160, 110, 200, 30);
        panel.add(emailField);


        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(CP2);
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(50, 150, 100, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(160, 150, 200, 30);
        panel.add(passwordField);


        loginButton = new JButton("Login");
        loginButton.setFont(CP2);
        loginButton.setBackground(btnColor);
        loginButton.setBounds(50, 190, 310, 40);
        loginButton.setCursor(cursor);
        loginButton.setBorder(null);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setFont(CP2);
        registerButton.setBackground(btnColor);
        registerButton.setBounds(50, 240, 310, 40);
        registerButton.addActionListener(this);
        registerButton.setCursor(cursor);
        registerButton.setBorder(null);
        registerButton.setFocusable(false);
        registerButton.addMouseListener(this);
        panel.add(registerButton);

        back = new JButton("Back");
        back.setFont(CP2);
        back.setBackground(btnColor);
        back.setBounds(50, 290, 150, 40);
        back.setCursor(cursor);
        back.setBorder(null);
        back.setFocusable(false);
        back.addMouseListener(this);
        panel.add(back);

        exitBtn = new JButton("Exit");
        exitBtn.setFont(CP2);
        exitBtn.setBackground(btnColor);
        exitBtn.setBounds (210, 290, 150, 40);
        exitBtn.setCursor(cursor);
        exitBtn.setBorder(null);
        exitBtn.setFocusable(false);
        exitBtn.addMouseListener(this);
        panel.add(exitBtn);

        frame.add(panel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Menu();
            }
        });
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });      
    }



    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() instanceof JButton)
        {
            JButton button = (JButton) e.getSource();

            if (button.getText().equals("Login"))
            {
                login();
            }
            else if (button.getText().equals("Register"))
            {
                frame.dispose();
                new Registration();
            }
        }
        else if(c1.isSelected())
        {
            pa1.setEchoChar((char)0);
        }
        else
        {
            pa1.setEchoChar('*');
        }

    }

    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){
        if (me.getSource() == loginButton){
            loginButton.setBackground(btnColor2);
        }
        else if (me.getSource() == registerButton) {
            registerButton.setBackground(btnColor2);
        }
        else if (me.getSource() == back) {
            back.setBackground(btnColor2);
        }
        else if (me.getSource() == exitBtn){
            exitBtn.setBackground(btnColor2);
        }
    }
    public void mouseExited(MouseEvent me){
        if (me.getSource() == loginButton){
            loginButton.setBackground(btnColor);
        }
        else if (me.getSource() == registerButton) {
            registerButton.setBackground(btnColor);
        }
        else if (me.getSource() == back) {
            back.setBackground(btnColor);
        }
        else if (me.getSource() == exitBtn){
            exitBtn.setBackground(btnColor);
        }
    }


    private void login()
    {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        User user = null;

        if(email.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            return;
        }

       try {
            File file = new File("userdata.txt");

            if (!file.exists())
            {
                JOptionPane.showMessageDialog(frame, "No user registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            boolean loggedIn = false;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");

                if (parts[1].equals(email) && parts[2].equals(password))
                {
                    loggedIn = true;
                    user = new User(parts[0], parts[1], parts[2], parts[3]);
                    break;
                }
            }
            reader.close();

            if (loggedIn)
            {
                JOptionPane.showMessageDialog(frame, "Login Successful!");

                frame.setVisible(false);
                double[] prices = {150.0, 200.0, 300.0, 400.0, 500.0, 800.0, 850.0, 1500.0};
                new Cart1(prices);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Invalid email or password!");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }








}
