import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import customer.Customer;
import movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import theater.Theater;
import ticket.Ticket;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Lab6Test {
    Movie[] movies;
    Ticket[] tickets1;
    Ticket[] tickets2;
    private Theater cgtBlitz;
    private Theater compFestXXI;
    private Customer dekDepe;
    private Customer sisDea;
    private Customer kakPewe;
    private OutputStream out;
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = Logger.getLogger(Lab6Test.class.getName());
        movies = Lab6.createMovieList();
        Movie[] movies2 = {movies[0], movies[1]};
        tickets1 = Lab6.createTicket1(movies);
        tickets2 = Lab6.createTicket2(movies2);

        cgtBlitz = new Theater("CGT Blitz", 0, new ArrayList<>(Arrays.asList(tickets1)), movies);
        compFestXXI = new Theater("CompFest XXI", 25000, new ArrayList<>(Arrays.asList(tickets2)), movies2);

        dekDepe = new Customer("Dek Depe","Female",10);
        sisDea = new Customer("Sis Dea","Female",15);
        kakPewe = new Customer("Kak Pewe","Male",20);

        out = new ByteArrayOutputStream();
    }

    @Test
    @DisplayName("Test Print Info CGT Blitz")
    void testPrintCGTInfo() {
        System.setOut(new PrintStream(out));
        cgtBlitz.printInfo();
        String output = out.toString().trim();

        assertTrue(output.contains("Black Panther, Dilan 1990, The Greatest Showman, Si Juki The Movie") && output.contains("0")
        && output.contains("CGT Blitz") && output.endsWith("------------------------------------------------------------------"));
    }

    @Test
    @DisplayName("Test Print Info CompFestXXI")
    void testPrintCompFestInfo() {
        System.setOut(new PrintStream(out));
        compFestXXI.printInfo();
        String output = out.toString().trim();

        assertTrue(output.startsWith("------------------------------------------------------------------")&&
                output.contains("Black Panther, Dilan 1990") && output.contains("CompFest XXI") && output.contains("25000") &&
                output.endsWith("------------------------------------------------------------------"));
    }

    @Test
    @DisplayName("Test Dek Depe Order tickets")
    void testDekDepeOrderTicket() {
        System.setOut(new PrintStream(out));
        dekDepe.orderTicket(cgtBlitz, "Black Panther", "Monday", "3 Dimensions");
        String output = out.toString().trim();
        assertTrue(output.equals("Tickets for the movie Black Panther type 3 Dimensions on Monday are not available at CGT Blitz"));

        assertEquals(tickets1[7],
                dekDepe.orderTicket(cgtBlitz, "The Greatest Showman", "Friday", "3 Dimensions"));
    }

    @Test
    @DisplayName("Test Sis Dea Find Movie")
    void testFindMovie() {
        System.setOut(new PrintStream(out));
        sisDea.findMovie(compFestXXI, "Si Juki The Movie");
        String output = out.toString().trim();
        assertTrue(output.equals("Movie Si Juki The Movie searched by Sis Dea is not in the cinema CompFest XXI"));

        System.setOut(new PrintStream(out));
        sisDea.findMovie(compFestXXI, "Dilan 1990");
        output = out.toString().trim();
        assertTrue(output.contains("Dilan 1990") && output.contains("Romantic/Drama")
        && output.contains("Teenager") && output.contains("Film Local"));
    }

    @Test
    @DisplayName("Test Sis Dea Order tickets")
    void testSisDeaOrderTicket() {
        System.setOut(new PrintStream(out));
        sisDea.orderTicket(compFestXXI, "Dilan 1990", "Tuesday", "Ordinary");
        String output = out.toString().trim();
        assertTrue(output.equals("Tickets for the movie Dilan 1990 type Ordinary on Tuesday are not available at CompFest XXI"));

        assertEquals(tickets2[8],
                sisDea.orderTicket(compFestXXI, "Dilan 1990", "Sunday", "Ordinary"));

        System.setOut(new PrintStream(out));
        sisDea.orderTicket(cgtBlitz, "Si Juki The Movie", "Friday", "3 Dimensions");
        output = out.toString().trim();
        assertTrue(output.contains("Sis Dea is not old enough to watch Si Juki The Movie"));
    }

    @Test
    @DisplayName("Test Kak Pewe Order tickets")
    void testKakPeweOrderTicket() {
        System.setOut(new PrintStream(out));
        kakPewe.orderTicket(cgtBlitz,"Si Juki The Movie", "Thursday", "Ordinary");
        String output = out.toString().trim();
        assertTrue(output.equals("Kak Pewe has purchased Si Juki The Movie type Ordinary at CGT Blitz on Thursday for Rp. 60000"));

        assertEquals(tickets2[2],
                kakPewe.orderTicket(compFestXXI, "Black Panther", "Saturday", "3 Dimensions"));
    }

    @Test
    @DisplayName("Test Print Total Revenue Earned")
    void testPrintTotalRevenueEarned() {
        Theater[] theaters = {cgtBlitz, compFestXXI};
        System.setOut(new PrintStream(out));
        Theater.printTotalRevenueEarned(theaters);
        String output = out.toString().trim();
        assertTrue(output.contains("Koh Mas's total money: Rp.")
        && output.contains("CGT Blitz") && output.contains("CompFest XXI"));
    }
/*
    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case success")
    void testCancelTicket() {
        Ticket t = kakPewe.orderTicket(cgtBlitz,"Black Panther", "Saturday", "3 Dimensions");
        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(cgtBlitz);
        String output = out.toString().trim();
//        logger.info("sukses: " + output);
        assertTrue(output.equals("Tiket film Black Panther dengan waktu tayang Saturday jenis 3 Dimensions dikembalikan ke bioskop CGT Blitz"));
    }

    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case fail theater not found")
    void testCancelTicketTheaterNotFound() {
        Ticket t = kakPewe.orderTicket(cgtBlitz,"Si Juki The Movie", "Thursday", "Ordinary");
        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(compFestXXI);
        String output = out.toString().trim();
        assertTrue(output.equals("Maaf tiket tidak bisa dikembalikan, Si Juki The Movie tidak tersedia dalam CompFest XXI"));
    }

    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case fail ticket has been used")
    void testCancelTicketHasBeenUsed() {
        Ticket t = kakPewe.orderTicket(cgtBlitz,"Si Juki The Movie", "Thursday", "Ordinary");
        System.setOut(new PrintStream(out));
        kakPewe.watchMovie(t);
        String output = out.toString().trim();
        assertTrue(output.contains("Kak Pewe telah menonton film Si Juki The Movie"));

        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(cgtBlitz);
        output = out.toString().trim();
        logger.info("used: " + output);
        assertTrue(output.contains("Tiket tidak bisa dikembalikan karena film Si Juki The Movie sudah ditonton oleh Kak Pewe"));
    }

    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case fail theater gone bankrupt")
    void testCancelTicketBankrupt() {
        Ticket t = kakPewe.orderTicket(compFestXXI,"Black Panther", "Saturday", "3 Dimensions");
        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(cgtBlitz);
        String output = out.toString().trim();
        logger.info("bankrut: " + output);
        assertTrue(output.contains("Maaf ya tiket tidak bisa dibatalkan, uang kas di bioskop CGT Blitz lagi tekor..."));
    }
*/
}
