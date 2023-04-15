package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bigramme {

    private int currentx;
    private int currenty;
    private int[][] bigrammeMatrix;

    public Bigramme() {
        this.bigrammeMatrix = new int[26][26];
        this.currentx = 0;
        this.currenty = 0;
    }

    public void parse(String filename) throws IOException {
        ArrayList<String> bigrammes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                bigrammes.add(line);
            }
        }

        // Removing useless content
        bigrammes.remove(0);
        for(String s : bigrammes){
            String[] occurs = s.split("\t");
            for(String s2 : occurs){
                if(!s2.equals(" ") && !s2.matches("[A-Z]_")){
                    this.addOccurToMatrix(Integer.parseInt(s2));
                }
            }
        }


    }

    public void addOccurToMatrix(int occur) {
        this.bigrammeMatrix[this.currentx][this.currenty] = occur;
        this.currenty++;
        if(this.currenty == 26){
            this.currenty = 0;
            this.currentx += 1;
        }
    }


    public int[][] getBigrammes() {
        return this.bigrammeMatrix;
    }


    public void printBigramme(){
        System.out.println("Bigrammes :");
        for(int i=0;i<26;i++){
            System.out.print(i + " - | ");
            for(int j=0;j<26;j++){
                System.out.print(this.bigrammeMatrix[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------"
                    + "----------------------------------------------------------------------------------------------"
                    + "--------------------");
        }
    }
}
