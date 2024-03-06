import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {CurrencyPipe, DatePipe, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {WaardeberekeningService} from "../service/waardeberekening.service";
import {Waardeberekening} from "../model/Waardeberekening";

@Component({
  selector: 'app-berekening',
  standalone: true,
  imports: [
    NgIf,
    DatePipe,
    FormsModule,
    CurrencyPipe
  ],
  templateUrl: './berekening.component.html',
  styleUrl: './berekening.component.css'
})
export class BerekeningComponent implements OnChanges {

  @Input() deelnemerID!: string;

  today: Date = new Date();
  waardeberekening: Waardeberekening | null;

  constructor(private waardeberekeningService: WaardeberekeningService) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.waardeberekening = null;
  }

  berekenPensioenwaarde(ingangsdatum: string) {
    this.waardeberekeningService.bereken(ingangsdatum, this.deelnemerID)
      .subscribe(data => {
        this.OnDataUpdate(data);
      });
  }

  private OnDataUpdate(data: Waardeberekening) {
    this.waardeberekening = data;
  }
}
