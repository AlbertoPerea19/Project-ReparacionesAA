package reparacionesaa.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import reparacionesaa.daos.UserDao;
import reparacionesaa.entities.User;
import reparacionesaa.hibernate.orm.EntityManagerProvider;

public class UserController {
   private UserDao userDao;

   public UserController(){
      EntityManager defaultEntityManager= EntityManagerProvider
      .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);
      userDao= new UserDao(defaultEntityManager);
   }

   public List<User> getUsers(){
      return this.userDao.findAll();
   }

   public void addUser(User user){
      this.userDao.create(user);
   }

   public boolean setUserStateForCommandsBot(String id){
      Boolean existe=false;
      UserController controller=new UserController();
      List<User> listaUsers=new ArrayList<User>();
      listaUsers=controller.getUsers();
      for(int i=0;i<listaUsers.size();i++){
         if(listaUsers.get(i).getUserID().equals(id)){
            existe= true;
         }
      }
      return existe;
      
   }

   public static void main(String[] args) {
      UserController controller=new UserController();
      User user= new User("Carlos Magaña","1492741535");
      controller.addUser(user);
   }
}
