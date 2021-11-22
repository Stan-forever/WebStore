package service;

import POJO.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    List<User> GetUserList();
//    String GetUserPagesList(int pageindex, int pagesize);
    String UserLogin(String userCode, String userPassword, HttpSession session);
//    String GetSerchUserPagesList(int pageindex, int pagesize, String UserName);
    String AddUser(User user);
    String UpdateUser(User user);
    String GetUser(int id);
    String deleteUser(int id, HttpSession session);
}
