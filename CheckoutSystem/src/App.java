import javax.swing.JFrame;

/* 
    - An interface showing products, the transaction, subtotal amount, tax amount, 
        the final amount, a cancel/void button, and a save/export button. 
    - An example layout is as follows but you’re free to create it as you see fit
        There must be at least 10 different products, each with their own price, 
        option to apply a 10% VAT tax, and belonging to 1 of 3 groups. 
    - You are free to decide what the products, groups, and prices are. 
    - An example of products and groups might be: apple/produce/tax=yes, 
        orange/produce/tax=yes, chips/sundries/tax=no, windshield fluid/vehicle/tax=yes, etc
    - When a product is selected, it is added to the current transaction. 
    - The transaction must support up to 10 different products, 
        listing product and price, and calculating subtotal, VAT, and total
    - A cancel or void button which, when pressed, clears and restarts the sale
    - A save or export button which, when pressed, saves or exports the current 
        transaction in a JSON, XML, or text format.
*/

public class App {

    public App () {
        // Create a Simple UI Interface for the application
        UIInterface simpleUIInterface = new UIInterface("Simple UI Interface");
        simpleUIInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simpleUIInterface.addComponentsToPane(simpleUIInterface.getContentPane());

        simpleUIInterface.setSize(800, 800);
        simpleUIInterface.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
