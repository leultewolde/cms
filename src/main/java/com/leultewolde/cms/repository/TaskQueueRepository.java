package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.TaskQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskQueueRepository extends JpaRepository<TaskQueue, Integer> {
}
