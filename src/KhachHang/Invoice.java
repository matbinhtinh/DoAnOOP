package KhachHang;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invoice {
    private cart Cart;
    private inforCustomer customer;
    private LocalDate timeCreate;
    private double VAT = 0.05;
    private int ID ;
    public static int id = 0;
    // constructor
    public Invoice(){

    }
    public Invoice(cart Cart,inforCustomer customer) {
        setCart(Cart);
        setCustomer(customer);
        setTimeCreate(LocalDate.now());
        Order.setQuantity(0);
        id = id +1;
        setID(id);

        
    }

    // getter and setter
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public cart getCart() {
        return Cart;
    }

    public void setCart(cart cart) {
        Cart = cart;
    }

    public inforCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(inforCustomer customer) {
        this.customer = customer;
    }

    public LocalDate getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(LocalDate timeCreate) {
        this.timeCreate = timeCreate;
    }
// in hóa đơn vào file - Anh Thu
    public void writeToFile(FileWriter writer) {
        try {
            writer.write("--------------------------Hoa Don-----------------------------------");
            writer.write("\nTen khach hang : " + customer.getName());
            writer.write("\nDia chi : " + customer.getAddress());
            writer.write("\nSo dien thoai : " + customer.getPhone());
            DateTimeFormatter FM = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            writer.write("\nNgay lap hoa don : "+timeCreate.format(FM));
            writer.write("\n--------------------------Don Hang---------------------------------");
            writer.write("\n-------------------------------------------------------------------");
            writer.write(String.format("\n|%-10s|%-15s|%-20s|%-15s|%-10s|%15s|","Ma Don","Ma San Pham","Ten San Pham","Don Gia","So Luong","Thanh tien"));
            for (int i = 0; i < Cart.getCartQuantity(); i++) {
                double Money =  Math.ceil(Cart.getOrderList()[i].getMoney()*1.05);
                String invoice =String.format("\n|%-10d|%-15s|%-20s|%-15s|%-10d|%15d|",Cart.getOrderList()[i].getOrderID(),Cart.getOrderList()[i].getProductID(), Cart.getOrderList()[i].getName(),Cart.getOrderList()[i].getPrice(),Cart.getOrderList()[i].getOrderQuantity(),(int)Money);
                writer.write(invoice);
                double CartMoney = Math.ceil(Cart.getMoney()*1.05);
                writer.write("Tong so tien phai thanh toan la : "+Integer.toString((int)CartMoney));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString(){
        System.out.println("--------------------------Hoa Don-----------------------------------");
        System.out.println("Ten khach hang : " + customer.getName());
        System.out.println("Dia chi : " + customer.getAddress());
        System.out.println("So dien thoai : " + customer.getPhone());
        DateTimeFormatter FM = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Ngay lap hoa don : "+timeCreate.format(FM));
        System.out.println("--------------------------Don Hang---------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(String.format("|%-10s|%-15s|%20s|%-15s|%-10s|%15s|","Ma Don","Ma San Pham","Ten San Pham","Don Gia","So Luong","Thanh tien"));
        for (int i = 0; i < Cart.getCartQuantity(); i++) {
            double Money =  Math.ceil(Cart.getOrderList()[i].getMoney()*1.05);
            String invoice =String.format("|%-10d|%-15s|%-20s|%-15s|%-10d|%15d|",ID,Cart.getOrderList()[i].getProductID(), Cart.getOrderList()[i].getName(),Cart.getOrderList()[i].getPrice(),Cart.getOrderList()[i].getOrderQuantity(),(int)Money);
            System.out.println(invoice);
        }
        double CartMoney = Math.ceil(Cart.getMoney()*1.05);
        return "Tong so tien phai thanh toan la : "+Integer.toString((int)CartMoney);
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double vAT) {
        VAT = vAT;
    }

}
