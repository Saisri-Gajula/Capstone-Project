import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstremindersComponent } from './firstreminders.component';

describe('FirstremindersComponent', () => {
  let component: FirstremindersComponent;
  let fixture: ComponentFixture<FirstremindersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FirstremindersComponent]
    });
    fixture = TestBed.createComponent(FirstremindersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
