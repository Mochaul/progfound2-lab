package theater;
import ticket.Ticket;
import movie.Movie;
import java.util.ArrayList;
public class Theater{
    String name;
    int balance;
    ArrayList<Ticket> ticket;
    Movie[] movies;
    static ArrayList<Theater> theaters; // stores instances of theaters

    public Theater(String name, int balance, ArrayList<Ticket> ticket, Movie[] movies){
        this.name = name;
        this.balance = balance;
        this.ticket = ticket;
        this.movies = movies;
    }

    // getter setter
    public String getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }
    public ArrayList<Ticket> getTicket(){
        return this.ticket;
    }
    public void setBalance(int newBalance){
        this.balance = newBalance;
    }

    // methods
    public static void printTotalRevenueEarned(Theater[] theaters){
        String result = "";
        int totalBalance = 0;
        for(int i=0; i < theaters.length; i++){
            totalBalance += theaters[i].getBalance();
            if (i==0) {
                result+=String.format("Cinema         : %s\n"+
                                      "Cash Balance   : Rp. %d\n",
                                      theaters[i].getName(), theaters[i].getBalance());
            }else{
                result+=String.format("\nCinema         : %s\n"+
                                      "Cash Balance     : Rp. %d\n",
                                      theaters[i].getName(), theaters[i].getBalance());
            }
        }
        System.out.println(String.format("Koh Mas's total money: Rp. %d\n"+
                                         "------------------------------------------------------------------\n"+
                                         result+"\n"+
                                         "------------------------------------------------------------------",
                                         totalBalance))          ;
    }

    public void printInfo(){
        String movieList = "";
        for(int i=0; i < this.movies.length; i++){
            if (i==0){
                movieList += movies[i].getTitle();
            }else{
                movieList += ", " + movies[i].getTitle();
            }
        }
        System.out.println(String.format("------------------------------------------------------------------\n" +
                                         "Cinema                          : %s\n"+
                                         "Cash Balance                    : %s\n"+
                                         "Number of tickets available     : %d\n"+
                                         "Movie list available            : %s\n"+
                                         "------------------------------------------------------------------"
                                         ,this.name ,this.balance, this.ticket.size(), movieList));                       
    }
}