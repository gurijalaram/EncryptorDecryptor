package com.alegeus.encryptordecryptor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * Handles base encryption / decryption of passwords
 */
public class Encryptor {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "steelinMAHbukkit".getBytes();

    /**
     * Encrypts string value using AES encryption
     * @param stringToEncrypt
     * @return AES encrypted string
     */
    public static String encryptString(String stringToEncrypt) {
        String returnString = "";
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encodedValue = cipher.doFinal(stringToEncrypt.getBytes("UTF-8"));
            byte[] encryptedByteValue = Base64.getEncoder().encode(encodedValue);
            returnString = new String(encryptedByteValue, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString;
    }

    /**
     * Decrypts AES encrypted string that was encrypted using this class
     * @param stringToDecrypt
     * @return Plaintext password
     */
    public static String decryptString(String stringToDecrypt) {
        String returnString = "";
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedValue = Base64.getDecoder().decode(stringToDecrypt.getBytes("UTF-8"));
            byte[] decryptedByteValue = cipher.doFinal(decodedValue);
            returnString = new String(decryptedByteValue, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString;
    }

    /**
     * Generates AES secret key
     * @return AES secret key
     * @throws Exception
     */
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
}
