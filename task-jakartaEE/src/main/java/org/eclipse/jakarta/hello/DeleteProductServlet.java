package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private final ProductRepository productRepo = ProductRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId =  Integer.parseInt(request.getParameter("productId"));

        productRepo.deleteProduct(productId);
        request.setAttribute("products",productRepo.findProducts());

        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
