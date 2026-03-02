import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeCandidacyComponent } from './demande-candidacy.component';

describe('DemandeCandidacyComponent', () => {
  let component: DemandeCandidacyComponent;
  let fixture: ComponentFixture<DemandeCandidacyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DemandeCandidacyComponent]
    });
    fixture = TestBed.createComponent(DemandeCandidacyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
