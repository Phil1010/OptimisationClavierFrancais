import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bigramme bigramme = new Bigramme();
        bigramme.parse("freqBigrammes.txt", " ");
        System.out.println(bigramme.getTab().toString());
    }
}
