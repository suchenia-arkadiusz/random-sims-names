import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrawAspirationComponent } from './draw-aspiration.component';

describe('DrawAspirationComponent', () => {
  let component: DrawAspirationComponent;
  let fixture: ComponentFixture<DrawAspirationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrawAspirationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrawAspirationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
