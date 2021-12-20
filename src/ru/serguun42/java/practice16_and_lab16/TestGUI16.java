package ru.serguun42.java.practice16_and_lab16;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class ManagingUI extends JFrame {
    private final Font defaultFont = new Font("Roboto", Font.PLAIN, 14);
    private final BorderLayout layout = new BorderLayout();
    private final JPanel centerPanel = new JPanel();

    public void selectManagerTypeView() {
        this.centerPanel.removeAll();
        this.centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        JButton buttonTables = new JButton("Tables orders");
        buttonTables.setFont(defaultFont);
        buttonTables.addActionListener((e) -> this.managerView(new TableOrdersManager(), "Tables"));
        this.centerPanel.add(buttonTables, gridBagConstraints);

        JButton buttonInternet = new JButton("Internet orders");
        buttonInternet.setFont(defaultFont);
        buttonInternet.addActionListener((e) -> this.managerView(new InternetOrdersManager()));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        this.centerPanel.add(buttonInternet, gridBagConstraints);

        this.centerPanel.repaint();
        this.setVisible(true);
    }

    public void managerView(OrdersManager ordersManager) {
        this.managerView(ordersManager, ordersManager.getClass().getSimpleName());
    }

    public void managerView(OrdersManager ordersManager, String title) {
        super.setTitle(title);

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        this.centerPanel.removeAll();
        this.centerPanel.add(boxPanel);

        JLabel quantityLabel = new JLabel("Orders quantity – " + ordersManager.ordersQuantity());
        quantityLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        boxPanel.add(quantityLabel);

        JLabel costLabel = new JLabel("All orders total cost – $" + ordersManager.ordersCostSummary());
        costLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        boxPanel.add(costLabel);

        JButton addOrderButton = new JButton("Add order");
        addOrderButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        addOrderButton.setFont(defaultFont);
        addOrderButton.addActionListener((e) ->
                this.orderView(
                        ordersManager,
                        ordersManager instanceof InternetOrdersManager ? new InternetOrder() : new TableOrder()
                )
        );
        boxPanel.add(addOrderButton);

        this.centerPanel.repaint();
        this.setVisible(true);
    }

    public void orderView(OrdersManager ordersManager, Order order) {
        super.setTitle("Adding order to " + ordersManager.getClass().getSimpleName());

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        this.centerPanel.removeAll();
        this.centerPanel.add(boxPanel);

        JLabel orderCost = new JLabel("Order cost – $" + order.costTotal());
        orderCost.setAlignmentX(JButton.CENTER_ALIGNMENT);
        boxPanel.add(orderCost);

        JLabel previouslyOrderedCounter = new JLabel(
                order.itemsQuantity() == 0 ?
                        "No items in order yet"
                        :
                        order.itemsQuantity() + " items in order:"
        );

        previouslyOrderedCounter.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        boxPanel.add(previouslyOrderedCounter);

        for (MenuItem item : order.getItems()) {
            JLabel previouslyOrderedLabel = new JLabel(item.toString());
            previouslyOrderedLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            previouslyOrderedLabel.setFont(defaultFont);
            boxPanel.add(previouslyOrderedLabel);
        }

        JButton addDish = new JButton("Add dish");
        addDish.setAlignmentX(JButton.CENTER_ALIGNMENT);
        addDish.setFont(defaultFont);
        addDish.addActionListener((e) -> this.addDish(ordersManager, order));
        boxPanel.add(addDish);

        JButton addDrink = new JButton("Add drink");
        addDrink.setAlignmentX(JButton.CENTER_ALIGNMENT);
        addDrink.setFont(defaultFont);
        addDrink.addActionListener((e) -> this.addDrink(ordersManager, order));
        boxPanel.add(addDrink);

        JButton finalizeOrderButton = new JButton("Finalize");
        finalizeOrderButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        finalizeOrderButton.setFont(defaultFont);
        finalizeOrderButton.addActionListener((e) -> this.finalizeOrder(ordersManager, order));
        boxPanel.add(finalizeOrderButton);

        this.centerPanel.repaint();
        this.setVisible(true);
    }

    public void addDish(OrdersManager ordersManager, Order order) {
        order.add(new Dish("Simple dish", "Гренка не может стоить 8 долларов, а крутон может", 8));

        this.orderView(ordersManager, order);
    }

    public void addDrink(OrdersManager ordersManager, Order order) {
        order.add(new Drink("Water", "Much wet", DrinkEnumType.WATER, 1));

        this.orderView(ordersManager, order);
    }

    public void finalizeOrder(OrdersManager ordersManager, Order order) {
        if (ordersManager instanceof InternetOrdersManager) {
            ((InternetOrdersManager) ordersManager).add(order);
            this.managerView(ordersManager);
        } else if (ordersManager instanceof TableOrdersManager) {
            super.setTitle("Finalizing order");

            JPanel boxPanel = new JPanel();
            boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

            this.centerPanel.removeAll();
            this.centerPanel.add(boxPanel);

            StringBuilder freeTableNumbersSB = new StringBuilder();
            int[] freeTableNumbers = ((TableOrdersManager) ordersManager).freeTableNumbers();
            for (int number : freeTableNumbers)
                freeTableNumbersSB.append(number + ", ");

            JLabel freeTables = new JLabel("<html><p>Free tables for placing order:</p><p width=\"500px\">" + freeTableNumbersSB + "</p></html>");
            freeTables.setAlignmentX(JButton.CENTER_ALIGNMENT);
            boxPanel.add(freeTables);

            JLabel chooseLabel = new JLabel("Choose table from above");
            chooseLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            chooseLabel.setBorder(new EmptyBorder(50, 0, 0, 0));
            boxPanel.add(chooseLabel);

            JTextField textField = new JTextField();
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setBounds(0, 0, 300, 30);
            textField.setFont(defaultFont);
            boxPanel.add(textField);

            JButton finalizeOrderButton = new JButton("Submit order");
            finalizeOrderButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            finalizeOrderButton.setFont(defaultFont);
            finalizeOrderButton.addActionListener((e) -> {
                try {
                    int tableToSet = Integer.parseInt(textField.getText());

                    if (tableToSet < 0) throw new NumberFormatException("Too low");

                    ((TableOrdersManager) ordersManager).remove(tableToSet);
                    ((TableOrdersManager) ordersManager).add(order, tableToSet);

                    this.managerView(ordersManager);
                } catch (Exception exc) {
                    System.out.println("Caught exception");
                }
            });
            boxPanel.add(finalizeOrderButton);

            this.centerPanel.repaint();
            this.setVisible(true);
        }
    }

    ManagingUI() {
        super("Orders managing system");
        this.setFont(defaultFont);

        this.setLayout(this.layout);
        this.getContentPane().add(this.centerPanel, BorderLayout.CENTER);

        this.selectManagerTypeView();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
}

public class TestGUI16 {
    public static void main(String[] args) {
        new ManagingUI();
    }
}
