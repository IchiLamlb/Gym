package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Process;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProcessRepo extends JpaRepository<Process, Integer> {
    @Query( value = "SELECT * FROM process WHERE register = :id", nativeQuery = true)
    List<Process> getByRegisterId(@Param("id") int id);
}
