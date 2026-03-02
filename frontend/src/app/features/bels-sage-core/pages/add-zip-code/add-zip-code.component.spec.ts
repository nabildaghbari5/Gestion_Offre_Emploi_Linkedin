import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddZipCodeComponent } from './add-zip-code.component';

describe('AddZipCodeComponent', () => {
  let component: AddZipCodeComponent;
  let fixture: ComponentFixture<AddZipCodeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddZipCodeComponent]
    });
    fixture = TestBed.createComponent(AddZipCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
