package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class payment extends JFrame implements ActionListener
{
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private JButton b1,b2;
    private JRadioButton b3,b4,b5;
    private JPanel P1,P2;
    private JTextField t1;
    private JPasswordField p1;
    private JCheckBox c1;
    private Cursor cursor;





    public payment()
    {
        super("payment");
        this.setSize(1000,562);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setIconImage(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\8AM\\Caffa Coffee House\\images\\token\\icon.png").getImage());
		//this.setIconImage(new ImageIcon("./images/token/icon.png").getImage());
		//"C:\Users\Lenovo\Desktop\8AM\Caffa Coffee House\images\token\icon.png"

        cursor =  new Cursor(Cursor.HAND_CURSOR);

        // panels

        P1 = new JPanel();
        P1.setBounds(0,0,750,50);
        P1.setBackground(new Color(118,113,113));
        P1.setBorder(BorderFactory.createLineBorder(Color.black));
        P1.setLayout(null);

        P2 = new JPanel();
        P2.setBounds(0,50,750,460);
        P2.setBackground(new Color(253, 247, 239));
        P2.setBorder(BorderFactory.createLineBorder(Color.black));
        P2.setLayout(null);




        //panel 1 component

        l1 = new JLabel("Coffee Shop");
        l1.setFont(new Font("Serif",Font.ITALIC | Font.BOLD,36));
        l1.setForeground(Color.ORANGE);
        l1.setBounds(20,8,180,35);
        P1.add(l1);

        l2 = new JLabel(". . . Enjoy your Coffee!");
        l2.setFont(new Font("Serif",Font.ITALIC | Font.BOLD,12));
        l2.setForeground(Color.orange);
        l2.setBounds(190,27,150,15);
        P1.add(l2);




        //panel 2 component

        b1 = new JButton("Back");
        b1.setFont(new Font("Serif",Font.PLAIN,22));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.decode("#C40C0C"));
        b1.setBounds(50,445,120,40);
        b1.addActionListener(this);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        P2.add(b1);


        b2 = new JButton("Confirm");
        b2.setFont(new Font("Serif",Font.PLAIN,24));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.decode("#084d26"));
        b2.setBounds(805,445,120,40);
        b2.addActionListener(this);
        b2.setFocusable(false);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        P2.add(b2);



        //label

        l3 = new JLabel("Complete your payment");
        l3.setFont(new Font("Serif",Font.BOLD,32));
        l3.setOpaque(true);
        l3.setBackground(new Color(253, 247, 239));
        l3.setBounds(310,60,380,40);
        P2.add(l3);

        l4 = new JLabel("We accept : ");
        l4.setFont(new Font("Serif",Font.BOLD,20));
        l4.setOpaque(true);
        l4.setBackground(new Color(253, 247, 239));
        l4.setBounds(190,140,110,30);
        P2.add(l4);


        //radio button
		l5 = new JLabel("Bkash");
		l5.setFont(new Font("Serif", Font.PLAIN, 18));
		l5.setBounds(340, 150, 60, 20); // Position it beside the Bkash radio button
		P2.add(l5);

        //bkash
        b3 = new JRadioButton();
        b3.setBounds(320, 150, 20, 20);
        b3.setBackground(new Color(253, 247, 239));
        b3.setCursor(cursor);
        P2.add(b3);


        //l5= new JLabel(new ImageIcon(getClass().getResource("C:\Users\Lenovo\Desktop\8AM\Caffa Coffee House\images\payment\bkash_1.png")));
		//l5= new JLabel(new ImageIcon(getClass().getResource("./images/payment/bkash_1.png")));
		//"C:\Users\Lenovo\Desktop\8AM\Caffa Coffee House\images\payment\bkash_1.png"
       // l5.setBounds(340, 130, 110, 70);
       // P2.add(l5);
		


        //rocket
		l7 = new JLabel("Nogod");
		l7.setFont(new Font("Serif", Font.PLAIN, 18));
		l7.setBounds(660, 150, 60, 20); // Position it beside the Nogod radio button
		P2.add(l7);
		
        b4 = new JRadioButton();
        b4.setBounds(475, 150, 20, 20);
        b4.setBackground(new Color(253, 247, 239));
        b4.setCursor(cursor);
        P2.add(b4);


       // l6= new JLabel(new ImageIcon(getClass().getResource("C:\Users\Lenovo\Desktop\8AM\Caffa Coffee House\images\payment\rocket.png")));
		//l6= new JLabel(new ImageIcon(getClass().getResource("./images/payment/rocket.png")));
        //l6.setBounds(495, 130, 110, 70);
        //P2.add(l6);



        //nogod
		l6 = new JLabel("Rocket");
		l6.setFont(new Font("Serif", Font.PLAIN, 18));
		l6.setBounds(495, 150, 60, 20); // Position it beside the Rocket radio button
		P2.add(l6);
		
        b5 = new JRadioButton();
        b5.setBounds(640, 150, 20, 20);
        b5.setBackground(new Color(253, 247, 239));
        b5.setCursor(cursor);
        P2.add(b5);


        //l7= new JLabel(new ImageIcon(getClass().getResource("C:\Users\Lenovo\Desktop\8AM\Caffa Coffee House\images\payment\nogod.jpg")));
		//l7= new JLabel(new ImageIcon(getClass().getResource("./images/payment/nogod.jpg")));
		//"C:\Users\Lenovo\Desktop\8AM\Caffa Coffee House\images\payment\nogod.jpg"
        //l7.setBounds(665, 130, 110, 70);
        //P2.add(l7);


        ButtonGroup group = new ButtonGroup();
        group.add(b3);
        group.add(b4);
        group.add(b5);


        //mobile number
        l8 = new JLabel("Number : ");
        l8.setFont(new Font("Serif",Font.BOLD,21));
        l8.setOpaque(true);
        l8.setBackground(new Color(253, 247, 239));
        l8.setBounds(250,270,160,30);
        P2.add(l8);

        t1 = new JTextField();
        t1.setFont(new Font("Serif",Font.PLAIN,21));
        t1.setBounds(420,275,220,28);
        P2.add(t1);



        //password
        l9 = new JLabel("Password : ");
        l9.setFont(new Font("Serif",Font.BOLD,21));
        l9.setOpaque(true);
        l9.setBackground(new Color(253, 247, 239));
        l9.setBounds(250,320,160,30);
        P2.add(l9);

        p1 = new JPasswordField();
        p1.setFont(new Font("Serif",Font.PLAIN,17));
        p1.setEchoChar('*');
        p1.setBounds(420,325,220,28);
        P2.add(p1);




        //checkbox
        c1 = new JCheckBox("Show password");
        c1.setFont(new Font("Serif",Font.PLAIN,16));
        c1.setForeground(Color.black);
        c1.setBackground(new Color(253, 247, 239));
        c1.setBounds(415,355,270,38);
        c1.addActionListener(this);
        c1.setFocusable(false);
        c1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        P2.add(c1);




        //this.add(P1);
        this.add(P2);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){



        //checking  if payment method is selected or not  &&   textfield are filled or not

        if (ae.getSource()==b2)
        {
            if(!(b3.isSelected() || b4.isSelected() || b5.isSelected()))
            {

                JOptionPane.showMessageDialog(this," Please select a payment method");

            }

            else if(t1.getText().length() <=0 || p1.getText().length() <=0){
                JOptionPane.showMessageDialog(this,"Mobile number or Password is missing!");
            }
            else
            {
                JOptionPane.showMessageDialog(this," PAYMENT COMPLETE !!");

                this.setVisible(false);
                new Token();
            }



        }
        else if (ae.getSource()==b1)
        {
            this.setVisible(false);
            double[] prices = {150.0, 200.0, 300.0, 400.0, 500.0, 800.0, 850.0, 1500.0};
        	new Cart1(prices);
        }
        // showing password
        else if(c1.isSelected()){
            p1.setEchoChar((char)0);
        }
        else{
            p1.setEchoChar('*');

        }


    }
    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() ==b1 )
        {
            b1.setBackground(new Color(0,0,0));

        }
        else if(me.getSource() == b2)
        {
            b2.setBackground(new Color(245,0,0));

        }


    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() ==b1 )
        {
            b1.setBackground(Color.decode("#053018"));

        }
        else if(me.getSource() == b2)
        {
            b2.setBackground(Color.decode("#C40C0C"));

        }
    }



}
