package com.ktch.asocavoice.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@EntityListeners(Achievement.AuditListener.class)
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Timestamp date;
    private String area;
    private String description;
    private String image;
    private Boolean typeVisible;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelationsAchievement> relationsAchievements;

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

    public List<RelationsAchievement> getRelationsAchievements() {
        return relationsAchievements;
    }

    public void setRelationsAchievements(List<RelationsAchievement> relationsAchievements) {
        this.relationsAchievements = relationsAchievements;
    }

    public static class AuditListener {

        @PrePersist
        public void setCreatedAt(Achievement achievement) {
            Timestamp now = Timestamp.from(Instant.now());
            achievement.setCreatedAt(now);
            achievement.setUpdatedAt(now);
        }

        @PreUpdate
        public void setUpdatedAt(Achievement achievement) {
            achievement.setUpdatedAt(Timestamp.from(Instant.now()));
        }
    }
}
