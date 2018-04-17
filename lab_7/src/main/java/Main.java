import character.*;

public class Main{
    public static void main(String[] args) {
        Human a = new Human(100, "player1");
        Human b = new Human(0, "player2");
        System.out.println(a instanceof Player);
        a.attack(b);
        System.out.println(a.getHp());
    }
}