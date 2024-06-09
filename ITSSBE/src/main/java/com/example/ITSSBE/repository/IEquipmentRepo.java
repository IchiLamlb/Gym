package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEquipmentRepo extends JpaRepository<Equipment, Integer> {
    @Query( value = "SELECT * FROM equipment WHERE room = :id ", nativeQuery = true)
    Equipment findById(@Param("id") int id);
    @Query( value = "SELECT * FROM equipment WHERE name = :name ", nativeQuery = true)
    Equipment findByName(@Param("name") String name);
    @Query( value = "DELETE FROM equipment WHERE id = :id LIMIT 1", nativeQuery = true)
    Equipment DeleteById(@Param("id") int id);
}
