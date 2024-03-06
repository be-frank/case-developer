import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {DeelnemerService} from "../service/deelnemer.service";
import {DeelnemerDetails} from "../model/DeelnemerDetails";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-deelnemer-details',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './deelnemer-details.component.html',
  styleUrl: './deelnemer-details.component.css'
})
export class DeelnemerDetailsComponent implements OnInit, OnChanges {

  @Input() deelnemerID!: string;

  deelnemerDetails: DeelnemerDetails;

  constructor(private deelnemerService: DeelnemerService) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("Reloading...");
    this.loadDeelnemerDetails();
  }

  private loadDeelnemerDetails() {
    console.log("Searching for deelnemer details...");
    this.deelnemerService.find(this.deelnemerID)
      .subscribe(data => {
        this.OnDataUpdate(data);
      });
  }

  private OnDataUpdate(data: DeelnemerDetails) {
    this.deelnemerDetails = data;
  }
}
