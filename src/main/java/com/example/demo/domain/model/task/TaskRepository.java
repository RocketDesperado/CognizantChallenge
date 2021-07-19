package com.example.demo.domain.model.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    <T> Collection<T> findByTaskName(String taskName, Class<T> type);

}
