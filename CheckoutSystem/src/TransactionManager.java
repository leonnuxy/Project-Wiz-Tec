
public class TransactionManager  {

    private Transaction transaction;

    public TransactionManager(Transaction transaction) {
        this.transaction = transaction;
    }

    public void addProduct(Products product) {
        transaction.addProduct(product);
    }

    public void removeProduct(int index) {
        transaction.removeProduct(index);
    }

    public Products getProduct(int index) {
        return transaction.getProduct(index);
    }

    public String getProductTax(int index) {
        return transaction.getProductTax(index);
    }

    public double getSubtotal() {
        return transaction.getSubtotal();
    }

    public void cancelTransaction() {
        transaction.cancelTransaction();
    }

    public void saveTransaction(Transaction transaction) {
        transaction.saveTransaction();
    }

    public void print(Object object) {
        System.out.println(object);
    }
}
