package src;

import java.io.IOException;

public class Main {

    private static RecuitSimule rs;
    private static float t0;

    public static void main(String[] args) throws IOException {

        // Initialisation
        init();

        // Traitement
        treatment();
    }


    public static void init() throws IOException {
        // -> Génération du tableau de bigrammes
        Bigramme occurencesBigrammes = new Bigramme();
        occurencesBigrammes.parse("freqBigrammes.txt");

        rs = new RecuitSimule(occurencesBigrammes);

        // -> Génération de 100 dispositions aléatoires de clavier
        ListeDispositionClavier ldc = new ListeDispositionClavier();
        int i = 0;
        while (i< 100) {
            DispositionClavier dc = new DispositionClavier();
            dc.generateRandomDisposition();
            ldc.ajouter(dc);
            i++;
        }

        // -> Calcul de T0
        t0 = rs.computeT0(0.20F, ldc);
    }


    public static void treatment(){






    }
}
