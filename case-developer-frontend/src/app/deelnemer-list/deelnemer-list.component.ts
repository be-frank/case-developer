import {Component, OnInit} from '@angular/core';
import {DeelnemerService} from "../service/deelnemer.service";
import {Deelnemer} from "../model/Deelnemer";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-deelnemer-list',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './deelnemer-list.component.html',
  styleUrl: './deelnemer-list.component.css'
})
export class DeelnemerListComponent implements OnInit {

  deelnemers: Deelnemer[];

  constructor(private deelnemerService: DeelnemerService) {
  }

  ngOnInit() {
    this.deelnemerService.findAll().subscribe(data => {
      this.deelnemers = data;
    });
  }
}
