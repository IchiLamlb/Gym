package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
    User findByGmailAndPassword(String gmail, String password);

    User findFirstById(int id);
    @Query( value = "select * from user where role != 2", nativeQuery = true)
    List<User> findByRole();
    @Query( value = "select * from user where role = 2", nativeQuery = true)
    List<User> findCustomers();
    @Modifying
    @Query(value = "UPDATE user set is_deleted = 1 where id = :id", nativeQuery = true)
    @Transactional
    void deleteById(@Param("id")int id);

}
