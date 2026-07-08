package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Join order per the hands-on: user -> attempt -> attempt_question ->
 * question -> attempt_option -> options.
 *
 * All the one-to-many/many-to-many associations traversed here
 * (Attempt.attemptQuestions, Question.options, AttemptQuestion.attemptOptions)
 * are mapped as Set, not List. Fetching more than one collection eagerly in
 * a single query is fine for Sets; doing it with List ("bag") mappings
 * would throw Hibernate's MultipleBagFetchException.
 */
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("SELECT DISTINCT a FROM Attempt a " +
            "join fetch a.user u " +
            "left join fetch a.attemptQuestions aq " +
            "left join fetch aq.question q " +
            "left join fetch q.options " +
            "left join fetch aq.attemptOptions ao " +
            "left join fetch ao.option " +
            "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
