import java.util.Scanner;

public class Encoder {
    private static final String refString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    private int offsetValue;

    public String encode(String plainText) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the offset > ");
        String offsetString = sc.next().toUpperCase();
        this.offsetValue = refString.indexOf(offsetString);
        sc.close();

        int lengthRefString = refString.length();
        String encoded = offsetString;

        for (int i = 0 ; i < plainText.length() ; i++) {
            char indivChar = plainText.charAt(i);
            int positionPlainText = refString.indexOf(indivChar);
            if (positionPlainText == -1) {
                encoded += " ";
            }
            else {
                int newPosition = (positionPlainText - offsetValue + lengthRefString) % lengthRefString;
                encoded += refString.charAt(newPosition);
            }
        }
        return encoded;
    }

    public String decode(String encodedText) {
        char offsetChar = encodedText.charAt(0);
        int lengthRefString = refString.length();
        this.offsetValue = refString.indexOf(offsetChar);
        
        String decoded = "";

        for (int i = 1 ; i < encodedText.length() ; i++) {
            char indivChar = encodedText.charAt(i);
            int positionEncodedText = refString.indexOf(indivChar);
            if (positionEncodedText == -1) {
                decoded += " ";
            }
            else {
                int newPosition = (positionEncodedText + offsetValue) %  lengthRefString;
                decoded += refString.charAt(newPosition);
            }
        }
        return decoded;
    }
}