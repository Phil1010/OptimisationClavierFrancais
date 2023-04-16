package src;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class DispositionClavierTest {

    @Test
    void generateRandomDisposition() {
        DispositionClavier dc = new DispositionClavier();
        dc.generateRandomDisposition();
        dc.printDisposition();
    }

    @Test
    void mixDispositionClavier() {
        DispositionClavier dc = new DispositionClavier();
        dc.generateRandomDisposition();
        DispositionClavier result = dc.mixDispositionClavier();
        dc.printDisposition();
        System.out.println();
        result.printDisposition();
    }

    @Test
    void testAzerty() {
        DispositionClavier dc = new DispositionClavier();
        dc.generateFixedDisposition();
        DispositionClavier result = dc.mixDispositionClavier();
        dc.printDisposition();
        System.out.println();
        result.printDisposition();
    }

    @Test
    void manhattanDistance() {
        DispositionClavier dc = new DispositionClavier();
        dc.generateFixedDisposition();
        dc.printDisposition();
        int distance = dc.manhattanDistance('A','Z');
        System.out.println(distance);
        distance = dc.manhattanDistance('A','E');
        assert distance==2 : "Erreur distanceManhattan value : " + distance + " !== 2";
        distance = dc.manhattanDistance('A','R');
        assert distance==3 : "Erreur distanceManhattan value : " + distance + " !== 3";
        distance = dc.manhattanDistance('A','Q');
        assert distance==1 : "Erreur distanceManhattan value : " + distance + " !== 1";
        distance = dc.manhattanDistance('A','W');
        assert distance==2 : "Erreur distanceManhattan value : " + distance + " !== 2";
        distance = dc.manhattanDistance('A','X');
        assert distance==3 : "Erreur distanceManhattan value : " + distance + " !== 3";
        distance = dc.manhattanDistance('W','T');
        assert distance==6 : "Erreur distanceManhattan value : " + distance + " !== 6";
    }


    @Test
    void test250() throws IOException {
        DispositionClavier dc = new DispositionClavier();
        Bigramme bigramme = new Bigramme();
        bigramme.parse("ressources/freqBigrammes.txt");
        RecuitSimule sa = new RecuitSimule(bigramme);
        dc.generateFixedDisposition250();
        double res = sa.targetFunction(dc);
        dc.printDisposition();
        System.out.println("Energie : "+ res);

    }


}