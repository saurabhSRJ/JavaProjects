import java.io.Serializable;
import java.util.*;

class AsciiCharSequence implements CharSequence {
    // implementation
    byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public String toString() {
        return new String(byteArray);
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int i) {
        return (char) byteArray[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(byteArray, i, i1));
    }
}