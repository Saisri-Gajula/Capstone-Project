import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerminationremindersComponent } from './terminationreminders.component';

describe('TerminationremindersComponent', () => {
  let component: TerminationremindersComponent;
  let fixture: ComponentFixture<TerminationremindersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TerminationremindersComponent]
    });
    fixture = TestBed.createComponent(TerminationremindersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
