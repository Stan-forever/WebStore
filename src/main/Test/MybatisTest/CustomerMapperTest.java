package MybatisTest;
import POJO.PagesInfor;
import Utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class CustomerMapperTest {
    @Test
    public void GetCustomerList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> list = customerMapper.getCustomerlist();
        for(Customer customer :list) {
            System.out.println(customer);
        }
        sqlSession.close();
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
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<PagesInfor> PagesInforList = customerMapper.TotalCustomer();
        List<Customer> customerPagesList = customerMapper.GetCustomerPagesList(pagesInfor);
        System.out.println(PagesInforList.get(0));
        for(Customer customer : customerPagesList) {
            System.out.println(customer);
        }
        sqlSession.close();
    }
}
