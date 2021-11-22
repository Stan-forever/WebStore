//package conf;
//
//import javax.servlet.*;
//import org.springframework.context.annotation.Configuration;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Configuration
//public class CorsConfig implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080"); // 允许的来源
//        response.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允许证书
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT"); // 允许的请求方式
//        response.setHeader("Access-Control-Max-Age", "3600"); // 预检请求的有效期
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//        chain.doFilter(req, res);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
