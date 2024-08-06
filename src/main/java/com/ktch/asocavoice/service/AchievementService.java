package com.ktch.asocavoice.service;

import com.ktch.asocavoice.dto.AchievementDTO;
import com.ktch.asocavoice.entity.Achievement;
import com.ktch.asocavoice.exception.ResourceNotFoundException;
import com.ktch.asocavoice.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public List<AchievementDTO> getAllAchievements() {
        return achievementRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AchievementDTO getAchievementById(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));
        return convertToDTO(achievement);
    }

    public AchievementDTO createAchievement(AchievementDTO achievementDTO) {
        Achievement achievement = convertToEntity(achievementDTO);
        achievement.setCreatedAt(Timestamp.from(Instant.now()));
        achievement.setUpdatedAt(Timestamp.from(Instant.now()));
        return convertToDTO(achievementRepository.save(achievement));
    }

    public AchievementDTO updateAchievement(Long id, AchievementDTO achievementDTO) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));

        achievement.setTitle(achievementDTO.getTitle());
        achievement.setDate(achievementDTO.getDate());
        achievement.setArea(achievementDTO.getArea());
        achievement.setDescription(achievementDTO.getDescription());
        achievement.setImage(achievementDTO.getImage());
        achievement.setTypeVisible(achievementDTO.getTypeVisible());
        achievement.setUpdatedAt(Timestamp.from(Instant.now())); // Solo actualizar updatedAt

        return convertToDTO(achievementRepository.save(achievement));
    }

    public void deleteAchievement(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));
        achievementRepository.delete(achievement);
    }
    public AchievementDTO updateTypeVisible(Long id, Boolean typeVisible) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));

        achievement.setTypeVisible(typeVisible);
        achievement.setUpdatedAt(Timestamp.from(Instant.now())); // Update updatedAt only

        return convertToDTO(achievementRepository.save(achievement));
    }

    private AchievementDTO convertToDTO(Achievement achievement) {
        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(achievement.getId());
        achievementDTO.setTitle(achievement.getTitle());
        achievementDTO.setDate(achievement.getDate());
        achievementDTO.setArea(achievement.getArea());
        achievementDTO.setDescription(achievement.getDescription());
        achievementDTO.setImage(achievement.getImage());
        achievementDTO.setTypeVisible(achievement.getTypeVisible());
        achievementDTO.setCreatedAt(achievement.getCreatedAt());
        achievementDTO.setUpdatedAt(achievement.getUpdatedAt());
        return achievementDTO;
    }

    private Achievement convertToEntity(AchievementDTO achievementDTO) {
        Achievement achievement = new Achievement();
        achievement.setId(achievementDTO.getId());
        achievement.setTitle(achievementDTO.getTitle());
        achievement.setDate(achievementDTO.getDate());
        achievement.setArea(achievementDTO.getArea());
        achievement.setDescription(achievementDTO.getDescription());
        achievement.setImage(achievementDTO.getImage());
        achievement.setTypeVisible(achievementDTO.getTypeVisible());
        achievement.setCreatedAt(achievementDTO.getCreatedAt());
        achievement.setUpdatedAt(achievementDTO.getUpdatedAt());
        return achievement;
    }
}
