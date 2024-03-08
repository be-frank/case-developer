import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {CurrencyPipe, DatePipe, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {WaardeberekeningService} from "../service/waardeberekening.service";
import {Waardeberekening} from "../model/Waardeberekening";
import {Deelnemer} from "../model/Deelnemer";

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

  @Input() deelnemer!: Deelnemer;

  leeftijd: number | null;
  pensioenleeftijd = '67';
  waardeberekening: Waardeberekening | null;

  constructor(private waardeberekeningService: WaardeberekeningService) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.pensioenleeftijd = '67';
    this.waardeberekening = null;
    this.leeftijd = this.berekenLeeftijd(this.deelnemer.geboortedatum);
    this.berekenPensioenwaarde(this.pensioenleeftijd);
  }

  berekenLeeftijd = (geboortedatum: Date) => {
    const diffMs = Date.now() - (new Date(geboortedatum)).getTime();
    const leeftijdDt = new Date(diffMs);
    return Math.abs(leeftijdDt.getUTCFullYear() - 1970);
  }

  berekenPensioenwaarde(pensioenleeftijd: string) {
    this.pensioenleeftijd = pensioenleeftijd;
    this.waardeberekeningService.bereken(this.pensioenleeftijd, this.deelnemer.id)
      .subscribe(data => {
        this.OnDataUpdate(data);
      });
  }

  private OnDataUpdate(data: Waardeberekening) {
    this.waardeberekening = data;
  }
}
