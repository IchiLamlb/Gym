package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.FeedBack;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeedBackRepo extends JpaRepository<FeedBack, Integer>{
    @Modifying
    @Query( value = "DELETE FROM feedback where id = :id", nativeQuery = true)
    @Transactional
    FeedBack deleteFeedBack(@Param("id")int id);
    @Query( value = "SELECT * FROM feedback WHERE id = :id", nativeQuery = true)
    FeedBack findById(int id);
    @Query( value = "SELECT * FROM feedback WHERE user = :id", nativeQuery = true)
    List<FeedBack> findByUser(int id);
}
