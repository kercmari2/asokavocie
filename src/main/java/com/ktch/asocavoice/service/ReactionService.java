package com.ktch.asocavoice.service;

import com.ktch.asocavoice.dto.ReactionDTO;
import com.ktch.asocavoice.dto.RelationsAchievementDTO;
import com.ktch.asocavoice.entity.Reaction;
import com.ktch.asocavoice.entity.RelationsAchievement;
import com.ktch.asocavoice.exception.ResourceNotFoundException;
import com.ktch.asocavoice.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    public List<ReactionDTO> getAllReactions() {
        return reactionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReactionDTO getReactionById(Long id) {
        Reaction reaction = reactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reaction not found"));
        return convertToDTO(reaction);
    }

    public ReactionDTO createReaction(ReactionDTO reactionDTO) {
        Reaction reaction = convertToEntity(reactionDTO);
        return convertToDTO(reactionRepository.save(reaction));
    }

    public ReactionDTO updateReaction(Long id, ReactionDTO reactionDTO) {
        Reaction reaction = reactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reaction not found"));

        reaction.setName(reactionDTO.getName());

        return convertToDTO(reactionRepository.save(reaction));
    }

    public void deleteReaction(Long id) {
        Reaction reaction = reactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reaction not found"));
        reactionRepository.delete(reaction);
    }

    private ReactionDTO convertToDTO(Reaction reaction) {
        ReactionDTO reactionDTO = new ReactionDTO();
        reactionDTO.setId(reaction.getId());
        reactionDTO.setName(reaction.getName());
        // Manejar relaciones nulas
        if (reaction.getRelationsAchievements() != null) {
            reactionDTO.setRelationsAchievements(
                    reaction.getRelationsAchievements().stream().map(this::convertToRelationsAchievementDTO).collect(Collectors.toList())
            );
        }
        return reactionDTO;
    }

    private Reaction convertToEntity(ReactionDTO reactionDTO) {
        Reaction reaction = new Reaction();
        reaction.setId(reactionDTO.getId());
        reaction.setName(reactionDTO.getName());
        return reaction;
    }

    private RelationsAchievementDTO convertToRelationsAchievementDTO(RelationsAchievement relationsAchievement) {
        RelationsAchievementDTO dto = new RelationsAchievementDTO();
        dto.setId(relationsAchievement.getId());
        dto.setIdReactions(relationsAchievement.getReaction().getId());
        dto.setIdAchievement(relationsAchievement.getAchievement().getId());
        dto.setUserId(relationsAchievement.getUserId());
        dto.setCreatedAt(relationsAchievement.getCreatedAt());
        dto.setUpdatedAt(relationsAchievement.getUpdatedAt());
        return dto;
    }
}
