package src;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class BigrammeTest {

    @Test
    void test(){
        Bigramme bigramme = new Bigramme();

        try {
            bigramme.parse("freqBigrammes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bigramme.printBigramme();

    }
}