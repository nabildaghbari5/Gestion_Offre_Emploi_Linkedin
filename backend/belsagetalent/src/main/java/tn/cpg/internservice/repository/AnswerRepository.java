package tn.cpg.internservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.cpg.internservice.model.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByEvaluationId(Long evaluationId);

    @Query("SELECT a FROM Answer a " +
            "JOIN a.evaluation te " +
            "JOIN te.request r " +
            "WHERE r.candidateId = :candidateId " +
            "AND r.id = :requestId")
    List<Answer> findAnswersByCandidateIdAndRequestId(
            @Param("candidateId") String candidateId,
            @Param("requestId") Integer requestId);
}