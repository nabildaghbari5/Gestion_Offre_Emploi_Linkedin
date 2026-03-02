import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { TestEvaluationService } from '../../service/test-evaluation.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-test-evaluation',
  templateUrl: './test-evaluation.component.html',
  styleUrls: ['./test-evaluation.component.scss']
})
export class TestEvaluationComponent  implements OnInit {
  evaluationForm: FormGroup;
  questions: any[] = [];
  stars: number[] = [1, 2, 3, 4, 5];
  loading = false;

  @Input() requestId!: number;
  @Input() candidateId!: string;
  @Input() showButton!: boolean;

  constructor(
    private router:Router,
    private evaluationService: TestEvaluationService,
    private fb: FormBuilder
  ) {
    this.evaluationForm = this.fb.group({
      candidateId: [''],
      requestId: [''],
      answers: this.fb.array([])
    });
  }

  ngOnInit(): void {
    if (this.requestId && this.candidateId) {
      this.evaluationForm.patchValue({
        candidateId: this.candidateId,
        requestId: this.requestId
      });
      this.loadQuestions();
      this.checkExistingEvaluation();
    }
  }

  getRatingValue(index: number): number {
    const answersArray = this.evaluationForm.get('answers') as FormArray;
    const answerControl = answersArray?.controls[index];
    return answerControl?.get('ratingValue')?.value || 0;
  }

  checkExistingEvaluation() {
    if (this.requestId) {
      this.evaluationService.getEvaluationByRequestId(this.requestId)
        .subscribe(
          (evaluation) => {
            if (evaluation) {
              this.evaluationForm.disable();
              this.loadExistingAnswers(evaluation);
            } else {
              console.warn('Évaluation introuvable.');
            }
          },
          (error) => {
            if (error.status === 404) {
              console.warn(`Évaluation introuvable pour requestId ${this.requestId}.`);
              // Optionnel : message utilisateur
            } else {
              console.error(`Erreur réseau : ${error.message}`, error);
            }
          }
        );
    } else {
      console.log('Request ID introuvable.');
    }
  }
  
  loadExistingAnswers(evaluation: any) {
    const answersArray = this.evaluationForm.get('answers') as FormArray;
    evaluation.answers.forEach((answer: any) => {
      const index = this.questions.findIndex(q => q.id === answer.question.id);
      if (index !== -1) {
        answersArray.at(index).patchValue({
          ratingValue: answer.ratingValue,
          textValue: answer.textValue
        });
      }
    });
  }

  loadQuestions() {
    this.evaluationService.getQuestions().subscribe(
      (questions) => {
        this.questions = questions;
        this.initializeAnswers();
      },
      (error) => console.error('Error loading questions:', error)
    );
  }

  initializeAnswers() {
    const answersArray = this.evaluationForm.get('answers') as FormArray;
    this.questions.forEach(question => {
      answersArray.push(this.fb.group({
        questionId: [question.id],
        ratingValue: [null],
        textValue: ['']
      }));
    });
  }

  setRating(questionIndex: number, rating: number): void {
    if (!this.evaluationForm.disabled) {
      const answersArray = this.evaluationForm.get('answers') as FormArray;
      answersArray.at(questionIndex).patchValue({ ratingValue: rating });
    }
  }

  submitEvaluation(): void {
    if (this.evaluationForm.valid && !this.evaluationForm.disabled) {
      this.loading = true;
      this.evaluationService.submitEvaluation(this.evaluationForm.value).subscribe(
        (response) => {
          console.log('Evaluation submitted successfully:', response);
          this.loading = false;
          this.evaluationForm.disable();
          this.router.navigate(["/features/talent/demandes/mycandidatures"])
        },
        (error) => {
          console.error('Error submitting evaluation:', error);
          this.loading = false;
        }
      );
    }
  }
}