package lab9.user;

import lab9.event.Event;
import java.util.ArrayList;

/**
* Class representing a user, willing to attend event(s)
*/
public class User
{
    /** Name of user */
    private String name;
    
    /** List of events this user plans to attend */
    private ArrayList<Event> events;
    
    /**
    * Constructor
    * Initializes a user object with given name and empty event list
    */
    public User(String name)
    {
        this.name = name;
        this.events = new ArrayList<>();
    }
    
    /**
    * Accessor for name field
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
        // TODO: Implement!
        return false;
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
        // TODO: Implement!
        // WARNING: The list returned needs to be a copy of the actual events list.
        //          You don't want people to change your plans (e.g. clearing the
        //          list) without your consent, right?
        // HINT: see Java API Documentation on ArrayList (java.util.ArrayList)                                                                                                          (or... Google. Yeah that works too. OK.)
        return null;
    }
}
