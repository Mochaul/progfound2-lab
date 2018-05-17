package lab9;

import lab9.user.User;
import lab9.event.Event;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Class representing event managing system
 * 
 * @author  Nicolaus
 * @version 1.0
 * @since   2018-05-17
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
    
    /**
     * registers an uniquely-named event to system
     * 
     * @param   name    the name of event to be registered
     * @param   start   the start of event
     * @param   end     the end of event
     * @param   cost    cost of attending event per hour
     * @return  a string indicating wether event is succesfully registered, event name already exist or invalid date format
     */
    public String addEvent(String name, String startTimeStr, String endTimeStr, String costPerHourStr)
    {
        Event temp;
        if (getEvent(name) == null){
            try{
                temp = new Event(name, startTimeStr, endTimeStr, costPerHourStr);
                if(temp.getEndDate().before(temp.getStartDate())){
                    throw new ParseException("start > end", 0);
                }
                events.add(temp);
                return String.format("Event %s berhasil ditambahkan!", name);

            }catch (ParseException e){
                return "Waktu yang diinputkan tidak valid!";
            }
        }
        return String.format("Event %s sudah ada!", name);
    }
    
    /**
     * registers a uniquely-named user to system
     * 
     * @param   name    name of user to be registered
     * @return  a string indicating wether user is successfully registered or user 
     */
    public String addUser(String name)
    {
        if(getUser(name) == null){
            users.add(new User(name));
            return String.format("User %s berhasil ditambahkan!", name);
        } 
        return String.format("User %s sudah ada!", name);
    }
    
    /**
     * registers event {@code eventName} to the list of events that will be attended by user {@code userName}
     * user must not have any events in user's list that overlaps with event {@code eventName}
     * 
     * @param   userName    name of user
     * @param   eventName   name of event
     * @return  a string indicating wether event is going to be attended by user, user {@code userName} not found, event {@code eventName} not found
     */
    public String registerToEvent(String userName, String eventName)
    {
        User registrant = getUser(userName);
        Event event = getEvent(eventName);
        if(registrant == null && event == null){
            return String.format("Tidak ada pengguna dengan nama %s dan acara dengan nama %s!", userName, eventName);
        }
        if(registrant == null) return String.format("Tidak ada pengguna dengan nama %s!", userName);
        if(event == null) return String.format("Tidak ada acara dengan nama %s!", eventName);
        for(Event e : registrant.getEvents()){
            if(e.overlapsWith(event)){
                return String.format("%s sibuk sehingga tidak dapat menghadiri %s!", userName, eventName);
            }
        }
        registrant.addEvent(event);
        return String.format("%s berencana menghadiri %s!", userName, eventName);
    }

    /**
     * returns {@code User} object with name {@code name}
     * 
     * @param   name    name of user
     * @return  {@code User} object if found, {@code null} otherwise
     */
    public User getUser(String name){
        for(User u : users){
            if (u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }

    /**
     * returns {@code Event} object with name {@name}
     * 
     * @param   name    name of event
     * @return  {@code Event} object if found, {@code null} otherwise
     */
    public Event getEvent(String name){
        for(Event e : events){
            if (e.getName().equals(name)){
                return (Event)e.clone();
            }
        }
        return null;
    }
}