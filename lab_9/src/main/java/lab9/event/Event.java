package lab9.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigInteger;

/**
 * A class representing an event and its properties.
 * 
 * @author  Nicolaus
 * @version 1.1
 * @since   2018-05-16
 */
public class Event implements Cloneable{
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
    * 
    * @return name of this event instance
    */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Accessor for start field.
     * 
     * @return start date of this event instance
     */
    public Date getStartDate(){
        return this.start;
    }

    /**
     * Accessor for end field.
     * 
     * @return end date of this event instance
     */
    public Date getEndDate(){
        return this.end;
    }

    /**
     * Accessor for cost field.
     * 
     * @return cost of attending event per hour
     */
    public BigInteger getCostPerHour(){
        return this.cost;
    }

    /**
     * returns a double whose value is the duration of the event in hours
     * 
     * @return duration of event in hours
     */
    public double getDuration(){
        return ((double)(this.end.getTime() - this.start.getTime()))/(1000.0*60.0*60.0);
    }

    /**
     * returns a biginteger whose value is the cost of attending this event
     * 
     * @return cost per hour * duration of event
     */
    public BigInteger getCost(){
        // multiplying by 1000 then dividing to increase precision of integer
        return this.getCostPerHour().multiply( new BigInteger(String.valueOf((int)(this.getDuration()*1000))) ).divide(new BigInteger("1000"));
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

    /**
     * returns a deep copy of this event
     * 
     * @return  deep copy of event
     */
    @Override
    public Object clone(){  
        try{  
            return super.clone();  
        }catch(Exception e){ 
            return null; 
        }
    }
}
