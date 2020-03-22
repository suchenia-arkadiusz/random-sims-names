import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-add-new-name',
  templateUrl: './add-new-name.component.html',
  styleUrls: ['./add-new-name.component.scss']
})
export class AddNewNameComponent implements OnInit {
  @ViewChild('nameInput') nameInput: ElementRef;

  constructor() { }

  ngOnInit(): void {
  }

  addNem() {
    console.log(this.nameInput.nativeElement.value);
  }

  selectGender(gender: string) {
    console.log(gender);
  }
}
