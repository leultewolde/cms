package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
}
