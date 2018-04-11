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
        return "";
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
        return "";
    }

    /**
     * fungsi untuk menghapus character dari game
     * @param String chara character yang ingin dihapus
     * @return String result hasil keluaran dari game
     */
    public String remove(String chara){
        return "";
    }


    /**
     * fungsi untuk menampilkan status character dari game
     * @param String chara character yang ingin ditampilkan statusnya
     * @return String result hasil keluaran dari game
     */
    public String status(String chara){
       return "";
    }

    /**
     * fungsi untuk menampilkan semua status dari character yang berada di dalam game
     * @return String result nama dari semua character, format sesuai dengan deskripsi soal atau contoh output
     */
    public String status(){
        return "";        
    }

    /**
     * fungsi untuk menampilkan character-character yang dimakan oleh chara
     * @param String chara Player yang ingin ditampilkan seluruh history player yang dimakan
     * @return String result hasil dari karakter yang dimakan oleh chara
     */
    public String diet(String chara){
        return "";
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
        return "";
    }

     /**
     * fungsi untuk menampilkan hasil dari me vs enemyName. Method ini hanya boleh dilakukan oleh magician
     * @param String meName nama dari character yang sedang dimainkan
     * @param String enemyName nama dari character yang akan di bakar
     * @return String result kembalian dari me Vs enemy, format sesuai deskripsi soal
     */
    public String burn(String meName, String enemyName){
        return "";
    }

     /**
     * fungsi untuk menampilkan hasil dari me vs enemyName. enemy hanya bisa dimakan sesuai dengan deskripsi yang ada di soal
     * @param String meName nama dari character yang sedang dimainkan
     * @param String enemyName nama dari character yang akan di makan
     * @return String result kembalian dari me Vs enemy, format sesuai deskripsi soal
     */
    public String eat(String meName, String enemyName){
        return "";
    }

     /**
     * fungsi untuk berteriak. Hanya dapat dilakukan oleh monster.
     * @param String meName nama dari character yang akan berteriak
     * @return String result kembalian dari teriakan monster, format sesuai deskripsi soal
     */
    public String roar(String meName){
        return "";
    }
}