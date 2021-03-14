import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AspirationsPageComponent } from './aspirations-page.component';

describe('AspirationsPageComponent', () => {
  let component: AspirationsPageComponent;
  let fixture: ComponentFixture<AspirationsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AspirationsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AspirationsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
