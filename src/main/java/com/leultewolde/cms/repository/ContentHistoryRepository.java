package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.ContentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentHistoryRepository extends JpaRepository<ContentHistory, Integer> {
}
