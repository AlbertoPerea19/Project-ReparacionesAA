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

    @Column(name="phone_number")
    private int phoneNumber;

    public User(){
    }


    public User( String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public int getphoneNumber() {
        return this.phoneNumber;
    }

    public void setphoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
