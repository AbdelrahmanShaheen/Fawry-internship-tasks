package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.entity.Product;
import org.eclipse.jakarta.hello.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    private final ProductRepository productRepo = ProductRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        productRepo.addProduct(newProduct);

        request.setAttribute("products",productRepo.findProducts());
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
