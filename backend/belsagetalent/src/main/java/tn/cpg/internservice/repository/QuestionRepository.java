package tn.cpg.internservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.cpg.internservice.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}