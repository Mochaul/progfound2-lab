package xoxo.crypto;

import xoxo.exceptions.KeyTooLongException;
import xoxo.key.HugKey;
import xoxo.key.KissKey;
import xoxo.util.XoxoMessage;

/**
 * This class is used to create an encryption instance
 * that can be used to encrypt a plain text message.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class XoxoEncryption {

    /**
     * A Kiss Key object that is required to encrypt the message.
     */
    private KissKey kissKey;

    /**
     * Class constructor with the given Kiss Key
     * string to build the Kiss Key object.
     * 
     * @throws KeyTooLongException if the length of the
     *         kissKeyString exceeded 28 characters.
     */
    public XoxoEncryption(String kissKeyString) throws KeyTooLongException{
        this.kissKey = new KissKey(kissKeyString);
    }

    /**
     * Encrypts a message in order to make it unreadable.
     * 
     * @param message The message that wants to be encrypted.
     * @return A XoxoMessage object that contains the encrypted message
     *         and a Hug Key object that can be used to decrypt the message.
     */
    public XoxoMessage encrypt(String message) {
        String encryptedMessage = this.encryptMessage(message); 
        return new XoxoMessage(encryptedMessage, new HugKey(this.kissKey));
    }

    /**
     * Encrypts a message in order to make it unreadable.
     * 
     * @param message The message that wants to be encrypted.
     * @param seed A number to generate different Hug Key.
     * @return A XoxoMessage object that contains the encrypted message
     *         and a Hug Key object that can be used to decrypt the message.
     * @throws RangeExceededException if ... <complete this>
     */
    public XoxoMessage encrypt(String message, int seed) {
        //TODO: throw RangeExceededException for seed requirements
        String encryptedMessage = this.encryptMessage(message); 
        return new XoxoMessage(encryptedMessage, new HugKey(this.kissKey, seed));
    }

    /**
     * Runs the encryption algorithm to turn the message string
     * into an ecrypted message string.
     * 
     * @param message The message that wants to be encrypted.
     * @return The encrypted message string.
     * @throws SizeTooBigException if ... <complete this>
     * @throws InvalidCharacterException if ... <complete this>
     */
    private String encryptMessage(String message) {
        //TODO: throw SizeTooBigException for message requirements
        final int length = message.length();
        String encryptedMessage = "";
        for (int i = 0; i < length; i++) {
            //TODO: throw InvalidCharacterException for message requirements
            int m = message.charAt(i);
            int k = this.kissKey.keyAt(i) - 'a';
            int value = m ^ k;
            encryptedMessage += (char) value;
        }
        return encryptedMessage;
    }
}

