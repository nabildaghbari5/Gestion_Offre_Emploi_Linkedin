import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierOffreComponent } from './modifier-offre.component';

describe('ModifierOffreComponent', () => {
  let component: ModifierOffreComponent;
  let fixture: ComponentFixture<ModifierOffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifierOffreComponent]
    });
    fixture = TestBed.createComponent(ModifierOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
