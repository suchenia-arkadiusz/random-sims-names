import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewNameComponent } from './add-new-name.component';

describe('AddNewNameComponent', () => {
  let component: AddNewNameComponent;
  let fixture: ComponentFixture<AddNewNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
