package com.taskflow.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskflow.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(String status);

    List<Todo> findByPriority(String priority);

    List<Todo> findByTitleContaining(String keyword);
}
