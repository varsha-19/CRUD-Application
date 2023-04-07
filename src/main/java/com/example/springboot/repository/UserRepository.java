package com.example.springboot.repository;

import com.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    //@Query("SELECT n FROM users n")
    //public List<User> findByFirstName(String name);

   // @Query("SELECT n FROM User n where n.firstName=:name")
    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT n FROM User n where n.firstName=:name")
    public List<User> findByName(@Param("name") String name);
}
