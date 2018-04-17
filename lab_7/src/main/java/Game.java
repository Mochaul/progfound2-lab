import character.*;
import java.util.ArrayList;

public class Game{
    ArrayList<Player> player = new ArrayList<Player>();
    
    /**
     * Fungsi untuk mencari karakter
     * @param String name nama karakter yang ingin dicari
     * @return Player chara object karakter yang dicari, return null apabila tidak ditemukan
     */
    public Player find(String name){
        for (int i=0; i<player.size(); i++){
            if (player.get(i).getName().equals(name)){
                return player.get(i);
            }
        }
        return null;
    }

    /**
     * fungsi untuk menambahkan karakter ke dalam game
     * @param String chara nama karakter yang ingin ditambahkan
     * @param String tipe tipe dari karakter yang ingin ditambahkan terdiri dari monster, magician dan human
     * @param int hp hp dari karakter yang ingin ditambahkan
     * @return String result hasil keluaran dari penambahan karakter contoh "Sudah ada karakter bernama chara" atau "chara ditambah ke game"
     */
    public String add(String chara, String tipe, int hp){
        if (this.find(chara) == null){
            if (tipe.equals("Human")){
                this.player.add(new Human(hp, chara));
            }else if (tipe.equals("Magician")){
                this.player.add(new Magician(hp, chara));
            }else if (tipe.equals("Monster")){
                this.player.add(new Monster(hp, chara, "AAAAAAaaaAAAAAaaaAAAAAA"));
            }
            return chara + " ditambah ke game";
        }else if (this.find(chara) != null && !this.find(chara).isEaten());{
            this.remove(chara);
            if (tipe.equals("Human")){
                this.player.add(new Human(hp, chara));
            }else if (tipe.equals("Magician")){
                this.player.add(new Magician(hp, chara));
            }else if (tipe.equals("Monster")){
                this.player.add(new Monster(hp, chara, "AAAAAAaaaAAAAAaaaAAAAAA"));
            }
        }
        return "Sudah ada karakter " + chara;
        
    }

    /**
     * fungsi untuk menambahkan karakter dengan tambahan teriakan roar, roar hanya bisa dilakukan oleh monster
     * @param String chara nama karakter yang ingin ditambahkan
     * @param String tipe tipe dari karakter yang ingin ditambahkan terdiri dari monster, magician dan human
     * @param int hp hp dari karakter yang ingin ditambahkan
     * @param String roar teriakan dari karakter
     * @return String result hasil keluaran dari penambahan karakter contoh "Sudah ada karakter bernama chara" atau "chara ditambah ke game"
     */
    public String add(String chara, String tipe, int hp, String roar){
        if (tipe.equals("monster") && this.find(chara) == null){
            player.add(new Monster(hp, chara, roar));
            return chara + " ditambah ke game";
        }else if (this.find(chara) != null && !this.find(chara).isEaten());{
            this.remove(chara);
            player.add(new Monster(hp, chara, roar));
        }
        return "Sudah ada karakter bernama " + chara;
    }

    /**
     * fungsi untuk menghapus character dari game
     * @param String chara character yang ingin dihapus
     * @return String result hasil keluaran dari game
     */
    public String remove(String chara){
        for (int i=0; i<this.player.size(); i++){
            if (this.player.get(i).getName().equals(chara)){
                this.player.remove(i);
                return chara + " dihapus dari game";
            }
        }
        return "Tidak ada " + chara;
    }


    /**
     * fungsi untuk menampilkan status character dari game
     * @param String chara character yang ingin ditampilkan statusnya
     * @return String result hasil keluaran dari game
     */
    public String status(String chara){
       String result = "";
       Player player = this.find(chara);
       if (player != null){
            result += String.format("%s %s\n", player.getType(), player.getName());
            result += String.format("HP: %d\n", player.getHp());
            if (player.getAlive()) result += "Masih hidup\n";
            else result += "Sudah meninggal dunia dengan damai\n";
            if (player.getDiet().size() > 0) result += "Memakan " + this.diet(chara);
            else result += this.diet(chara);
       }else{
           result += chara + " tidak ditemukan";
       }
       return result;
    }

    /**
     * fungsi untuk menampilkan semua status dari character yang berada di dalam game
     * @return String result nama dari semua character, format sesuai dengan deskripsi soal atau contoh output
     */
    public String status(){
        String result = "";
        if (this.player.size() > 0){
            for (int i=0; i<this.player.size(); i++){
                result += this.status(this.player.get(i).getName());
            }
        }else{
            result += "Tidak ada pemain";
        }
        return result;        
    }

    /**
     * fungsi untuk menampilkan character-character yang dimakan oleh chara
     * @param String chara Player yang ingin ditampilkan seluruh history player yang dimakan
     * @return String result hasil dari karakter yang dimakan oleh chara
     */
    public String diet(String chara){
        String result = "";
        Player player = this.find(chara);
        int dietSize = player.getDiet().size();
        if (player != null){
             if (dietSize > 0){
                 result += player.getDiet().get(0).getType() + " " + player.getDiet().get(0).getName();
                 for (int i=1; i<dietSize; i++){
                     result += ", " + player.getDiet().get(i).getType() + " " + player.getDiet().get(i).getName();
                 }  
             }else{
                 result += "Belum memakan siapa siapa\n";
             } 
        }else{
            result += chara + "tidak ditemukan";
        }
        return result;    
    }

    /**
     * fungsi helper untuk memberikan list character yang dimakan dalam satu game
     * @return String result hasil dari karakter yang dimakan dalam 1 game
     */
    public String diet(){
        return "";
    }

    /**
     * fungsi untuk menampilkan hasil dari me vs enemyName
     * @param String meName nama dari character yang sedang dimainkan
     * @param String enemyName nama dari character yang akan di serang
     * @return String result kembalian dari me Vs enemy, format sesuai deskripsi soal
     */
    public String attack(String meName, String enemyName){
        Player me = this.find(meName);
        Player enemy = this.find(enemyName);
        if (me == null) return meName + " tidak ditemukan";
        if (enemy == null) return enemyName + " tidak ditemukan";
        me.attack(enemy);
        return "Nyawa " + enemyName + " " + enemy.getHp();
    }

     /**
     * fungsi untuk menampilkan hasil dari me vs enemyName. Method ini hanya boleh dilakukan oleh magician
     * @param String meName nama dari character yang sedang dimainkan
     * @param String enemyName nama dari character yang akan di bakar
     * @return String result kembalian dari me Vs enemy, format sesuai deskripsi soal
     */
    public String burn(String meName, String enemyName){
        Player me = this.find(meName);
        Player enemy = this.find(enemyName);
        if (me instanceof Magician) ((Magician)me).burn(enemy);
        if (enemy.getHp() > 0) return "Nyawa " + enemyName + " " + enemy.getHp();
        return "Nyawa " + enemyName + " " + enemy.getHp() + "\n dan matang";
    }

     /**
     * fungsi untuk menampilkan hasil dari me vs enemyName. enemy hanya bisa dimakan sesuai dengan deskripsi yang ada di soal
     * @param String meName nama dari character yang sedang dimainkan
     * @param String enemyName nama dari character yang akan di makan
     * @return String result kembalian dari me Vs enemy, format sesuai deskripsi soal
     */
    public String eat(String meName, String enemyName){
        Player me = this.find(meName);
        Player enemy = this.find(enemyName);
        if (me == null) return meName + " tidak ditemukan";
        if (enemy == null) return enemyName + " tidak ditemukan";
        
        if(me.canEat(enemy)){
            me.eat(enemy);
            this.remove(enemyName);
            return meName + " memakan " + enemyName + "\nNyawa " + me.getName() + " kini " + me.getHp();
        }else{
            return meName + " tidak bisa memakan " + enemyName;
        }
    }

     /**
     * fungsi untuk berteriak. Hanya dapat dilakukan oleh monster.
     * @param String meName nama dari character yang akan berteriak
     * @return String result kembalian dari teriakan monster, format sesuai deskripsi soal
     */
    public String roar(String meName){
        Player me = this.find(meName);
        if (me != null) return me.roar();
        else return "Tidak ada " + meName;
    }
}