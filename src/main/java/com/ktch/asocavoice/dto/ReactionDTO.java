package com.ktch.asocavoice.dto;

import java.util.List;

public class ReactionDTO {

    private Long id;
    private String name;
    private List<RelationsAchievementDTO> relationsAchievements; // Representa la relación con RelationsAchievement, puede ser nulo

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RelationsAchievementDTO> getRelationsAchievements() {
        return relationsAchievements;
    }

    public void setRelationsAchievements(List<RelationsAchievementDTO> relationsAchievements) {
        this.relationsAchievements = relationsAchievements;
    }
}
