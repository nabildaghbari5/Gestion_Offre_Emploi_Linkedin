import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewChartOrganizationComponent } from './view-chart-organization.component';

describe('ViewChartOrganizationComponent', () => {
  let component: ViewChartOrganizationComponent;
  let fixture: ComponentFixture<ViewChartOrganizationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewChartOrganizationComponent]
    });
    fixture = TestBed.createComponent(ViewChartOrganizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
