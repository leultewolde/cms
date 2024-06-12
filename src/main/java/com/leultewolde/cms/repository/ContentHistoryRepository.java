package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.ContentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentHistoryRepository extends JpaRepository<ContentHistory, Integer> {
    Optional<List<ContentHistory>> findContentHistoriesByContent_ContentId(Integer contentId);
    Optional<List<ContentHistory>> findContentHistoriesByModifiedBy_UserId(Integer userId);
}
