package javatest;

import org.junit.Test;
import org.springframework.util.DigestUtils;
import test.Javatest;
public class JavaTest {
@Test
    public void testJava() {
    Javatest javatest = new Javatest();
    javatest.testname("徐俊生");
}
@Test
    public void md5test() {
    String pass = DigestUtils.md5DigestAsHex("123456".getBytes());
    System.out.println(pass);
}
}
