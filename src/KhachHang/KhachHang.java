package KhachHang;

import java.io.FileWriter;
import java.util.Scanner;
import KhachHang.*;
import Product.*;

public class KhachHang implements KhachHangIF {
    private Scanner sc = new Scanner(System.in);
    private cart Cart;
    private inforCustomer customer;
// contructor 
// Mỗi lần khởi tạo một khách hàng  đều phải khởi tạo một giỏ hàng và một thông tin khách hàng 
    public KhachHang() {
        Cart = new cart();
        customer = new inforCustomer();
    }


    public cart getCart() {
        return Cart;
    }

    public void setCart(cart cart) {
        Cart = cart;
    }
// tỉm sản phẩm trong kho hàng thông qua ID,nếu có trả về index,nếu không trả về -1 Hà Vi
    public int findElement(StoreHouse Store, String inputID) {
        for (int i = 0; i < Store.getStoreQuantity(); i++) {
            if (inputID.compareTo(Store.gettStore()[i].getID().toLowerCase()) == 0) {
                return i;
            }
        }
        return -1;
    }
// tìm sản phẩm trong kho thông qua ID thông qua menu kết hợp xử lý ngoại lệ - Hà Vi
    private int findByID(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.print("Nhap ID them vao gio hang:");
            String inputID = sc.nextLine().toLowerCase();
            int index = findElement(Store, inputID);
            if (index != -1)
                return index;
            boolean subactive = true;
            while (subactive) {
                System.out.println("-------------Khong co san pham co ma nay-------");
                System.out.println("1.Tiep tuc them san pham");
                System.out.println("2.Quay tro lai");
                System.out.print("Lua chon cua ban : ");
                String Choose = sc.nextLine();
                switch (Choose) {
                    case "1":
                        subactive = false;
                        break;
                    case "2":
                        return -1;
                    default:
                        System.out.println("----Lua chon khong hop le-----");
                        break;
                }
            }
        }
        // tra ve -1 co nghia la thoat chuong trinh
        return -1;
    }
// menu tìm kiếm sản phẩm - Hà Vi
    @Override
    public void FindProduct(StoreHouse Store) {
        Scanner sc = new Scanner(System.in);
        boolean active = true;
        while (active) {
            System.out.println("------Tim Kiem San Pham--------");
            System.out.println("1.Tim kiem theo ten. ");
            System.out.println("2.Tim kiem theo loai san pham.");
            System.out.println("3.Tro lai.");
            System.out.print("Lua chon cua ban:");
            String Choose = sc.nextLine();
            switch (Choose) {
                case "1":
                    Store.FindProductByName();
                    break;
                case "2":
                    Store.FindProductByType();
                    break;
                case "3":
                    active = false;
                    break;
                default:
                    System.out.println("\nNhap sai roi vui long nhap lai");
                    break;
            }

        }

    }
// Thêm sản phẩm vào kho - Văn Tâm
    @Override
    public boolean addProductToCart(StoreHouse Store) {
        int index = findByID(Store);
        if (index == -1)
            return false;
        boolean active = true;
        int orderQuantity = -1;
        while (active) {
            try {
                System.out.print("Nhap so luong: ");
                orderQuantity = Integer.parseInt(sc.nextLine());
                if (orderQuantity > Store.gettStore()[index].getQuantityProduct().getSoLuong())
                    Integer.parseInt("");
                active = false;
            } catch (Exception e) {
                System.out.println("--------Nhap so luong khong hop le vui long nhap lai !-------");
            }
        }
        Cart.setCart(Store.gettStore()[index], orderQuantity);
        System.out.println("-----Them san pham vao gio hang thanh cong-----");
        return true;

    }
// cập nhật kho hàng sau khi mua hàng
    public boolean updateStore(StoreHouse Store, Invoice invoice) {
        for (int i = 0; i < invoice.getCart().getCartQuantity(); i++) {
            int index = findElement(Store, invoice.getCart().getOrderList()[i].getProductID().toLowerCase());
            int updateQuantity = Store.gettStore()[index].getQuantityProduct().getSoLuong()
                    - invoice.getCart().getOrderList()[i].getOrderQuantity();
            Store.gettStore()[index].getQuantityProduct().setSoLuong(updateQuantity);
            if (updateQuantity == 0) {
                Store.delProduct(index);
            }
        }
        return true;
    }
// hiển thị giỏ hàng
    @Override
    public void showCart() {
        System.out.println(Cart);

    }
// hiển thị hóa đơn lên console và tạo file hóa đơn 
    @Override
    public Invoice invoice() {
        Invoice invoice = new Invoice(Cart, customer);
        try {
            String Name = "MaDon"+Integer.toString(invoice.getID());
            FileWriter writer = new FileWriter("HoaDon//"+Name);
            invoice.writeToFile(writer);
            writer.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        System.out.println(invoice);
        return invoice;
    }

}
