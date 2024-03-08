# Uitwerking case sollicitatie developer BeFrank


Bij het ontwikkelen van software probeer ik in het algemeen onder meer de volgende uitgangspunten te hanteren:

- Architectuur: hexagonal, tenzij...
- Domain model staat centraal en dient op zichzelf te staan (DDD)
- Toepassen van OO en vermijden van stringly-typed systems
- KISS, YAGNI en clean code zijn imho altijd belangrijk
- Zoveel mogelijk TDD werken (red-green-_refactor_)

Een casus is natuurlijk vrij beperkt, maar ik hoop dat desondanks deze uitgangspunten erin naar voren zijn gekomen.


## Globale werkwijze bij deze casus

De opdracht aangevlogen alsof deze uit 2 use cases bestaat:

1. Het ophalen van de persoonsgegevens van een deelnemer
2. Voor deze deelnemer de waarde van de pensioenpot berekenen op basis van ingevoerde pensioenleeftijd

Om het eenvoudig te houden heb ik gekozen voor een H2 database (H2 console available at 'http://localhost:8080/h2-console') en middels een CommandLineRunner de database voorzien van twee deelnemers. Dit laatste vooral om de frontend handmatig te testen. Hierdoor hoefde ik in de unit-integratietesten geen testdata op te voeren of te mocken (hetgeen ik normaalgesproken uiteraard wel zou doen).

De gegevens van een van de deelnemers heb ik daarbij overeen laten komen met het gegeven voorbeeld om de uitkomst ook makkelijk visueel te kunnen controleren in de frontend applicatie.

### 1. Deelnemergegevens

Begonnen middels TDD met een unit-integratie test voor het endpoint voor het ophalen van de deelnemers.
Vandaar uit de 1e versie van de controller en de domain en repository code uitgewerkt.

De test vervolgens uitgebreid met een endpoint voor het ophalen van de detail informatie van een enkele deelnemer. Gevolgd door de implementatie.

Daarna de angular applicatie opgezet. Begonnen met een deelnemer-list component en deelnemer-service om de lijst van deelnemers op te halen. Gevolgd door een component met de deelnemer detail informatie.

### 2. Berekening pensioenpot op basis van gewenste pensioenleeftijd

In de frontend een berekening component en service gebouwd en de backend voorzien van een RestController welke een fixed response terug gaf. Hiermee de frontend "afgerond".

In de backend een unit-integratie test opgezet gebaseerd op de twee voorbeelden uit de casus. Vervolgens de formules uit de casus geimplementeerd in een application service.

Voor deze case retourneert de proxy voor de externe beleggingsservice hardcoded dummy waarden. De proxy heb ik dan ook niet voorzien van een RestClient. Daarom heb ik in de unit-integratietesten ook geen gebruik gemaakt van bijv. MockWebServer of WireMock, hetgeen ik normaal gesproken wel geneigd ben om te doen.

### Afronding

Tenslotte m.b.v. de eerdere unit-integratie testen, de code gerefactored/opgeschoond tot clean code, clean design en een expressief model (voor zover mogelijk en/of relevant voor de scope van deze casus :wink:)


## Omissies

Voor de beperkte scope van deze casus heb ik een fors aantal zaken achterwege gelaten. Zaken die uiteraard bij een productiewaardige applicatie niet mogen ontbreken. Denk daarbij onder meer aan het volgende:

- REST API Specificatie (OpenAPI/Swagger)
- REST maturity: Content negotiation (Consumes/Produces) en HATEOAS
- foutafhandeling i.h.a. en een globale exceptionhandler inclusief ProblemDetail in het bijzonder
- logging
- geen mapstruct o.i.d. gebruikt, maar simpele mapping
- input validatie (form/api/jpa)
- security en authenticatie & autorisatie
- voor de eenvoud doubles gebruikt voor bedragen. Netter zou zijn om hier gebruik te maken van JSR 354, Java's Money & Currency API
- unit en e2e testing in het Angular project
- ingelogde gebruiker (bijv. via /user/me API call) i.p.v. een dropdown met alle deelnemers
- documentatie
- etc.
