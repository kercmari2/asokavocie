package com.ktch.asocavoice.controller;

import com.ktch.asocavoice.dto.ReactionDTO;
import com.ktch.asocavoice.dto.ApiResponse;
import com.ktch.asocavoice.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @GetMapping
    public ResponseEntity<List<ReactionDTO>> getAllReactions() {
        return ResponseEntity.ok(reactionService.getAllReactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReactionDTO> getReactionById(@PathVariable Long id) {
        return ResponseEntity.ok(reactionService.getReactionById(id));
    }

    @PostMapping
    public ResponseEntity<ReactionDTO> createReaction(@RequestBody ReactionDTO reactionDTO) {
        ReactionDTO createdReaction = reactionService.createReaction(reactionDTO);
        return ResponseEntity.ok(createdReaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReactionDTO> updateReaction(@PathVariable Long id, @RequestBody ReactionDTO reactionDTO) {
        ReactionDTO updatedReaction = reactionService.updateReaction(id, reactionDTO);
        return ResponseEntity.ok(updatedReaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteReaction(@PathVariable Long id) {
        reactionService.deleteReaction(id);
        return ResponseEntity.ok(new ApiResponse("Reaction with ID " + id + " has been deleted successfully."));
    }
}
