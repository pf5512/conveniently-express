package com.neng.repository;

import com.neng.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByNameAndPassword(String username, String password);

    int countByName(String username);

    User findUserByName(String neng);
}
