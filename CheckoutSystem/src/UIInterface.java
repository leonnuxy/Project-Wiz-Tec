import javax.swing.*;
import java.awt.*;
 
public class UIInterface extends JFrame {
    // UI Interface
    // Holds 6 botton aligned to the left of the window
    // Holds a Text area aligned to the top-right of the window
    // Text area is meant to display the current transaction
    // Buttons are meant to add products to the current transaction
    // Buttons are meant to save the current transaction
    // Buttons are meant to cancel the current transaction
    // Text label is meant to display the subtotal
    // Text label is meant to display the tax
    // Text label is meant to display the total
    
    GridLayout labelLayout = new GridLayout(1, 1);
    GridLayout buttonLayout = new GridLayout(5, 6);
    GridLayout textArearLayout = new GridLayout(1, 2);

    Transaction transaction = new Transaction();
    ProductCatalog productCatalog = new ProductCatalog();
    TransactionManager transactionManager = new TransactionManager(transaction);

    private final static String newline = "\n";
    private String product1 = productCatalog.getProductName(0);
    private String product2 = productCatalog.getProductName(1);
    private String product3 = productCatalog.getProductName(2);
    private String product4 = productCatalog.getProductName(3);
    private String product5 = productCatalog.getProductName(4);
    private String product6 = productCatalog.getProductName(5);
    private String product7 = productCatalog.getProductName(6);
    private String product8 = productCatalog.getProductName(7);
    private String product9 = productCatalog.getProductName(8);
    private String product10 = productCatalog.getProductName(9);


    public UIInterface(String title) {
        super(title);
        setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        // Set up Components
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300, 300));
        buttonPanel.setLayout(buttonLayout);
        
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setPreferredSize(new Dimension(300, 300));
        textAreaPanel.setLayout(textArearLayout);
        
        JPanel labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(50, 50));
        labelPanel.setLayout(labelLayout);

        // Create a JButton
        JButton button1 = new JButton(product1);
        JButton button2 = new JButton(product2);
        JButton button3 = new JButton(product3);
        JButton button4 = new JButton(product4);
        JButton button5 = new JButton(product5);
        JButton button6 = new JButton(product6);
        JButton button7 = new JButton(product7);
        JButton button8 = new JButton(product8);
        JButton button9 = new JButton(product9);
        JButton button10 = new JButton(product10);

        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        
        // Create a JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Current Transaction" + newline);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(200, 200));
        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        textArea.setAlignmentY(Component.TOP_ALIGNMENT);

        // Create a JLabel
        JLabel label1 = new JLabel("Subtotal: ");
        label1.setSize(5, 10);
        JLabel label2 = new JLabel("Tax: ");
        label2.setSize(5, 10);
        JLabel label3 = new JLabel("Total: ");
        label3.setSize(5, 10);

        // Add the JButton to the JPanel
        buttonPanel.add(button1); buttonPanel.add(button2);
        buttonPanel.add(button3); buttonPanel.add(button4);
        buttonPanel.add(button5); buttonPanel.add(button6);
        buttonPanel.add(button7); buttonPanel.add(button8);
        buttonPanel.add(button9); buttonPanel.add(button10);

        textAreaPanel.add(textArea);

        labelPanel.add(label1);
        labelPanel.add(label2);
        labelPanel.add(label3);

        labelPanel.add(saveButton);
        labelPanel.add(cancelButton);

        // Process Button Press For Products 1-10 and Save/Cancel Buttons
        button1.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(0));
            textArea.append(productCatalog.getProductDisplay(0) + newline);
            updateLabels(label1, label2, label3);
        });

        button2.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(1));
            textArea.append(productCatalog.getProductDisplay(1) + newline);
            updateLabels(label1, label2, label3);
        });

        button3.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(2));
            textArea.append(productCatalog.getProductDisplay(2) + newline);
            updateLabels(label1, label2, label3);
        });

        button4.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(3));
            textArea.append(productCatalog.getProductDisplay(3) + newline);
            updateLabels(label1, label2, label3);
        });

        button5.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(4));
            textArea.append(productCatalog.getProductDisplay(4) + newline);
            updateLabels(label1, label2, label3);
        });

        button6.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(5));
            textArea.append(productCatalog.getProductDisplay(5) + newline);
            updateLabels(label1, label2, label3);
        });

        button7.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(6));
            textArea.append(productCatalog.getProductDisplay(6) + newline);
            updateLabels(label1, label2, label3);
        });

        button8.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(7));
            textArea.append(productCatalog.getProductDisplay(7) + newline);
            updateLabels(label1, label2, label3);
        });

        button9.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(8));
            textArea.append(productCatalog.getProductDisplay(8) + newline);
            updateLabels(label1, label2, label3);
        });

        button10.addActionListener(e -> {
            transactionManager.addProduct(productCatalog.getProduct(9));
            textArea.append(productCatalog.getProductDisplay(9) + newline);
            updateLabels(label1, label2, label3);
        });

        saveButton.addActionListener(e -> {
            transactionManager.saveTransaction(transaction);
            textArea.append("Transaction Saved" + newline);
        });

        cancelButton.addActionListener(e -> {
            transactionManager.cancelTransaction();
            textArea.setText("Current Transaction" + newline);
            label1.setText("Subtotal: ");
            label2.setText("Tax: ");
            label3.setText("Total: ");
        });

        // Add the JPanel to the JFrame
        pane.add(buttonPanel, BorderLayout.NORTH);
        pane.add(textAreaPanel, BorderLayout.CENTER);
        pane.add(labelPanel, BorderLayout.SOUTH);
    }

    private void updateLabels(JLabel label1, JLabel label2, JLabel label3) {
        label1.setText("Subtotal: " + transaction.getSubtotal());
        label2.setText("Tax: " + transaction.getTax());
        label3.setText("Total: " + transaction.getTotal());
    }

}