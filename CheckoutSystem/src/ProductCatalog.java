/*
    There should be at least 10 different products, each with their own price,
    option to apply a 10% VAT tax, and belonging to 1 of 3 groups.
*/

public class ProductCatalog  {

    private Products[] products = new Products[10];
    private int productCount = 0;

    public ProductCatalog() {
        products[0] = new Products("Apple", "Produce", "Yes", 10.00);
        products[1] = new Products("Orange", "Produce", "Yes", 10.00);
        products[2] = new Products("Chips", "Sundries", "No", 5.00);
        products[3] = new Products("Washer-Fluid", "Vehicle", "Yes", 3.00);
        products[4] = new Products("Coke", "Beverage", "No", 2.00);
        products[5] = new Products("Pepsi", "Beverage", "No", 2.00);
        products[6] = new Products("Coke Zero", "Beverage", "No", 2.00);
        products[7] = new Products("Sprite", "Beverage", "No", 2.00);
        products[8] = new Products("Lays", "Candy", "No", 1.00);
        products[9] = new Products("Snickers", "Candy", "No", 1.00);
        productCount = 10;
    }

    public String getProductName(int index) {
        return products[index].getProductName();
    }

    // Gets the number of products in the catalog
    public int getProductCount() {
        return productCount;
    }

    // Gets a product and price
    public String getProductDisplay(int index) {
        return products[index].getProductDisplayNamePrice();
    }

    public Products getProduct(int index) {
        return products[index];
    }
    
    // Adds a product to the catalog
    public void addProduct(Products product) {
        products[productCount] = product;
        productCount++;
    }

    // Removes a product from the catalog
    public void removeProduct(int index) {
        for (int i = index; i < productCount; i++) {
            products[i] = products[i + 1];
        }
        productCount--;
    }
}
