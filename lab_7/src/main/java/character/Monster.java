package character;

//  write Monster Class here
public class Monster extends Human{
    String roar;

    public Monster(int hp, String name, String roar){
        super(2*hp, name);
        this.roar = roar;
        this.type = "Monster";
    }

    public void eat(Player player){
        if (this.canEat(player)){
            this.setHp(this.getHp() + HEAL_AMOUNT);
            this.addDiet(player);
        }
    }

    public String roar(){
        return this.roar;
    }
}