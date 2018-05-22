package xoxo.exceptions;

/**
 * An exception that is thrown if the Kiss Key that
 * is used to encrypt a message contains characters other 
 * than A-Z, a-z or {@code}
 * 
 * @author Nicolaus
 */
public class InvalidCharacterException extends RuntimeException{
    
    /**
     * Class constructor.
     */
    public InvalidCharacterException(String message){
        super(message);
    }

}