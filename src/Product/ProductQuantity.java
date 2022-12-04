package Product;

import java.util.Scanner;

public class ProductQuantity {
    private Integer Quantity;
    // constructor
    public ProductQuantity() {

    }
// getter and setter
    public int getSoLuong() {
        return Quantity;
    }

    public void setSoLuong(int Quantity) {
        this.Quantity = Quantity;
    }
// xử lý ngoại lệ và nhập số lượng trên console bởi người nhân viên
    public void setQuantityByEmployee() {
        Scanner sc = new Scanner(System.in);
        boolean active = true;
        while (active) {
            try {
                System.out.print("Nhap so luong thuoc: ");
                setSoLuong(Integer.parseInt(sc.nextLine().replaceAll("\\s", "")));
                active = false;
            } catch (Exception e) {
                System.out.println("----------So luong san pham khong phai mot so vui long nhap lai !----------");
            }

        }

    }
}
