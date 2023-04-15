package src;

public class DispositionClavier {

    private final char[][] disposition;
    private final Alphabet alphabet;

    public DispositionClavier(){
        this.disposition = new char[4][10];
        this.alphabet = new Alphabet();
    }


    public void generateRandomDisposition(){
        int nbLetters = 26;
        for(int i = 0; i<4; i++) {
            for(int j = 0; j<10; j++) {
                if(nbLetters > 0) {
                    int value = (int) Math.floor(Math.random() * (nbLetters));
                    this.disposition[i][j] = this.alphabet.getLetter(value);
                    nbLetters -= 1;
                }
            }
        }
    }

    public void printDisposition(){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<10; j++){
                System.out.print(this.disposition[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    private int[] findLetterCoords(Character letter){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<10; j++){
                if(this.disposition[i][j] == letter){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;
    }

    public int manhattanDistance(Character letter1, Character letter2){
        int[] tab1 = this.findLetterCoords(letter1);
        int[] tab2 = this.findLetterCoords(letter2);
        assert tab1 != null; assert tab2 != null;

        int xl1 = tab1[0]; int yl1 = tab1[1];
        int xl2 = tab2[0]; int yl2 = tab2[1];
        return Math.abs(xl1-xl2) + Math.abs(yl1 - yl2);
    }


}
