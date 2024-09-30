package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel implements ActionListener {
    private double[] productPrices;
    private JTextField[] priceFields;
    private JFrame frame;

    public AdminPanel(double[] prices) {
        this.productPrices = prices;

        // Frame settings
        frame = new JFrame("Admin Panel");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(prices.length + 1, 2));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setIconImage(new ImageIcon("./images/token/icon.png").getImage());

        priceFields = new JTextField[prices.length];

        // Create fields for each product price
        for (int i = 0; i < prices.length; i++) {
            frame.add(new JLabel("Price for " + getProductName(i) + ":"));
            priceFields[i] = new JTextField(String.valueOf(prices[i]));
            frame.add(priceFields[i]);
        }

        // Update Button
        JButton updateButton = new JButton("Update Prices");
        updateButton.addActionListener(this);
        frame.add(updateButton);

        frame.setVisible(true);
    }

    private String getProductName(int index) {
        String[] productNames = {"Dark Coffee", "Latte Macchiato", "Cafe Latte", "Cappuccino", "Cafe An Lait", "Flat White", "Frappe", "Frappuccino"};
        return productNames[index];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < priceFields.length; i++) {

            productPrices[i] = Double.parseDouble(priceFields[i].getText());
            frame.dispose();
        }
        JOptionPane.showMessageDialog(frame, "Prices updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        new Cart1(productPrices);

    }
}
