import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterOffreComponent } from './ajouter-offre.component';

describe('AjouterOffreComponent', () => {
  let component: AjouterOffreComponent;
  let fixture: ComponentFixture<AjouterOffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AjouterOffreComponent]
    });
    fixture = TestBed.createComponent(AjouterOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
