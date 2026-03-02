import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryManagementComponent } from './country-management.component';

describe('CountryManagementComponent', () => {
  let component: CountryManagementComponent;
  let fixture: ComponentFixture<CountryManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CountryManagementComponent]
    });
    fixture = TestBed.createComponent(CountryManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
