package encryptdecrypt;

public class ShiftEncryptionMethod implements EncryptionMethod {


    @Override
    public StringBuilder encrypt(int key, StringBuilder message) {
        StringBuilder result = new StringBuilder();
        int originalAlphabetPosition;
        int newAlphabetPosition;
        char newCharacter;

        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                if (Character.isUpperCase(message.charAt(i))) {
                    originalAlphabetPosition = message.charAt(i) - 'A';
                    newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    newCharacter = (char) ('A' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    originalAlphabetPosition = message.charAt(i) - 'a';
                    newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                }
            } else {
                result.append(message.charAt(i));
            }
        }
        return result;
    }
}
