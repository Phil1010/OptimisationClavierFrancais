package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispositionClavierTest {

    @Test
    void generateRandomDisposition() {
        DispositionClavier dc = new DispositionClavier();
        dc.generateRandomDisposition();
        dc.printDisposition();
    }
}