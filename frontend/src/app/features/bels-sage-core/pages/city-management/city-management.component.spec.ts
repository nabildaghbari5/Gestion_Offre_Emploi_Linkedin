import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityManagementComponent } from './city-management.component';

describe('CityManagementComponent', () => {
  let component: CityManagementComponent;
  let fixture: ComponentFixture<CityManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CityManagementComponent]
    });
    fixture = TestBed.createComponent(CityManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
