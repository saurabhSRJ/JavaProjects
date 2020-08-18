package encryptdecrypt;

public class Input {
    private String data;
    private int key;
    private String mode;
    private String in;
    private String out;
    private String algorithm;

    public Input() {
        this.data = "";
        this.key = 0;
        this.algorithm = "shift";
        this.in = "";
        this.out = "";
        this.mode = "enc";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
