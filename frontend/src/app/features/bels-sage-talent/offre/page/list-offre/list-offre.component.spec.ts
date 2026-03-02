import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOffreComponent } from './list-offre.component';

describe('ListOffreComponent', () => {
  let component: ListOffreComponent;
  let fixture: ComponentFixture<ListOffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListOffreComponent]
    });
    fixture = TestBed.createComponent(ListOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
