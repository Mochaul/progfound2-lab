package character;

//  write Magician Class here
public class Magician extends Player{
    public Magician(int hp, String name){
        super(hp, name);
        this.type = "Magician";
    }

    public void burn(Player player){
        if (player instanceof Magician) player.setHp(player.getHp() - 2*ATTACK_DMG);
        else player.setHp(player.getHp() - ATTACK_DMG);
        player.adjustHp();
        if (player.getHp() == 0) player.burnt = true;
    }
}