package xoxo.exceptions;

/**
 * An exception that is thrown if seed is not in
 * the range of 0-36 inclusive.
 * 
 * @author Nicolaus
 */
public class RangeExceededException extends RuntimeException{
    
    /**
     * Class constructor.
     */
    public RangeExceededException(String message){
        super(message);
    }

}