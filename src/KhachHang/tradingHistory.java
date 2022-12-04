package KhachHang;

import java.util.Arrays;

public class tradingHistory {
    private Invoice[] tradeHistory;
    public static int tradeQuantity = 0;
    public tradingHistory(){
        tradeHistory = new Invoice[0];
        tradeQuantity=0;
    }
    public Invoice[] getTradeHistory() {
        return tradeHistory;
    }
    // cài đặt lịch sử mua hàng khi mua hàng
    public void setTradeHistory(Invoice invoice) {
        tradeHistory = Arrays.copyOf(tradeHistory, tradeQuantity+1);
        tradeHistory[tradeQuantity] = new Invoice();
        tradeHistory[tradeQuantity] = invoice;
        tradeQuantity= tradeQuantity + 1;
    }
    
}
