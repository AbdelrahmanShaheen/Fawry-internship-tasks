package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.repository.ProductRepository;
import org.eclipse.jakarta.hello.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final ProductRepository productRepo = ProductRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();
    public LoginServlet(){
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean isUserExist = userRepository.findUser(name, password);
        if(isUserExist){
            request.setAttribute("products",productRepo.findProducts());
            request.getRequestDispatcher("products.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("errorLoggedin.jsp");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
