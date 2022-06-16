package encryptdecrypt;

public class ShiftDecryptionMethod implements DecryptionMethod {

    @Override
    public StringBuilder decrypt(int key, StringBuilder message) {
        StringBuilder result = new StringBuilder();
        int originalAlphabetPosition;
        int newAlphabetPosition;
        char newCharacter;

        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                if (Character.isUpperCase(message.charAt(i))) {
                    originalAlphabetPosition = message.charAt(i) - 'A';
                    newAlphabetPosition = (originalAlphabetPosition + 26 - key) % 26;
                    newCharacter = (char) ('A' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    originalAlphabetPosition = message.charAt(i) - 'a';
                    newAlphabetPosition = (originalAlphabetPosition + 26 - key) % 26;
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
