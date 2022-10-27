package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    //lager en hjelpemetode som skal brukes i oppgave 9
    private T fjernNode(Node<T> p)
    {
        if (p == hode)
        {
            if (antall == 1) hode = hale = null;
            else (hode = hode.neste).forrige = null;
        }
        else if (p == hale) (hale = hale.forrige).neste = null;
        else (p.forrige.neste = p.neste).forrige = p.forrige;

        antall--;
        endringer++;

        return p.verdi;
    }

    public DobbeltLenketListe() {
        //throw new UnsupportedOperationException();
    }

    public DobbeltLenketListe(T[] a) {
        //throw new UnsupportedOperationException();
        if (a == null){
            throw new NullPointerException("Tabellen a er null!");
        }

        for (T t : a) {
            if (t != null) {
                Node<T> p = new Node<>(t);
                if (hode == null) {
                    hode = hale = p;
                    hode.forrige = null;
                } else {
                    hale.neste = p;
                    p.forrige = hale;
                    hale = p;
                }
                hale.neste = null;
                antall++;
            }
        }
    }

    private void fratilKontroll(int antall, int fra, int til){ //Kilde: Kompendiet, programkode 1.2.3 a)
        if (fra < 0){
            throw new IndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }
        if (til > antall)
            throw new IndexOutOfBoundsException("til(" + til + ") > antall(" + antall + ")");

        if (fra > til){
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }

    public Liste<T> subliste(int fra, int til) {
        //throw new UnsupportedOperationException();

        fratilKontroll(antall,fra,til);
        Liste<T> liste = new DobbeltLenketListe<>();
        int lengde = til - fra;

        if (lengde < 1){
            return liste;
        }
        Node<T> p = finnNode(fra);

        while (lengde > 0){
            liste.leggInn(p.verdi);
            p = p.neste;
            lengde--;
        }
        return liste;
    }

    @Override
    public int antall() {
        //throw new UnsupportedOperationException();
        return antall;
    }

    @Override
    public boolean tom() {
        //throw new UnsupportedOperationException();
        return hode == null;
    }

    //
    @Override
    public boolean leggInn(T verdi) {
        //throw new UnsupportedOperationException();
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");
        Node<T> p = new Node<>(verdi);
        if (antall == 0){
            hode = hale = p;
            hode.forrige = null;
        }
        else {
            hale.neste = p;
            p.forrige = hale;
            hale = p;
        }
        hale.neste = null;
        antall++;
        endringer++;
        return true;
    }

    private Node<T> finnNode(int indeks){
        Node<T> p;
        if (indeks < antall/2){
            p = hode;
            for (int i = 0;i < indeks;i++){
                p = p.neste;
            }
        }
        else {
            p = hale;
            for (int i = antall - 1;i > indeks;i--){
                p = p.forrige;
            }
        }
        return p;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        //throw new UnsupportedOperationException();
        if(verdi == null) {
            throw new NullPointerException("Verdi kan ikke være null!");
        }
        if(indeks < 0 || indeks > antall) {
            throw new IndexOutOfBoundsException("Indeks kan ikke være mindre enn 0 eller større enn antall");
        }

        Node<T> q = new Node<>(verdi);
        if(tom()) {
            hode = hale = q;
            hode.forrige = null;
            hode.neste = null;
        }

        else{
            if(indeks == 0) {
                hode.forrige = q;
                q.neste = hode;
                hode = q;
                hode.forrige = null;
            }

            else if(indeks == antall) {
                hale.neste = q;
                q.forrige = hale;
                hale = q;
                hale.neste = null;
            }

            else{
                Node<T> p = finnNode(indeks-1);
                if(p.neste != null){
                    Node<T> r = p.neste;
                    p.neste = q;
                    q.forrige = p;
                    q.neste = r;
                    r.forrige = q;
                }
            }
        }
        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;   //returnerer true eller false dersom om listen er tom eller ikke
        //throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) { //Kilde: Kompendiet, programkode 3.3.3 b)
        //throw new UnsupportedOperationException();
        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        if (verdi == null) return -1; //sjekker om det sendes inn nullverdier

        Node<T> p = hode;
        for (int i = 0; i < antall; i++, p = p.neste) {
            if (p.verdi.equals(verdi)) return i;
        }
        return -1;
        //throw new UnsupportedOperationException();
    }



    @Override
    public T oppdater(int indeks, T nyverdi) { //Kilde: Kompendiet, programkode 3.3.3 b)
        //throw new UnsupportedOperationException();
        Objects.requireNonNull(nyverdi,"Ikke tillat med null-verdier!");
        indeksKontroll(indeks,false);

        Node<T> p = finnNode(indeks);
        T gammelverdi = p.verdi;
        p.verdi = nyverdi;
        endringer++;
        return gammelverdi;
    }


    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false;
        }

        Node<T> current = hode;

        //Første fjernes
        if (verdi.equals(current.verdi)) {
            if (current.neste != null) {
                hode = current.neste;
                hode.forrige = null;
            } else {
                hode = null;
                hale = null;
            }
            antall--;
            endringer++;
            return true;
        }

        //Siste fjernes
        current = hale;
        if (verdi.equals(current.verdi)) {
            hale = current.forrige;
            hale.neste = null;
            antall--;
            endringer++;
            return true;
        }

        //Mellom fjernes
        current = hode.neste;
        for (; current != null; current = current.neste) {
            if (verdi.equals(current.verdi)) {
                current.forrige.neste = current.neste;
                current.neste.forrige = current.forrige;
                antall--;
                endringer++;
                return true;
            }
        }
        return false;


    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);

        Node<T> current = hode;
        T verdi;

        //Første fjernes
        if (indeks == 0) {
            verdi = current.verdi;

            if (current.neste != null) {
                hode = current.neste;
                hode.forrige = null;
            } else {
                hode = null;
                hale = null;
            }
        }

        //Siste fjernes
        else if (indeks == antall - 1) {
            current = hale;
            verdi = hale.verdi;

            hale = current.forrige;
            hale.neste = null;
        }

        //Mellom fjernes
        else {
            for (int i = 0; i < indeks; i++) {
                current = current.neste;
            }
            verdi = current.verdi;

            current.forrige.neste = current.neste;
            current.neste.forrige = current.forrige;
        }

        antall--;
        endringer++;
        return verdi;
        }



        @Override
    public void nullstill() {
        for (Node<T> temp = hode; temp != null; temp = temp.neste) {
            temp.verdi = null;
            temp.forrige = temp.neste = null;
        }
        hode = hale = null;
        antall = 0;
        endringer++;
    }

    @Override
    public String toString() {
        //throw new UnsupportedOperationException();
        StringBuilder s = new StringBuilder();
        s.append('[');
        if (hode != null){
            Node<T> p = hode;
            s.append(p.verdi);
            p = p.neste;
            while (p != null){
                s.append(',').append(' ').append(p.verdi);
                p = p.neste;
            }
        }
        s.append(']');
        return s.toString();
    }

    public String omvendtString() {
        //throw new UnsupportedOperationException();
        StringBuilder t = new StringBuilder();
        t.append('[');
        if (hale != null){
            Node<T> p = hale;
            t.append(p.verdi);
            p = p.forrige;
            while (p != null){
                t.append(',').append(' ').append(p.verdi);
                p = p.forrige;
            }
        }
        t.append(']');
        return t.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if(iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Iteratorendringer er ikke lik endringer");
            }
            if(!hasNext()) {
                throw new NoSuchElementException("Det er ikke fler igjen i listen");
            }
            fjernOK = true;
            T denneVerdi = denne.verdi;
            denne = denne.neste;
            return denneVerdi;
        }

        @Override // oppgave 9
        public void remove() {

            if (!fjernOK) throw
                    new IllegalStateException("Verdien blir ikke fjernet!");

            if (iteratorendringer != endringer) throw
                    new ConcurrentModificationException("Listen er endret!");

            fjernOK = false;

            fjernNode(denne == null ? hale : denne.forrige);
            iteratorendringer++;
        }

    } // class DobbeltLenketListeIterator

    // oppgave 10
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c)
    {
        if (liste.tom()) return;
        for (int i = 0; i < liste.antall(); i++) {
            for (int j = 0; j < liste.antall(); j++) {
                if ((c.compare(liste.hent(i), liste.hent(j))) < 0)
                {
                    T tempVerdi = liste.hent(i);
                    liste.oppdater(i,liste.hent(j));
                    liste.oppdater(j,tempVerdi);
                }
            }
        }
    }
} // class DobbeltLenketListe



