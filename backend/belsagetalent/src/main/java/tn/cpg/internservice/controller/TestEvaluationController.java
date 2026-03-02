package tn.cpg.internservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cpg.internservice.dto.TestEvaluationDTO;
import tn.cpg.internservice.impl.TestEvaluationService;
import tn.cpg.internservice.model.Answer;
import tn.cpg.internservice.model.Question;
import tn.cpg.internservice.model.TestEvaluation;

import java.util.List;

@RestController
@RequestMapping("api/evaluation")
@CrossOrigin(origins = "http://localhost:4200")
public class TestEvaluationController {

    @Autowired
    private TestEvaluationService evaluationService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(evaluationService.getAllQuestions());
    }

    @GetMapping("/request/{requestId}")
    public ResponseEntity<TestEvaluation> getEvaluationByRequestId(@PathVariable Integer requestId) {
        TestEvaluation evaluation = evaluationService.getEvaluationByRequestId(requestId);
        return evaluation != null ? ResponseEntity.ok(evaluation) : ResponseEntity.notFound().build();
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<TestEvaluation>> getEvaluationsByCandidateId(@PathVariable String candidateId) {
        return ResponseEntity.ok(evaluationService.getEvaluationsByCandidateId(candidateId));
    }

    @GetMapping("/request/candidate/{candidateId}/{requestId}")
    public ResponseEntity<List<Answer>> getByCandidateIdAndRequestId(@PathVariable String candidateId , @PathVariable Integer requestId){
      return ResponseEntity.ok(evaluationService.findAnswersByCandidateIdAndRequestId(candidateId, requestId)) ;
    }

    @PostMapping("/submit")
    public ResponseEntity<TestEvaluation> submitEvaluation(@RequestBody TestEvaluationDTO submissionDTO) {
        return ResponseEntity.ok(evaluationService.submitEvaluation(submissionDTO));
    }
}