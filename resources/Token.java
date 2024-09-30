package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Token implements MouseListener, ActionListener {

    //Random Number Generator
    Random random = new Random();
    int rntkn = random.nextInt(98) + 1;
    String tkn = String.valueOf(rntkn);
    
    //Object Calling
    JFrame tframe;
    JPanel panel;
    JLabel label1, label2, label3, label4, label5, label6, label7, bg;
    JButton homeButton, backButton, exitButton;
    ImageIcon ico;
    Font fntBig ,fntSmall;
    Color fntColor;
    

    Token() {
        //Fonts
        fntBig = new Font("Times New Roman", Font.BOLD, 60);
        fntSmall = new Font("Calibri", Font.PLAIN, 20);

        //Color
        fntColor = new Color(194, 136, 79);

        tframe = new JFrame("Token");
        tframe.setSize(1000, 562);
        tframe.setLocationRelativeTo(null);
        tframe.setResizable(false);
        tframe.setIconImage(new ImageIcon("./images/token/icon.png").getImage());
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setVisible(true);
        
        
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(253, 247, 239));

        label1 = new JLabel("Thank You");
        label1.setBounds(357, 104, 320, 60);
        label1.setFont(fntBig);
        label1.setForeground(fntColor);
        panel.add(label1);

        label2 = new JLabel("Your order has been placed.");
        label2.setBounds(382, 174, 236, 20);
        label2.setFont(fntSmall);
        panel.add(label2);

        label3 = new JLabel("Your token number is -");
        label3.setBounds(402, 204, 197, 20);
        label3.setFont(fntSmall);
        panel.add(label3);

        label4 = new JLabel(tkn);
        label4.setBounds(450, 234, 100, 60);
        label4.setFont(fntBig);
        label4.setForeground(fntColor);
        panel.add(label4);

        label5 = new JLabel("Please collect your token and wait while we prepare your order.");
        label5.setBounds(233, 304, 535, 20);
        label5.setFont(fntSmall);
        panel.add(label5);

        label6 = new JLabel("When the token starts blinking, collect your order.");
        label6.setBounds(289, 334, 422, 20);
        label6.setFont(fntSmall);
        panel.add(label6);

        label7 = new JLabel("Thank you for your patience.");
        label7.setBounds(380, 364, 241, 25);
        label7.setFont(fntSmall);
        panel.add(label7);

        homeButton = new JButton("Home");
        homeButton.setBounds(458, 414, 85, 40);
        homeButton.setFont(fntSmall);
        homeButton.setBackground(new Color(194, 136, 79));
        homeButton.setForeground(new Color(253, 247, 239));
        homeButton.setBorder(null);
        homeButton.setFocusable(false);
        homeButton.addMouseListener(this);
        homeButton.addActionListener(this);
        panel.add(homeButton);

        backButton = new JButton(new ImageIcon("./images/token/back.png"));
        backButton.setBounds(5, 5, 30, 30);
        backButton.setBackground(new Color(253, 247, 239));
        backButton.setBorder(null);
        backButton.setFocusable(false);
        backButton.addMouseListener(this);
        backButton.addActionListener(this);
        panel.add(backButton);

        exitButton = new JButton(new ImageIcon("./images/token/exit.png"));
        exitButton.setBounds(950, 5, 30, 30);
        exitButton.setBackground(new Color(253, 247, 239));
        exitButton.setBorder(null);
        exitButton.setFocusable(false);
        exitButton.addMouseListener(this);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        bg = new JLabel(new ImageIcon("./images/token/token_background.png"));
        bg.setBounds(0, 0, 1000, 562);
        panel.add(bg);
        
        tframe.add(panel);
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == homeButton) {
            homeButton.setBackground(new Color(180, 120, 65));
        }
        else if (me.getSource() == backButton) {
            backButton.setBackground(new Color(233, 227, 234));
        }
        else if (me.getSource() == exitButton) {
            exitButton.setBackground(new Color(233, 227, 234));
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == homeButton) {
            homeButton.setBackground(new Color(194, 136, 79));
        }
        else if (me.getSource() == backButton) {
            backButton.setBackground(new Color(253, 247, 239));
        }
        
        else if (me.getSource() == exitButton) {
            exitButton.setBackground(new Color(253, 247, 239));
        }
    }
    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            new Home();
            tframe.setVisible(false);
        }
        else if (e.getSource() == backButton) {
            double[] prices = {90.0, 60.0, 70.0, 80.0, 40.0, 30.0, 20.0, 90.0};
        	new Cart1(prices);
            tframe.setVisible(false);
        }
        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
