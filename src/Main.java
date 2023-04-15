package src;

import java.io.IOException;

public class Main {

    public static ListeDispositionClavier ldc;
    public static Bigramme occurencesBigrammes;


    public static void main(String[] args) throws IOException {

        // Initialisation
        init();

        // Traitement

    }

    public static void init() throws IOException {
        // -> Génération de 100 dispositions aléatoires de clavier
        ldc = new ListeDispositionClavier();
        int i = 0;
        while (i< 100) {
            DispositionClavier dc = new DispositionClavier();
            dc.generateRandomDisposition();
            ldc.ajouter(dc);
            i++;
        }

        // -> Génération du tableau de bigrammes
        occurencesBigrammes = new Bigramme();
        occurencesBigrammes.parse("freqBigrammes.txt");



    }



}
