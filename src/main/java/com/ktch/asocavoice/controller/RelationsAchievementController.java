package com.ktch.asocavoice.controller;

import com.ktch.asocavoice.dto.RelationsAchievementDTO;
import com.ktch.asocavoice.dto.ApiResponse;
import com.ktch.asocavoice.service.RelationsAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationsAchievements")
public class RelationsAchievementController {

    @Autowired
    private RelationsAchievementService relationsAchievementService;

    @GetMapping
    public ResponseEntity<List<RelationsAchievementDTO>> getAllRelationsAchievements() {
        return ResponseEntity.ok(relationsAchievementService.getAllRelationsAchievements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationsAchievementDTO> getRelationsAchievementById(@PathVariable Long id) {
        return ResponseEntity.ok(relationsAchievementService.getRelationsAchievementById(id));
    }

    @PostMapping
    public ResponseEntity<RelationsAchievementDTO> createRelationsAchievement(@RequestBody RelationsAchievementDTO relationsAchievementDTO) {
        RelationsAchievementDTO createdRelationsAchievement = relationsAchievementService.createRelationsAchievement(relationsAchievementDTO);
        return ResponseEntity.ok(createdRelationsAchievement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelationsAchievementDTO> updateRelationsAchievement(@PathVariable Long id, @RequestBody RelationsAchievementDTO relationsAchievementDTO) {
        RelationsAchievementDTO updatedRelationsAchievement = relationsAchievementService.updateRelationsAchievement(id, relationsAchievementDTO);
        return ResponseEntity.ok(updatedRelationsAchievement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRelationsAchievement(@PathVariable Long id) {
        relationsAchievementService.deleteRelationsAchievement(id);
        return ResponseEntity.ok(new ApiResponse("RelationsAchievement with ID " + id + " has been deleted successfully."));
    }
}
