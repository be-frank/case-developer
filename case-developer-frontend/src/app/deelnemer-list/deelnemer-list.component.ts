import {Component, OnInit} from '@angular/core';
import {DeelnemerService} from "../service/deelnemer.service";
import {Deelnemer} from "../model/Deelnemer";
import {NgForOf, NgIf} from "@angular/common";
import {BerekeningComponent} from "../berekening/berekening.component";
import {DeelnemerDetailsComponent} from "../deelnemer-details/deelnemer-details.component";

@Component({
  selector: 'app-deelnemer-list',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    BerekeningComponent,
    DeelnemerDetailsComponent
  ],
  templateUrl: './deelnemer-list.component.html',
  styleUrl: './deelnemer-list.component.css'
})
export class DeelnemerListComponent implements OnInit {

  deelnemers: Deelnemer[];

  selectedDeelnemer: Deelnemer | undefined;

  constructor(private deelnemerService: DeelnemerService) {
  }

  ngOnInit() {
    this.deelnemerService.findAll().subscribe(data => {
      this.deelnemers = data;
    });
  }

  onSelectedDeelnemer(id: string) {
    const deelnemer = this.deelnemers.find(elm => elm.id === id);
    if (deelnemer) {
      this.selectedDeelnemer = deelnemer;
    } else {
      this.selectedDeelnemer = undefined;
    }
  }
}
