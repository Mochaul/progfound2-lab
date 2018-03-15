import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Johanes Iman
 * @version 2.1
 * created for tutorial 6 DDP2
 * You don't need to change any code here except if you want to work on the Bonus problem.
 * Don't forget to put your works (Class for Movie, Ticket, Theater, and Customer )in the separate package, and give the package name "tutorial_6"
 */
public class Lab6 {
    public static void main(String[] args) {
        //Membuat daftar film yang ada
        Movie[] movies = createMovieList();
        Movie[] movies2 = {movies[0], movies[1]};

        //Membuat daftar tiket film dengan film-film yang tersedia
        Ticket[] tickets1 = createTicket1(movies);
        Ticket[] tickets2 = createTicket2(movies);

        //Membuat bioskop dengan nama, saldo awal, dan tiket awal
        Theater[] theaters = {new Theater("CGT Blitz", 0, new ArrayList<>(Arrays.asList(tickets1)), movies),
                new Theater("CompFest XXI", 25000, new ArrayList<>(Arrays.asList(tickets2)), movies2)};

        //Menginisiasi pelanggan dengan nama, jenis kelamin, dan umur
        Customer dekDepe = new Customer("Dek Depe",true,10);
        Customer sisDea = new Customer("Sis Dea",true,15);
        Customer kakPewe = new Customer("Kak Pewe",false,20);

        theaters[0].printInfo();
        theaters[1].printInfo();

        Ticket tiketDekDepe1 = dekDepe.orderTicket(theaters[0], "Black Panther", "Senin", "3 Dimensi");
        Ticket tiketDekDepe2 = dekDepe.orderTicket(theaters[0], "The Greatest Showman", "Selasa", "3 Dimensi");

        sisDea.findMovie(theaters[1], "Si Juki The Movie");
        sisDea.findMovie(theaters[1], "Dilan 1990");

        Ticket tiketSisDea1 = sisDea.orderTicket(theaters[1], "Dilan 1990", "Selasa", "Biasa");
        Ticket tiketSisDea2 = sisDea.orderTicket(theaters[1], "Dilan 1990", "Sabtu", "Biasa");

        Ticket tiketPewe1 = kakPewe.orderTicket(theaters[0],"Si Juki The Movie", "Kamis", "Biasa");
        Ticket tiketPewe2 = kakPewe.orderTicket(theaters[1],"Black Panther", "Sabtu", "3 Dimensi");

        Theater.printTotalRevenueEarned(theaters);

        /*==========TEMPLATE UNTUK SOAL BONUS==========
        kakPewe.cancelTicket(theaters[0]);//Refund ke CGT Blitz
        kakPewe.cancelTicket(theaters[1]);
        kakPewe.watchMovie(tiketPewe1);
        kakPewe.cancelTicket(theaters[0]);
        sisDea.cancelTicket(theaters[0]);

        Theater.printTotalRevenueEarned(theaters);//Bangkrutt
        */
    }

    public static Movie[] createMovieList() {
        Movie[] movies = {new Movie("Black Panther","Remaja",134,"Action/Adventure","Import"),
                new Movie("Dilan 1990","Remaja",110,"Romantis/Drama","Lokal"),
                new Movie("The Greatest Showman","Umum",106,"Drama/Musical","Import"),
                new Movie("Si Juki The Movie","Dewasa",100,"Jomblo","Lokal")};
        return movies;
    }

    private static Ticket[] createTicket1(Movie[] movies) {
        Ticket[] tickets1 = {new Ticket(movies[0],"Senin",false), new Ticket(movies[0],"Selasa",true),new Ticket(movies[0],"Sabtu",true),
                new Ticket(movies[1],"Senin",true), new Ticket(movies[1],"Rabu",true),new Ticket(movies[1],"Minggu",true),
                new Ticket(movies[2],"Selasa",true), new Ticket(movies[2],"Jumat",true),new Ticket(movies[2],"Minggu",true),
                new Ticket(movies[3],"Kamis",false), new Ticket(movies[3],"Jumat",true),new Ticket(movies[3],"Sabtu",true)};
        return tickets1;
    }

    private static Ticket[] createTicket2(Movie[] movies) {
        Ticket[] tickets2 = {new Ticket(movies[0],"Senin",false), new Ticket(movies[0],"Selasa",true),new Ticket(movies[0],"Sabtu",true),
                new Ticket(movies[0],"Rabu",false), new Ticket(movies[0],"Kamis",false),new Ticket(movies[0],"Minggu",false),
                new Ticket(movies[1],"Senin",true), new Ticket(movies[1],"Jumat",false),new Ticket(movies[1],"Minggu",false),
                new Ticket(movies[1],"Senin",false), new Ticket(movies[1],"Sabtu",false),new Ticket(movies[1],"Minggu",true)};
        return tickets2;
    }
}
