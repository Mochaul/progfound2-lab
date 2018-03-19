public class Movie{
    String title;
    String genre;
    int duration;
    String rating;
    String type;
    
    public String getTitle(){
        return this.title;
    }
    public String getRating(){
        return this.rating;
    }
    
    public Movie(String title, String genre, int duration, String rating, String type){
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.type = type;
    }

    public String toString(){
        return String.format("------------------------------------------------------------------\n" +
                             "Title       : %s\n" +
                             "Genre       : %s\n" +
                             "Duration    : %d minutes\n" +
                             "Rating      : %s\n" +
                             "Type        : %s\n" +
                             "------------------------------------------------------------------"
                              ,this.title , this.genre, this.duration, this.rating, this.type);
    }
}