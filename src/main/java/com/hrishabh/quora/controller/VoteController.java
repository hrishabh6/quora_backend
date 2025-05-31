package com.hrishabh.quora.controller;

import com.hrishabh.quora.models.Votes;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Comment;
import com.hrishabh.quora.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    // Create or update a vote
    @PostMapping
    public ResponseEntity<Votes> saveVote(@RequestBody Votes vote) {
        Votes savedVote = voteService.saveVote(vote);
        return ResponseEntity.ok(savedVote);
    }

    // Get vote by ID
    @GetMapping("/{id}")
    public ResponseEntity<Votes> getVoteById(@PathVariable Long id) {
        Optional<Votes> vote = voteService.getVoteById(id);
        return vote.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a vote by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
        return ResponseEntity.noContent().build();
    }

    // Example: Get votes by user (pass userId as request param)
    @GetMapping("/byUser")
    public ResponseEntity<List<Votes>> getVotesByUser(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        List<Votes> votes = voteService.getVotesByUser(user);
        return ResponseEntity.ok(votes);
    }

    // Similarly, get votes by question
    @GetMapping("/byQuestion")
    public ResponseEntity<List<Votes>> getVotesByQuestion(@RequestParam Long questionId) {
        Question question = new Question();
        question.setId(questionId);
        List<Votes> votes = voteService.getVotesByQuestion(question);
        return ResponseEntity.ok(votes);
    }

    // Get votes by answer
    @GetMapping("/byAnswer")
    public ResponseEntity<List<Votes>> getVotesByAnswer(@RequestParam Long answerId) {
        Answer answer = new Answer();
        answer.setId(answerId);
        List<Votes> votes = voteService.getVotesByAnswer(answer);
        return ResponseEntity.ok(votes);
    }

    // Get votes by comment
    @GetMapping("/byComment")
    public ResponseEntity<List<Votes>> getVotesByComment(@RequestParam Long commentId) {
        Comment comment = new Comment();
        comment.setId(commentId);
        List<Votes> votes = voteService.getVotesByComment(comment);
        return ResponseEntity.ok(votes);
    }
}
