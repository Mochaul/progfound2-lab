package lab9.user;

import lab9.event.Event;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class representing a user, willing to attend event(s)
 * 
 * @author  Nicolaus
 * @version 1.0
 * @since   2018-05-16
 */
public class User
{
    /** Name of user */
    private String name;
    
    /** List of events this user plans to attend */
    private ArrayList<Event> events;
    
    /**
     * Initializes a user object with given name and empty event list
     * 
     * @param   name    name of user
     */
    public User(String name)
    {
        this.name = name;
        this.events = new ArrayList<>();
    }
    
    /**
    * Accessor for name field
    *
    * @return name of this instance
    */
    public String getName() {
        return name;
    }
    
    /**
    * Adds a new event to this user's planned events, if not overlapping
    * with currently planned events.
    *
    * @return true if the event if successfully added, false otherwise
    */
    public boolean addEvent(Event newEvent)
    {
        for(Event e : events){
            if(newEvent.overlapsWith(e)){
                return false;
            }
        }
        events.add(newEvent);
        return true;
    }

    /**
    * Returns the list of events this user plans to attend,
    * Sorted by their starting time.
    * Note: The list returned from this method is a copy of the actual
    *       events field, to avoid mutation from external sources
    *
    * @return list of events this user plans to attend
    */
    public ArrayList<Event> getEvents()
    { 
        ArrayList<Event> result = new ArrayList<>();
        for(Event e : events){
            result.add((Event)e.clone());
        }
        Collections.sort(result, new Comparator<Event>() {
            public int compare(Event one, Event other) {
                return one.getStartDate().compareTo(other.getStartDate());
            }
        });
        return result;
    }

    /**
     * returns a biginteger whose value is the total cost of attending all events selected by this user
     * 
     * @return total cost of attending events selected by user
     */
    public BigInteger getTotalCost(){
        BigInteger result = new BigInteger("0");
        for(Event e : events){
            result = result.add(e.getCost());
        }
        return result;
    }
}
