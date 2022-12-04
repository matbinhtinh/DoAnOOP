package Product;

import java.util.Scanner;

public class Price {
    private Integer giaBan;
    private Integer GiaNhap;
    private String donViTinh;
// constructor
    public Price() {
    }
//getter and setter
    public String getGiaNhap() {
        return String.format("%d/%s", GiaNhap, donViTinh);
    }

    public int getGiaNhap(boolean a) {
        return GiaNhap;
    }

    public void setGiaNhap(Integer giaNhap) {
        GiaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;

    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
// console cài đặt giá bán của nhân viên đồng thời kết hợp xử lý ngoại lệ 

    public void PriceSetUpByEmployee() {
        Scanner sc = new Scanner(System.in);
        boolean active = true;
        while (active) {
            try {
                System.out.print("Nhap gia nhap :");
                setGiaNhap(Integer.parseInt(sc.nextLine().replaceAll("\\s", "")));
                System.out.print("Nhap gia ban :");
                setGiaBan(Integer.parseInt(sc.nextLine().replaceAll("\\s", "")));
                System.out.print("Nhap don vi tinh:");
                setDonViTinh(sc.nextLine());
                active = false;
            } catch (Exception e) {
                System.out.println("--------Nhap gia khong hop le vui long nhap lai !-------");
            }
        }
    }
// cài đặt setup giá bán thông qua file
    public void PriceSetUpByFile(String PriceIn, String PriceOut, String Unit) {
        donViTinh = Unit;
        try {
            try {
                GiaNhap = Integer.parseInt(PriceIn);
            } catch (Exception e) {
                GiaNhap = -1;
            }

            giaBan = Integer.parseInt(PriceOut);
        } catch (Exception e) {
            giaBan = -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%s", giaBan, donViTinh);
    }

}
