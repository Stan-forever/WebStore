package Controller;

import POJO.User;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import POJO.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.impl.BillServiceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge=3600)
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillServiceimpl billService;


//    @RequestMapping("/billManagement")
//    public String getBillList(Model model, String queryProductName,
//                              String queryProviderId,
//                              String queryIsPayment
//    ) {
//        List<Provider> providerList = providerService.getProviderList("", "");
//        model.addAttribute("providerList", providerList);
//        if (StringUtils.isNullOrEmpty(queryProductName)) {
//            queryProductName = "";
//        }
//        int ProviderId = 0;
//        if (!StringUtils.isNullOrEmpty(queryProviderId)) {
//            ProviderId = Integer.parseInt(queryProviderId);
//        }
//        int IsPayment = 0;
//        if (!StringUtils.isNullOrEmpty(queryIsPayment)) {
//            IsPayment = Integer.parseInt(queryIsPayment);
//        }
//        List<Bill> billList = billService.getBillList(queryProductName, ProviderId, IsPayment);
//
//        model.addAttribute("billList", billList);
//        model.addAttribute("queryProductName", queryProductName);
//        model.addAttribute("queryProviderId", ProviderId);
//        model.addAttribute("queryIsPayment", IsPayment);
//        return "WEB-INF/jsp/billlist";
//    }
//
//
//    @RequestMapping("/addbillpage")
//    public String toAddBillPage() {
//        return "WEB-INF/jsp/billadd";
//    }
//
//    @RequestMapping("/viewbill")
//    public String toViewPage(String id, Model model) {
//        if (!StringUtils.isNullOrEmpty(id)) {
//            Bill bill = billService.getBillById(Integer.parseInt(id));
//            model.addAttribute("bill", bill);
//        }
//        return "WEB-INF/jsp/billview";
//    }
//
//    @RequestMapping("/modifybill")
//    public String modifyBill(String id, Model model) {
//        if (!StringUtils.isNullOrEmpty(id)) {
//            Bill bill = billService.getBillById(Integer.parseInt(id));
//            model.addAttribute("bill", bill);
//        }
//        return "WEB-INF/jsp/billmodify";
//    }
//
//    @RequestMapping("/savebill")
//    public String saveModifyBill(Bill bill, HttpSession session) {
//
//        bill.setProductCount(new BigDecimal(String.valueOf(bill.getProductCount())).setScale(2, BigDecimal.ROUND_DOWN));
//        bill.setTotalPrice(new BigDecimal(String.valueOf(bill.getTotalPrice())).setScale(2, BigDecimal.ROUND_DOWN));
//
//        bill.setModifyBy(((User) session.getAttribute(Constants.USER_SESSION)).getId());
//        bill.setModifyDate(new Date());
//
//        int i = billService.modifyBillById(bill);
//        if (i > 0) {
//            return "redirect:/jsp/billManagement";
//        } else {
//            return "WEB-INF/jsp/billmodify";
//        }
//    }
//
//    @RequestMapping("/delbill")
//    @ResponseBody
//    public String deleteBillById(String id) {
//        HashMap<String, String> resultMap = new HashMap<String, String>();
//        if (!StringUtils.isNullOrEmpty(id)) {
//            int i = billService.deleteBillById(Integer.parseInt(id));
//            if (i > 0) {
//                resultMap.put("delResult", "true");
//            } else {
//                resultMap.put("delResult", "false");
//            }
//        } else {
//            resultMap.put("delResult", "notexit");
//        }
//        return JSONArray.toJSONString(resultMap);
//    }
//
//    @RequestMapping("/addbill")
//    public String addBill(Bill bill, HttpSession session) {
//        bill.setProductCount(new BigDecimal(String.valueOf(bill.getProductCount())).setScale(2, BigDecimal.ROUND_DOWN));
//        bill.setTotalPrice(new BigDecimal(String.valueOf(bill.getTotalPrice())).setScale(2, BigDecimal.ROUND_DOWN));
//        bill.setCreatedBy(((User) session.getAttribute(Constants.USER_SESSION)).getId());
//        bill.setCreationDate(new Date());
//        int i = billService.addBill(bill);
//        if (i > 0) {
//            return "redirect:/jsp/billManagement";
//        } else {
//            return "WEN-INF/jsp/billadd";
//        }
//    }
    @RequestMapping("/getbilllist.do")
    @ResponseBody
    public List<Bill> getbilllist(){
        List<Bill> list=billService.GetBillList();
        return list;
    }

    @RequestMapping(value = "/getBill.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody
    public String getBill(@RequestParam int id) {
        Bill bill=new Bill();
        bill.setId(id);
        //@RequestParam 是注解，声明下就可以获取传递的参数
        String relute = billService.GetBill(id);//去调度业务逻辑层层进行登录判断结果获取
        System.out.println(relute);
        return relute;
    }

    @RequestMapping(value = "/insertBill.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody//返回的格式是放到body中
    public String insertBill(@RequestParam String billCode, String productName,
        String productUnit, BigDecimal productCount,
                             BigDecimal totalPrice, Integer isPayment,
                             String createdBy,String creationDate, String providerName,String productDesc) {
        Bill bill=new Bill();
        bill.setBillCode(billCode);
        bill.setProductUnit(productUnit);
        bill.setProductName(productName);
        bill.setProductUnit(productUnit);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setIsPayment(isPayment);
        bill.setCreatedBy(createdBy);
        bill.setCreationDate(creationDate);
        bill.setProviderName(providerName);
        bill.setProductDesc(productDesc);
        String relute = billService.AddBill(bill);
        System.out.println(relute);
        return relute;
    }

    @RequestMapping(value = "/deleteBill.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody//返回的格式是放到body中
//@RequestParam  注解 获取 前端传递的参数   最根本的还是 servlet  de httprequest  里面的表单值的获取
    public String deleteBill(@RequestParam int id,Integer isdelete) {
        Bill bill=new Bill();
        bill.setId(id);
        bill.setIsdelete(isdelete);
        //@RequestParam 是注解，声明下就可以获取传递的参数
        String relute = billService.deleteBill(bill);//去调度业务逻辑层层
        System.out.println(relute);
        return relute;
    }
    @RequestMapping(value = "/searchBill.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody
    public String searchBill(@RequestParam String providerName) {
        Bill bill=new Bill();
        bill.setProviderName(providerName);
        String relute = billService.SearchBill(providerName);//去调度业务逻辑层层进行登录判断结果获取
        System.out.println(relute);
        return relute;
    }

    @RequestMapping(value = "/updateBill.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody
    public String updateBill(@RequestParam Integer id,
                             String productName,String productUnit,
                             BigDecimal productCount,BigDecimal totalPrice,String productDesc,Integer isPayment) {
        Bill bill=new Bill();
        bill.setId(id);
        bill.setProductName(productName);
        bill.setProductUnit(productUnit);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setProductDesc(productDesc);
        bill.setIsPayment(isPayment);
        String relute = billService.UpdateBill(bill);
        System.out.println(relute);
        return relute;
    }
}
