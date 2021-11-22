package Controller;

import POJO.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge=3600)
@RequestMapping("/user")  //访问路径 解析路径！在用户请求的时候
// ，DisppatherServlet (Servlet)------转发 的能接收到
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/getuserlist.do")
    @ResponseBody
    public List<User> getuserlist(){
        List<User> list=userService.GetUserList();
        return  list;

    }
//    //@RequestParam 是注解，声明下就可以获取传递的参数
//    @RequestMapping(value = "/getuserpageslist.do",produces = "text/plain;charset=UTF-8")
//    @ResponseBody//返回的格式是放到body中
//    public String getuserpageslist(@RequestParam int pageindex, int pagesize) {
//        String userlist = userService.GetUserPagesList(pageindex, pagesize);
//        System.out.println(userlist);
//        return userlist;
//    }
//
    @RequestMapping(value = "/userlogin.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody//返回的格式是放到body中
    public String userlogin(@RequestParam String userCode, String userPassword, HttpServletRequest request) {
        //@RequestParam 是注解，声明下就可以获取传递的参数
        HttpSession session = request.getSession(false);
        if(session == null) {
            session = request.getSession(true);
        }
        String userlist = userService.UserLogin(userCode, userPassword, session);
        System.out.println(userlist);
        return userlist;
    }

//    @RequestMapping(value = "/serchuserpages.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
//    @ResponseBody//返回的格式是放到body中
//    public String GetSerchUserPagesList(@RequestParam int page,int  limit , String UserNme) {
//        //@RequestParam 是注解，声明下就可以获取传递的参数
////        if(UserNme=="") {
////            UserNme = null;
////        }
//        String userlist = userService.GetSerchUserPagesList(page, limit,UserNme);//去调度业务逻辑层层进行登录判断结果获取
//        System.out.println(userlist);
//        return userlist;
//    }
//
    @RequestMapping(value = "/insertUser.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody
    public String insertUser(@RequestParam String userCode,
                             String userName,String userPassword,String sex,String phone,String address) {
        User user=new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setSex(sex);
        user.setPhone(phone);
        user.setAddress(address);
        String relute = userService.AddUser(user);
        System.out.println(relute);
        return relute;
    }

//    @RequestMapping(value = "/updateUser.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
//    @ResponseBody//返回的格式是放到body中
////@RequestParam  注解 获取 前端传递的参数   最根本的还是 servlet  de httprequest  里面的表单值的获取
//    public String updateUser(@RequestParam int id,String addr) {
//
//        User user=new User();
//        user.setId(id);
//        user.setAddr(addr);
//        //@RequestParam 是注解，声明下就可以获取传递的参数
//        String relute = userService.UpdateUser(user);//去调度业务逻辑层层
//        System.out.println(relute);
//        return relute;
//    }
//
//
    @RequestMapping(value = "/getUser.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
    @ResponseBody//返回的格式是放到body中
//@RequestParam  注解 获取 前端传递的参数   最根本的还是 servlet  de httprequest  里面的表单值的获取
    public String getUser(@RequestParam int id) {
        User user=new User();
        user.setId(id);
        //@RequestParam 是注解，声明下就可以获取传递的参数
        String relute = userService.GetUser(id);//去调度业务逻辑层层进行登录判断结果获取
        System.out.println(relute);
        return relute;
    }
//
//    @RequestMapping(value = "/deleteUser.do",method = RequestMethod.POST,produces={"application/json;","text/html;charset=UTF-8;"})
//    @ResponseBody//返回的格式是放到body中
////@RequestParam  注解 获取 前端传递的参数   最根本的还是 servlet  de httprequest  里面的表单值的获取
//    public String deleteUser(@RequestParam int id,HttpServletRequest request) {
//
//        HttpSession session=request.getSession(false);
//        User user=new User();
//        user.setId(id);
//        //@RequestParam 是注解，声明下就可以获取传递的参数
//        String relute = userService.deleteUser(id,session);//去调度业务逻辑层
//        System.out.println(relute);
//        return relute;
//    }
}


