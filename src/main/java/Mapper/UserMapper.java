package Mapper;

import POJO.PagesInfor;
import POJO.SrechModel;
import POJO.User;

import java.util.List;

public interface UserMapper {

    List<User>  getUserlist();
    int InsertUser(User user);
//
//    int DeleteUser(User user);
    List<User> CheckUser(User user);
//    int InsertList(List<User> list);
//    List<PagesInfor> TotalUser();
//    List<User> GetUserPagesList(PagesInfor pagesInfor);
    List<User> UserLogin(User user);
//    //用户检索
//    List<User> SerchUserPagesList(SrechModel model);
//    //用户检索
//    List<PagesInfor> SrechTotleUser(SrechModel model);
    //用户信息添加
    String AddUser(User user);
    User getUser(User user);
    int UpdateUser(User user);
    int deleteUser(User user);
}
