import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {

    private double total;
    private double tax;
    private Products[] products;
    private String[] productTax;

    public Transaction() {
        this.products = new Products[20];
        this.productTax = new String[20];
    }

    public void removeProduct(int index) {
        products[index] = null;
    }

    public void addProduct(Products product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
    }

    public Products getProduct(int index) {
        System.out.println(products[index]);
        return products[index];
    }

    public String getProductTax(int index) {
        return productTax[index];
    }

    public double getSubtotal() {
        total = 0;
        for (Products product : products) {
            if (product != null) {
                total += product.getProductPrice();
            }
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public double getTax() {
        tax = 0;
        for (Products product : products) {
            if (product != null) {
                if (product.getProductTax().equals("Yes"))
                    tax += product.getProductPrice() * 0.10;
            }
        }
        tax = Math.ceil(tax * 100) / 100;
        return tax;
    }

    public double getTotal() {
        return Math.ceil((getSubtotal() + getTax()) * 100) / 100;
    }

    public void saveTransaction() {

        File file = new File("transaction.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Transactions " + "\n");
            for (Products product : products) {
                if (product != null) {
                    writer.write(product.getProductName() + "............." + product.getProductPrice() + "\n");
                }
            }

            writer.write("\n");
            writer.write("Subtotal: " + getSubtotal() + "\n");
            writer.write("Tax: " + getTax() + "\n");
            writer.write("Total: " + getTotal() + "\n");
            writer.close();

            // Check if System is Windows or Mac
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cmd /c start transaction.txt");
            } else if (os.contains("Mac")) {
                String[] cmd = { "/bin/sh", "-c", "open transaction.txt" };
                Runtime.getRuntime().exec(cmd);
            } else if (os.contains("Linux")) {
                System.out.println("Not Tested Yet");
                Runtime.getRuntime().exec("xdg-open transaction.txt");
            } else {
                System.out.println(" Sorry Not Invented Yet ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelTransaction() {
        for (int i = 0; i < products.length; i++)
            removeProduct(i);

        total = 0;
        tax = 0;
    }

}
