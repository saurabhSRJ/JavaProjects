package encryptdecrypt;

public class UnicodeAlgorithm implements AlgorithmStrategy {
    @Override
    public String encrypt(String message, int key) {
        StringBuilder encodedMessage = new StringBuilder("");
        for (int i = 0; i < message.length(); i++) {
            encodedMessage.append((char) (message.charAt(i) + key));
        }
        return encodedMessage.toString();
    }

    @Override
    public String decrypt(String message, int key) {
        StringBuilder decodedMessage = new StringBuilder("");
        for (int i = 0; i < message.length(); i++) {
            decodedMessage.append((char) (message.charAt(i) - key));
        }
        return decodedMessage.toString();
    }
}
