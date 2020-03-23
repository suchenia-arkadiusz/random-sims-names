import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NameService } from "../../services/name.service";
import { Name } from "../../data/entities/Name";
import { PopupService } from "../../services/popup.service";

@Component({
  selector: 'app-add-new-name',
  templateUrl: './add-new-name.component.html',
  styleUrls: ['./add-new-name.component.scss']
})
export class AddNewNameComponent implements OnInit {
  @ViewChild('nameInput') nameInput: ElementRef;
  private selectedGender: string = 'MALE';

  constructor(private nameService: NameService,
              private popupService: PopupService) { }

  ngOnInit(): void {
  }

  addNem() {
    let name = this.nameInput.nativeElement.value;
    let entry:Name = new Name();
    entry.gender = this.selectedGender;
    entry.name = name;
    entry.isUsed = false;
    this.nameService.addNewName(entry);
    this.popupService.closePopup();
  }

  selectGender(gender: string) {
    this.selectedGender = gender;
  }
}
