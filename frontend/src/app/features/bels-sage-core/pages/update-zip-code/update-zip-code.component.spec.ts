import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateZipCodeComponent } from './update-zip-code.component';

describe('UpdateZipCodeComponent', () => {
  let component: UpdateZipCodeComponent;
  let fixture: ComponentFixture<UpdateZipCodeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateZipCodeComponent]
    });
    fixture = TestBed.createComponent(UpdateZipCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
