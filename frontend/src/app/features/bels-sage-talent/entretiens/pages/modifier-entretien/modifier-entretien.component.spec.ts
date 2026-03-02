import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierEntretienComponent } from './modifier-entretien.component';

describe('ModifierEntretienComponent', () => {
  let component: ModifierEntretienComponent;
  let fixture: ComponentFixture<ModifierEntretienComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifierEntretienComponent]
    });
    fixture = TestBed.createComponent(ModifierEntretienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
