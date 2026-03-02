import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListFunctionalitiesManagementComponent } from './list-functionalities-management.component';

describe('ListFunctionalitiesManagementComponent', () => {
  let component: ListFunctionalitiesManagementComponent;
  let fixture: ComponentFixture<ListFunctionalitiesManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListFunctionalitiesManagementComponent]
    });
    fixture = TestBed.createComponent(ListFunctionalitiesManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
