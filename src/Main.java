import java.io.File;
import java.util.Scanner;
import KhachHang.*;
import Product.*;

public class Main {
    // ham lay dia chi cua chuong trinh
    public static String getPath(){
        String path = "";
        try {
            File file = new File("getpath.txt");
            path= file.getAbsolutePath();
            file.deleteOnExit();;
            String[] split = path.split("\\\\");
            path = "";
            for(int i = 0;i<split.length-1;i++){
                path = path +split[i]+"\\\\";
            }
    
            } catch (Exception e) {
                // TODO: handle exception
            }
        return path;
    }
// main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = Main.getPath();
        StoreHouse.setPathThuoc(path+"Data////thuoc.csv");
        StoreHouse.setPathDungCuYTe(path+"Data////dungcuyte.csv");
        StoreHouse Store = new StoreHouse();
        tradingHistory tradingHistory = new tradingHistory();
        NhanVienIF NhanVien = new NhanVien();
        boolean active = true;
        while (active) {
            System.out.println("---------Quan Ly Cua Hang Thuoc--------");
            System.out.println("1.Nhan Vien");
            System.out.println("2.Khach hang");
            System.out.println("3.Thoat");
            System.out.print("Lua chon cua ban : ");
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    while (active) {
                        System.out.println("-----Danh Muc----");
                        System.out.println("1.Them san pham moi ");
                        System.out.println("2.Hien thi kho hang");
                        System.out.println("3.Tim kiem san pham");
                        System.out.println("4.Xoa san pham");
                        System.out.println("5.Sua san pham");
                        System.out.println("6.Xem lich su ban hang");
                        System.out.println("7.Tinh Doanh Thu");
                        System.out.println("8.Tro lai");
                        System.out.print("Nhap lua chon cua ban : ");
                        choose = sc.nextLine();
                        switch (choose) {
                            case "1":
                                if (NhanVien.themSP(Store)) {
                                    System.out.println("-----Them San Pham Thanh Cong----");
                                }
                                break;
                            case "2":
                                NhanVien.hienThiKho(Store);
                                break;
                            case "3":
                                NhanVien.timKiemSanPham(Store);
                                break;
                            case "4":
                                if (NhanVien.xoaSP(Store)) {
                                    System.out.println("-----Xoa San Pham Thanh Cong----");
                                }
                                break;
                            case "5":
                                if (NhanVien.SuaSanPham(Store)) {
                                    active = false;
                                }
                                break;
                            case "6":
                                NhanVien.hienThiLS(tradingHistory);
                                break;
                            case "7":
                                NhanVien.ThongKe(tradingHistory);
                                break;
                            case "8":
                                active = false;
                                break;
                            default:
                                System.out.println("-----Yeu cau khong hop le vui long nhap lai-----");
                                break;
                        }
                    }
                    active = true;
                    break;
                case "2":
                    KhachHangIF customer = new KhachHang();
                    while (active) {
                        System.out.println("-----Danh Muc----");
                        System.out.println("1.Tim kiem san pham");
                        System.out.println("2.Them san pham vao gio hang");
                        System.out.println("3.Hien thi gio hang");
                        System.out.println("4.Thanh toan va in hoa don");
                        System.out.println("5.Quay lai ");
                        System.out.print("Nhap lua chon cua ban : ");
                        choose = sc.nextLine();
                        switch (choose) {
                            case "1":
                                customer.FindProduct(Store);
                                break;
                            case "2":
                                customer.addProductToCart(Store);
                                break;
                            case "3":
                                customer.showCart();
                                break;
                            case "4":
                                Invoice invoice = customer.invoice();
                                tradingHistory.setTradeHistory(invoice);
                                if (customer.updateStore(Store, invoice))
                                    System.out.println("------Mua san pham thanh cong------");

                                active = false;
                                break;
                            case "5":
                                active = false;
                                break;
                            default:
                                System.out.println("-----Yeu cau khong hop le vui long nhap lai-----");
                                break;
                        }
                    }
                    active = true;
                    break;
                case "3":
                    break;
                default:
                    break;
            }
        }
    }
}
