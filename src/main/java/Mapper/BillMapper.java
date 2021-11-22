package Mapper;

import POJO.Bill;
import POJO.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    List<Bill>  getBilllist();
    Bill getBill(Bill bill);
    int UpdateBill(Bill bill);
    String AddBill(Bill bill);
    List<Bill> CheckBill(Bill bill);
    int InsertBill(Bill bill);
    int deleteBill(Bill bill);
    Bill searchBill(Bill bill);
}
