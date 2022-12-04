package Product;

import KhachHang.tradingHistory;
import Product.StoreHouse;

/**
 * NhanVienIF
 */
public interface NhanVienIF {
    public boolean themSP(StoreHouse Store);
    public void hienThiKho(StoreHouse Store);
    public void timKiemSanPham(StoreHouse Store);
    public boolean SuaSanPham(StoreHouse Store);
    public boolean xoaSP(StoreHouse Store);
    public void hienThiLS(tradingHistory tradingHistory);
    public boolean ThongKe(tradingHistory tradingHistory);
}