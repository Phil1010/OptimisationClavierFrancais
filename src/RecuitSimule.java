package src;

public class RecuitSimule {

    private final Alphabet alphabet;
    private final Bigramme bigramme;

    public RecuitSimule(Bigramme b){
        this.alphabet = new Alphabet();
        this.bigramme = b;
    }

    private double distanceAndWeigth(char lettre1, char lettre2, DispositionClavier dispositionClavier){
        int nbOccuLettre1Lettre2 = this.bigramme.getOccurr(lettre1, lettre2);
        int nbOccuLettre2Lettre1 = this.bigramme.getOccurr(lettre2, lettre1);
        return (double) dispositionClavier.manhattanDistance(lettre1, lettre2) / (nbOccuLettre2Lettre1 + nbOccuLettre1Lettre2 +1);
    }

    public double targetFunction(DispositionClavier dc){

        double score = 0;
        char[][] array = dc.getDisposition();
        int i = 0,j = 0;
        int k = 0,l = 0;

        while(i<4){
            while(j<10) {
                if(array[i][j] != this.alphabet.emptyLetter) {
                    while (k < 4) {
                        while (l < 10) {
                            if (array[k][l] != this.alphabet.emptyLetter) {
                                //System.out.print("Computing " + array[i][j] + " - " + array[k][l] + '\n');
                                //System.out.println("Result : " +  this.distanceAndWeigth(array[k][l], array[i][j], dc));
                                score += this.distanceAndWeigth(array[k][l], array[i][j], dc);
                            } l++;
                        } l = 0; k++;
                    }
                } k = 0; j++;
            } j = 0; i++;
        }

        return score;
    }


    public double computeT0(double tau0, ListeDispositionClavier ldc){
        // Moyenne des variations de DeltaE
        double moy = 0;
        int i = 0;
        while(i<ldc.getListe().size()-1){
            moy += Math.abs(targetFunction(ldc.getListe().get(i)) - targetFunction(ldc.getListe().get(i+1)));
            i++;
        }
        moy = moy/ldc.getListe().size();

        // Calcul de T0
        return -moy/Math.log(tau0);
    }

    public double temperatureVariation(double ti, double lambda){
        return lambda*ti;
    }

}
