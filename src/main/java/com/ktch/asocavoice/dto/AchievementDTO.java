package com.ktch.asocavoice.dto;

import java.sql.Timestamp;
import java.util.List;

public class AchievementDTO {

    private Long id;
    private String title;
    private Timestamp date;
    private String area;
    private String description;
    private String image;
    private Boolean typeVisible;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<RelationsAchievementDTO> relationsAchievements; // Representa la relación con RelationsAchievement

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getTypeVisible() {
        return typeVisible;
    }

    public void setTypeVisible(Boolean typeVisible) {
        this.typeVisible = typeVisible;
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

    public List<RelationsAchievementDTO> getRelationsAchievements() {
        return relationsAchievements;
    }

    public void setRelationsAchievements(List<RelationsAchievementDTO> relationsAchievements) {
        this.relationsAchievements = relationsAchievements;
    }
}
