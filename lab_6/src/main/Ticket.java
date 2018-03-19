public class Ticket {
    Movie movie;
    String day; // day of show, monday to sunday
    boolean type; // true -> 3d movie, false -> 2d movie
    int price = 60000;

    // constructor
    public Ticket(Movie movie, String day, boolean type){
        this.movie = movie;
        this.day = day;
        this.type = type;
        if (day.toLowerCase().equals("sabtu") || day.toLowerCase().equals("minggu")){
            this.price += 40000;
        }
        if (this.type){
            price *= 1.2;
        }
    }

    // setter getter
    public Movie getMovie(){
        return this.movie;
    }
    public String getDay(){
        return this.day;
    }
    public boolean getType(){
        return this.type;
    }
    public int getPrice(){
        return this.price;
    }

    // methods
    public String toString(){
        return  String.format("------------------------------------------------------------------\n"+ 
                              "Film            : %s\n"+
                              "Jadwal Tayang   : %s\n"+
                              "Jenis           : %s\n"+
                              "------------------------------------------------------------------"
                              ,this.movie, this.day, this.type);
    }
}