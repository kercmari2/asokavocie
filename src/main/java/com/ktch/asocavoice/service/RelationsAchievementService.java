package com.ktch.asocavoice.service;

import com.ktch.asocavoice.dto.RelationsAchievementDTO;
import com.ktch.asocavoice.entity.Achievement;
import com.ktch.asocavoice.entity.Reaction;
import com.ktch.asocavoice.entity.RelationsAchievement;
import com.ktch.asocavoice.exception.ResourceNotFoundException;
import com.ktch.asocavoice.repository.AchievementRepository;
import com.ktch.asocavoice.repository.ReactionRepository;
import com.ktch.asocavoice.repository.RelationsAchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelationsAchievementService {

    @Autowired
    private RelationsAchievementRepository relationsAchievementRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private ReactionRepository reactionRepository;

    public List<RelationsAchievementDTO> getAllRelationsAchievements() {
        return relationsAchievementRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RelationsAchievementDTO getRelationsAchievementById(Long id) {
        RelationsAchievement relationsAchievement = relationsAchievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RelationsAchievement not found"));
        return convertToDTO(relationsAchievement);
    }

    public RelationsAchievementDTO createRelationsAchievement(RelationsAchievementDTO relationsAchievementDTO) {
        RelationsAchievement relationsAchievement = convertToEntity(relationsAchievementDTO);
        relationsAchievement.setCreatedAt(Timestamp.from(Instant.now())); // Set createdAt only when creating
        relationsAchievement.setUpdatedAt(Timestamp.from(Instant.now())); // Set updatedAt when creating
        return convertToDTO(relationsAchievementRepository.save(relationsAchievement));
    }

    public RelationsAchievementDTO updateRelationsAchievement(Long id, RelationsAchievementDTO relationsAchievementDTO) {
        RelationsAchievement relationsAchievement = relationsAchievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RelationsAchievement not found"));

        Achievement achievement = achievementRepository.findById(relationsAchievementDTO.getIdAchievement()).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));
        Reaction reaction = reactionRepository.findById(relationsAchievementDTO.getIdReactions()).orElseThrow(() -> new ResourceNotFoundException("Reaction not found"));

        relationsAchievement.setAchievement(achievement);
        relationsAchievement.setReaction(reaction);
        relationsAchievement.setUserId(relationsAchievementDTO.getUserId());
        relationsAchievement.setUpdatedAt(Timestamp.from(Instant.now())); // Update updatedAt only

        return convertToDTO(relationsAchievementRepository.save(relationsAchievement));
    }

    public void deleteRelationsAchievement(Long id) {
        RelationsAchievement relationsAchievement = relationsAchievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RelationsAchievement not found"));
        relationsAchievementRepository.delete(relationsAchievement);
    }

    private RelationsAchievementDTO convertToDTO(RelationsAchievement relationsAchievement) {
        RelationsAchievementDTO relationsAchievementDTO = new RelationsAchievementDTO();
        relationsAchievementDTO.setId(relationsAchievement.getId());
        relationsAchievementDTO.setIdReactions(relationsAchievement.getReaction().getId());
        relationsAchievementDTO.setIdAchievement(relationsAchievement.getAchievement().getId());
        relationsAchievementDTO.setUserId(relationsAchievement.getUserId());
        relationsAchievementDTO.setCreatedAt(relationsAchievement.getCreatedAt());
        relationsAchievementDTO.setUpdatedAt(relationsAchievement.getUpdatedAt());
        return relationsAchievementDTO;
    }

    private RelationsAchievement convertToEntity(RelationsAchievementDTO relationsAchievementDTO) {
        RelationsAchievement relationsAchievement = new RelationsAchievement();

        Achievement achievement = achievementRepository.findById(relationsAchievementDTO.getIdAchievement()).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));
        Reaction reaction = reactionRepository.findById(relationsAchievementDTO.getIdReactions()).orElseThrow(() -> new ResourceNotFoundException("Reaction not found"));

        relationsAchievement.setAchievement(achievement);
        relationsAchievement.setReaction(reaction);
        relationsAchievement.setUserId(relationsAchievementDTO.getUserId());
        relationsAchievement.setCreatedAt(relationsAchievementDTO.getCreatedAt());
        relationsAchievement.setUpdatedAt(relationsAchievementDTO.getUpdatedAt());
        return relationsAchievement;
    }
}
