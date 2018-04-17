package character;
import java.util.ArrayList;

//  write Player Class here
public class Player{
    final int ATTACK_DMG = 10;
    final int HEAL_AMOUNT = 15;

    int hp;
    String name;
    ArrayList<Player> diet;
    boolean alive;
    boolean burnt;
    String type;
    boolean eaten;

    public Player(int hp, String name){
        this.hp = hp;
        this.name = name;
        this.diet = new ArrayList<>();
        this.alive = true;
        this.burnt = false;
        this.eaten = false;
        this.adjustHp();
    }

    // GETTER SETTER
    public int getHp(){
        return this.hp;
    }
    public String getName(){
        return this.name;
    }
    public boolean getAlive(){
        return this.alive;
    }
    public boolean getBurnt(){
        return this.burnt;
    }
    public ArrayList<Player> getDiet(){
        return this.diet;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public void setBurnt(boolean burnt){
        this.burnt = burnt;
    }
    public void addDiet(Player player){
        this.diet.add(player);
    }
    public String getType(){
        return this.type;
    }
    public boolean isEaten(){
        return this.eaten;
    }
    // METHODS
    public void adjustHp(){
        if (this.getHp() < 0) this.setHp(0);
        if (this.getHp() == 0) this.setAlive(false);
    }
    public boolean canEat(Player player){
        if (this instanceof Monster && !player.getAlive()){
            return true;
        }
        else if (!player.getAlive() && player.getBurnt() && player instanceof Monster){
            return true;
        }
        return false;
    }
    public void attack(Player player){
        if (player instanceof Magician) player.setHp(player.getHp() - 2*ATTACK_DMG);
        else player.setHp(player.getHp() - ATTACK_DMG);
        player.adjustHp();
    }
    public void eat(Player player){
        if (this.canEat(player)){
            this.setHp(this.getHp() + HEAL_AMOUNT);
            player.eaten = true;
            this.addDiet(player);
        }
    }
    public String roar(){
        return this.getName() + " tidak bisa berteriak";
    }

}
