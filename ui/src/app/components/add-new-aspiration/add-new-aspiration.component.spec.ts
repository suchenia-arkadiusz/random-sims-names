import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewAspirationComponent } from './add-new-aspiration.component';

describe('AddNewAspirationComponent', () => {
  let component: AddNewAspirationComponent;
  let fixture: ComponentFixture<AddNewAspirationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewAspirationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewAspirationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
