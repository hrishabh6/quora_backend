package com.hrishabh.quora.service;

import com.hrishabh.quora.models.Votes;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Comment;
import com.hrishabh.quora.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    private final VoteRepository votesRepository;

    public VoteService(VoteRepository votesRepository) {
        this.votesRepository = votesRepository;
    }

    // Save or update a vote
    public Votes saveVote(Votes vote) {
        return votesRepository.save(vote);
    }

    // Find vote by ID
    public Optional<Votes> getVoteById(Long id) {
        return votesRepository.findById(id);
    }

    // Find vote by user and question
    public Optional<Votes> getVoteByUserAndQuestion(User user, Question question) {
        return votesRepository.findByUserAndQuestion(user, question);
    }

    // Find vote by user and answer
    public Optional<Votes> getVoteByUserAndAnswer(User user, Answer answer) {
        return votesRepository.findByUserAndAnswer(user, answer);
    }

    // Find vote by user and comment
    public Optional<Votes> getVoteByUserAndComment(User user, Comment comment) {
        return votesRepository.findByUserAndComment(user, comment);
    }

    // Get all votes by user
    public List<Votes> getVotesByUser(User user) {
        return votesRepository.findByUser(user);
    }

    // Get all votes on question
    public List<Votes> getVotesByQuestion(Question question) {
        return votesRepository.findByQuestion(question);
    }

    // Get all votes on answer
    public List<Votes> getVotesByAnswer(Answer answer) {
        return votesRepository.findByAnswer(answer);
    }

    // Get all votes on comment
    public List<Votes> getVotesByComment(Comment comment) {
        return votesRepository.findByComment(comment);
    }

    // Delete vote
    public void deleteVote(Long id) {
        votesRepository.deleteById(id);
    }
}
