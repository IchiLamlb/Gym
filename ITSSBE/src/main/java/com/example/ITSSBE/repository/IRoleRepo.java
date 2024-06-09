package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Integer> {

    @Query( value = "SELECT * FROM role where name = :name LIMIT 1", nativeQuery = true)
    Role findByName(@Param("name") String name);
    @Query( value = "select * from role where id = :id limit 1", nativeQuery = true)
    Role findFirstByRoleId(@Param("id") int id);
}
