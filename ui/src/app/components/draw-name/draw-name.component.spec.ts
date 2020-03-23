import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrawNameComponent } from './draw-name.component';

describe('DrawNameComponent', () => {
  let component: DrawNameComponent;
  let fixture: ComponentFixture<DrawNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrawNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrawNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
