# **Tutorial 4: Intro to OOP (Soal Tutorial)**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2017/2018

**Dibuat oleh KK | MF**

* * *
Pada tutorial sebelumnya, Anda telah mempelajari mengenai konsep rakursif di Java. Anda juga telah menyinggung sedikit materi mengenai method (return pada bagian branching statement). Kali ini, Anda akan mempelajari lebih mengenai method, keyword *static*,
overloading dan mendesain kelas (intro to OOP).

## **Tujuan Pembelajaran**
1. Memahami konsep **static** keyword.
2. Memahami konsep **overloading**.
3. Memahami konsep **encapsulation**.
3. Memahami cara mendesain **kelas** dalam Java.

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder `lab_4/src/main/java`. Kami sudah menyediakan folder kosong untuk kamu.
3. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.

## **Materi Tutorial**

### **Static keyword in Java**
**Static** keyword di dalam java adalah keyword yang menyatakan bahwa properti (atribut atau method) suatu kelas dimiliki oleh kelas tersebut, bukan objek (instansiasi sebuah kelas) dari kelas tersebut. Pengaksesan properti **static** harus melalui kelasnya secara langsung, namun bisa juga melalui objek dari kelas tersebut (tidak *best practice*).
### Contoh penggunaan keyword **static**
```java
public class Frame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public String type;

    public Frame(String type) {
        this.type = type;
    }

    public static int area(){
        return HEIGHT * WIDTH;
    }
}
```
### Perintah untuk mengakses atribut/method static
```java
int frameWidth = Frame.WIDTH;
int frameHeight = Frame.HEIGHT;
int frameArea = Frame.area();
System.out.println(frameArea); // Mencetak bilangan 250000

// Untuk mengakses type, perlu diinstansiasi terlebih dahulu objek Frame!
Frame bingkai = new Frame("Bingkai Foto");
String tipeBingkai = bingkai.type;
System.out.println(tipeBingkai); // Mencetak string "Bingkai Foto"
System.out.println(bingkai.WIDTH); // Mencetak bilangan 500, namun tidak best practice :)
```

### **Overloading**
Pada tutorial kali ini, Anda akan belajar suatu konsep yang disebut *overloading*. *Overloading* di dalam Java terdiri atas *method overloading* dan *constructor overloading*. *Method overloading* adalah sebuah konsep/fitur yang memungkinkan untuk membuat method dengan nama yang sama, namun memiliki parameter masukan yang berbeda, baik tipe parameter maupun jumlah parameter. *Constructor overloading* memiliki konsep yang sama dengan *method overloading*, namun yang di-overload adalah constructor dari kelas. Salah satu overloading method yang sering kalian gunakan adalah method println().
### Contoh overloading method
```java
public void spawn() {
    System.out.println("Unknown object successfully spawned");    
}

public String spawn(String name) {
    return name + " successfully spawned";
}

public String spawn(String name, int amount) {
    return amount + " objects of " + name + " successfully spawned";
}
```

### **Encapsulation**
*Encapsulation* merupakan proses menutup/membungkus untuk membatasi akses langsung ke beberapa properti objek (atribut/method). Di Java, kita dapat melakukan *encapsulation* dengan cara memberikan *access modifier* kepada properti objek. Terdapat 4 macam access specifier di Java, yaitu :

| **Access modifier** | **Class** | **Package**  | **Subclass** | **Global** |
| --- | :---: | :---: | :---: | :---: |
| private | ✅ | ❎ | ❎ | ❎ |
| default | ✅ | ✅ | ❎ | ❎ |      
| protected | ✅ | ✅ | ✅ | ❎ |  
| public | ✅ | ✅ | ✅ | ✅ |
✅ : Bisa diakses

❎ : Tidak bisa diakses

Jika kita tidak melakukan *encapsulation* dengan baik, bisa saja terjadi hal-hal yang tidak diinginkan, seperti :
```java
// Inisiasi objek Frame
Frame bingkai = new Frame("Foto");

// bingkai langsung berubah jadi undangan
bingkai.type = "Undangan";
```
Supaya *behavior* kelas yang kita kembangkan dapat sesuai dengan harapan, dan supaya pengguna kelas tersebut dapat menggunakannya dengan lebih mudah, adalah alasan mengapa *encapsulation* penting untuk dilakukan. (contoh kasus diatas terjadi **JIKA** *access modifier* atribut **type** dari kelas Frame adalah **public**, jadi solusinya adalah ubah *access modifier* atribut tersebut menjadi **private**). Selain itu, *encapsulation* bertujuan untuk menyembunyikan kerumitan dari suatu kelas. Misal, kalian menggunakan kelas Math di Java, kemudian kalian menggunakan method log() untuk menghitung logaritma, kalian tidak perlu mengetahui apa yang dilakukan didalam method log().

Terus gimana dong cara mengakses variable yang *access modifier*-nya **private**? Jawabannya adalah, menggunakan **setter dan getter**, contohnya gini :
```java
public void setType(String type) {
    this.type = type;    
}

public String getType() {
    return type;
}
```

### **Class Design**
Dalam Object Oriented Programming, struktur kelas yang digunakan biasanya seperti ini:
```java
package Demo;       // Kelas Demo berada dalam package Demo

public class Demo   // Nama kelas
{
    /* Atribut dari kelas */
    private String var1;                    // Instance variable, menggunakan access modifier private
    private int var2;                       // Juga instance variable

    /* Konstruktor kelas Demo, sama seperti __init__() di Python */
    public Demo(String var1, int var2) {
        this.var1 = var1;                   // Keyword 'this', menunjuk kepada atribut/method suatu object di kelas ini (kelas Demo)
        this.var2 = var2;
    }

    /* Setters & Getters */
    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public String getVar2() {
        return var2;
    }

    /* Method lain yang ingin diimplementasikan */
    public void method1(String args1) {
        System.out.println(var1 + " " + args1);
    }

    public int method2(int args2) {
        return var2 + args2;
    }
}
```

### **Let's do this!?**

Sebelum kita masuk ke soal tutorial, kita akan warm-up terlebih dahulu. Untuk menguji pemahaman Object Oriented Programming kalian, coba jawab pertanyaan berikut :

Misal kita punya class:
```java
class Motor {
   String nama;
   String merk;

   Motor(String nama, String merk) {
       this.nama = nama;
       this.merk = merk;
   }
}
```
Coba tebak output program di main method berikut :

**Soal 1**
```java
Motor a = new Motor("bleki", "Yamahmud");
Motor b = new Motor("bleki", "Yamahmud");
System.out.println(a == b);
```
**Soal 2**
```java
Motor a = new Motor("bleki", "Yamahmud");
Motor b = a;
b.nama = "hajigur";
System.out.println(a.nama);
```
**Soal 3**
```java
Motor a = new Motor("bleki", "Yamahmud");
Motor b = a;
b = new Motor("hajigur", "Yamahmud");
System.out.println(a.nama);
```


## **Soal Tutorial : "PEPERAS (PeEl’s Personal Assistant)"**

![alt text](https://www.movies4kids.co.uk/wp-content/uploads/2014/12/Big_Hero_6_Baymax.jpg "Gambar Rabbit House")

**WARNING** Untuk soal tutorial ini, dilarang untuk mengubah kode yang ada di dalam file **PersonalAssistant.java**!

------

### **What's the story?**

Setelah asik berkunjung ke Rabbit House, Pak PeEl, paman dari Kak Pewe bercerita bahwa ia sedang mengembangkan sebuah Personal Assistant yang ia beri nama PeEl’s Personal Assistant (PEPERAS) di Kabupaten Parbel. PEPERAS ini bertujuan untuk mempermudah dalam mengelola keuangan dan kebahagiaan seseorang.

Pak PeEl diberi tahu (bukan tempe) Kak Pewe bahwa Dek Depe mempunyai teman yang sangat mahir membuat program Java (yaitu kamu, iya kamu). Oleh karena itu Pak PeEl meminta bantuan kamu untuk mendesain sebuah kelas disebuah file Java yang dapat digunakan sebagai struktur program agar PEPERAS tersebut dapat berjalan dengan baik. Pak PeEl akan mengurus input dari user yang merupakan file bernama **PersonalAssistant.java** sehingga kamu dilarang untuk mengubah file ini sedikitpun. Tugas kamu adalah membuat file terpisah dengan nama **Manusia.java** dan mengimplementasikan sebuah class Manusia sehingga dapat menjalankan perintah-perintah yang terdapat pada file **PersonalAssistant.java**.

### **Spesifikasi Class**

Nama file kamu **wajib** Manusia.java

### Setiap Manusia mempunyai :
- [ ] nama
- [ ] umur
- [ ] uang (sebuah bilangan bulat)
- [ ] kebahagiaan (sebuah bilangan riil)

>Catatan : 
- Kamu boleh menambahkan atribut baru jika dibutuhkan
- Nilai MINIMUM kebahagiaan adalah 0.0 dan MAKSIMUM-nya adalah 100.0
- Jika dalam sebuah perhitugan nilai kebahagiaan melebihi 100, maka set nilai kebahagiaan menjadi 100
- Jika dalam sebuah perhitugan nilai kebahagiaan kurang dari 0, maka set nilai kebahagiaan menjadi 0
- Jumlah uang awal apabila tidak dispesifikasikan adalah 50000
- Jumlah kebahagiaan awal setiap manusia adalah 50
- Bisa jadi nama seseorang terdiri dari 1 kata lebih
- Karena terdapat spesifikasi yang berbeda, anda diminta untuk melakukan **Constructor Overloading**, silahkan disesuaikan dengan yang ada didalam file **PersonalAssistant.java**
- Jangan lupa untuk mengimplementasikan **Setters & Getters**

### Setiap Manusia dapat melakukan beberapa *behaviour* yaitu :

:boom: **beriUang(penerima)**
>
- Method untuk memberikan uang kepada **[penerima]**
- Banyak uang yang akan diberikan dapat dihitung menggunakan rumus berikut :

>>
```
Jumlah dari setiap nilai ASCII tiap karakter dari nama penerima dikali 100. Contoh:
penerima = "ABC"
Total nilai ASCII = 65 + 66 + 67 = 198
jumlah uang = 198 * 100 = 19800
```

>
- Jika uang yang dimiliki pemberi tersebut cukup, maka kebahagiaan mereka berdua (pemberi dan penerima) bertambah.

>>
Rumus perhitungan kebahagiaan baru:
```
kebahagiaanBaru = kebahagiaanSekarang + [JUMLAH_UANG]/6000
Perlu diingat nilai kebahagiaan adalah bilangan riil dan nilainya tidak boleh melebihi batas maksimum
```

>>
Kemudian cetak:
```
[NAMA_PEMBERI] memberi uang sebanyak [JUMLAH_UANG] kepada [NAMA_PENERIMA], mereka berdua senang :D
```

>
- Jika uang yang dimiliki pemberi tidak cukup, maka cetak :

>>
```
[NAMA_PEMBERI] ingin memberi uang kepada [NAMA_PENERIMA] namun tidak memiliki cukup uang :'(
```

:boom: **beriUang(penerima, jumlah)**
>
- Method untuk memberikan uang sebanyak **[jumlah]** kepada **[penerima]**
- Jika uang yang dimiliki pemberi tersebut cukup, maka kebahagiaan mereka berdua (pemberi dan penerima) akan bertambah
 
>>
Rumus Perhitungan Kebahagiaan Baru :
```
kebahagiaanBaru = kebahagiaanLama + [JUMLAH_UANG]/6000
Perlu diingat nilai kebahagiaan tidak boleh melebihi nilai maksimumnya
```

>>
Kemudian cetak :
```
"[NAMA_PEMBERI] memberi uang sebanyak [JUMLAH] kepada [NAMA_PENERIMA], mereka berdua senang :D"
```

>
- Jika uang yang dimiliki pemberi tidak cukup, maka cetak :
 
>>
```
"[NAMA_PEMBERI] ingin memberi uang kepada [NAMA_PENERIMA] namun tidak memiliki cukup uang :'("
```

:boom: **bekerja(durasi, bebanKerja)**
>
- Method untuk bekerja, mendapatkan uang namun kehilangan kebahagiaan
- Jika umur manusia tersebut masih dibawah usia kerja minimum (anggap usia kerja minimum di Kabupaten Parbel adalah 18), cetak :

>>
```
"[NAMA] belum boleh bekerja karena masih dibawah umur D:"
```

>
- Beban kerja total dan kebahagiaan saling terkait, didapatkan dengan cara:

>>
```
BebanKerjaTotal = durasi * bebanKerja
```
```
Apabila (BebanKerjaTotal <= Kebahagiaan), maka:
Kebahagiaan = Kebahagiaan - BebanKerjaTotal
Pendapatan = BebanKerjaTotal * 10000
```

>
- Lalu cetak:

>>
```
"[NAMA] bekerja full time, total pendapatan : [PENDAPATAN]"
```

>
- Kasus kedua:

>>
```
Apabila (BebanKerjaTotal > Kebahagiaan), maka manusia tersebut tidak dapat bekerja full time, sehingga dikalkulasi kembali durasi bekerja
DurasiBaru = Kebahagiaan/bebanKerja (DurasiBaru dalam integer)
BebanKerjaTotal = DurasiBaru * bebanKerja
Pendapatan = BebanKerjaTotal * 10000
Karena (BebanKerjaTotal > Kebahagiaan), kemudian (Kebahagiaan - BebanKerjaTotal < 0), maka Kebahagiaan di-set menjadi nilai MINIMUM
```

>
- Lalu cetak:

>>
```
"[NAMA] tidak bekerja secara full time karena sudah terlalu lelah, total pendapatan : [PENDAPATAN]"
```

>
- Setelah itu:

>>
```
Jumlah uang ditambahkan dengan Pendapatan
```


:boom: **rekreasi(namaTempat)**
>
- Method untuk berekreasi, mendapatkan kebahagiaan dengan mengorbankan uang
- Biaya rekreasi/uang yang harus dikeluarkan untuk berekreasi di tempat **[namaTempat]** adalah :

>>
```
Biaya = Panjang String [NAMA_TEMPAT] dikali 10000
```

>
- Jika uang yang dimiliki manusia tersebut lebih dari biaya rekreasi, kurangi uang Manusia tersebut sebanyak Biaya yang dibutuhkan dan tambahkan kebahagiaan Manusia tersebut sebanyak : 

>>
```
KebahagiaanBaru = kebahagiaanLama + Panjang String [NAMA_TEMPAT]
```

>>
Kemudian cetak :
```
"[NAMA] berekreasi di [NAMA_TEMPAT], [NAMA] senang :)"
```

>
- Jika uang yang dimiliki manusia tersebut tidak cukup, cetak :

>>
```
"[NAMA] tidak mempunyai cukup uang untuk berekreasi di [NAMA_TEMPAT] :("
```

:boom: **sakit(namaPenyakit)**
>
- Method yang dipanggil jika seorang Manusia sakit, kehilangan kebahagiaan
- Rumus perhitungan kebahagiaan baru : 

>>
```
kebahagiaanBaru = kebahagiaanLama - panjang String [NAMA_PENYAKIT]
Perlu diingat nilai kebahagiaan tidak boleh kurang dari nilai minimumnya
```

>
- Kemudian cetak

>>
```
"[NAMA] terkena penyakit [NAMA_PENYAKIT] :O"
```

:boom: **toString()**
>
- Method yang dipanggil untuk mendapatkan representasi String dari sebuah Objek
- Saat System.out.println(*suatuObjek*) dieksekusi, maka representasi String dari *suatuObjek* diminta, sehingga *suatuObjek*.toString() dieksekusi.
- Method ini harus mereturn sebuah String, yang berisi :

>>
```
Nama(tab)(tab): [NAMA]
Umur(tab)(tab): [UMUR]
Uang(tab)(tab): [UANG]
Kebahagiaan(tab): [KEBAHAGIAAN]
```

>>
```
Gunakan \t untuk tabulasi
```

### **Contoh output yang diharapkan ketika file PersonalAssistant.java dijalankan :**

<pre>Nama		: Yumna
Umur		: 20
Uang		: 500000
Kebahagiaan	: 50.0
Nama		: Me Cin
Umur		: 11
Uang		: 50000
Kebahagiaan	: 50.0
Me Cin terkena penyakit Candu Internet :O
Yumna bekerja full time, total pendapatan : 160000
Yumna berekreasi di Ancol, Yumna senang :)
Yumna terkena penyakit Hati :O
Yumna memberi uang sebanyak 49200 kepada Me Cin, mereka berdua senang :D
Nama		: Yumna
Umur		: 20
Uang		: 560800
Kebahagiaan	: 43.2
Yumna tidak bekerja secara full time karena sudah terlalu lelah, total pendapatan : 420000
Nama		: Yumna
Umur		: 20
Uang		: 980800
Kebahagiaan	: 1.2000008
Yumna terkena penyakit Migrain :O
Nama		: Yumna
Umur		: 20
Uang		: 980800
Kebahagiaan	: 0.0
Yumna memberi uang sebanyak 900000 kepada Me Cin, mereka berdua senang :D
Nama		: Yumna
Umur		: 20
Uang		: 80800
Kebahagiaan	: 100.0
Yumna tidak mempunyai cukup uang untuk berekreasi di San Diego Hills :(
Yumna ingin memberi uang kepada Me Cin namun tidak memiliki cukup uang :'(
----------------------------------------------------------
Me Cin belum boleh bekerja karena masih dibawah umur D:
Me Cin berekreasi di KRL, Me Cin senang :)
Me Cin memberi uang sebanyak 5000 kepada Yumna, mereka berdua senang :D
Me Cin terkena penyakit Pelit :O
Me Cin memberi uang sebanyak 52200 kepada Yumna, mereka berdua senang :D
Nama		: Me Cin
Umur		: 11
Uang		: 912000
Kebahagiaan	: 100.0
</pre>



## **Soal Bonus: "Setiap yang hidup akan merasakan mati"**
### **The Story?**
The story is, there's no story.

implementasikan fitur tambahan berupa *behaviour* yang mempunyai spesifikasi berikut :

:boom: **meninggal()**
>
- Method yang dipanggil jika seorang Manusia meninggal
- Cetak :

>>
```
"[NAMA] meninggal dengan tenang, kebahagiaan : [KEBAHAGIAAN_TERAKHIR]"
```

>
- Kemudian semua sisa uang manusia tersebut disumbangkan ke "Manusia Terakhir" (yang disebut "Manusia Terakhir" adalah Object Manusia yang diinstansiasi terakhir kali). Contoh :

>>
```java
//Ceritanya ini main method
Manusia manusia_1 = new ("Aku Ganteng", 23);
Manusia manusia_2 = new ("Kata siapa?", 15);
Manusia manusia_3 = new ("Kata Mama", 18);
Manusia manusia_4 = new ("Hehe", 20);
manusia_2.meninggal();
```

>>
```
Maka semua uang manusia_2 akan disumbangkan ke manusia_4 yang merupakan "Manusia Terakhir" karena diinstansiasi paling terakhir
```

>
- Karena penyumbangan uang tersebut terjadi karena meninggalnya seorang Manusia, maka kebahagiaan [PEMBERI_UANG] dan [PENERIMA_UANG] tidak berubah
- Kemudian cetak lagi :

>>
```
"Semua harta [NAMA_ALMARHUM] disumbangkan untuk [NAMA_MANUSIA_TERAKHIR]"
```

>
- Setelah seorang Manusia meninggal, ia tidak dapat melakukan *behaviour* apapun lagi (kecuali toString()) dan juga tidak bisa diberi uang lagi, sehingga jika seorang Manusia yang telah meninggal menjalankan sebuah *behaviour* atau diberi uang, cetak :

>>
```
"[NAMA_YANG_MENINGGAL] telah tiada"
```

>>
```
Catatan Khusus : Apabila method beriUang dijalankan dan pemberi uang maupun penerima uang telah meninggal, maka outputnya sekreatif kalian, yang penting tidak boleh ada perubahan uang maupun kebahagiaan
```

>
- Modifikasi method toString() sehingga menambahkan gelar "Almarhum" di depan nama asli jika Manusia tersebut telah meninggal
- KASUS KHUSUS : Jika Manusia yang meninggal adalah "Manusia Terakhir", maka uang tersebut akan hangus dan mencetak :

>>
```
"Semua harta [NAMA] hangus"
```


### Contoh Main Method dan Output Soal Bonus

Contoh Main Method 1 :
```java
Manusia manusia_1 = new Manusia("Calon Ahli Kubur", 20);
Manusia manusia_2 = new Manusia("Tobat Sebelum Terlambat", 40, 200000);
Manusia manusia_3 = new Manusia("Calon Suami Idaman", 23);
Manusia manusia_4 = new Manusia("Fakir Miskin", 25, 10000);
manusia_2.beriUang(manusia_1, 100000);
manusia_1.beriUang(manusia_4, 2000);
manusia_1.sakit("Kikir");
manusia_1.beriUang(manusia_4, 80000);
manusia_1.meninggal();
System.out.println(manusia_1);
System.out.println(manusia_4);
manusia_1.sakit("Sakitan");
manusia_1.rekreasi("Kuburan sebelah");
manusia_1.bekerja(24, 10);
manusia_1.beriUang(manusia_4);
manusia_1.meninggal();
manusia_3.beriUang(manusia_1);
System.out.println(manusia_1);
System.out.println(manusia_4);
```

Contoh Output 1 :
<pre>
Tobat Sebelum Terlambat memberi uang sebanyak 100000 kepada Calon Ahli Kubur, mereka berdua senang :D
Calon Ahli Kubur memberi uang sebanyak 2000 kepada Fakir Miskin, mereka berdua senang :D
Calon Ahli Kubur terkena penyakit Kikir :O
Calon Ahli Kubur memberi uang sebanyak 80000 kepada Fakir Miskin, mereka berdua senang :D
Calon Ahli Kubur meninggal dengan tenang, kebahagiaan : 75.333336
Semua harta Calon Ahli Kubur disumbangkan untuk Fakir Miskin
Nama		: Almarhum Calon Ahli Kubur
Umur		: 20
Uang		: 0
Kebahagiaan	: 75.333336
Nama		: Fakir Miskin
Umur		: 25
Uang		: 160000
Kebahagiaan	: 63.666664
Calon Ahli Kubur telah tiada
Calon Ahli Kubur telah tiada
Calon Ahli Kubur telah tiada
Calon Ahli Kubur telah tiada
Calon Ahli Kubur telah tiada
Calon Ahli Kubur telah tiada
Nama		: Almarhum Calon Ahli Kubur
Umur		: 20
Uang		: 0
Kebahagiaan	: 75.333336
Nama		: Fakir Miskin
Umur		: 25
Uang		: 160000
Kebahagiaan	: 63.666664
</pre>


Contoh Main Method 2 :
```java
Manusia manusia_1 = new Manusia("Selamet bin Aman", 32);
manusia_1.meninggal();
System.out.println(manusia_1);
```

Contoh Output 2 :
<pre>
Selamet bin Aman meninggal dengan tenang, kebahagiaan : 50.0
Semua harta Selamet bin Aman hangus
Nama		: Almarhum Selamet bin Aman
Umur		: 32
Uang		: 0
Kebahagiaan	: 50.0
</pre>
****

>
```
Catatan :
Kamu boleh mengimplementasikan output sekreatif kalian, namun pastikan tidak ada informasi yang berkurang dari contoh
```


## Checklist
Isi kurung siku komponen dengan x untuk menceklis komponen.
### Komponen Wajib | 100 Poin
- [ ] **Membuat kelas Manusia sesuai spesifikasi**
- [ ] **Melakukan handling ketika nilai kebahagiaan diluar batas**
- [ ] **Menerapkan method overloading untuk beriUang dan constructor overloading pada kelas Manusia**
- [ ] **Menerapkan access modifier (encapsulation) yang sesuai pada kelas Manusia**
- [ ] **Menerapkan konsep static keyword yang sesuai pada kelas Manusia**
- [ ] **Membuat Getter Setter**

### Komponen Bonus | 10 Poin
- [ ] **Membuat method meninggal**
- [ ] **Mengimplementasikan "Manusia Terakhir" yang diinstansiasi**
- [ ] **Memodifikasi semua method (kecuali toString()) supaya manusia yang telah meninggal tidak dapat melakukannya lagi**
- [ ] **Memodifikasi method toString()**

-----
### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita mulai memakai sistem git sejak semester 2, mengikuti kakak angkatan kalian yang baru mulai memakai sistem git sejak semester 3. Salah satu guna dari menggunakan git adalah kita bisa menggunakan fitur Continuos Integration?

Apa itu Continuous Integration? Continuos Integration adalah konsep di mana ketika kalian push, hasil push kalian langsung di build (compile) dan di test (uji langsung). Jika gagal, kalian akan diberitahu.

Bagian Build baru akan dijelaskan di mata kuliah Advanced Programming. Kalian hanya perlu mengetahui bagian test.

Sistem yang digunakan untuk mengetest di Java bernama JUnit. Kita bisa menggunakan framework JUnit untuk mengetes secara langsung (tanpa harus print di command line). Untuk sekarang, kalian tidak perlu tahu cara kerja JUnit.

Kamu dapat memeriksa hasil kerja Junit di tab Commit. Tekan logo centang hijau atau cross merah untuk memeriksa detail lebih lanjut.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

Ketika kamu menekan logo tersebut, kamu akan memeriksa rangkuman dari tes tersebut yang memiliki dua lingkaran.

Jika lingkaran pertama cross, maka program kamu gagal karena compile error.
Jika lingkaran pertama centang hijau tetapi lingkaran kedua cross, maka program kamu tidak akurat.
Jika kedua lingkaran centang, berati program kamu sudah baik.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

Kamu dapat menekan tombol cross merah atau centang hijau untuk melihat hasil lebih lanjut. Sebagai contoh, jika kalain mendapat cross merah di lingkaran kedua, kamu dapat menemkan cross merah kedua untuk melihat test case mana program kalian tidak akurat.
