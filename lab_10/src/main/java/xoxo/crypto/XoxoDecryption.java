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
        String result = "";
        int c;
        for(int i=0; i<encryptedMessage.length(); i++){
            c = encryptedMessage.charAt(i) ^ ((hugKeyString.charAt(i%hugKeyString.length()) ^ seed) - 'a');
            result += (char)c;
            System.out.println(c);
        }
        return result;
    }
}