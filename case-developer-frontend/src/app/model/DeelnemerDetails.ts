export class DeelnemerDetails {
  id: string;
  naam: string;
  email: string;
  geboortedatum: Date;
  adres: Adres;
}

export class Adres {
  straatnaam: string;
  huisnummer: string;
  postcode: string;
  woonplaats: string;
}
