# **Tutorial 7: Inheritance (Soal Tutorial)**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2017/2018

**Dibuat oleh AE | INT**

* * *
Pada tutorial sebelumnya, Anda telah mempelajari mengenai konsep *cohesion* dan *coupling*, pada tutorial kali ini kita akan membahas lebih dalam lagi mengenai konsep OO khususnya **inheritance**.

## **Tujuan Pembelajaran**
1. Memahami *konsep inheritance*
2. Dapat mengimplementasikan konsep *inheritance* menggunakan bahasa java

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder `lab_7/src/main/java`. Kami sudah menyediakan folder kosong untuk kamu.
3. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.

## **Materi Tutorial**

### **What is inheritance**
**Inheritance** dapat didefinisikan sebagai suatu proses di mana satu kelas memerlukan suatu
properti (method atau atribut) dari kelas lainnya. Penggunaan inheritance sebuah informasi data
dapat di-manage dalam struktur hierarchical.
Suatu kelas yang meng-inherit properti dari kelas lain dikenal sebagai subclass dan kelas yang
di-inherit dikenal sebagai superclass.

#### **Example of Inheritance**
Mari kita coba mengimplmentasikan inheritance pada program sederhana berikut ini
```java
interface HitungBangunDatar {
    void hitungLuas();

    void hitungKeliling();
}

public class ProgramBangunDatar {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(4);
        PersegiPanjang persegiPanjang = new PersegiPanjang(4, 2);
        persegi.hitungLuas();
        persegiPanjang.hitungLuas();
        persegi.hitungKeliling();
        persegiPanjang.hitungKeliling();
    }
}

class BangunDatar implements HitungBangunDatar {
    int hasil;

    public void hitungLuas() {
    }

    public void hitungKeliling() {
    }
}

class Persegi extends BangunDatar {
    int x;

    public Persegi(int x) {
        this.x = x;
    }

    public void hitungLuas() {
        hasil = x * x;
        System.out.println("Luas dari persegi adalah: " + hasil);
    }

    public void hitungKeliling() {
        hasil = x * 4;
        System.out.println("Keliling dari persegi adalah: " + hasil);
    }
}

class PersegiPanjang extends BangunDatar {
    int x, y;

    public PersegiPanjang(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void hitungLuas() {
        hasil = x * y;
        System.out.println("Luas dari persegi panjang adalah: " + hasil);
    }

    public void hitungKeliling() {
        hasil = (2 * x) + (2 * y);
        System.out.println("Keliling dari persegi panjang adalah: " + hasil);
    }
}


```
Perhatikan bahwa kelas Persegi dan *PersegiPanjang* (subclass) meng-inherit kelas *BangunDatar*
(superclass), dan mengambil atribut hasil dan method hitungKeliling() serta hitungLuas() dari
superclass-nya. Cara subclass meng-inherit yaitu dengan keyword `extends`.
Kita juga dapat memanggil method superclass atau mengambil atribut superclass melalui suatu
subclass dengan memakai keyword `super`. Silahkan membuat kode seperti berikut, dan coba kalian
eksekusikan.

```java
# Reference: https://www.tutorialspoint.com/java/java_inheritance.htm
class Super_class {
    int num = 20;
    // display method of superclass
    public void display() {
        System.out.println("This is the display method of superclass");
    }
}

public class Sub_class extends Super_class {
    int num = 10;
    // display method of sub class
    public void display() {
        System.out.println("This is the display method of subclass");
    }
    public void my_method() {
        // Instantiating subclass
        Sub_class sub = new Sub_class();
        // Invoking the display() method of sub class
        sub.display();
        // Invoking the display() method of superclass
        super.display();
        // printing the value of variable num of subclass
        System.out.println("value of the variable named num in sub class:"+ sub.num);
        // printing the value of variable num of superclass
        System.out.println("value of the variable named num in super class:"+ super.num);
    }
    public static void main(String args[]) {
        Sub_class obj = new Sub_class();
        obj.my_method();
    }
}

```
Selain dengan memanggil method dari superclass, kita juga bisa meng-construct superclass dengan
menggunakan method 'super' pada constructor subclass. Silahkan buat program seperti di bawah ini:

```java
class Superclass {
    int age;
    
    Superclass(int age) {
        this.age = age;
    }
    public void getAge() {
        System.out.println("The value of the variable named age in super class is: " +age);
    }
}

public class Subclass extends Superclass {
    Subclass(int age) {
        super(age);
    }
    public static void main(String argd[]) {
        Subclass s = new Subclass(24);
        s.getAge();
    }
}
```
Perhatikan kembali bahwa method super pada constructor kelas *Subclass* digunakan untuk
meng-construct kelas *Superclass*. Ini sangat berguna ketika superclass mempunyai semua atribut
yang ada di subclass sehingga kita hanya perlu memanggil method super.
Dan terakhir, kita juga dapat mengecek apakah suatu kelas merupakan instance dari kelas yang
lain dengan memakai keyword `instanceof`. Silahkan mengimplementasikan program sederhana
berikut untuk lebih memahami fungsionalitas instanceof

```java
# Reference: https://www.tutorialspoint.com/java/java_inheritance.htm
interface Animal{}
class Mammal implements Animal{}
public class Dog extends Mammal {
    public static void main(String args[]) {
        Mammal m = new Mammal();
        Dog d = new Dog();
        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal); 
    }
}

```

Perhatikan bahwa output dari program akan menjadi seperti berikut:

true

true

true

Hal tersebut menunjukkan bahwa m merupakan instance dari kelas Animal, dan d merupakan
instance dari kelas Mammal serta Animal. Keyword instance sangat berguna untuk mengetahui
apakah suatu kelas meng-extend suatu kelas atau meng-implement suatu interface.

## **Soal Tutorial: To Eat Or To Be Eaten**

### **What's the story?**

Suatu ketika Dek Depe sedang bermain game dan merasa kelaparan. Ditengah-tengah dilema untuk melanjutkan gamenya atau makan, Dek Depe mendapat ide untuk membuat game dimana semua player bisa memakan lawannya yang sudah mati agar mendapatkan HP tambahan. Namun karena Dek Depe tidak sempat membuat prototype untuk idenya ini karena harus makan, ia meminta para pekerja gratis, ehm, para Mahasiswa DDP2 yang baik hati dan suka membantu untuk menyelesaikan pekerjaan ini.
***

Game ini memiliki 2 tipe player. Yakni monster dan manusia. Keduanya sama-sama memiliki HP, nama, dan diet. Diet adalah semua Player yang sudah dimakan oleh player tersebut selama di game. Monster bisa memakan manusia dan sesama monster yang sudah mati. Namun manusia hanya boleh memakan monster yang sudah matang terbakar. 
Manusia biasa tidak bisa membakar monster hingga matang, namun terdapat manusia yang memiliki kemampuan khusus yakni penyihir,penyihir adalah manusia yang bisa menggunakan move `burn` selain sekedar `attack` seperti manusia biasa. `burn` sama seperti `attack` biasa, namun jika monster mati karena serangan `burn` atau ketika `burn` diarahkan ke mayat monster maka monster itu akan matang sehingga aman untuk dimakan oleh manusia.

Terdapat minimal 4 kelas yang harus diimplemntasikan dengan menggunakan konsep inheritence. yakni

#### Player

Player memiliki attribut `name`, `hp`, dan `diet`. Semua player dapat menyerang dan memakan dengan `attack` dan `eat`. `attack` akan mengurangi HP musuh sejumlah **10**, sedangkan `eat` akan memakan player yang bisa dimakan dan mendapatkan tambahan `hp` sejumlah **15**. player juga dapat memperlihatkan `diet` dan `status`. Dimana `diet` mengembalikan player-player yang sudah dimakan oleh player tersebut. `status` akan memperlihatkan tipe player tersebut (apakah dia manusia, monster atau penyihir), namanya, HP serta informasi `diet`. Apabila mati karena `burn` Magician, atau setelah mati terkena `burn`, Player akan menjadi matang.

**player mati ketika hp 0, nilai minimal dari hp adalah 0. Sehingga ketika diserang dan nilai hp menjadi < 0, hp yang tersimpan tetap 0. Ketika assigment nyawa Player dapat bernilai kurang dari sama dengan 0**

#### Human

Human hanya dapat memakan monster yang sudah matang sebelumnya. Namun Human tidak bisa melakukan `roar` seperti monster. 

#### Monster

Monster dapat memakan semua hal yang sudah mati. Monster juga bisa melakukan `roar`. `roar` dari monster ditentukan ketika monster ditambah ke game. Namun jika `roar` tidak di spesifikasi, gunakan default "AAAAAAaaaAAAAAaaaAAAAAA". Monster memiliki nyawa 2x lipat dari nyawa yang di assign. 

#### Magician

Apalah artinya RPG tanpa Magician? Magician di game ini **adalah `human`** yang memiliki kemampuan khusus bernama `burn` yang dapat menyerang sekaligus memasak Player yang ia target. **Damage dari burn adalah 10**. Player yang mati karena `burn` damage atau yang sudah mati dan terkena `burn` akan menjadi matang. **Magician akan terkena damage 2x lipat ketika dijadikan `target` untuk method `attack` dan `burn`**

#### Beberapa Aturan

1. Nama unik untuk seluruh player. Bahkan ketika sudah mati sekalipun.
2. player di remove dari game ketika sudah dimakan. **Nama player dianggap tidak valid untuk command eat, attack, burn, diet, status, remove, roar. Namun menjadi valid untuk command add**
3. Minimal HP adalah 0
4. player yang mati tidak bisa melakukan apa-apa selain merelakan dirinya dimakan(?)
5. player yang mati tetap bisa diserang.
6. **Untuk validasi keberadaan nama method eat, attack dan burn, cukup keluarkan "Tidak ada (Player) atau (target)"**
7. **Untuk validasi keberadaan nama method diet, status, remove, roar, cukup keluarkan "Tidak ada (Player)"**
8. **player yang mati tidak dapat melakukan eat, attack, burn. cetak "(Player) tidak bisa (memakan/menyerang/membakar) (target)"**
9. **Command `diet()` akan mencetak semua player yang sudah dimakan. Cetak `diet()` berisi attribut `diet` seluruh player. Urutan dimulai pencetakan attribut `diet` dimulai dari player yang masuk ke game dari awal**
10. **canEat() di test adalah method yang harus diimplementasi di seluruh player, yang menandakan apakah suatu player dapat memakan player_lain atau tidak**
11. **Character diubah menjadi Player supaya konsisten dengan template**

#### Beberapa contoh output command

System.out.println(game1.add("Almarhum", "Human", 0)); 

//Almarhum ditambah ke game

System.out.println(game1.add("Fooder", "Monster", 0)); 

//Fooder ditambah ke game

System.out.println(game1.add("Mons", "Monster", 50)); 

//Mons ditambah ke game

System.out.println(game1.eat("Mons", "Fooder")); 

//Mons memakan Fooder

//Nyawa Mons kini 65

System.out.println(game1.eat("Mons", "Almarhum")); 

//Mons memakan Almarhum

//Nyawa Mons kini 80

System.out.println(game1.diet("Mons"));

//Human Almarhum, Monster Fooder

System.out.println(game1.status("Mons"));

// Monster Mons

// HP: 105

// Masih hidup

// Memakan Human Almarhum, Monster Fooder

**Contoh lagi**

game1.add("Fooder", "Monster", 0);

game1.add("Makan", "Monster", 10);

game1.add("Lapar", "Monster", 10);

game1.eat("Makan", "Fooder");

game1.attack("Mons")

System.out.println(game1.diet()); 

//Termakan : Human Almarhum, Monster Fooder, Monster Fooder

**Untuk contoh lain bisa dibaca di** 

[Lab7.java](https://gitlab.com/DDP2-CSUI/ddp-lab/blob/master/lab_7/src/main/java/Lab7.java "Lab7.java")

2 Hal dibawah tidak di test. Tapi agar lengkap:

**Jika mencetak diet() ketika tidak ada yang sudah dimakan. Keluarkan "Belum ada yang termakan"**

**Jika mencetak status() ketika belum ada pemain. Keluarkan "Tidak ada pemain"**

#### Bonus

1. Buat methode di `game` dengan nama `cetakMenu` dan cetak **[Tree](https://en.wikipedia.org/wiki/Tree_(data_structure))** dari attribute `diet` untuk setiap player yang masih ada di game (belum di remove atau dimakan). player yang masih ada di game tersebut sebagai root dari tree, dan Player yang sudah dimakan sebagai nodenya. (format pencetakan Tree bebas)

Contoh:

B Makan D

B Makan C

A Makan B

Maka Treenya (Pencetakan tidak perlu mengikuti format ini)

---A

---B

-C---D

## Checklist

Isi kurung siku komponen dengan x untuk menceklis komponen.

### Komponen Wajib | 100 Poin

- [ ] **Mengimplementasikan class-class yang diminta (boleh mengimplementasikan lebih dari yang diminta)**
- [ ] **Mengimplementasikan atribut-atribut yang sesuai pada setiap class**
- [ ] **Mengimplementasikan setiap method sesuai dengan kebutuhan soal**

### Komponen Bonus | 10 Poin

- [ ] **Implementasi `cetakMenu` yang mencetak Tree dari attribute `diet` Player yang masih hidup**

-----
### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita mulai memakai sistem git sejak semester 2, mengikuti kakak angkatan kalian yang baru mulai memakai sistem git sejak semester 3. Salah satu guna dari menggunakan git adalah kita bisa menggunakan fitur Continuous Integration?

Apa itu Continuous Integration? Continuous Integration adalah konsep di mana ketika kalian push, hasil push kalian langsung di build (compile) dan di test (uji langsung). Jika gagal, kalian akan diberitahu.

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
