package xoxo.exceptions;

/**
 * An exception that is thrown if the size of message is
 * exceeding 10 kilobits
 * 
 * @author Nicolaus
 */
public class SizeTooBigException extends RuntimeException{
    
    /**
     * Class constructor.
     */
    public SizeTooBigException(String message){
        super(message);
    }
    
}