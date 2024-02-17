package org.eclipse.jakarta.hello.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.entity.Product;

import java.util.List;
@Transactional
public class ProductRepository {
    private static ProductRepository productRepository;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private ProductRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("sh");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public static ProductRepository getInstance(){
        if(productRepository != null){
            return productRepository;
        }
        synchronized (ProductRepository.class) {
                productRepository = new ProductRepository();
        }
        return productRepository;
    }
    public List<Product> findProducts() {
        return entityManager.createQuery("SELECT p FROM Product p",Product.class).getResultList();
    }

    public void addProduct(Product product) {
        try{
            begin();
                entityManager.persist(product);
            commit();
        }catch (Exception exception){
            rollback();
        }
    }
    public Product findProductById(Integer id){
        Product product = entityManager.find(Product.class ,id);
        return product;
    }
    public void updateProduct(Integer id ,String name, double price){
        try {
        begin();
            Product product = findProductById(id);
            product.setName(name);
            product.setPrice(price);
            entityManager.persist(product);
        commit();
        }catch (Exception exception){
            rollback();
        }
    }
    public void deleteProduct(int id) {
        try {
            begin();
            Product product = findProductById(id);
                entityManager.remove(product);
            commit();
        }catch (Exception exception){
            rollback();
        }
    }
    private void commit(){
        entityManager.getTransaction().commit();
    }
    private void begin(){
        entityManager.getTransaction().begin();
    }
    private void rollback(){
        entityManager.getTransaction().rollback();
    }
}
