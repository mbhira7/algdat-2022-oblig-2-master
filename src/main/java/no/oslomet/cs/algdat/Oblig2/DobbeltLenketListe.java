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

    public DobbeltLenketListe() {
        //throw new UnsupportedOperationException();
    }


    public DobbeltLenketListe(T[] a) {
        //throw new UnsupportedOperationException();
        if (a == null){
            throw new NullPointerException("Tabellen a er null!");
        }

        for (int i = 0;i < a.length;i++){
            if (a[i] != null){
                Node<T> p = new Node(a[i]);
                if (hode == null){
                    hode = hale = p;
                    hode.forrige = null;
                    hale.neste = null;
                }
                else {
                    hale.neste = p;
                    p.forrige = hale;
                    hale = p;
                    hale.neste = null;
                }
                antall++;
            }
        }
    }

    private void fratilKontroll(int lengde, int fra, int til){ //Kilde: Kompendiet, programkode 1.2.3 a)
        if (fra < 0){
            throw new IndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }
        if (til > lengde)
            throw new IndexOutOfBoundsException("til(" + til + ") > tablengde(" + lengde + ")");

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
<<<<<<< HEAD
    public <T> int antall(T[] a) {
        throw new UnsupportedOperationException();

        for(int i=0; i<a.length;i++){
            antall++;
        }
    }

    @Override
    public boolean tom(Integer a) {
        //throw new UnsupportedOperationException();

        if(a < 1) {
            return false;
        }
        return true;
=======
    public int antall() {
        //throw new UnsupportedOperationException();
        return antall;
    }

    @Override
    public boolean tom() {
        //throw new UnsupportedOperationException();
        if (hode == null){
            return true;
        }
        else {
            return false;
        }
>>>>>>> 5e9e446d62e80e44b6172f20c59648bee971eff0
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
            hale.neste = null;
        }
        else {
            hale.neste = p;
            p.forrige = hale;
            hale = p;
            hale.neste = null;
        }
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

        /*
            1. Bruk finnNode(int indeks) til å finne Node p
            2. p.neste gir r
            3. Oppretter noden q
         */
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) { //Kilde: Kompendiet, programkode 3.3.3 b)
        //throw new UnsupportedOperationException();
        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {

       throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        // ANDRE METODEN
        int toDelete = antall;
        if (antall > 0) {
            for(int i = 0; i < toDelete; i++) {
                fjern(0);
            }
            antall = 0;
            endringer++;
        }
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
            /*indeksKontroll(indeks, false);
            denne = finnNode(indeks - 1);
            fjernOK = false;
            iteratorendringer = endringer; */
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if(endringer != iteratorendringer) {
                throw new ConcurrentModificationException();
            }
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T verdi;
            fjernOK = true;
            if(denne.neste.neste == null) {
                verdi = denne.neste.verdi;
                denne = null;
            }
            else {
                verdi = denne.neste.verdi;
                denne = denne.neste;
            }
            return verdi;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


