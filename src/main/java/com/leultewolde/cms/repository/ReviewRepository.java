package com.leultewolde.cms.repository;

import com.leultewolde.cms.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
