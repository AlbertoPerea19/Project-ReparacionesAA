package reparacionesaa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="User_id")
    private String UserID;

    public User(){
    }

    public User(String name){
        this.name=name;
    }

    public User( String name, String UserID) {
        this.name = name;
        this.UserID = UserID;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "{" +
            ", name='" + getname() + "'" +
            ", UserID='" + getUserID() + "'" +
            "}";
    }


}
