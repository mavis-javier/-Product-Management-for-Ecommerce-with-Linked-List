// Creates Product class that implements IDedObject 
public class Product implements IDedObject {
    // private variables
    private int productID;
    private String productName;
    private String supplierName;

    // method implementations
    // prints all information for given ID
    @Override
    public void printID() {
        System.out.println(productID + "\n" + productName + "\n" + supplierName);
    }

    @Override
    public int getID() {
        return productID;
    }

    public void setID(int productID) {
        this.productID = productID;
    }

    public void setProd(String productName) {
        this.productName = productName;
    }

    public void setSup(String supplierName) {
        this.supplierName = supplierName;
    }

    public String toString() {
        return  productID + "\n" + productName + "\n" + supplierName + "\n" ;
    }
}