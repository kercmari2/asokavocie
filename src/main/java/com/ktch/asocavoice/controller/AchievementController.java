package com.ktch.asocavoice.controller;

import com.ktch.asocavoice.dto.AchievementDTO;
import com.ktch.asocavoice.dto.ApiResponse;
import com.ktch.asocavoice.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping
    public ResponseEntity<List<AchievementDTO>> getAllAchievements() {
        return ResponseEntity.ok(achievementService.getAllAchievements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchievementDTO> getAchievementById(@PathVariable Long id) {
        return ResponseEntity.ok(achievementService.getAchievementById(id));
    }

    @PostMapping
    public ResponseEntity<AchievementDTO> createAchievement(@RequestBody AchievementDTO achievementDTO) {
        AchievementDTO createdAchievement = achievementService.createAchievement(achievementDTO);
        return ResponseEntity.ok(createdAchievement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AchievementDTO> updateAchievement(@PathVariable Long id, @RequestBody AchievementDTO achievementDTO) {
        AchievementDTO updatedAchievement = achievementService.updateAchievement(id, achievementDTO);
        return ResponseEntity.ok(updatedAchievement);
    }
    @PatchMapping("/{id}/typeVisible")
    public ResponseEntity<AchievementDTO> updateTypeVisible(@PathVariable Long id, @RequestBody AchievementDTO achievementDTO) {
        AchievementDTO updatedAchievement = achievementService.updateTypeVisible(id, achievementDTO.getTypeVisible());
        return ResponseEntity.ok(updatedAchievement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAchievement(@PathVariable Long id) {
        achievementService.deleteAchievement(id);
        return ResponseEntity.ok(new ApiResponse("Achievement with ID " + id + " has been deleted successfully."));
    }
}
