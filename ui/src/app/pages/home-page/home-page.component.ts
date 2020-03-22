import { Component, OnInit } from '@angular/core';
import { Name } from "../../data/entities/Name";
import { NameService } from "../../services/name.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  names: Name[] = [];

  constructor(private nameService: NameService) { }

  ngOnInit(): void {
    this.names = this.nameService.getNames();
  }
}
