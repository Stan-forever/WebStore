package service;

import POJO.Bill;
import POJO.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface BillService {
//    int getBillCountByProviderId(@Param("providerId") int providerId);
//
//    List<Bill> getBillList(String productName,
//                           int providerId,
//                           int isPayment
//    );
//
//    Bill getBillById(int id);
//
//    int modifyBillById(Bill bill);
//
//    int deleteBillById(int id);
//
//    int addBill(Bill bill);
    List<Bill> GetBillList();
    String GetBill(int id);
    String AddBill(Bill bill);
    String deleteBill(Bill bill);
    String SearchBill(String providerName);
    String UpdateBill(Bill bill);
}