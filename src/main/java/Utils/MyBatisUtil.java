package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    //    从 XML 文件中构建 SqlSessionFactory 的实例非常简单，
    //    建议使用类路径下的资源文件进行配置
    //MyBatis 包含一个名叫 Resources 的工具类，
    //    它包含一些实用方法，使得从类路径或其它位置加载资源文件更加容易
    static {
        try {

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回sqlSession连接
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
