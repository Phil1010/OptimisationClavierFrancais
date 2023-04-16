package src;

import java.io.IOException;

public class Main {

    private static RecuitSimule rs;
    private static double t0;

    public static boolean isDone = false;

    public static void main(String[] args) throws IOException {

        if(args.length == 0){
            System.out.println("Aucun fichier fourni ! Abandon...");
            System.exit(0);
        }
        String filename = args[0];



        System.out.println(" -> Calcul de la meilleure disposition du clavier à partir de dispositions aléatoires ...");

        Thread t = new Thread(new ConsoleHelper());
        t.start();

        // Initialisation.
        double seuil = 0.00001F;          // Seuil de température à partir duquel nous supposerons qu'il n'y a plus de meilleure solution.
        double lambda = 0.9999F;         // Paramètre de décroissance de la fonction températue à chaque itération.
        double tau0 = 0.50F;            // Seuil de confiance dans le calcul de la température initiale.

        init(tau0, filename);


        // Traitement.
        DispositionClavier meilleureSolution = treatment(seuil, lambda);

        // Affichage des données.
        Main.isDone = true;
        System.out.println("\nSolution optimale trouvée !\n\n");
        System.out.println("Energie de la disposition : " + rs.targetFunction(meilleureSolution));
        System.out.println("// ----- DISPOSITION DU CLAVIER ----- //");
        meilleureSolution.printDisposition();
        System.out.println("// ---------------------------------- //");
    }


    public static void init(double tau0, String filename) throws IOException {
        // -> Génération du tableau de bigrammes
        Bigramme occurencesBigrammes = new Bigramme();
        occurencesBigrammes.parse(filename);

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
        t0 = rs.computeT0(tau0, ldc);
    }


    public static DispositionClavier treatment(double seuil, double lambda){

        DispositionClavier dc1 = new DispositionClavier();
        dc1.generateRandomDisposition();                     // Disposition initiale du clavier.
        DispositionClavier dc2;                              // Nouvelle disposition du clavier.
        double p;                                     // Probabilité d'accepter un choix dégradant la fonction Energie
        double t = t0;                                       // Température du système
        double eAvant = rs.targetFunction(dc1);              // Energie de la disposition initiale du clavier
        double eApres;                                   // Energie de la nouvelle disposition du clavier.
        double deltaE;                                       // Différence de eAvant et eAprès
        DispositionClavier meilleureSolution = dc1;          // Meilleure solution trouvée
        double min = eAvant;


        while(t > seuil) {
            dc2 = dc1.mixDispositionClavier();
            eApres = rs.targetFunction(dc2);
            deltaE = eApres - eAvant;
            p = Math.exp(-deltaE / t);

            if (deltaE <= 0 || Math.random() <= p) {
                // Solution améliorante ou dégradante mais choisie avec une probabilité p.
                dc1 = dc2;

                if (min > rs.targetFunction(dc2)) {
                    meilleureSolution = dc2;
                    min = rs.targetFunction(dc2);
                }
            }
            t = rs.temperatureVariation(t, lambda);
        }

        return meilleureSolution;
    }
}
