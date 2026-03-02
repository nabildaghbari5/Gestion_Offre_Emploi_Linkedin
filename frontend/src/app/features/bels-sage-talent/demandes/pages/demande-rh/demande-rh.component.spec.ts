import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeRhComponent } from './demande-rh.component';

describe('DemandeRhComponent', () => {
  let component: DemandeRhComponent;
  let fixture: ComponentFixture<DemandeRhComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DemandeRhComponent]
    });
    fixture = TestBed.createComponent(DemandeRhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
