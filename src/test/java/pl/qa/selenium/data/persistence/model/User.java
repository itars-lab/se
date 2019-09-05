package pl.qa.selenium.data.persistence.model;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//@Entity
public class User {

//    @Id
//    @GeneratedValue
    private long id;

//    @Column
    private String firstName;

//    @Column
    private String sureName;

    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }
}
