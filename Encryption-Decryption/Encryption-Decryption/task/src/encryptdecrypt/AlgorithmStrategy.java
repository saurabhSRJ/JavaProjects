package encryptdecrypt;

public interface AlgorithmStrategy {
    String encrypt(String data, int key);

    String decrypt(String data, int key);
}
