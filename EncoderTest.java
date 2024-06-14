public class EncoderTest {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        String plainText = "H#LLO WORLD";
        String encoded = encoder.encode(plainText);
        System.out.println("Encoded message: " + encoded);

        String decoded = encoder.decode(encoded);
        System.out.println("Decoded message: " + decoded);   
    }
}