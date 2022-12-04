package Product;
/**
 * Product
 */
public abstract class Product {
    protected String ID;
    protected String Name;
    protected Price ProductPrice;
    protected ProductQuantity QuantityProduct;
    protected String Type;

// GETTER AND SETTER
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public Price getProductPrice() {
        return ProductPrice;
    }
    public void setProductPrice(Price productPrice) {
        ProductPrice = productPrice;
    }
    public ProductQuantity getQuantityProduct() {
        return QuantityProduct;
    }
    public void setQuantityProduct(ProductQuantity quantityProduct) {
        QuantityProduct = quantityProduct;
    }
    // abstract method
    public abstract void setProductByEmployee();

    public abstract void setProductByFile(String Data);
    
    public abstract String displayForEmployee();
}