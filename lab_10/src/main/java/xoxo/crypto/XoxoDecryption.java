package xoxo.crypto;

/**
 * This class is used to create a decryption instance
 * that can be used to decrypt an encrypted message.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class XoxoDecryption {

    /**
     * A Hug Key string that is required to decrypt the message.
     */
    private String hugKeyString;

    /**
     * Class constructor with the given Hug Key string.
     */
    public XoxoDecryption(String hugKeyString) {
        this.hugKeyString = hugKeyString;
    }

    /**
     * Decrypts an encrypted message.
     * 
     * @param encryptedMessage An encrypted message that wants to be decrypted.
     * @return The original message before it is encrypted.
     */
    public String decrypt(String encryptedMessage, int seed) {
        //TODO: Implement decryption algorithm
        
    }
}