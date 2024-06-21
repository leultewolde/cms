package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findTasksByAssignedTo_Username(String username);
}
