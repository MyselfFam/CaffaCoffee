package resources;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Menu implements MouseListener, ActionListener {
    JFrame mframe;
    JPanel panel;
    JLabel coupon, background, imgLabel1, imgLabel2, imgLabel3, imgLabel4, imgLabel5, imgLabel6, imgLabel7, imgLabel8, label1, label2, label3, label4, label5, label6, label7, label8, price1, price2, price3, price4, price5, price6, price7, price8;
    JButton exitBtn, backBtn, order;
    ImageIcon img1, img2, img3, img4, img5, img6, img7, img8, backimg;
    Font myFont;
	Color myColor;
	Border border;

    public Menu() {
        mframe = new JFrame("Menu");
        mframe.setSize(1000, 562);
        mframe.setLocationRelativeTo(null);
        mframe.setResizable(false);
        mframe.setVisible(true);
        mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setIconImage(new ImageIcon("./images/token/icon.png").getImage());

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(60, 179, 113));

		label1 = new JLabel("Dark Coffee");
		label1.setBounds(60, 45, 310, 50);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setBackground(Color.DARK_GRAY);
		label1.setOpaque(true);
		label1.setForeground(Color.WHITE);
        myFont = new Font("Cambria", Font.PLAIN, 24);
		label1.setFont(myFont);
		panel.add(label1);

		label2 = new JLabel("Latte Macchiato");
		label2.setBounds(60, 105, 310, 50);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setBackground(Color.DARK_GRAY);
		label2.setOpaque(true);
		label2.setForeground(Color.WHITE);
		label2.setFont(myFont);
		panel.add(label2);
		
		label3 = new JLabel("Cafe Latte");
		label3.setBounds(60, 165, 310, 50);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setBackground(Color.DARK_GRAY);
		label3.setOpaque(true);
		label3.setForeground(Color.WHITE);
		label3.setFont(myFont);
		panel.add(label3);
		
		label4 = new JLabel("Cappuccino");
		label4.setBounds(60, 225, 310, 50);
		label4.setHorizontalAlignment(JLabel.CENTER);
		label4.setBackground(Color.DARK_GRAY);
		label4.setOpaque(true);
		label4.setForeground(Color.WHITE);
		label4.setFont(myFont);
		panel.add(label4);
		
		label5 = new JLabel("Cafe Au Lait");
		label5.setBounds(60, 285, 310, 50);
		label5.setHorizontalAlignment(JLabel.CENTER);
		label5.setBackground(Color.DARK_GRAY);
		label5.setOpaque(true);
		label5.setForeground(Color.WHITE);
		label5.setFont(myFont);
		panel.add(label5);
		
		label6 = new JLabel("Flat White");
		label6.setBounds(60, 345, 310, 50);
		label6.setHorizontalAlignment(JLabel.CENTER);
		label6.setBackground(Color.DARK_GRAY);
		label6.setOpaque(true);
		label6.setForeground(Color.WHITE);
		label6.setFont(myFont);
		panel.add(label6);
		
		label7 = new JLabel("Frappe");
		label7.setBounds(60, 405, 310, 50);
		label7.setHorizontalAlignment(JLabel.CENTER);
		label7.setBackground(Color.DARK_GRAY);
		label7.setOpaque(true);
		label7.setForeground(Color.WHITE);
		label7.setFont(myFont);
		panel.add(label7);
		
		label8 = new JLabel("Frappuccino");
		label8.setBounds(60, 465, 310, 50);
		label8.setHorizontalAlignment(JLabel.CENTER);
		label8.setBackground(Color.DARK_GRAY);
		label8.setOpaque(true);
		label8.setForeground(Color.WHITE);
		label8.setFont(myFont);
		panel.add(label8);

        exitBtn = new JButton("Exit");
		exitBtn.setBounds(525, 460, 100, 30);
		exitBtn.setBackground(new Color(252, 48, 72));
		exitBtn.setFocusable(false);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		exitBtn.setBorder(null);
		myFont = new Font("serif",Font.BOLD | Font.ITALIC,18);
		exitBtn.setFont(myFont);
		panel.add(exitBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(5, 5, 470, 30);
		backBtn.setBackground(Color.GRAY);
		backBtn.setFocusable(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		myFont = new Font("serif",Font.BOLD | Font.ITALIC,20);
		backBtn.setFont(myFont);
		panel.add(backBtn);
		
		order = new JButton("Order Now");
		order.setBounds(825, 460, 100, 30);
		order.setBackground(Color.GREEN);
		order.setFocusable(false);
		order.addMouseListener(this);
		order.addActionListener(this);
		order.setBorder(null);
		myFont = new Font("serif",Font.BOLD | Font.ITALIC,18);
		order.setFont(myFont);
		panel.add(order);

        price1 = new JLabel("150 TK");
		price1.setBounds(375, 45, 100, 50);
		price1.setHorizontalAlignment(JLabel.CENTER);
		price1.setBackground(Color.DARK_GRAY);
		price1.setOpaque(true); 
		price1.setForeground(new Color(172,176,123));
		myFont = new Font("serif",Font.BOLD | Font.ITALIC,24);
		price1.setFont(myFont);
		panel.add(price1);
		
		price2 = new JLabel("200 TK");
		price2.setBounds(375, 105, 100, 50);
		price2.setHorizontalAlignment(JLabel.CENTER);
		price2.setBackground(Color.DARK_GRAY);
		price2.setOpaque(true);
		price2.setForeground(new Color(172,176,123));
		price2.setFont(myFont);
		panel.add(price2);
		
		price3 = new JLabel("300 TK");
		price3.setBounds(375, 165, 100, 50);
		price3.setHorizontalAlignment(JLabel.CENTER);
		price3.setBackground(Color.DARK_GRAY);
		price3.setOpaque(true);
		price3.setForeground(new Color(172,176,123));
		//price3.setForeground(Color.BLUE);
		price3.setFont(myFont);
		panel.add(price3);
		
		price4 = new JLabel("400 TK");
		price4.setBounds(375, 225, 100, 50);
		price4.setHorizontalAlignment(JLabel.CENTER);
		price4.setBackground(Color.DARK_GRAY);
		price4.setOpaque(true);
		price4.setForeground(new Color(172,176,123));
		//price4.setForeground(Color.BLUE);
		price4.setFont(myFont);
		panel.add(price4);
		
		price5 = new JLabel("500 TK");
		price5.setBounds(375, 285, 100, 50);
		price5.setHorizontalAlignment(JLabel.CENTER);
		price5.setBackground(Color.DARK_GRAY);
		price5.setOpaque(true);
		price5.setForeground(new Color(172,176,123));
		//price5.setForeground(Color.BLUE);
		price5.setFont(myFont);
		panel.add(price5);
		
		price6 = new JLabel("800 TK");
		price6.setBounds(375, 345, 100, 50);
		price6.setHorizontalAlignment(JLabel.CENTER);
		price6.setBackground(Color.DARK_GRAY);
		price6.setOpaque(true);
		price6.setForeground(new Color(172,176,123));
		//price6.setForeground(Color.BLUE);
		price6.setFont(myFont);
		panel.add(price6);
		
		price7 = new JLabel("850 TK");
		price7.setBounds(375, 405, 100, 50);
		price7.setHorizontalAlignment(JLabel.CENTER);
		price7.setBackground(Color.DARK_GRAY);
		price7.setOpaque(true);
		price7.setForeground(new Color(172,176,123));
		//price7.setForeground(Color.BLUE);
		price7.setFont(myFont);
		panel.add(price7);
		
		price8 = new JLabel("1500 Tk");
		price8.setBounds(375, 465, 100, 50);
		price8.setHorizontalAlignment(JLabel.CENTER);
		price8.setBackground(Color.DARK_GRAY);
		price8.setOpaque(true);
		price8.setForeground(new Color(172,176,123));
		//price8.setForeground(Color.BLUE);
		price8.setFont(myFont);
		panel.add(price8);
		
		coupon = new JLabel("<html>10% Discount Avalaible<br>Use Coupon Code<br>'new'</html>");
		coupon.setBounds(600, 300, 250, 100);
		coupon.setHorizontalAlignment(JLabel.CENTER);
		coupon.setBackground(Color.DARK_GRAY);
		coupon.setOpaque(false);
		coupon.setForeground(Color.MAGENTA);
		myFont = new Font("serif",Font.BOLD | Font.ITALIC,24);
		coupon.setFont(myFont);
		panel.add(coupon);

        backimg = new ImageIcon("./images/menu/menu_background.jpg");
		background = new JLabel(backimg);
		background.setBounds(484, 0, 500, 525);
		panel.add(background);
		
		img1 = new ImageIcon("./images/menu/product-06-free-img.jpg");
		imgLabel1 = new JLabel(img1);
		imgLabel1.setBounds(5, 45, 50, 50);
		panel.add(imgLabel1);
		
		img2 = new ImageIcon("./images/menu/product-07-free-img.jpg");
		imgLabel2 = new JLabel(img2);
		imgLabel2.setBounds(5, 105, 50, 50);
		panel.add(imgLabel2);
		
		img3 = new ImageIcon("./images/menu/product-08-free-img.jpg");
		imgLabel3 = new JLabel(img3);
		imgLabel3.setBounds(5, 165, 50, 50);
		panel.add(imgLabel3);
		
		img4 = new ImageIcon("./images/menu/product-09-free-img.jpg");
		imgLabel4 = new JLabel(img4);
		imgLabel4.setBounds(5, 225, 50, 50);
		panel.add(imgLabel4);
		
		img5 = new ImageIcon("./images/menu/product-10-free-img.jpg");
		imgLabel5 = new JLabel(img5);
		imgLabel5.setBounds(5, 285, 50, 50);
		panel.add(imgLabel5);
		
		img6 = new ImageIcon("./images/menu/product-11-free-img.jpg");
		imgLabel6 = new JLabel(img6);
		imgLabel6.setBounds(5, 345, 50, 50);
		panel.add(imgLabel6);
		
		img7 = new ImageIcon("./images/menu/product-12-free-img.jpg");
		imgLabel7 = new JLabel(img7);
		imgLabel7.setBounds(5, 405, 50, 50);
		panel.add(imgLabel7);
		
		img8 = new ImageIcon("./images/menu/product-13-free-img.jpg");
		imgLabel8 = new JLabel(img8);
		imgLabel8.setBounds(5, 465, 50, 50);
		panel.add(imgLabel8);

        mframe.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            System.exit(0);
        } else if (e.getSource() == backBtn) {
            mframe.setVisible(false);
            new Home();
        } else if (e.getSource() == order) {
			mframe.setVisible(false);
			new Login();
        }
    }

    public void mouseEntered(MouseEvent me) {
		if(me.getSource() == order)
		{
			order.setBackground(new Color(137, 207, 240));
		}
		else if(me.getSource() == backBtn)
		{
			backBtn.setBackground(new Color(137, 207, 240));
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(new Color(137, 207, 240));
		}
    }

    public void mouseExited(MouseEvent me) {
        if(me.getSource() == order)
		{
			order.setBackground(Color.GREEN);
		}
		else if(me.getSource() == backBtn)
		{
			backBtn.setBackground(Color.GRAY);
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(new Color(252, 48, 72));
		}
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
}
