package character;

//  write Human Class here
public class Human extends Player{
    public Human(int hp, String name){
        super(hp, name);
        this.type = "Human";
    }
}