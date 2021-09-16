package com.company;

import java.math.BigInteger;

public class MetodaAfin {
    private static int firstKey = 7;
    private static int secondKey = 16;
    private static int module = 26;

    public static void main(String[] args) {
        String input = "la multi ani";
        String cipher = encrypt(input);
        String deciphered = decrypt(cipher);
        System.out.println("Source:    " + input);
        System.out.println("Encrypted: " + cipher);
        System.out.println("Decrypted: " + deciphered);
    }

    static String encrypt(String input) {
        StringBuilder builder = new StringBuilder();
        for (int in = 0; in < input.length(); in++) {
            char character = input.charAt(in);
            if (Character.isLetter(character)) {
                character = (char) ((firstKey * (character - 'a') + secondKey) % module + 'a');
            }
            builder.append(character);
        }
        return builder.toString();
    }

    static String decrypt(String input) {
        StringBuilder builder = new StringBuilder();
        // compute firstKey^-1 aka "modular inverse"
        BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));
        // perform actual decryption
        for (int in = 0; in < input.length(); in++) {
            char character = input.charAt(in);
            if (Character.isLetter(character)) {
                int decoded = inverse.intValue() * (character - 'a' - secondKey + module);
                character = (char) (decoded % module + 'a');
            }
            builder.append(character);
        }
        return builder.toString();
    }
}
