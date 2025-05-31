package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.Votes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Votes, Long> {
}
