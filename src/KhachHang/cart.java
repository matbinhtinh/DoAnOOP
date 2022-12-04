package KhachHang;

import java.util.Arrays;

import Product.*;

public class cart {
    private Order[] OrderList;
    private static int OrderListQuantity = 0 ;
    private int Money = 0;
    private int costMoney = 0;
    public cart() {
        OrderList = new Order[0];
        OrderListQuantity = 0;
    }

    public Order[] getOrderList() {
        return OrderList;
    }
    

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public int getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(int costMoney) {
        this.costMoney = costMoney;
    }
// cai dat cac gia tri 
    public void setCart(Product product,int orderQuantity) {
        OrderList = Arrays.copyOf(OrderList, OrderListQuantity+1);
        OrderList[OrderListQuantity] = new Order();
        OrderList[OrderListQuantity].setOrder(product, orderQuantity);
        Money = Money +OrderList[OrderListQuantity].getMoney();
        costMoney =OrderList[OrderListQuantity].getCostMoney()+costMoney; 
        OrderListQuantity = OrderListQuantity + 1;
    }
    public int getCartQuantity() {
        return OrderListQuantity;
    }

    public static void delCart(cart OrderList) {
        OrderList = new cart();
    }
    @Override
    public String toString() {
        System.out.println("----------------------------Gio Hang-------------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(String.format("|%-10s|%-15s|%-20s|%10s|", "Ma don", "ID", "Ten thuoc", "So luong"));
        for (int i = 0; i < OrderListQuantity; i++) {
            System.out.print(OrderList[i] + "\n");
        }
        return "";
    }

}
