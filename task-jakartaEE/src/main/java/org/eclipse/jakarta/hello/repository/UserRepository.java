package org.eclipse.jakarta.hello.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.eclipse.jakarta.hello.entity.User;

public class UserRepository {
    private static UserRepository userRepository;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sh");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public static UserRepository getInstance(){
        if(userRepository != null){
            return userRepository;
        }
        synchronized (UserRepository.class) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    public boolean findUser(String name, String password){
        TypedQuery<User>query = entityManager
                .createQuery("SELECT u FROM User u WHERE u.name=:userName AND u.password=:pass",User.class);
        query.setParameter("userName", name);
        query.setParameter("pass" ,password);
        User user = query.getSingleResult();
        if(user != null) {
            return true;
        }
        return false;
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
