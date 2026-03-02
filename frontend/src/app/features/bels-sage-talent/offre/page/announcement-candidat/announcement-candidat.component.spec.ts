import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementCandidatComponent } from './announcement-candidat.component';

describe('AnnouncementCandidatComponent', () => {
  let component: AnnouncementCandidatComponent;
  let fixture: ComponentFixture<AnnouncementCandidatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnnouncementCandidatComponent]
    });
    fixture = TestBed.createComponent(AnnouncementCandidatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
