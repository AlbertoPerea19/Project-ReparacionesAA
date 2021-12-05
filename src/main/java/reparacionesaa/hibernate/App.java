package reparacionesaa.hibernate;

import javax.persistence.EntityManager;

import reparacionesaa.daos.UserDao;
import reparacionesaa.entities.User;
import reparacionesaa.hibernate.orm.EntityManagerProvider;

public class App {
    
     public static void main(String[] args) {
        EntityManager defaultEntityManager= EntityManagerProvider
        .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);

        UserDao userDao= new UserDao(defaultEntityManager);

        //create

        User user1 = new User("Roberto Hernandez",999258499 );
        userDao.create(user1);


    }
}
