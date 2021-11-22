//package Controller;
//
//import POJO.Provider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import service.ProviderServices;
//import service.impl.ProvidersServiceimpl;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Controller
//@CrossOrigin(origins = "*", maxAge=3600)
//@RequestMapping("/provider")
//public class ProviderController {
////    @Resource
////    ProviderServices providerServices;
//    @Autowired
//    private ProvidersServiceimpl providerService;
//    @RequestMapping(value = "/getProvider.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
//    @ResponseBody//返回的格式是放到body中
////@RequestParam  注解 获取 前端传递的参数   最根本的还是 servlet  de httprequest  里面的表单值的获取
//    public String getProvider(@RequestParam int id) {
//        Provider provider=new Provider();
//        provider.setId(id);
//        //@RequestParam 是注解，声明下就可以获取传递的参数
//        String relute = providerService.GetProvider(id);//去调度业务逻辑层层进行登录判断结果获取
//        System.out.println(relute);
//        return relute;
//    }
//
//    @RequestMapping("/getproviderlist.do")
//    @ResponseBody
//    public List<Provider> getproviderlist(){
//        List<Provider> list=providerService.GetProviderList();
//        return list;
//    }
//}
package Controller;

import POJO.Bill;
import POJO.Provider;
import POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.impl.ProvidersServiceimpl;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge=3600)
@RequestMapping("/pro")
public class ProviderController {

    @Autowired
    private ProvidersServiceimpl providerService;

    @RequestMapping("/getprolist.do")
    @ResponseBody
    public List<Provider> getprolist(){
        List<Provider> list=providerService.GetProviderList();
        return list;
    }

    @RequestMapping(value = "/getpro.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody
    public String getPro(@RequestParam int id) {
        Provider provider=new Provider();
        provider.setId(id);
        String relute = providerService.GetProvider(id);//去调度业务逻辑层层进行登录判断结果获取
        System.out.println(relute);
        return relute;
    }

    @RequestMapping(value = "/insertProvider.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody//返回的格式是放到body中
    public String insertProvider(@RequestParam String proCode, String proName,String proDesc,
                                 String proContact,String proPhone,String proAddress,String proFax,String createdBy,
                                 String creationDate) {
        Provider provider=new Provider();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProDesc(proDesc);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setCreatedBy(createdBy);
        provider.setCreationDate(creationDate);
        String relute = providerService.AddProvider(provider);
        System.out.println(relute);
        return relute;
    }

    @RequestMapping(value = "/deletePro.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody//返回的格式是放到body中
//@RequestParam  注解 获取 前端传递的参数   最根本的还是 servlet  de httprequest  里面的表单值的获取
    public String deleteBill(@RequestParam int id,Integer isdelete) {
        Provider provider=new Provider();
        provider.setId(id);
        provider.setIsdelete(isdelete);
        //@RequestParam 是注解，声明下就可以获取传递的参数
        String relute =providerService.deleteProvider(provider);//去调度业务逻辑层层
        System.out.println(relute);
        return relute;
    }

    @RequestMapping(value = "/searchpro.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody
    public String searchPro(@RequestParam String proCode) {
        Provider provider=new Provider();
        provider.setProCode(proCode);
        String relute = providerService.SearchProvider(proCode);//去调度业务逻辑层层进行登录判断结果获取
        System.out.println(relute);
        return relute;
    }
}
