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
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/hello")
public class LoginServlet extends HttpServlet {
    private UserService userService= new UserServiceIml();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        String method = req.getParameter("method");
        Class<LoginServlet> loginServletClass = LoginServlet.class;
        try {
            LoginServlet ls = loginServletClass.newInstance();
            Method declaredMethod = loginServletClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(ls,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    protected void login(HttpServletRequest req,HttpServletResponse resp) throws Exception {
        String username = req.getParameter("name");
        String password = req.getParameter("pwd");
        User login = userService.login(new User(username, password));
        if(login != null){
           resp.getWriter().write("ok");
        }else{
            resp.getWriter().write("no");
        }
    }
}
