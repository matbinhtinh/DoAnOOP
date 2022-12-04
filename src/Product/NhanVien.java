package Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import KhachHang.tradingHistory;
import Product.*;

/**
 * NhanVien
 */
public class NhanVien implements NhanVienIF {

    Scanner sc = new Scanner(System.in);

// thêm n thuốc vào kho
    private boolean addThuoc(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.print("Nhap so luong thuoc muon them: ");
            try {
                int InputQuantity = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < InputQuantity; i++) {
                    Store.addThuoc();
                }
                active = false;
            } catch (Exception e) {
                System.out.println("Nhap so luong san pham loi vui long nhap lai");
            }
        }
        return active;
    }
// thêm n dụng cụ y tế vào kho
    private boolean addDungCuYTe(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.print("Nhap so luong muon them: ");
            try {
                int InputQuantity = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < InputQuantity; i++) {
                    Store.addThuoc();
                }
                active = false;
            } catch (Exception e) {
                System.out.println("Nhap so luong san pham loi vui long nhap lai");
            }
        }
        return active;
    }
// Các option Chỉnh sửa thuốc
    private boolean suaThuoc(StoreHouse Store, int index) {
        Product thuoc = new thuoc();
        thuoc = Store.gettStore()[index];
        boolean active = true;
        while (active) {
            System.out.println("-------Sua San Pham------");
            System.out.println("1.Sua ID");
            System.out.println("2.Sua ten");
            System.out.println("3.Sua so luong");
            System.out.println("4.Sua gia nhap");
            System.out.println("5.Sua gia ban");
            System.out.println("6.Hien thi thong tin san pham");
            System.out.println("7.Tro lai");
            System.out.print("Lua chon cua ban la : ");
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    System.out.print("\nNhap ID moi : ");
                    thuoc.setID(sc.nextLine());
                    System.out.println("----------Sua san pham thanh cong----------");
                    break;
                case "2":
                    System.out.print("\nNhap ten moi :");
                    thuoc.setName(sc.nextLine());
                    System.out.println("----------Sua san pham thanh cong----------");
                    break;
                case "3":
                    while (active) {
                        System.out.print("\nNhap so luong moi :");
                        try {
                            thuoc.getQuantityProduct().setSoLuong(Integer.parseInt(sc.nextLine()));
                            active = false;
                            System.out.println("----------Sua san pham thanh cong----------");
                        } catch (Exception e) {
                            System.out.println("So luong khong hop le vui long nhap lai !");
                        }
                    }
                    active = true;
                    break;
                case "4":
                    while (active) {
                        System.out.print("\nNhap gia nhap moi : ");
                        try {
                            thuoc.getProductPrice().setGiaNhap(Integer.parseInt(sc.nextLine()));
                            active = false;
                            System.out.println("----------Sua san pham thanh cong----------");

                        } catch (Exception e) {
                            System.out.println("Gia nhap khong hop le vui long nhap lai ! ");
                        }
                    }
                    active = true;
                    break;
                case "5":
                    while (active) {
                        System.out.print("\nNhap gia ban moi : ");
                        try {
                            thuoc.getProductPrice().setGiaNhap(Integer.parseInt(sc.nextLine()));
                            active = false;
                            System.out.println("----------Sua san pham thanh cong----------");

                        } catch (Exception e) {
                            System.out.println("Gia ban khong hop le vui long nhap lai ! ");
                        }
                    }
                    active = true;
                    break;
                case "6":
                    System.out.println("\n----------Thong tin san pham---------");
                    System.out.println(thuoc);
                    break;
                case "7":
                    return true;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai !");
                    break;
            }
        }
        return active;
    }
// tìm sản ID cho việc chỉnh sửa và các option phụ 
    private int findByID(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.print("Nhap ID muon chinh sua:");
            String inputID = sc.nextLine().toLowerCase();
            for (int i = 0; i < Store.getStoreQuantity(); i++) {
                if (inputID.compareTo(Store.gettStore()[i].getID().toLowerCase()) == 0) {

                    return i;
                }
            }
            boolean subactive = true;
            while (subactive) {
                System.out.println("----------Khong co san pham co ma nay----------");
                System.out.println("1.Tiep tuc nhap ma chinh sua");
                System.out.println("2.Quay tro lai");
                System.out.print("Lua chon cua ban : ");
                String Choose = sc.nextLine();
                switch (Choose) {
                    case "1":
                        subactive = false;
                        break;
                    case "2":
                        subactive = false;
                        active = false;
                    default:
                        System.out.println("-----Lua chon khong hop le-----");
                        break;
                }
            }
        }
        return -1;
    }


// các option thêm sản phẩm vào kho thuốc
    @Override
    public boolean themSP(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.println("----------Them San Pham----------");
            System.out.println("1.Them Thuoc");
            System.out.println("2.Them dung cu y te");
            System.out.println("3.Tro Lai");
            System.out.print("Lua chon cua ban:");
            String Choose = sc.nextLine();
            switch (Choose) {
                case "1":
                    if (addThuoc(Store) == false) {
                        return true;
                    }
                    break;
                case "2":
                    if (addDungCuYTe(Store) == false) {
                        return true;
                    }
                    break;
                case "3":
                    return false;
                default:
                    break;
            }
        }
        return active;
    }

    @Override
    public void hienThiKho(StoreHouse Store) {
        System.out.println("--------Kho Hang-------");
        Store.displayForEmployee();
    }

    @Override
    public void timKiemSanPham(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.println("----------Tim Kiem San Pham----------");
            System.out.println("1.Tim kiem theo ten. ");
            System.out.println("2.Tim kiem theo loai san pham.");
            System.out.println("3.Tro lai.");
            System.out.print("Lua chon cua ban:");
            String Choose = sc.nextLine();
            switch (Choose) {
                case "1":
                    Store.FindProductEmployeeByName();
                    break;
                case "2":
                    Store.FindProductEmployeeType();
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

    @Override
    public boolean xoaSP(StoreHouse Store) {
        System.out.print("Nhap ID san pham muon xoa:");
        String inputID = sc.nextLine();
        for (int i = 0; i < Store.getStoreQuantity(); i++) {
            if (Store.gettStore()[i].getID().toLowerCase().compareTo(inputID.toLowerCase()) == 0) {
                Store.delProduct(i);
            }
        }
        return true;
    }

    @Override
    public void hienThiLS(tradingHistory tradingHistory) {
        for (int i = 0; i < tradingHistory.tradeQuantity; i++) {
            System.out.println(tradingHistory.getTradeHistory()[i]);
        }

    }

    public int DoanhThu(tradingHistory tradingHistory) {
        int DoanhThu = 0;
        for (int i = 0; i < tradingHistory.tradeQuantity; i++) {
            double Money = Math.ceil(tradingHistory.getTradeHistory()[i].getCart().getMoney()*1.05);
            DoanhThu = DoanhThu+(int)Money;
        }
        return DoanhThu;
    }
    public int LoiNhuan(tradingHistory tradingHistory){
        int LoiNhuan = 0;
        int costMoney = 0;
        for (int i = 0; i < tradingHistory.tradeQuantity; i++) {
            int beforVAT = tradingHistory.getTradeHistory()[i].getCart().getMoney();
            LoiNhuan =LoiNhuan+ beforVAT-tradingHistory.getTradeHistory()[i].getCart().getCostMoney();
        }
        return LoiNhuan;
    }

    @Override
    public boolean ThongKe(tradingHistory tradingHistory) {
        boolean active = true;
        while (active) {
            System.out.println("----------Thong Ke-----------");
            System.out.println("1.Tong Doanh Thu");
            System.out.println("2.Tinh loi nhuan");
            System.out.println("3.Thoat");
            System.out.print("Lua chon cua ban ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Tong thu hien tai la : "+Integer.toString((int)DoanhThu(tradingHistory)));
                case "2":
                    System.out.println("Loi Nhuan : "+Integer.toString(LoiNhuan(tradingHistory)));
                case "3":
                    return false;
                default:
                    break;
            }

        }
        return true;

    }

    @Override
    public boolean SuaSanPham(StoreHouse Store) {
        boolean active = true;
        while (active) {
            System.out.println("-------Sua San Pham-----");
            int index = findByID(Store);
            if (suaThuoc(Store, index))
                active = false;
        }
        return false;
    }
}