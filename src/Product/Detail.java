package Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Detail {
    private LocalDate ngaySX;
    private String hanSD;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    // CONSTRUCTOR
    public Detail() {
    }

    public Detail(LocalDate ngaySX, String hanSD, String nhaCungCap) {
        this.ngaySX = ngaySX;
        this.hanSD = hanSD;
        this.nhaCungCap = nhaCungCap;
    }

    // GETTER AND SETTERS

    public String getNgaySX() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedString = ngaySX.format(formatter);
        return formattedString;
    }

    public void setNgaySX(LocalDate ngaySX) {
        this.ngaySX = ngaySX;
    }

    public String getHanSD() {
        return hanSD;
    }

    public void setHanSD(String hanSD) {
        this.hanSD = hanSD;
    }

    public void setNgayHetHan(String hansd) {
        String[] splitString = hansd.split(" ", 2);
        switch (splitString[1]) {
            case "nam":
                ngayHetHan = ngaySX.plusYears(Integer.parseInt(splitString[0]));
                break;
            case "thang":
                ngayHetHan = ngaySX.plusMonths(Integer.parseInt(splitString[0]));

                break;
            case "ngay":
                ngayHetHan = ngaySX.plusDays(Integer.parseInt(splitString[0]));
                break;
        }

    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public void setDetailByEmployee() {
        Scanner sc = new Scanner(System.in);
        boolean active = true;
        while (active) {
            try {
                System.out.print("Nhap ngay san xuat:");
                DateTimeFormatter FM = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ngaySX = LocalDate.parse(sc.nextLine(), FM);
                while (active) {
                    System.out.print("Nhap HSD:");
                    hanSD = sc.nextLine();
                    String[] splitString = hanSD.split(" ", 2);
                    if (splitString[1].compareTo("nam") == 0 || splitString[1].compareTo("thang") == 0
                            || splitString[1].compareTo("ngay") == 0)
                        active = false;
                }
                System.out.print("Nhap nha cung cap:");
                nhaCungCap = sc.nextLine();
                setNgayHetHan(hanSD);
                active = false;
            } catch (Exception e) {
                System.out.print("Ngay san xuat khong hop le vui long nhap lai:");
            }
        }

    }
// ham cai dat chi tiet san pham voi ngoai le 
    public void setDetailByFile(String date, String hanSD, String nhaCungCap) {
        try {
            ngaySX = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            setNgayHetHan(hanSD);
            setNhaCungCap(nhaCungCap);
        } catch (Exception e) {
            ngaySX = LocalDate.parse("01-01-1111", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ngayHetHan = ngaySX;
        }
    }

}
