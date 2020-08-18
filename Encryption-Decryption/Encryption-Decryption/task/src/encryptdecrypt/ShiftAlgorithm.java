package encryptdecrypt;

public class ShiftAlgorithm implements AlgorithmStrategy {
    @Override
    public String encrypt(String data, int key) {
        key = key % 26;
        StringBuilder encodedMessage = new StringBuilder(data);
        for (int i = 0; i < encodedMessage.length(); i++) {
            char ch = encodedMessage.charAt(i);
            if (Character.isLetter(ch)) {
                char newChar;
                if (Character.isLowerCase(ch)) {
                    newChar = (char) ((ch + key - 97) % 26 + 97);
                } else {
                    newChar = (char) ((ch + key - 65) % 26 + 65);
                }
                encodedMessage.setCharAt(i, newChar);
            }
        }
        return encodedMessage.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        key = key % 26;
        StringBuilder decodedMessage = new StringBuilder(data);
        for (int i = 0; i < decodedMessage.length(); i++) {
            char ch = decodedMessage.charAt(i);
            if (Character.isLetter(ch)) {
                char newChar;
                if (Character.isLowerCase(ch)) {
                    newChar = (char) ((ch - key - 97 + 26) % 26 + 97);
                } else {
                    newChar = (char) ((ch - key - 65 + 26) % 26 + 65);
                }
                decodedMessage.setCharAt(i, newChar);
            }
        }
        return decodedMessage.toString();
    }
}
