package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageRepo extends JpaRepository<Package, Integer> {
    @Query( value = "SELECT * FROM package WHERE id = :id LIMIT 1", nativeQuery = true)
    Package findById(@Param("id") int id);
}
