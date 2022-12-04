package KhachHang;

import KhachHang.Invoice;
import KhachHang.cart;
import Product.StoreHouse;

public interface KhachHangIF {
    public void FindProduct(StoreHouse Store);
    public boolean addProductToCart(StoreHouse Store);
    public void showCart();
    public boolean updateStore(StoreHouse Store,Invoice invoice);
    public Invoice invoice();

    
}
