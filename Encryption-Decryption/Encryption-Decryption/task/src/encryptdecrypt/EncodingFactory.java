package encryptdecrypt;

public class EncodingFactory {

    public AlgorithmStrategy getEncodingObject(Input input){
        if(input.getAlgorithm().equals("shift")) {
            return new ShiftAlgorithm();
        } else  if(input.getAlgorithm().equals("unicode")) {
            return new UnicodeAlgorithm();
        } else {
            throw new IllegalArgumentException("Error: algorithm not supported");
        }
    }
}
