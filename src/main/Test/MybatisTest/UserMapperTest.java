package MybatisTest;
import Mapper.UserMapper;
import POJO.PagesInfor;
import POJO.User;
import Utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
public class UserMapperTest {
    @Test
    public void GetUserList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserlist();
        for(User user :list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void AddUserMapperTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(3);
        user.setName("李四");
        user.setSex("女");
        user.setAge(23);
        user.setTel("123456");
        user.setAddr("厦门");
        userMapper.InsertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void UpdateUserMapperTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("xujunsheng");
        user.setId(1);
        int relute = userMapper.UpdateUser(user);
        System.out.println(relute);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void DeleteUserMapperTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(3);
        int relute=userMapper.DeleteUser(user);
        System.out.println(relute);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void CheckUserMapperTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("张三");
        List<User> listuser = userMapper.CheckUser(user);
        System.out.println(listuser.get(0));
    }
    @Test
    public void pagesListTest() {
        int pageIndex = 0;
        int pageSize = 5;
        int PageBegin = pageIndex * pageSize;
        int PageEnd = pageIndex * pageSize + pageSize;
        PagesInfor pagesInfor = new PagesInfor();
        pagesInfor.setPagebegin(PageBegin);
        pagesInfor.setPageend(PageEnd);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<PagesInfor> PagesInforList = userMapper.TotalUser();
        List<User> userPagesList = userMapper.GetUserPagesList(pagesInfor);
        System.out.println(PagesInforList.get(0));
        for(User user : userPagesList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
