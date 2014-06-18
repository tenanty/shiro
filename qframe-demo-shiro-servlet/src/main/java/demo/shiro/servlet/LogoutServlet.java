package demo.shiro.servlet;

import demo.shiro.tool.Web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.smart4j.security.SmartSecurityHelper;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前用户并进行登出操作
        SmartSecurityHelper.logout();

        // 重定向到首页
        Web.redirect("/");
    }
}
