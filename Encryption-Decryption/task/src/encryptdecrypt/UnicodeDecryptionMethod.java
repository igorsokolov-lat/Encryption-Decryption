package encryptdecrypt;

public class UnicodeDecryptionMethod implements DecryptionMethod {

    @Override
    public StringBuilder decrypt(int key, StringBuilder message) {
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            int uniCode = letter - key;
            char newLetter = (char) uniCode;
            message.setCharAt(i, newLetter);
        }
        return message;
    }
}
