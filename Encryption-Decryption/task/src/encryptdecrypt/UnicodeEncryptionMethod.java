package encryptdecrypt;

public class UnicodeEncryptionMethod implements EncryptionMethod {


    @Override
    public StringBuilder encrypt(int key, StringBuilder message) {
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            int uniCode = letter + key;
            char newLetter = (char) uniCode;
            message.setCharAt(i, newLetter);
        }
        return message;
    }
}
