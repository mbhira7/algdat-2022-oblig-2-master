# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Kaja Line Åbyholm Reehorst, s358385, s358385@oslomet.no
* Hoda Saoudi, s362114, s362114@oslomet.no
* Konrad Przemyslaw dabrowski, s366446, s366446@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Kaja har hatt ansvar for oppgave 2 og 3.
* Konrad har hatt ansvar for oppgave 9 og 10.

# Oppgavebeskrivelse

I oppgave 1 så går vi frem ved å først returnere antall i int antall().
Så returnerer vi true/false i boolean tom(), avhengig av om listen er tom eller ikke ved hjelp av if(hode==null).
Videre laget vi en konstruktør og bruker for-løkke til å legge inn alle verdier fra a.
Vi bruker if(a[i]!=null) for å sjekke at vi ikke legger inn null-verdier.
Hvis tabellen er tom, peker det første elementet i a til hode.
Resten av elementene legges inn med neste-pekere.
Om a=null, kastes det en exception.

I oppgave 2 så bruker vi en StringBuilder til å skrive ut listen i String toString().
Hvis a er tom skriver vi kun ut [].
Ellers, bygger vi opp tegnestrengen ved å traversere fra hode til hale, ved hjelp av neste-pekere.
For String omvendtString(), gjør vi det samme, men traverserer fra hale til hode, ved hjelp av forrige-pekere.
Tilslutt legger vi inn en verdi i boolean leggInn(T verdi).
Vi sjekker om tabellen er tom, hvis ja -> Verdi blir første element og dermed hode/hale.
Hvis nei -> verdi legges tilslutt (hale.neste), og blir den nye halen.

I oppgave 3 initialiserer vi Node<T> finnNode(int indeks) og finner en indeks sin tilhørende node.
Vi leter frem noden ved hjelp av to for-løkker.
Hvis indeks er mindre enn halvparten begynner vi letingen fra hode og benytter neste-pekere.
Hvis ikke, begynner vi letingen fra hale og vi benytter forrige-pekere.
T hent(int indeks) bruker finnNode(int indeks) for å returnere verdien til noden på plass indeks.
T oppdater(int indeks, T nyverdi) bytter ut en en verdi på plass indeks, med en ny verdi.
Liste<T> subliste(int fra, int til) lager en ny liste i intervallet [fra,til) og legger til elementer med leggInn(verdi).
Vi bruker fratilKontroll() for å passe på at intervallet er gyldig.

I oppgave 9 brukte jeg metoden void remove() i iterator klassen. Hvis det ikke er tillat å kalle på metoden blir det kastet en
IllegalStateException. Hvis det viser seg at endringer er ulike kastes det Concurrrent-ModificiationException.
Hvis den passerer de to første testene skal fjernOk settes til false og noden fjernes. Ellers er det veldig rett frem om verdien
(antall==1) skal fjernes så nulles hode og hale ut. mens hvis den siste (denne == null ) så må hale oppdateres. Hvis en noden i listen
skal fjernes, så må pekerne på hver side oppdateres. 

I oppgave 10 så brukte jeg en metoden sorter(Liste<T> liste, Comperator<? super T > c). Denne sorterer listen
ved bruk av en comperator. Her bruker man for loops og literer.