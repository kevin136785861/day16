package common.controller;

import domain.User;
import service.UserService;
import service.UserServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/hello")
public class LoginServlet extends HttpServlet {
    private UserService userService= new UserServiceIml();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        User login = userService.login(new User(username, password));
        List<String> list = userService.userAll();
        if(login != null){
            HttpSession session = req.getSession();
            session.setAttribute("loginuser",login);
            resp.sendRedirect(req.getContextPath()+"/page/main.jsp");
        }else{
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/page/login.jsp").forward(req,resp);
        }

    }
}
