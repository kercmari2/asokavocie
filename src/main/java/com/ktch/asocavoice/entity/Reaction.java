package com.ktch.asocavoice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "reaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelationsAchievement> relationsAchievements;

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

    public List<RelationsAchievement> getRelationsAchievements() {
        return relationsAchievements;
    }

    public void setRelationsAchievements(List<RelationsAchievement> relationsAchievements) {
        this.relationsAchievements = relationsAchievements;
    }
}
