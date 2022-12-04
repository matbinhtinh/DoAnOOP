package KhachHang;

import Product.Product;

public class Order {
    static int Quantity = 0;
    private int orderID;
    private String productID;
    private String Name;
    private int price;
    private int orderQuantity;
    private int money;
    private int realPrice;
    private String unit;
    private int costMoney;

    // Constructor
    public Order() {
        Quantity = Quantity + 1;
        setOrderID(Quantity);
    }

    // getter and setter

    public static int getQuantity() {
        return Quantity;
    }

    public static void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setOrder(Product orderProduct, int orderquantity) {
        setProductID(orderProduct.getID());
        setOrderQuantity(orderquantity);
        setName(orderProduct.getName());
        setPrice(orderProduct.getProductPrice().getGiaBan());
        setRealPrice(orderProduct.getProductPrice().getGiaNhap(true));
        setUnit(orderProduct.getProductPrice().getDonViTinh());
        double temp = orderquantity * orderProduct.getProductPrice().getGiaBan();
        setMoney( orderquantity * orderProduct.getProductPrice().getGiaBan());
        setCostMoney( orderquantity * orderProduct.getProductPrice().getGiaNhap(true));
    }

    @Override
    public String toString() {
        return String.format("|%-10d|%-15s|%-20s|%10d|", orderID, productID, Name, orderQuantity);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(int realPrice) {
        this.realPrice = realPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(int costMoney) {
        this.costMoney = costMoney;
    }

}
