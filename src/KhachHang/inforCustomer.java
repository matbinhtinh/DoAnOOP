package KhachHang;

import java.util.Scanner;

public class inforCustomer {
    private int customerID;
    private String Name;
    private String Address;
    private String Phone;
    public static int Quantity = 0;
    // Constructor
    public inforCustomer() {
        setInfor();
        Quantity = Quantity+1;
    }
    // 
    
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getcustumerID() {
        return customerID;
    }
    public void setcustumerID(int customerid) {
        customerID = customerid;
    }
    // chua xu ly ngoai le
    public void setInfor(){
        Scanner sc = new Scanner(System.in);
        setcustumerID(Quantity);
        System.out.print("Nhap ten cua ban : ");
        setName(sc.nextLine());
        System.out.print("Nhap dia chi cua ban : ");
        setAddress(sc.nextLine());
        System.out.print("Nhap so dien thoai : ");
        setPhone(sc.nextLine());
    }

}
