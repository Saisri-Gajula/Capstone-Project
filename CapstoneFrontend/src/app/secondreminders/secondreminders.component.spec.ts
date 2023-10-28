import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondremindersComponent } from './secondreminders.component';

describe('SecondremindersComponent', () => {
  let component: SecondremindersComponent;
  let fixture: ComponentFixture<SecondremindersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SecondremindersComponent]
    });
    fixture = TestBed.createComponent(SecondremindersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
