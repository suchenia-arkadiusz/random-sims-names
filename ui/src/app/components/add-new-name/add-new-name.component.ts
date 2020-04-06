import { Component, OnInit } from '@angular/core';
import { NameService } from "../../services/name.service";
import { Name } from "../../data/entities/Name";
import { PopupService } from "../../services/popup.service";

@Component({
  selector: 'app-add-new-name',
  templateUrl: './add-new-name.component.html',
  styleUrls: ['./add-new-name.component.scss']
})
export class AddNewNameComponent implements OnInit {

  names: Name[] = [new Name('', 'MALE', false)];

  constructor(private nameService: NameService,
              private popupService: PopupService) { }

  ngOnInit(): void {
  }

  addName() {
    this.nameService.addNewName(this.names);
    this.popupService.closePopup();
  }

  addRow() {
    this.names.push(new Name('', 'MALE', false));
  }
}
