package encryptdecrypt;

public class Decryptor {

    private DecryptionMethod method;

    public void setMethod(DecryptionMethod method) {
        this.method = method;
    }

    public StringBuilder decrypt(int key, StringBuilder message) {
        return this.method.decrypt(key, message);
    }
}
