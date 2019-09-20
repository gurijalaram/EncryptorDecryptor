package com.alegeus.encryptordecryptor;

import java.util.Scanner;

/**
 * Encrypts / decrypts passwords to be used in RAQ database
 */
public class RaqEncryptorDecryptor {

    public static void main(String[] args) {
        String encryptOrDecrypt = "";
        String input = "";
        String consoleMessage = "encrypt";
        String finalDisplay = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("[e]ncrypting or [d]ecrypting?: ");
            encryptOrDecrypt = scanner.nextLine();
        } while (!encryptOrDecrypt.toLowerCase().equals("e") && !encryptOrDecrypt.toLowerCase().equals("d"));

        if ((encryptOrDecrypt).toLowerCase().equals("d")) {
            consoleMessage = "decrypt";
        }
        System.out.print(String.format("Enter string to %s: ", consoleMessage));
        input = scanner.nextLine();
        if ((encryptOrDecrypt).toLowerCase().equals("e")) {
            finalDisplay = Encryptor.encryptString(input);
            System.out.println("Encrypted String:");
            System.out.println(finalDisplay);
        } else {
            finalDisplay = Encryptor.decryptString(input);
            System.out.println("Decrypted string");
            System.out.println(finalDisplay);
        }

        System.out.println("Press return to finish.");
        scanner.nextLine();
    }
}
