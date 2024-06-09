package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Register;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegisterRepo extends JpaRepository<Register, Integer> {

    Register findFirstById(int id);

    @Modifying
    @Query( value = "update register set is_deleted = true where id = :id", nativeQuery = true)
    @Transactional
    void deleteById(@Param("id") int id);
    @Query( value = "select * from register where customer = :customerId", nativeQuery = true)
    List<Register> findByCustomerId(@Param("customerId") int customerId);
}
