
export class DeelnemerDetails {

  id: string;
  naam: string;
  email: string;
  geboortedatum: string;

  adres: Adres;

}

export class Adres {
  straatnaam: string;
  huisnummer: string;
  postcode: string;
  woonplaats: string;
}
