import { TestBed } from '@angular/core/testing';

import { TestEvaluationService } from './test-evaluation.service';

describe('TestEvaluationService', () => {
  let service: TestEvaluationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestEvaluationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
