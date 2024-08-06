package com.ktch.asocavoice.repository;

import com.ktch.asocavoice.entity.RelationsAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationsAchievementRepository extends JpaRepository<RelationsAchievement, Long> {
}
