import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertiesManagementComponent } from './properties-management.component';

describe('PropertiesManagementComponent', () => {
  let component: PropertiesManagementComponent;
  let fixture: ComponentFixture<PropertiesManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PropertiesManagementComponent]
    });
    fixture = TestBed.createComponent(PropertiesManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
