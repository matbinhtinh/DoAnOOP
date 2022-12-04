package Product;

import java.util.Scanner;

public class thuoc extends Product {
    private Detail detail;

    // Constructor
    public thuoc() {
        ProductPrice = new Price();
        QuantityProduct = new ProductQuantity();
        detail = new Detail();
    }

    public thuoc(String type, Detail detail) {
        Type = type;
        this.detail = detail;
    }

    // getter and setter
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Detail getDetail() {
        return detail;
    }
// cài đặt sản phẩm của nhân viên
    @Override
    public void setProductByEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten san pham:");
        setName(sc.nextLine());
        System.out.print("Nhap ma san pham:");
        setID(sc.nextLine());
        System.out.print("Loai san pham :");
        Type = sc.nextLine();
        ProductPrice.PriceSetUpByEmployee();
        QuantityProduct.setQuantityByEmployee();
        detail.setDetailByEmployee();
    }
// cài đặt sản phẩm thông qua file,tiến hành cắt String data sau đó gọi những hàm cài đặt từng thuộc tính
    public void setProductByFile(String Data) {
        String[] DataArray = Data.split(",");
        setID(DataArray[0]);
        setName(DataArray[1]);
        ProductPrice.PriceSetUpByFile(DataArray[2], DataArray[3], DataArray[4]);
        QuantityProduct.setSoLuong(Integer.parseInt(DataArray[5]));
        detail.setDetailByFile(DataArray[6], DataArray[7], DataArray[9]);
        setType(DataArray[8]);
    }
// hiển thị sản phẩm theo góc nhìn của nhân viên
    @Override
    public String displayForEmployee() {
        return String.format("|%-15s|%-25s|%-10s|%-10s|%-10s|%-15s|%-20s|%-20s|", getID(), getName(),
                QuantityProduct.getSoLuong(), ProductPrice.getGiaNhap(), ProductPrice, detail.getNgayHetHan(),
                getType(), detail.getNhaCungCap());
    }

    @Override
// hiển hị sản phẩm theo góc nhìn thông thường của người dùng
    public String toString() {

        return String.format("|%-15s|%-25s|%-10s|%-10s|%-15s|%-20s|%-20s|", getID(), getName(),
                QuantityProduct.getSoLuong(), ProductPrice, detail.getNgayHetHan(), getType(), detail.getNhaCungCap());
    }

}
