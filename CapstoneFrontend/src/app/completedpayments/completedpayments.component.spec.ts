import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompletedpaymentsComponent } from './completedpayments.component';

describe('CompletedpaymentsComponent', () => {
  let component: CompletedpaymentsComponent;
  let fixture: ComponentFixture<CompletedpaymentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompletedpaymentsComponent]
    });
    fixture = TestBed.createComponent(CompletedpaymentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
