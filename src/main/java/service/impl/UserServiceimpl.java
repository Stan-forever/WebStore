package service.impl;

import Mapper.UserMapper;
import POJO.MMGridPageVoBean;
import POJO.PagesInfor;
import POJO.SrechModel;
import POJO.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceimpl implements UserService {
    //引用用类型，使用自动注入  @Autowired ,@Resource
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User>  GetUserList(){
        List<User> list=userMapper.getUserlist();
        return  list;
    }
//    @Override
//    public  String GetUserPagesList( int pageindex , int pagesize){
//        //定义页码，计算页码规则
//        int Pagebegin = pageindex * pagesize;
//        PagesInfor pagesInfor = new PagesInfor();
//        pagesInfor.setPagebegin(Pagebegin);
//        pagesInfor.setPageend(pagesize);
//        List<PagesInfor> Pageslist = userMapper.TotalUser();//获取总数
//        List<User>  list = userMapper.GetUserPagesList(pagesInfor);//获取分页后的数据
//        //map类别类型数据是hashmap 类型！是属于键，值模式   Map<String,String>  第一个是键，第二是值
//        Map<String,List> map=new HashMap<>();
//        map.put("Pages",Pageslist);//将数据放入map中
//        map.put("list",list); //将list数据放入map中
//        JSONObject json=  JSONObject.fromObject(map); //将map转换成json数据
//        return  json.toString();//将json数据转换成string类型
//    }

    public  String UserLogin(String userCode, String userPassword, HttpSession session){
        User user =new User();
        boolean success = false;
        String  msg="";
        user.setUserCode(userCode);
        user.setUserPassword(userPassword);
        List<User> userlist=  userMapper.UserLogin(user);
        if(userlist.size()>0){
            session.setAttribute("name", userlist.get(0).getUserName());
            session.setAttribute("id", userlist.get(0).getId());
            System.out.println(session.getAttribute("name"));
            msg="登录成功";
            success=true;
        }else {
            msg="登录失败";
            success=false;
        }
        JSONObject  jsonObject=new JSONObject();
        jsonObject.put("msg",msg);
        jsonObject.put("success", success);
        JSONObject json=  JSONObject.fromObject(jsonObject);
        return  json.toString();
    }

//    public  String GetSerchUserPagesList( int pageindex , int pagesize,String UserNme){
//        //定义页码，计算页码规则
//        pageindex=pageindex-1;  //因为前端传递过来的是第一页，而我们后台取数据库的时候是0到第一页数量
//        pageindex = pageindex * pagesize;
//        SrechModel mode=new SrechModel(); //分页检索实体
//        mode.setSrechaStr(UserNme);
//        mode.setPagesindex(pageindex);
//        mode.setPagesize(pagesize);
//        List<PagesInfor> Pageslist = userMapper.SrechTotleUser(mode);//获取总数
//        List<User>  list = userMapper.SerchUserPagesList(mode);//获取分页后的数据
//        MMGridPageVoBean<User> vo = new MMGridPageVoBean<>(); //使用这个实体，来返回对应的数据给前端
//        vo.setTotal(Pageslist.get(0).getTotle());
//        vo.setRows(list);
//        JSONObject json=  JSONObject.fromObject(vo); //将map转换成json数据
//        return  json.toString();//将json数据转换成string类型
//    }
//
    public String AddUser(User user) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();
        List<User> list = userMapper.CheckUser(user);
        if (list.size() > 0) {
            success = false;
            msg = "该用户已经存在了，请修改";
        } else {
            int result = userMapper.InsertUser(user);
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
        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }

    @Override
    public String UpdateUser(User user) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        int result = userMapper.UpdateUser(user);

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
//
//
    public String GetUser(int id) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        User user=new User();
        user.setId(id);
        user = userMapper.getUser(user);

        if (user !=null) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        map.put("user", user);

        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }
//
    @Override
    public String deleteUser(int id, HttpSession session) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        User user = new User();
        user.setId(id);
        User olduser = userMapper.getUser(user);
        if (session != null) {
            String oldusername = session.getAttribute("name").toString();
            if (oldusername.equals(olduser.getUserName())) {
                success = false;
                msg = "不能把自己删除";
            } else {
                int result = userMapper.deleteUser(user);
                if (result > 0) {
                    success = true;
                    msg = "删除用户信息成功";
                } else {
                    success = false;
                    msg = "删除用户信息失败";
                }
            }
        } else {
            success = false;
            msg = "1";
        }
        map.put("success", success);
        map.put("msg", msg);
        map.put("user", user);

        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }


}
