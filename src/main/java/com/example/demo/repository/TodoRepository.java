package com.example.demo.repository;

import com.example.demo.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

    // Custom query
//    List<TodoEntity> findByUserId(String userId);

    @Query(value= "select * from Todo as t where t.userId = ?1", nativeQuery = true)
    List<TodoEntity> findByUserId(String userId);
}
