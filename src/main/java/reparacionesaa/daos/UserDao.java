package reparacionesaa.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import reparacionesaa.entities.User;

public class UserDao {
    
    private final EntityManager EM;

    

    public UserDao(EntityManager EM) {
        this.EM = EM;
    }

    public void create(User user){
        EntityTransaction transaction= EM.getTransaction();

        try {
            transaction.begin();
            EM.persist(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    public List<User> findAll(){
        String queryFindAll="SELECT m FROM User m";
        return  EM.createQuery(queryFindAll,User.class).getResultList();
    }


}
