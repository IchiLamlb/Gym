package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.EpCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEpCategoryRepo extends JpaRepository<EpCategory, Integer> {
    @Query(value = "SELECT * FROM ep_category where name = :name", nativeQuery = true)
    EpCategory findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM ep_category where id = :id", nativeQuery = true)
    EpCategory findById(@Param("id") int id);
}
