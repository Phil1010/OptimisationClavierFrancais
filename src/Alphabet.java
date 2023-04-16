package src;

import java.util.ArrayList;

public class Alphabet {

    private final ArrayList<Character> lettres;
    public final char emptyLetter;

    public Alphabet(){
        this.lettres = new ArrayList<>();
        for(int i = 1; i <= 26; i++){
            this.lettres.add((char)(64 + i));
        }
        this.emptyLetter = '*';
    }

    public void printAlphabet(){
        for(Character c : this.lettres){
            System.out.print(c + "  ");
        }
        System.out.println();
    }

    public void removeLetter(int index){
        this.lettres.remove(index);
    }

    public char getLetter(int index) {
        return this.lettres.get(index);
    }
}
