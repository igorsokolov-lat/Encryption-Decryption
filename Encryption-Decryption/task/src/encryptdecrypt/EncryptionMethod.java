package encryptdecrypt;

public interface EncryptionMethod {

    StringBuilder encrypt(int key, StringBuilder message);

}
