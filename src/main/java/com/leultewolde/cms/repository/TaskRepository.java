package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
