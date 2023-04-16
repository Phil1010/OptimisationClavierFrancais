package src;

public class RecuitSimule {

    private final Alphabet alphabet;
    private final Bigramme bigramme;

    public RecuitSimule(Bigramme b){
        this.alphabet = new Alphabet();
        this.bigramme = b;
    }

    public float targetFunction(DispositionClavier dc){

        float score = 0;
        char[][] array = dc.getDisposition();
        int i = 0,j = 0;
        int k = 0,l = 0;

        while(i<4){
            while(j<10) {
                if(array[i][j] != this.alphabet.emptyLetter) {
                    while (k < 4) {
                        while (l < 10) {
                            if (array[k][l] != this.alphabet.emptyLetter) {
                                // System.out.print("Computing " + array[i][j] + " - " + array[k][l] + '\n');
                                score += this.distanceAndWeigth(array[k][l], array[i][j], dc);
                            } l++;
                        } l = 0; k++;
                    }
                } k = 0; j++;
            } j = 0; i++;
        }

        return score;
    }


    public float computeT0(float tau0, ListeDispositionClavier ldc){
        // Moyenne des variations de DeltaE
        float moy = 0;
        int i = 0;
        while(i<ldc.getListe().size()-1){
            moy += Math.abs(targetFunction(ldc.getListe().get(i)) - targetFunction(ldc.getListe().get(i+1)));
            i++;
        }
        moy = moy/ldc.getListe().size();

        // Calcul de T0
        return (float) (-moy/Math.log(tau0));
    }

    public float temperatureVariation(float ti, float lambda){
        return lambda*ti;
    }

}
