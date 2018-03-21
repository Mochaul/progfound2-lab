package customer;
import ticket.Ticket;
import theater.Theater;
import movie.Movie;

public class Customer{
    String name;
    boolean gender; // true -> female
    int age;
    
    // constructor
    public Customer(String name, String gender, int age){
        this.name = name;
        if (gender.toLowerCase().equals("laki-laki")) this.gender = true;
        if (gender.toLowerCase().equals("perempuan")) this.gender = false;
        this.age = age;
    }

    // methods
    public Ticket orderTicket(Theater theater, String title, String day, String type){
        for(int i=0; i < theater.getTicket().size(); i++){
            Ticket ticket = theater.getTicket().get(i);
            if(ticket.getMovie().getTitle().equals(title)){
                // if there is matching day and type(3D or 2D) for this show
                if(ticket.getDay().equals(day) && ( (ticket.getType() == true && type.toLowerCase().equals("3 dimensi")) || (ticket.getType() == false && type.toLowerCase().equals("biasa"))) ){
                    // if customer does not meet age requirements for movie
                    if( (ticket.getMovie().getRating().toLowerCase().equals("remaja") && this.age < 13) || (ticket.getMovie().getRating().toLowerCase().equals("dewasa") && this.age < 17) ){
                        System.out.println(String.format("%s masih belum cukup umur untuk menonton %s dengan rating %s", this.name, title, ticket.getMovie().getRating()));
                        return null;
                    }else{
                        System.out.println(String.format("%s telah membeli tiket %s jenis %s di %s pada hari %s seharga Rp. %d", this.name, title, type, theater.getName(), day, ticket.getPrice()));
                        theater.setBalance(theater.getBalance() + ticket.getPrice());
                        return ticket;
                    }
                }
            }
        }
        System.out.println(String.format("Tiket untuk film %s jenis %s dengan jadwal %s tidak tersedia di %s",title, type, day, theater.getName()));
        return null;
    }

    public void findMovie(Theater theater, String title){
        for(int i=0; i < theater.getTicket().size(); i++){
            Ticket ticket = theater.getTicket().get(i);
            if(ticket.getMovie().getTitle().equals(title)){
                // if customer does not meet age requirements of movie
                if( (ticket.getMovie().getRating().toLowerCase().equals("remaja") && this.age < 13) || (ticket.getMovie().getRating().toLowerCase().equals("dewasa") && this.age < 17) ){
                    System.out.println(String.format("%s masih belum cukup umur untuk menonton %s dengan rating %s", this.name, title, ticket.getMovie().getRating()));
                }else{
                    System.out.println(ticket.getMovie()); 
                }
                return;
            }
        }
        System.out.println(String.format("Film %s yang dicari %s tidak ada di bioskop %s", title, this.name, theater.getName()));
    }
}