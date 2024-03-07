import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {DeelnemerService} from "../service/deelnemer.service";
import {DeelnemerDetails} from "../model/DeelnemerDetails";
import {DatePipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-deelnemer-details',
  standalone: true,
  imports: [
    NgIf,
    DatePipe
  ],
  templateUrl: './deelnemer-details.component.html',
  styleUrl: './deelnemer-details.component.css'
})
export class DeelnemerDetailsComponent implements OnChanges {

  @Input() deelnemerID!: string;

  deelnemerDetails: DeelnemerDetails;

  constructor(private deelnemerService: DeelnemerService) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.loadDeelnemerDetails();
  }

  private loadDeelnemerDetails() {
    this.deelnemerService.find(this.deelnemerID)
      .subscribe(data => {
        this.OnDataUpdate(data);
      });
  }

  private OnDataUpdate(data: DeelnemerDetails) {
    this.deelnemerDetails = data;
  }
}
