package Product;

import java.util.Scanner;

/**
 * dungCuYTe
 */
class dungCuYTe extends Product {
// constructor
    public dungCuYTe() {
        ProductPrice = new Price();
        QuantityProduct = new ProductQuantity();
        setType("Dung Cu Y Te");
    }
// getter and setter 
    public String getType() {
        return Type;
    }

    @Override
// cài đặt các thuộc tính dụng cụ y tế bởi nhân viên 

    public void setProductByEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten san pham:");
        setName(sc.nextLine());
        System.out.print("Nhap ma san pham:");
        setID(sc.nextLine());
        ProductPrice.PriceSetUpByEmployee();
        QuantityProduct.setQuantityByEmployee();
    }
// cài đặt các thuộc tính dụng cụ y tế bởi file 

    public void setProductByFile(String Data) {
        String[] DataArray = Data.split(",");
        setID(DataArray[0]);
        setName(DataArray[1]);
        ProductPrice.PriceSetUpByFile(DataArray[2], DataArray[3], DataArray[4]);
        QuantityProduct.setSoLuong(Integer.parseInt(DataArray[5]));
    }

    @Override
    public String displayForEmployee() {
        // TODO Auto-generated method stub
        return String.format("|%-15s|%-25s|%-10s|%-10s|%-10s|%-15s|%-20s|%-20s|", getID(), getName(),
                QuantityProduct.getSoLuong(), ProductPrice.getGiaNhap(), ProductPrice, "", getType(), "");
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-25s|%-10s|%-10s|%-15s|%-20s|%-20s|", getID(), getName(),
                QuantityProduct.getSoLuong(), ProductPrice.getGiaNhap(), ProductPrice, "", Type, "");
    }


}