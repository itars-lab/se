package pl.qa.selenium.data.persistence.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
import pl.qa.selenium.data.persistence.model.User;

import java.util.List;

//@Repository
public interface UserRepository { //extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    List<User> findBySureName(String sureName);

    List<User> findByAge(int age);
}
