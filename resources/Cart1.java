package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cart1 implements MouseListener,ActionListener
{
    // Variables for tracking total and discount
    double totalAmount = 0;
    double discount = 0;
    JTextField promoField = new JTextField(15);
    JLabel totalLabel = new JLabel("Total: Tk 0.00");

    // Declare buttons at class level so they can be accessed in actionPerformed
    //Container cart;
    JButton applyPromoButton, btnClear, bkButton, confirmButton, exitButton;
    JButton[] plusButtons, minusButtons;
    JLabel[] quantityLabels;
    String[] productNames = {"Dark Coffee", "Latte Macchiato", "Cafe Latte", "Cappuccino", "Cafe An Lait", "Flat White", "Frappe", "Frappuccino"};
    double[] productPrices;
    int[] quantities;
    JFrame frame;
    JPanel cartPanel;
    JButton adminButton;

    public Cart1(double[] prices) {


        // Initialize product prices from parameter
        this.productPrices = prices;

        // Frame settings
        frame = new JFrame("Shopping Cart");
        frame.setSize(1000, 562);
        frame.setBackground(new Color(218,227,243));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

		frame.setIconImage(new ImageIcon("./images/token/icon.png").getImage());



        // Main Shopping Cart Panel
        cartPanel = new JPanel();
        cartPanel.setLayout(null);
        //cartPanel.setBackground(new Color(218,227,243));
        cartPanel.setBackground(new Color(253, 247, 239));

        // cursor
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        // Initialize product quantity and labels
        quantities = new int[productNames.length];
        plusButtons = new JButton[productNames.length];
        minusButtons = new JButton[productNames.length];
        quantityLabels = new JLabel[productNames.length];


        // Create labels, + and - buttons for each product
        for (int i = 0; i < productNames.length; i++)
			{
            // Creating the product name label with price
            JLabel productLabel = new JLabel(productNames[i] + " (Tk " + productPrices[i] + ")");

            // Set custom font style for the product name
            productLabel.setFont(new Font("Calibri", Font.BOLD, 18));  // Setting font to Calibri, Bold, size 18

            // Set bounds and add to panel
            productLabel.setBounds(50, 50 + i * 40, 200, 30);
            cartPanel.add(productLabel);

            minusButtons[i] = new JButton("-");
            minusButtons[i].setBounds(360, 50 + i * 40, 45, 30);
            minusButtons[i].setActionCommand("minus" + i);
            minusButtons[i].addActionListener(this);
            minusButtons[i].setFocusable(false);
            cartPanel.add(minusButtons[i]);

            quantityLabels[i] = new JLabel("0");
            quantityLabels[i].setBounds(410, 50 + i * 40, 50, 30);
            cartPanel.add(quantityLabels[i]);

            plusButtons[i] = new JButton("+");
            plusButtons[i].setBounds(460, 50 + i * 40, 45, 30);
            plusButtons[i].setActionCommand("plus" + i);
            plusButtons[i].addActionListener(this);
            plusButtons[i].setFocusable(false);
            cartPanel.add(plusButtons[i]);
        }




        // Promo Code Label
        JLabel promoCodeLabel = new JLabel("Promo Code");
        promoCodeLabel.setFont(new Font("Calibri", Font.BOLD, 20));  // Set font to Calibri
        promoCodeLabel.setForeground(Color.black);
        promoCodeLabel.setBounds(710, 190, 120, 30);
        cartPanel.add(promoCodeLabel);

        // Promo Code Text Field
        promoField.setFont(new Font("Calibri", Font.PLAIN, 20));  // Set font to Calibri
        promoField.setBounds(830, 190, 100, 28);
        cartPanel.add(promoField);

        // Apply Button
        applyPromoButton = new JButton("APPLY");
        applyPromoButton.setFont(new Font("Calibri", Font.BOLD, 20));  // Set font to Calibri
        applyPromoButton.setForeground(Color.WHITE);
        applyPromoButton.setBackground(Color.decode("#053018"));
        applyPromoButton.setCursor(cursor);
        applyPromoButton.setBounds(830, 240, 100, 25);
        applyPromoButton.addActionListener(this);
        applyPromoButton.setFocusable(false);
        applyPromoButton.setBorder(null);
        applyPromoButton.addMouseListener(this);
        cartPanel.add(applyPromoButton);

        // Clear Button beside Apply Button
        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Calibri", Font.BOLD, 20));  // Set font to Calibri
        btnClear.setForeground(Color.WHITE);
        btnClear.setBackground(Color.decode("#C40C0C"));
       // btnClear.setForeground(Color.black);
        btnClear.setCursor(cursor);
        btnClear.setBounds(630, 445, 135, 40);
        btnClear.addActionListener(this);
        btnClear.setFocusable(false);
        btnClear.setBorder(null);
        btnClear.addMouseListener(this);
        cartPanel.add(btnClear);

        //Back Button
        bkButton = new JButton("Back");
        bkButton.setFont(new Font("Calibri", Font.BOLD, 20));  // Set font to Calibri
        bkButton.setForeground(Color.WHITE);
        bkButton.setBackground(Color.decode("#C40C0C"));
        // btnClear.setForeground(Color.black);
        bkButton.setCursor(cursor);
        bkButton.setBounds(50, 445, 135, 40);
        bkButton.addActionListener(this);
        bkButton.setFocusable(false);
        bkButton.setBorder(null);
        bkButton.addMouseListener(this);
        cartPanel.add(bkButton);

        //Exit Button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri", Font.BOLD, 20));  // Set font to Calibri
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#C40C0C"));
        exitButton.setCursor(cursor);
        exitButton.setBounds(225, 445, 135, 40);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setBorder(null);
        exitButton.addMouseListener(this);
        cartPanel.add(exitButton);


        // Total Amount Label
        totalLabel.setFont(new Font("Calibri", Font.PLAIN, 26));  // Set font to Calibri
        totalLabel.setBounds(780, 280, 240, 50);
        totalLabel.setBorder(null);
        cartPanel.add(totalLabel);

        // Confirm Button
        confirmButton = new JButton("CONFIRM");
        confirmButton.setFont(new Font("Calibri", Font.PLAIN, 20));  // Set font to Calibri
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setBackground(Color.decode("#053018"));//coooooonformmmm
        //confirmButton.setBorder(null);
        confirmButton.setCursor(cursor);
        confirmButton.setBounds(805, 445, 135, 40);
        confirmButton.addActionListener(this);
        confirmButton.setFocusable(false);
        confirmButton.setBorder(null);
        //confirmButton.addMouseListener(this);
        cartPanel.add(confirmButton);




        // Admin Button
        adminButton = new JButton("ADMIN");
        adminButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        adminButton.setForeground(Color.white);
        adminButton.setBackground(Color.LIGHT_GRAY);
        //adminButton.setBorder(null);
        adminButton.setCursor(cursor);
        adminButton.setBounds(805, 50, 135, 40);
        adminButton.addActionListener(this);
        adminButton.setFocusable(false);
        adminButton.setBorder(null);
        adminButton.addMouseListener(this);
        cartPanel.add(adminButton);





        frame.add(cartPanel);
        frame.setVisible(true);

        // Initial total calculation
        updateTotal();
    }

    // Override actionPerformed method to handle button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.startsWith("plus"))
			{
            int index = Integer.parseInt(command.substring(4));
            quantities[index]++;
            quantityLabels[index].setText(String.valueOf(quantities[index]));
            updateTotal(); // Update total on quantity change
        } 
		else if (command.startsWith("minus"))
			
			{
            int index = Integer.parseInt(command.substring(5));
            if (quantities[index] > 0) {
                quantities[index]--;
                quantityLabels[index].setText(String.valueOf(quantities[index]));
                updateTotal(); // Update total on quantity change
            }
        }
		else if (e.getSource() == bkButton){
            frame.setVisible(false);
            new Menu();

        }
		else if (e.getSource() == exitButton){
            System.exit(0);

        } 
		else if (e.getSource() == applyPromoButton)
			{
            // Handle Apply Promo Button action
            String promoCode = promoField.getText();
            if (promoCode.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Wrong promo code!");
            } 
			else 
			{
                // Change promo code to 'NEW' or keep it as 'FAHIM'
                discount = "NEW".equalsIgnoreCase(promoCode) ? totalAmount * 0.10 : 0;
                updateTotal(); // Update total to reflect discount
            }
        } 
		else if (e.getSource() == btnClear) 
		{
            // Handle Clear Button action
            promoField.setText("");
            discount = 0;
            for (int i = 0; i < productNames.length; i++) {
                quantities[i] = 0;
                quantityLabels[i].setText("0");
            }
            updateTotal();
            JOptionPane.showMessageDialog(null, "Cart Cleared");
        } else if (e.getSource() == confirmButton) 
		{
            // Handle Confirm Button actionup
            updateCheckoutSummary();
            int response = JOptionPane.showConfirmDialog(null, "CONTINUE PAYMENT !", "Confirm", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {    new payment();    frame.setVisible(false);}
        } 
		else if (e.getSource()== adminButton ) 
		{

            new AdminLogin();
            /*
            new AdminPanel(productPrices); // Pass the product prices to admin panel
            updateProductLabels(cartPanel);

             */
            frame.setVisible(false);
        }
    }

    // Update the total amount and label
    void updateTotal()
	{
        totalAmount = 0;
        for (int i = 0; i < productNames.length; i++) {
            totalAmount += productPrices[i] * quantities[i];
        }
        totalLabel.setText("Total: Tk " + String.format("%.2f", totalAmount - discount));
    }

    // Update checkout summary
    void updateCheckoutSummary()
	{
        double payableAmount = totalAmount - discount;
        String summary = "TOTAL:                   Tk " + String.format("%.2f", totalAmount) +
                "\nDISCOUNT:              (-" + String.format("%.2f", discount) + ")" +
                "\nPAYABLE TOTAL: Tk " + String.format("%.2f", payableAmount);
        JOptionPane.showMessageDialog(null, summary, "Checkout Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to update product labels based on current prices
    void updateProductLabels(JPanel panel)
	{
        for (int i = 0; i < productNames.length; i++) 
		{
            JLabel productLabel = (JLabel) panel.getComponent(i * 4); // Each product label is every 4th component
            productLabel.setText(productNames[i] + " (Tk " + productPrices[i] + ")");
        }
        updateTotal(); // Update total after changing prices
    }
	
	
	
	
	
    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() ==confirmButton )
        {
            confirmButton.setBackground(new Color(0,0,0));

        }
        else if(me.getSource() == bkButton)
        {
            bkButton.setBackground(new Color(245,0,0));

        }else if(me.getSource() == exitButton)
        {
            exitButton.setBackground(new Color(245,0,0));

        }else if(me.getSource() == btnClear)
        {
            btnClear.setBackground(new Color(245,0,0));

        }else if(me.getSource() == applyPromoButton)
        {
            applyPromoButton.setBackground(new Color(0,0,0));

        }else if(me.getSource() == adminButton)
        {
            adminButton.setBackground(new Color(0,0,0));

        }


    }
	
	
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() ==confirmButton )
        {
            confirmButton.setBackground(Color.decode("#053018"));

        }
        else if(me.getSource() == bkButton)
        {
            bkButton.setBackground(Color.decode("#C40C0C"));

        }else if(me.getSource() == exitButton)
        {
            exitButton.setBackground(Color.decode("#C40C0C"));
            
        }else if(me.getSource() == btnClear)
        {
            btnClear.setBackground(Color.decode("#C40C0C"));

        }else if(me.getSource() == applyPromoButton)
        {
            applyPromoButton.setBackground(Color.decode("#053018"));

        }else if(me.getSource() == adminButton)
        {
            adminButton.setBackground(Color.LIGHT_GRAY);

        }
    }

    
}
