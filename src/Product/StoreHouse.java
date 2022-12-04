package Product;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class StoreHouse {
    private static Product[] Store = new Product[0];
    private int StoreQuantity = 0;
    private static String path1 = "";
    private static String path2 = "";



    public StoreHouse() {
        addThuocByFile(path1);
        addDungCuYTeByFile(path2);
    }

    // static method tien hanh lay va sua dia chi tu ben ngoai 
    public static String getPathThuoc() {
        return path1;
    }


    public static void setPathThuoc(String path1) {
        StoreHouse.path1 = path1;
    }


    public static String getPathDungCuYTe() {
        return path2;
    }


    public static void setPathDungCuYTe(String path2) {
        StoreHouse.path2 = path2;
    }

// getter va setter thông thường
    public Product[] gettStore() {
        return Store;
    }

    public int getStoreQuantity() {
        return StoreQuantity;
    }

    public void setStoreQuantity(int storeQuantity) {
        StoreQuantity = storeQuantity;
    }

    // them thuoc vao kho hang
    // tiến hành tạo một mảng mới sau đó copy toàn bộ mảng cũ sang sau đó gọi phương thức cài đặt sản phẩm
    // dựa trên downcasting
    public void addThuoc() {
        int newKhoQuantity = StoreQuantity + 1;
        Product KhoThuocNew[] = new Product[newKhoQuantity];
        if (StoreQuantity == 0) {
            Store = KhoThuocNew;
        } else {
            for (int i = 0; i < StoreQuantity; i++) {
                KhoThuocNew[i] = Store[i];
            }
            Store = KhoThuocNew;
        }
        for (int i = StoreQuantity; i < newKhoQuantity; i++) {
            Store[i] = new thuoc();
            Store[i].setProductByEmployee();

        }
        StoreQuantity = newKhoQuantity;

    }
    public void addThuoc(String Data) {
        int newKhoQuantity = StoreQuantity + 1;
        Product KhoThuocNew[] = new Product[newKhoQuantity];
        if (StoreQuantity == 0) {
            Store = KhoThuocNew;
        } else {
            for (int i = 0; i < StoreQuantity; i++) {
                KhoThuocNew[i] = Store[i];
            }
            Store = KhoThuocNew;
        }
        for (int i = StoreQuantity; i < newKhoQuantity; i++) {
            Store[i] = new thuoc();
            Store[i].setProductByFile(Data);
        }
        StoreQuantity = newKhoQuantity;
    }

    // them dung cu y te vao kho hang
    // tiến hành tạo một mảng mới sau đó copy toàn bộ mảng cũ sang sau đó gọi phương thức cài đặt sản phẩm
    // dựa trên downcasting

    public void addDungCuYTe() {
        int newKhoQuantity = StoreQuantity + 1;
        Product KhoThuocNew[] = new Product[newKhoQuantity];
        if (StoreQuantity == 0) {
            Store = KhoThuocNew;
        } else {
            for (int i = 0; i < StoreQuantity; i++) {
                KhoThuocNew[i] = Store[i];
            }
            Store = KhoThuocNew;
        }
        for (int i = StoreQuantity; i < newKhoQuantity; i++) {
            Store[i] = new dungCuYTe();
            Store[i].setProductByEmployee();

        }
        StoreQuantity = newKhoQuantity;
    }

    public void addDungCuYTe(String Data) {
        int newKhoQuantity = StoreQuantity + 1;
        Product KhoThuocNew[] = new Product[newKhoQuantity];
        if (StoreQuantity == 0) {
            Store = KhoThuocNew;
        } else {
            for (int i = 0; i < StoreQuantity; i++) {
                KhoThuocNew[i] = Store[i];
            }
            Store = KhoThuocNew;
        }
        for (int i = StoreQuantity; i < newKhoQuantity; i++) {
            Store[i] = new dungCuYTe();
            Store[i].setProductByFile(Data);

        }
        StoreQuantity = newKhoQuantity;
    }

    // add thuoc by file
    // tiến hành đọc file thuốc bằng đường dẫn,sau đó đọc từng dòng và gọi phương thức thêm sản phẩm bên trên
    // ngoại lệ: nếu sản phẩm trong file ghi không đúng định dạng sẽ bị bỏ qua
    public void addThuocByFile(String link) {
        try {
            Scanner input = new Scanner(new File(link));
            while (input.hasNext()) {
                String Data = input.nextLine();
                try {
                    addThuoc(Data);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Khong tim thay file");
        }

    }
    // tiến hành đọc file dụng cụ y tế bằng đường dẫn,sau đó đọc từng dòng và gọi phương thức thêm sản phẩm bên trên
    // ngoại lệ: nếu sản phẩm trong file ghi không đúng định dạng sẽ bị bỏ qua
    public void addDungCuYTeByFile(String path) {
        try {
            Scanner input = new Scanner(new File(path));
            while (input.hasNext()) {
                String Data = input.nextLine();
                try {
                    addDungCuYTe(Data);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Khong tim thay file");
        }
    }
    // delete product by index of the list
// tiến hành xóa một sản phẩm với vị trí trong kho cố định
    public void delProduct(int index) {
        StoreQuantity = StoreQuantity - 1;
        Product KhoThuocNew[] = new Product[StoreQuantity];
        for (int i = 0; i < StoreQuantity; i++) {
            KhoThuocNew[i] = Store[i];
            if (i >= index) {
                KhoThuocNew[i] = Store[i + 1];
            }
        }
        Store = KhoThuocNew;
    }

    // find Product
    // tìm kiếm sản phẩm trên console
// tìm kiếm gần theo tên đúng với việc không phân biệt hoa thường và contains method
// tìm kiếm sản phẩm và hiển thị thông tin cho khách hàng với ít thông tin hơn
    public void FindProductByName() {
        int findQuantity = 0;
        System.out.print("San pham ban muon tim kiem: ");
        Scanner sc = new Scanner(System.in);
        String Condition = sc.nextLine().toLowerCase();
        for (int i = 0; i < StoreQuantity; i++) {
            if (Store[i].getName().toLowerCase().contains(Condition.strip())) {
                System.out.println(Store[i]);
                findQuantity = findQuantity + 1;
            }
        }
        if (findQuantity == 0)
            System.out.println("---Rat tiec khong tim thay san pham----");
    }

// tìm kiếm gần đúng theo tên với việc không phân biệt hoa thường và contains method
// tìm kiếm và được hiển thị thông tin cho nhân viên nhiều thông tin hơn (displayForEmployee)
    public void FindProductEmployeeByName() {
        int findQuantity = 0;
        System.out.print("San pham ban muon tim kiem: ");
        Scanner sc = new Scanner(System.in);
        String Condition = sc.nextLine().toLowerCase();
        for (int i = 0; i < StoreQuantity; i++) {
            if (Store[i].getName().toLowerCase().contains(Condition.strip())) {
                System.out.println(Store[i].displayForEmployee());
                findQuantity = findQuantity + 1;
            }
        }
        if (findQuantity == 0)
            System.out.println("---Rat tiec khong tim thay san pham----");
    }

    //
// tương tự như tìm kiếm sản phẩm theo tên nhưng là tìm kiếm theo loại sản phẩm
    public void FindProductEmployeeType() {
        int findQuantity = 0;
        System.out.print("Nhap loai san pham muon tim kiem:");
        Scanner sc = new Scanner(System.in);
        String condition = sc.nextLine().toLowerCase();
        for (int i = 0; i < StoreQuantity; i++) {
            if (Store[i].getType().toLowerCase().contains(condition.strip())) {
                System.out.println(Store[i].displayForEmployee());
                findQuantity = findQuantity + 1;
            }
        }
        if (findQuantity == 0)
            System.out.println("---Rat tiec khong tim thay san pham----");
    }

    public void FindProductByType() {
        int findQuantity = 0;
        System.out.println("Nhap loai san pham muon tim kiem:");
        Scanner sc = new Scanner(System.in);
        String condition = sc.nextLine().toLowerCase();
        for (int i = 0; i < StoreQuantity; i++) {
            if (Store[i].getType().toLowerCase().contains(condition.strip())) {
                System.out.println(Store[i]);
                findQuantity = findQuantity + 1;
            }
        }
        if (findQuantity == 0)
            System.out.println("---Rat tiec khong tim thay san pham----");
    }
// Phương thức hiển thị sản phẩm trong kho của nhân viên
    public void displayForEmployee() {
        System.out.println(String.format("|%-15s|%-25s|%-10s|%-10s|%-10s|%-15s|%-20s|%-20s|", "ID", "Ten San Pham",
                "So Luong", "Gia Nhap", "Gia Ban", "Ngay Het Han", "Loai San Pham", "Nha San Xuat"));
        for (int i = 0; i < StoreQuantity; i++) {
            System.out.println(Store[i].displayForEmployee());
        }
    }
// Phương thức hiển thị sản phẩm trong kho của người dùng
    @Override
    public String toString() {
        System.out.println(String.format("|%-15s|%-25s|%-10s|%-10s|%-15s|%-20s|%-20s|", "ID", "Ten San Pham",
                "So Luong", "Gia Ban", "Ngay Het Han", "Loai San Pham", "Nha San Xuat"));
        for (int i = 0; i < StoreQuantity; i++) {
            System.out.println(Store[i]);
        }
        return "";
    }
}
