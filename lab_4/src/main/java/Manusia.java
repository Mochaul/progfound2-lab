public class Manusia {

    // CLASS PROPERTIES //
    private String nama;
    private int umur;
    private int uang = 50000;
    private double kebahagiaan = 50.0;
    private boolean hidup = true;
    private static Manusia lastInstance = null;

    // CONSTRUCTOR //
    public Manusia(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
        lastInstance = this;
    }
    public Manusia(String nama, int umur, int uang){
        this.nama = nama;
        this.umur = umur;
        this.uang = uang;
        lastInstance = this;
    }
    public Manusia(String nama, int umur, int uang, double kebahagiaan){
        this.nama = nama;
        this.umur = umur;
        this.uang = uang;
        this.kebahagiaan = kebahagiaan;
        this.adjustKebahagiaan(); // adjusts happiness if it is out of range, declaration at bottom
        lastInstance = this;
    }

    // GETTER //
    public String getNama(){
        return this.nama;
    }
    public int getUmur(){
        return this.umur;
    }
    public int getUang(){
        return this.uang;
    }
    public double getKebahagiaan(){
        return this.kebahagiaan;
    }
    public boolean getHidup(){
        return this.hidup;
    }
    public static Manusia getLastInstance(){
        return lastInstance;
    }

    // SETTER //
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setUmur(int umur){
        this.umur = umur;
    }
    public void setUang(int uang){
        this.uang = uang;
    }
    public void setKebahagiaan(double kebahagiaan){
        this.kebahagiaan = kebahagiaan;
    }
    public void setHidup(boolean hidup){
        this.hidup = hidup;
    }

    // METHODS //
    public void beriUang(Manusia man){
        /**
         * gives money to another instance of Manusia
         * amount going to be given is equal to the sum of ascii value of each char in receiver's name
         * if sufficient, both instance's happiness increase
         */
        if (this.getHidup() == false){
            System.out.println(this.getNama() + " telah tiada");
            return;
        }else if (man.getHidup() == false){
            System.out.println(man.getNama() + " telah tiada");
            return;
        }

        int amount = 0;
        for(int i = 0; i < man.getNama().length(); i++){
            amount += (int)man.getNama().charAt(i);
        }
        amount *= 100; // calculate amount given

        if (this.getUang() >= amount){
            // update sender and receiver cash if sufficient
            this.setUang(this.getUang() - amount);
            man.setUang(man.getUang() + amount);

            // update sender and receiver happiness and adjusts it if out of range
            this.setKebahagiaan(this.getKebahagiaan() + amount/6000.0);
            this.adjustKebahagiaan();
            man.setKebahagiaan(man.getKebahagiaan() + amount/6000.0);
            man.adjustKebahagiaan();

            System.out.println(this.getNama() + " memberi uang sebanyak " + amount + " kepada " + man.getNama() + ", mereka berdua senang :D");
        }else{
            System.out.println(this.getNama() + " ingin memberi uang kepada " + man.getNama() + " namun tidak memiliki cukup uang :'(");
        }

    }
    public void beriUang(Manusia man, int amount){
        /**
         * gives money to another instance of Manusia
         * amount going to be given as an argument
         * if sufficient, both instance's happiness increase
         */
        if (this.getHidup() == false){
            System.out.println(this.getNama() + " telah tiada");
            return;
        }else if (man.getHidup() == false){
            System.out.println(man.getNama() + " telah tiada");
            return;
        }

        if (this.getUang() >= amount){
            // update sender and receiver cash if sufficient
            this.setUang(this.getUang() - amount);
            man.setUang(man.getUang() + amount);

            // update sender and receiver happiness and adjusts it if out of range
            this.setKebahagiaan(this.getKebahagiaan() + amount/6000.0);
            this.adjustKebahagiaan();
            man.setKebahagiaan(man.getKebahagiaan() + amount/6000.0);
            man.adjustKebahagiaan();

            System.out.println(this.getNama() + " memberi uang sebanyak " + amount + " kepada " + man.getNama() + ", mereka berdua senang :D");
        }else{
            System.out.println(this.getNama() + " ingin memberi uang kepada " + man.getNama() + " namun tidak memiliki cukup uang :'(");
        }
    }
    public void bekerja(int durasi, int bebanKerja){
        /**
         * increases cash and decreases happiness by working
         */
        if (this.getHidup() == false){
            System.out.println(this.getNama() + " telah tiada");
            return;
        }

        if (this.getUmur() < 18 ){ // cannot work if age is less than 18
            System.out.println(this.getNama() + " belum boleh bekerja karena masih dibawah umur D:");
            return;
        }

        int bebanKerjaTotal = durasi * bebanKerja;
        int pendapatan;

        // decrease and adjust happiness if sufficient for work
        if (bebanKerjaTotal <= this.getKebahagiaan()){
            this.setKebahagiaan(this.getKebahagiaan() - bebanKerjaTotal); 
            this.adjustKebahagiaan();
            pendapatan = bebanKerjaTotal * 10000;
            System.out.println(this.getNama() + " bekerja full time, total pendapatan : " + pendapatan);
        }
        // if happiness insufficient, duration of work is recalculated
        else{
            int DurasiBaru = (int)(this.getKebahagiaan() / bebanKerja); 
            bebanKerjaTotal = DurasiBaru * bebanKerja;
            pendapatan = bebanKerjaTotal * 10000;
            this.setKebahagiaan(this.getKebahagiaan() - bebanKerjaTotal);
            this.adjustKebahagiaan();
            System.out.println(this.getNama() + " tidak bekerja secara full time karena sudah terlalu lelah, total pendapatan : " + pendapatan);
        }
        // update cash after working
        this.setUang(this.getUang() + pendapatan); 
    }
    public void rekreasi(String namaTempat){
        /**
         * increases happiness but reduces cash by going to recreation place
         */
        if (this.getHidup() == false){
            System.out.println(this.getNama() + " telah tiada");
            return;
        }

        int biaya = namaTempat.length() * 10000;

        if (this.getUang() >= biaya){
            this.setKebahagiaan(this.getKebahagiaan() + namaTempat.length());
            this.adjustKebahagiaan();
            this.setUang(this.getUang() - biaya);
            System.out.println(this.getNama() + " berekreasi di " + namaTempat + ", " + this.getNama() + " senang :)");
        }else{
            System.out.println(this.getNama() + " tidak mempunyai cukup uang untuk berekreasi di " + namaTempat + " :(");
        }
    }
    public void sakit(String namaPenyakit){
        /**
         * decreases happiness because of sickness
         */
        if (this.getHidup() == false){
            System.out.println(this.getNama() + " telah tiada");
            return;
        }

        this.setKebahagiaan(this.getKebahagiaan() - namaPenyakit.length());
        this.adjustKebahagiaan();
        System.out.println(this.getNama() + " terkena penyakit " + namaPenyakit + " :O");
    }
    public String toString(){
        /**
         * returns info of instance in the following format,
         * Nama(tab)(tab): [NAMA]
         * Umur(tab)(tab): [UMUR]
         * Uang(tab)(tab): [UANG]
         * Kebahagiaan(tab): [KEBAHAGIAAN]
         */
        return "Nama\t\t: " + this.getNama() + "\n" +
               "Umur\t\t: " + this.getUmur() + "\n" + 
               "Uang\t\t: " + this.getUang() + "\n" +
               "Kebahagiaan\t: " + this.getKebahagiaan();

    }
    public void meninggal(){
        /**
         * an instance dies, unable to perform any methods except toString()
         * the instance's money is set to 0, and given to the last instance of Manusia if alive
         */
        if (getHidup() == true){
            // update instance properties
            this.setNama("Almarhum " + this.getNama());
            this.setHidup(false);
            System.out.println(this.getNama() + " meninggal dengan tenang, kebahagiaan : " + this.getKebahagiaan());
            
            // if last instance alive
            if (Manusia.getLastInstance().getHidup() == true){
                // give all cash to last instance of Manusia
                Manusia.getLastInstance().setUang(Manusia.getLastInstance().getUang() + this.getUang());
                this.setUang(0);
                System.out.println("Semua harta " + this.getNama() + " disumbangkan untuk " + Manusia.getLastInstance().getNama());
            }
            // if last instance already die
            else if (Manusia.getLastInstance() == this || Manusia.getLastInstance().getHidup() == false){
                this.setUang(0);
                System.out.println("Semua harta " + this.getNama() + " hangus");
            }
        }else{
            System.out.println(this.getNama() + " sudah meninggal");
        }
    }

    // HELPER FUNCTION //
    private void adjustKebahagiaan(){
        /**
         * adjust kebahagiaan to 100.0 (max) or 0.0 (min)
         * if it is out of the range 0.0 < x < 100.0
         */
        if(this.getKebahagiaan() > 100.0){
            this.setKebahagiaan(100.0);
        }else if (this.getKebahagiaan() < 0.0){
            this.setKebahagiaan(0.0);
        }
    }
}   