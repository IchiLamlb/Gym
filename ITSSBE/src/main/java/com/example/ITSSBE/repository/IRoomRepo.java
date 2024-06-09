package com.example.ITSSBE.repository;
import com.example.ITSSBE.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepo extends JpaRepository<Room, Integer>{
    @Query( value = "SELECT * FROM room WHERE id = :id LIMIT 1", nativeQuery = true)
    Room findById(@Param("id") int id);
//    @Query( value = "SELECT * FROM room WHERE address = :address LIMIT 1", nativeQuery = true)
//    Room findByAddress(String address);
}
