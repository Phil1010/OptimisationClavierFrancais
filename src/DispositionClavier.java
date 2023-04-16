package src;

public class DispositionClavier {



    private char[][] disposition;
    private final Alphabet alphabet;

    public DispositionClavier(){
        this.disposition = new char[4][10];
        this.alphabet = new Alphabet();
    }

    public DispositionClavier(DispositionClavier dispositionClavier) {
        this.disposition = new char[4][10];
        int i = 0, j = 0;
        while(i<4){
            while(j<10){
                this.disposition[i][j] = dispositionClavier.getDisposition()[i][j];
                j++;
            }
            j=0; i++;
        }


        this.alphabet = new Alphabet();
    }

    public void generateRandomDisposition(){
        int nbLetters = 26;
        for(int i = 0; i<4; i++) {
            for(int j = 0; j<10; j++) {
                if(nbLetters > 0) {
                    int value = (int) Math.floor(Math.random() * (nbLetters));
                    this.disposition[i][j] = this.alphabet.getLetter(value);
                    this.alphabet.removeLetter(value);
                    nbLetters -= 1;
                } else {
                    this.disposition[i][j] = this.alphabet.emptyLetter;
                }
            }
        }
    }

    public void generateFixedDisposition(){
        char[][] disp = new char[4][10];
        disp[0] = new char[] {'A', '*', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        disp[1] = new char[] {'Q', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M'};
        disp[2] = new char[] {'W', 'X', 'C', 'V', 'B', 'N', '*', '*', '*', '*'};
        disp[3] = new char[] {'*', '*', '*', '*', '*', '*', '*', 'Z', '*', '*'};


        this.disposition = disp;
    }
    public void generateFixedDisposition250(){
        char[][] disp = new char[4][10];
        disp[0] = new char[] {'*', '*', 'H', 'N', 'Y', '*', '*', 'E', 'U', '*'};
        disp[1] = new char[] {'C', 'M', 'P', 'J', 'K', '*', 'L', 'S', '*', '*'};
        disp[2] = new char[] {'*', 'V', 'W', 'Q', 'Z', 'X', 'A', 'O', 'D', 'T'};
        disp[3] = new char[] {'*', 'B', 'G', 'F', 'I', 'R', '*', '*', '*', '*'};


        this.disposition = disp;
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
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public char getLetter(int x, int y){
        return this.disposition[x][y];
    }

    public int manhattanDistance(Character letter1, Character letter2){
        int[] tab1 = this.findLetterCoords(letter1);
        int[] tab2 = this.findLetterCoords(letter2);
        assert tab1 != null; assert tab2 != null;

        int xl1 = tab1[0]; int yl1 = tab1[1];
        int xl2 = tab2[0]; int yl2 = tab2[1];
        return Math.abs(xl1-xl2) + Math.abs(yl1 - yl2);
    }

    public char[][] getDisposition() {
        return disposition;
    }


}
