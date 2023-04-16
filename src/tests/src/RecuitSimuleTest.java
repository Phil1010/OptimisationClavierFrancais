package src;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecuitSimuleTest {


    @Test
    void targetFunction() {
        DispositionClavier dc = new DispositionClavier();
        dc.generateRandomDisposition();
        dc.printDisposition();
        Bigramme b = new Bigramme();
        try {
            b.parse("freqBigrammes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        RecuitSimule rs = new RecuitSimule(b);
        double score = rs.targetFunction(dc);
        System.out.println("Score : " + score);
    }

    @Test
    void computeT0() {
        Bigramme b = new Bigramme();
        try {
            b.parse("freqBigrammes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RecuitSimule rs = new RecuitSimule(b);

        ListeDispositionClavier ldc = new ListeDispositionClavier();
        int i = 0;
        while (i< 100) {
            DispositionClavier dc = new DispositionClavier();
            dc.generateRandomDisposition();
            ldc.ajouter(dc);
            i++;
        }

        double t0 = rs.computeT0(0.50F, ldc);
        System.out.println("T0 = " + t0);

    }
}