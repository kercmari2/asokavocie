package com.ktch.asocavoice.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
@Entity
public class RelationsAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reactions", nullable = false) // Asegúrate de que el nombre de la columna sea correcto
    private Reaction reaction;

    @ManyToOne
    @JoinColumn(name = "id_achievement", nullable = false) // Asegúrate de que el nombre de la columna sea correcto
    private Achievement achievement;

    private int userId;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
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

    public static class AuditListener {

        @PrePersist
        public void setCreatedAt(RelationsAchievement relationsAchievement) {
            Timestamp now = Timestamp.from(Instant.now());
            relationsAchievement.setCreatedAt(now);
            relationsAchievement.setUpdatedAt(now);
        }

        @PreUpdate
        public void setUpdatedAt(RelationsAchievement relationsAchievement) {
            relationsAchievement.setUpdatedAt(Timestamp.from(Instant.now()));
        }
    }
}
