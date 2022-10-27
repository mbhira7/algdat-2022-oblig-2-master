# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Kaja Line Åbyholm Reehorst, s358385, s358385@oslomet.no
* Hoda Saoudi, s362114, s362114@oslomet.no
* Konrad Przemyslaw dabrowski, s366446, s366446@oslomet.no
* Amalie Johnsen Aase, s364682, s364682@oslomet.no
* Bhiravina Mahesaratnam, s334895, s334895@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Kaja har hatt ansvar for oppgave 2 og 3.
* Konrad har hatt ansvar for oppgave 9 og 10.
<<<<<<< HEAD
* Hoda har hatt ansvar for oppgave 1 og 4 
=======
* Bhiravina har hatt ansvar for oppgave 5.
* Amalie har hatt ansvar for oppgave 6, 7, og 8.
>>>>>>> cd698028dcec600c0d896e7e6656617551613846

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

I oppgave 4 lager vi en metode som skal returnere indeksen til verdi hvis den finnes i listen og 
den skal returnere -1 hvis den finnes, det gjør vi ved å returnere ideksen/posisjonen til verdi hvis 
den finnes i listen, deretter sjekker vi i koden om det sendes inn noen nullverdier. vi har også metoden
boolean som skal returnere true eller false avhengig om listen er tom eller ikke. 

I oppgave 5 bruker jeg metoden finnNode(int indeks) for å finne Noden p. Jeg oppretter så en ny Node q med verdien vi får som parameter.
Dersom listen er tom opprettes det en ny Node. Hvis listen ikke er tom og 
indeks er lik 0 legges Noden q inn på starten av lista. Dersom indeks er lik antall legges q på slutten. 
Dersom indeks verken er lik 0 eller antall legges q mellom de to Nodene p og r.

I oppgave 6 var rett fram, gjorde det som ble beskrevet i oppgaveteksten ved å lage pekere som fjernet første, siste og mellom verdi.

I oppgave 7 ble det laget en hjelpevariabel (Node p) som tok inn den første noden i listen, om denne ikke var null gikk varaiblene inn i en loop hvor p ble oppdatert til den neste noden og forrige sin verdi ble null. 

I oppgave 8 (a) laget jeg en exception hvis iteratorendringer ikke er lik endring slik som oppgaven ønsket. (b) Instansierte en ny tpe av klassen DobbeltLenketListeIterator. (c) startet en indeksKontroll, bruker metoden finnNode med indeks-1. Denne istansieres, og bruker fjernOK og iteratorendringer.

I oppgave 9 brukte jeg metoden void remove() i iterator klassen. Hvis det ikke er tillat å kalle på metoden blir det kastet en
IllegalStateException. Hvis det viser seg at endringer er ulike kastes det Concurrrent-ModificiationException.
Hvis den passerer de to første testene skal fjernOk settes til false og noden fjernes. Ellers er det veldig rett frem om verdien
(antall==1) skal fjernes så nulles hode og hale ut. mens hvis den siste (denne == null ) så må hale oppdateres. Hvis en noden i listen
skal fjernes, så må pekerne på hver side oppdateres. 

I oppgave 10 så brukte jeg en metoden sorter(Liste<T> liste, Comperator<? super T > c). Denne sorterer listen
ved bruk av en comperator. Her bruker man for loops og if statements.
