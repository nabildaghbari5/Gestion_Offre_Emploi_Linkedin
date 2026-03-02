package tn.cpg.internservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.cpg.internservice.model.TestEvaluation;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestEvaluationRepository extends JpaRepository<TestEvaluation, Long> {
    List<TestEvaluation> findByCandidateId(String candidateId);
    Optional<TestEvaluation> findByRequestId(Integer requestId);


    @Query("SELECT te FROM TestEvaluation te " +
            "JOIN te.answers a " +
            "JOIN a.question q " +
            "WHERE te.candidateId = :candidateId " +
            "AND te.request.id = :requestId")
    TestEvaluation findByCandidateIdAndRequestIdWithAnswers(
            @Param("candidateId") String candidateId,
            @Param("requestId") Integer requestId);
}