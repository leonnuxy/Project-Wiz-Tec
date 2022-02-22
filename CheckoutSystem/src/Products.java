/*
    - You are free to decide what the products, groups, and prices are. 
    - An example of products and groups might be: apple/produce/tax=yes, 
        orange/produce/tax=yes, chips/sundries/tax=no, windshield fluid/vehicle/tax=yes, etc
*/

public class Products {
    
    private String productName;
    private String productGroup;
    private String productTax;
    private double productPrice;
    
    public Products(String productName, String productGroup, String productTax, double productPrice) {
        this.productName = productName;
        this.productGroup = productGroup;
        this.productTax = productTax;
        this.productPrice = productPrice;
    }
    
    // Get Product Name
    public String getProductName() {
        return productName;
    }
    
    public String getProductGroup() {
        return productGroup;
    }
    
    public String getProductTax() {
        return productTax;
    }
    
    public double getProductPrice() {
        if (productTax.equals("Yes")) {
            return productPrice + (productPrice * 0.10);
        } else {
            return productPrice;
        }
    }
    
    public String getProductDisplayNamePrice() {
        return productName + " " + productPrice;
    }

    public void setProductTax(String tax) {
        this.productTax = tax;
    }
} 