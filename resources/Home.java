package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home implements MouseListener, ActionListener {
    JFrame hframe;
    JLabel welcomeLabel, featureLabel, imgLabel1, imgLabel2, imgLabel3, imgLabel4, imgLabel5, aLabel, bLabel, cLabel, dLabel;
    JButton aboutBtn, menuBtn, exitBtn, nextMenuBtn;
    JPanel panel;
    Font myFont;

    public Home() {

        hframe = new JFrame("Caffa Coffee House");
        hframe.setSize(1000, 562);
        hframe.setLocationRelativeTo(null);
        hframe.setResizable(false);
        hframe.setIconImage(new ImageIcon("./images/token/icon.png").getImage());
        hframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(253, 247, 239));
        myFont = new Font("Cambria", Font.BOLD, 24);

        welcomeLabel = new JLabel("  WELCOME");
        welcomeLabel.setBounds(100, 150, 300, 50);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Cambria", Font.BOLD, 50));
        panel.add(welcomeLabel);

        featureLabel = new JLabel("FEATURED MENU");
        featureLabel.setBounds(626, 13, 260, 27);
        featureLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        panel.add(featureLabel);

        aLabel = new JLabel("Black Coffee");
        aLabel.setBounds(600, 220, 133, 27);
        aLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        panel.add(aLabel);

        bLabel = new JLabel("Cappuccino");
        bLabel.setBounds(820, 220, 133, 27);
        bLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        panel.add(bLabel);

        cLabel = new JLabel("Frappe");
        cLabel.setBounds(600, 420, 133, 27);
        cLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        panel.add(cLabel);

        dLabel = new JLabel("Dark Coffee");
        dLabel.setBounds(820, 420, 133, 27);
        dLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        panel.add(dLabel);

        aboutBtn = new JButton("About");
        aboutBtn.setBounds(10, 13, 111, 30);
        aboutBtn.setForeground(Color.WHITE);
        aboutBtn.setBackground(new Color(0, 0, 0, 0));
        aboutBtn.setFont(new Font("Cambria", Font.BOLD, 22));
        aboutBtn.setBorder(null);
        aboutBtn.setFocusable(false);
        aboutBtn.addMouseListener(this);
        aboutBtn.addActionListener(this);
        panel.add(aboutBtn);

        menuBtn = new JButton("Menu");
        menuBtn.setBounds(131, 13, 111, 30);
        menuBtn.setForeground(Color.WHITE);
        menuBtn.setBackground(Color.WHITE);
        menuBtn.setFont(new Font("Cambria", Font.BOLD, 22));
        menuBtn.setOpaque(false);
        menuBtn.setBorder(null);
        menuBtn.setFocusable(false);
        menuBtn.addMouseListener(this);
        menuBtn.addActionListener(this);
        panel.add(menuBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(252, 13, 111, 30);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBackground(Color.WHITE);
        exitBtn.setFont(new Font("Cambria", Font.BOLD, 22));
        exitBtn.setOpaque(false);
        exitBtn.setBorder(null);
        exitBtn.setFocusable(false);
        exitBtn.addMouseListener(this);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        nextMenuBtn = new JButton("View Full Menu");
        nextMenuBtn.setBounds(755, 467, 180, 30);
        nextMenuBtn.setForeground(Color.BLACK);
        nextMenuBtn.setFont(new Font("Cambria", Font.PLAIN, 18));
        nextMenuBtn.setBackground(new Color(194, 136, 79));
        nextMenuBtn.setBorder(null);
        nextMenuBtn.setFocusable(false);
        nextMenuBtn.addMouseListener(this);
        nextMenuBtn.addActionListener(this);
        panel.add(nextMenuBtn);

        imgLabel1 = new JLabel(new ImageIcon("./images/home/home_background.jpg"));
        imgLabel1.setBounds(0, 0, 500, 562);
        panel.add(imgLabel1);

        imgLabel2 = new JLabel(new ImageIcon("./images/home/black_coffee.png"));
        imgLabel2.setBounds(520, 67, 228, 160);
        panel.add(imgLabel2);

        imgLabel3 = new JLabel(new ImageIcon("./images/home/cappuccino.png"));
        imgLabel3.setBounds(740, 67, 228, 177);
        panel.add(imgLabel3);

        imgLabel4 = new JLabel(new ImageIcon("./images/home/frappe.png"));
        imgLabel4.setBounds(520, 268, 228, 160);
        panel.add(imgLabel4);

        imgLabel5 = new JLabel(new ImageIcon("./images/home/dark_coffee.png"));
        imgLabel5.setBounds(740, 268, 228, 160);
        panel.add(imgLabel5);

        hframe.add(panel);
        hframe.setVisible(true);
    }

    private void showAboutDetails() {
        // Create a JPanel to hold all the labels
        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayout(5, 1, 10, 10));

        // Create a JLabel for the title
        JLabel titleLabel = new JLabel("About Us");
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aboutPanel.add(titleLabel);

        // Create JLabels for each name and id number with different colors
        aboutPanel.add(createLabel("Fahim Hassan - ID: 23-55325-3"));
        aboutPanel.add(createLabel("Jamiul Hasan Reyhad - ID: 23-55291-3"));
        aboutPanel.add(createLabel("Mohammad Saib - ID: 23-54748-3"));
        aboutPanel.add(createLabel("Samia Afroze Simla - ID: 23-54500-3"));

        // Display the panel in a JOptionPane
        JOptionPane.showMessageDialog(hframe, aboutPanel, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Cambria", Font.PLAIN, 18));
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aboutBtn) {
            showAboutDetails();
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        } else if (e.getSource() == menuBtn || e.getSource() == nextMenuBtn) {
            hframe.setVisible(false);
            new Menu();
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == nextMenuBtn){
            nextMenuBtn.setBackground(new Color(184, 126, 69));
        }
        else if (me.getSource() == aboutBtn){
            aboutBtn.setBackground(new Color(0, 0, 0, 100));
            aboutBtn.setOpaque(true);
        }
        else if (me.getSource() == menuBtn){
            menuBtn.setBackground(new Color(0,0,0, 100));
            menuBtn.setOpaque(true);
        }
        else if (me.getSource() == exitBtn){
            exitBtn.setBackground(new Color(0,0,0, 100));
            exitBtn.setOpaque(true);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == nextMenuBtn){
            nextMenuBtn.setBackground(new Color(194, 136, 79));
        }
        else if (me.getSource() == aboutBtn){
            aboutBtn.setOpaque(false);
        }
        else if (me.getSource() == menuBtn){
            menuBtn.setOpaque(false);
        }
        else if (me.getSource() == exitBtn){
            exitBtn.setOpaque(false);
        }
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
}