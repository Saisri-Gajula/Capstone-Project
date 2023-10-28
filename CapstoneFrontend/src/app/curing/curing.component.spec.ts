import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuringComponent } from './curing.component';

describe('CuringComponent', () => {
  let component: CuringComponent;
  let fixture: ComponentFixture<CuringComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CuringComponent]
    });
    fixture = TestBed.createComponent(CuringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
