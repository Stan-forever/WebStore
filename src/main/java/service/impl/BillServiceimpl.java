package service.impl;

import Mapper.BillMapper;
import POJO.Bill;
import POJO.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BillService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class BillServiceimpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Bill> GetBillList() {
        List<Bill> list=billMapper.getBilllist();
        return  list;
    }

    public String GetBill(int id) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();
        Bill bill=new Bill();
        bill.setId(id);
        bill = billMapper.getBill(bill);
        if (bill !=null) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        map.put("bill", bill);
        JSONObject json = JSONObject.fromObject(map);
        return json.toString();
    }

    public String AddBill(Bill bill) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();
        List<Bill> list = billMapper.CheckBill(bill);
        if (list.size() > 0) {
            success = false;
            msg = "该用户已经存在了，请修改";
        } else {
            int result = billMapper.InsertBill(bill);
            if (result > 0) {
                success = true;
                msg = "用户信息添加成功";
            } else {
                success = false;
                msg = "用户信息添加失败";
            }
        }
        map.put("success", success);
        map.put("msg", msg);
        JSONObject json = JSONObject.fromObject(map);
        return json.toString();
    }

    @Override
    public String deleteBill(Bill bill) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        int result = billMapper.deleteBill(bill);

        if (result > 0) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }

    public String SearchBill(String providerName) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();
        Bill bill=new Bill();
        bill.setProviderName(providerName);
        bill = billMapper.getBill(bill);
        if (bill !=null) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        map.put("bill", bill);
        JSONObject json = JSONObject.fromObject(map);
        return json.toString();
    }

    @Override
    public String UpdateBill(Bill bill) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        int result = billMapper.UpdateBill(bill);
        if (result > 0) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }
//    public String deleteBill(int id, HttpSession session) {
//        boolean success = false;
//        String msg = "";
//        JSONObject map = new JSONObject();
//        Bill bill = new Bill();
//        bill.setId(id);
//        Bill oldbill = billMapper.getBill(bill);
//        if (session != null) {
//            String oldbillname = session.getAttribute("name").toString();
//            if (oldbillname.equals(oldbill.getProductName())) {
//                success = false;
//                msg = "不能把自己删除";
//            } else {
//                int result = billMapper.deleteBill(bill);
//                if (result > 0) {
//                    success = true;
//                    msg = "删除用户信息成功";
//                } else {
//                    success = false;
//                    msg = "删除用户信息失败";
//                }
//            }
//        } else {
//            success = false;
//            msg = "1";
//        }
//        map.put("success", success);
//        map.put("msg", msg);
//        map.put("bill", bill);
//        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
//        return json.toString();//将json数据转换成string类型
//    }


//    @Override
//    public int getBillCountByProviderId(int providerId) {
//        return billMapper.getBillCountByProviderId(providerId);
//    }
//
//    @Override
//    public List<Bill> getBillList(String productName, int providerId, int isPayment) {
//        return billMapper.getBillList(productName, providerId, isPayment);
//    }
//
//    @Override
//    public Bill getBillById(int id) {
//        return billMapper.getBillById(id);
//    }
//
//    @Override
//    public int modifyBillById(Bill bill) {
//        return billMapper.modifyBillById(bill);
//    }
//
//    @Override
//    public int deleteBillById(int id) {
//        return billMapper.deleteBillById(id);
//    }
//
//    @Override
//    public int addBill(Bill bill) {
//        return billMapper.addBill(bill);
//    }
}
