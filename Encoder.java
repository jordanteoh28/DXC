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

        if (refString.indexOf(offsetString) != -1) {
            int lengthRefString = refString.length();
            String encoded = offsetString;
    
            for (int i = 0 ; i < plainText.length() ; i++) {
                char indivChar = plainText.charAt(i);
                int positionPlainText = refString.indexOf(indivChar);
                if (positionPlainText == -1) {
                    encoded += indivChar;
                }
                else {
                    int newPosition = (positionPlainText - offsetValue + lengthRefString) % lengthRefString;
                    encoded += refString.charAt(newPosition);
                }
            }

            return encoded;
        }

        else {
            return offsetString + plainText;
        }
    }

    public String decode(String encodedText) {
        char offsetChar = encodedText.charAt(0);
        String offsetString = "" + offsetChar;


        int lengthRefString = refString.length();
        this.offsetValue = refString.indexOf(offsetChar);
        
        String decoded = "";

        if (refString.indexOf(offsetString) != -1) {
            for (int i = 1 ; i < encodedText.length() ; i++) {
                char indivChar = encodedText.charAt(i);
                int positionEncodedText = refString.indexOf(indivChar);
                if (positionEncodedText == -1) {
                    decoded += indivChar;
                }
                else {
                    int newPosition = (positionEncodedText + offsetValue) %  lengthRefString;
                    decoded += refString.charAt(newPosition);
                }
            }
            return decoded;
        }

        else {
            return encodedText.substring(1, encodedText.length());
        }
        
    }
}