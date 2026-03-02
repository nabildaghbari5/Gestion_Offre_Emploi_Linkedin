import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntretiensListRhComponent } from './entretiens-list-rh.component';

describe('EntretiensListRhComponent', () => {
  let component: EntretiensListRhComponent;
  let fixture: ComponentFixture<EntretiensListRhComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EntretiensListRhComponent]
    });
    fixture = TestBed.createComponent(EntretiensListRhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
