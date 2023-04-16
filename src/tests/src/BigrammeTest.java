package src;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class BigrammeTest {

    @Test
    void test(){
        Bigramme bigramme = new Bigramme();

        try {
            bigramme.parse("ressources/freqBigrammes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bigramme.printBigramme();

    }

    @Test
    void getOccurr() {
        Bigramme bigramme = new Bigramme();
        try {
            bigramme.parse("ressources/freqBigrammes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bigramme.printBigramme();

        int occur = bigramme.getOccurr('V', 'G');
        System.out.println("Occur of VG : " + occur);


    }
}