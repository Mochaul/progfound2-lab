package lab9;

import lab9.user.User;
import lab9.event.Event;

import java.util.ArrayList;

/**
* Class representing event managing system
*/
public class EventSystem
{
    /**
    * List of events
    */
    private ArrayList<Event> events;
    
    /**
    * List of users
    */
    private ArrayList<User> users;
    
    /**
    * Constructor. Initializes events and users with empty lists.
    */
    public EventSystem()
    {
        this.events = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    public String addEvent(String name, String startTimeStr, String endTimeStr, String costPerHourStr)
    {
        // TODO: Implement!
        return false;
    }
    
    public String addUser(String name)
    {
        // TODO: Implement:
        return false;
    }
    
    public String registerToEvent(String userName, String eventName)
    {
        // TODO: Implement
        return "";
    }
}