package encryptdecrypt;

public class Encryptor {

    private EncryptionMethod method;

    public void setMethod(EncryptionMethod method) {
        this.method = method;
    }

    public StringBuilder encrypt(int key, StringBuilder message) {
        return this.method.encrypt(key, message);
    }
}
