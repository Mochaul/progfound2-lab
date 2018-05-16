package lab9.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigInteger;

/**
 * A class representing an event and its properties.
 * 
 * @author  Nicolaus
 * @version 1.0
 * @since   2018-05-16
 */
public class Event {
    private final String READ_FORMAT = "yyyy-MM-dd_HH:mm:ss";
    private final String WRITE_FORMAT = "yyyy-MM-dd, HH:mm:ss";
    private final SimpleDateFormat RFORMAT = new SimpleDateFormat(READ_FORMAT);
    private final SimpleDateFormat WFORMAT = new SimpleDateFormat(WRITE_FORMAT);

    private String name;
    private Date start;
    private Date end;
    private BigInteger cost;

    /**
     * creates an instance of {@code Event}
     * 
     * @param   name    the name of the event
     * @param   start   the start of the event in date time format specified in {@code READ_FORMAT}
     * @param   end     the end of the event in date time format specified in {@code READ_FORMAT}
     * @param   cost    the cost per hour for attending the event
     * @throws  ParseException   if start and end date cannot be read     
     */
    public Event(String name, String start, String end, String cost) throws ParseException{
        this.name = name;
        this.start = RFORMAT.parse(start);
        this.end = RFORMAT.parse(end);
        this.cost = new BigInteger(cost);
    }

    /**
    * Accessor for name field. 
    * @return name of this event instance
    */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * returns a string containing information of the event
     * 
     * @return the string containing information of event
     */
    public String toString(){
        return String.format("%s\nWaktu mulai: %s\nWaktu selesai: %s\nBiaya kehadiran: %s", 
            this.name, WFORMAT.format(start), WFORMAT.format(end), this.cost.toString());
    }
    
    /**
     * checks wether two events overlap
     * 
     * @param   other   another event to check for overlap with this event
     * @return  boolean value indicating wether overlap occurs
     */
    public boolean overlapsWith(Event other){
        if (other.start.before(this.start)){
            return other.overlapsWith(this);
        }
        if (this.end.after(other.start)){
            return true;
        }
        return false;
    }
}
