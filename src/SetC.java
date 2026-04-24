import javax.swing.*;
import java.awt.*;

public class SetC extends JFrame {
    JTextField customerField, quantityFied;
    JComboBox<String> productComboBox;
    JCheckBox extraCheese, noOnions, spicy, addDrink;
    JButton orderButton;

    SetC() {
        setTitle("Restaurant Order Form");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Name Section
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Customer Name:"), gbc);
        customerField = new JTextField(15);
        gbc.gridx = 1;
        add(customerField, gbc);

        // Product Selection Section
        String[] products = { "Burger", "Pizza", "Pasta", "Salad", "Steak" };
        productComboBox = new JComboBox<>(products);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Select Product:"), gbc);
        gbc.gridx = 1;
        add(productComboBox, gbc);

        // Quantity Section
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Quantity:"), gbc);
        quantityFied = new JTextField(15);
        gbc.gridx = 1;
        add(quantityFied, gbc);

        // Add-ons Section
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Add-ons:"), gbc);
        JPanel addOnsPanel = new JPanel();

        extraCheese = new JCheckBox("Extra Cheese");
        noOnions = new JCheckBox("No Onions");
        spicy = new JCheckBox("Spicy");
        addDrink = new JCheckBox("Add Drink");

        addOnsPanel.add(extraCheese);
        addOnsPanel.add(noOnions);
        addOnsPanel.add(spicy);
        addOnsPanel.add(addDrink);

        gbc.gridx = 1;
        add(addOnsPanel, gbc);

        // Order Button
        orderButton = new JButton("Place Order");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(orderButton, gbc);

        orderButton.addActionListener(e -> {
            String name = customerField.getText();
            String menuProduct = (String) productComboBox.getSelectedItem();
            String quantityText = quantityFied.getText();
            StringBuilder addonsOrder = new StringBuilder();

            if (extraCheese.isSelected()) {
                addonsOrder.append("Extra Cheese, ");
            }
            if (noOnions.isSelected()) {
                addonsOrder.append("No Onions, ");
            }
            if (spicy.isSelected()) {
                addonsOrder.append("Spicy, ");
            }
            if (addDrink.isSelected()) {
                addonsOrder.append("Add Drink, ");
            }

            if (addonsOrder.length() > 0) {
                addonsOrder.setLength(addonsOrder.length() - 2); // Remove trailing comma and space
            } else {
                addonsOrder.append("None");
            }

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the customer's name.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (quantityText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the quantity.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a positive integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price = 0;

            if (productComboBox.getSelectedItem().equals("Burger")) {
                price += 120.5;
            } else if (productComboBox.getSelectedItem().equals("Pizza")) {
                price += 350.0;
            } else if (productComboBox.getSelectedItem().equals("Pasta")) {
                price += 250.0;
            } else if (productComboBox.getSelectedItem().equals("Salad")) {
                price += 180.0;
            } else if (productComboBox.getSelectedItem().equals("Steak")) {
                price += 500.0;
            }

            if (extraCheese.isSelected()) {
                price += 30;
            }

            if (noOnions.isSelected()) {
                price += 20;
            }

            if (spicy.isSelected()) {
                price += 25;
            }

            if (addDrink.isSelected()) {
                price += 50;
            }

            double totalPrice = price * quantity;
            JOptionPane.showMessageDialog(this,
                    "Order Summary:\nCustomer Name: " + name + "\nProduct: " + menuProduct + "\nQuantity: " + quantity
                            + "\nAdd-ons: " + addonsOrder + "\nTotal Price: " + totalPrice,
                    "Order Placed", JOptionPane.INFORMATION_MESSAGE);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SetC());
    }
}
