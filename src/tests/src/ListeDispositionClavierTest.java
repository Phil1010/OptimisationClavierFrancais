package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeDispositionClavierTest {

    @Test
    void ajouter() {
        ListeDispositionClavier ldc = new ListeDispositionClavier();
        int i = 0;
        while (i< 100) {
            DispositionClavier dc = new DispositionClavier();
            dc.generateRandomDisposition();
            ldc.ajouter(dc);
            i++;
        }

        for(DispositionClavier d : ldc.getListe()){
            d.printDisposition();
        }
    }
}