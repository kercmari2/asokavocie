package com.ktch.asocavoice.dto;

import java.sql.Timestamp;

public class RelationsAchievementDTO {

    private Long id;
    private Long idReactions; // ID de Reaction
    private Long idAchievement; // ID de Achievement
    private int userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private ReactionDTO reaction; // Relación con Reaction
    private AchievementDTO achievement; // Relación con Achievement

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdReactions() {
        return idReactions;
    }

    public void setIdReactions(Long idReactions) {
        this.idReactions = idReactions;
    }

    public Long getIdAchievement() {
        return idAchievement;
    }

    public void setIdAchievement(Long idAchievement) {
        this.idAchievement = idAchievement;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ReactionDTO getReaction() {
        return reaction;
    }

    public void setReaction(ReactionDTO reaction) {
        this.reaction = reaction;
    }

    public AchievementDTO getAchievement() {
        return achievement;
    }

    public void setAchievement(AchievementDTO achievement) {
        this.achievement = achievement;
    }
}
