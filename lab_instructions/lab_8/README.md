# **Tutorial 8: Polymorphism (Soal Tutorial)**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia,
Semester Genap 2017/2018

**Dibuat oleh ADA | RPN**

* * *

Pada tutorial kali ini kita akan mempelajari suatu konsep yang cukup erat pada dunia
Object-Oriented Programming, yaitu **Polymorphism**.

## **Tujuan Pembelajaran**

1. Memahami konsep **polymorphism**.
2. Dapat mengimplementasikan konsep **polymorphism** menggunakan bahasa java.

### **Before You Start...**

1. **[`PENTING`]** Lakukan `git pull upstream master` dengan menggunakan command prompt atau
   terminal kesayangan anda pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder
   `lab_8/src/main/java`. Disana sudah tersedia folder kosong untuk tempat kita bekerja.
3. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code
   kalian tersebut.

## **Materi Tutorial**

### **Polymorphism?**

**Polymorphism** dapat didefinisikan sebagai suatu konsep dimana suatu objek dapat memiliki
banyak bentuk. Contoh nyatanya adalah H2O dapat memiliki bentuk cair, padat, dan gas.

Pada OOP, **Polymorphism** adalah kemampuan suatu variabel atau argumen untuk me-*refer*
kepada suatu objek dari bermacam-macam kelas [Meyer pp. 224].

### Lebih Lanjut tentang Polymorphism

```java
class A {
    // ...
    void foo() {
        System.out.println("foo A");
    }
    // ...
}
```


```java
class B extends A {
    // ...
    void foo() {
        System.out.println("foo B");
    }

    void bar() {
        System.out.println("bar B");
    }
    // ...
}
```


* Kelas A merupakan **superclass** dari kelas B.
* Kelas B merupakan **subclass** dari kelas A.

Hasil simulasi kedua kelas tersebut adalah:

```java
A a = new A();
B b = new B();

a.foo(); // foo A
b.foo(); // foo B

b.bar(); // bar B
```

#### Dynamic

Dynamic disini artinya variabel `x` akan memiliki tipe yang berbeda-beda seiring program
berjalan. Contohnya adalah proses upcasting dan downcasting di bawah ini.

##### Upcasting

![upcasting](https://i.imgur.com/dDfsIgZ.png)

Upcasting adalah melakukan proses pengubahan referensi **subclass ke superclass**.


```java
A a = new A();
B b = new B();

a.foo() // foo A

a = b; // Upcasting

a.foo(); // foo B
```


Perhatikan bahwa pada kondisi diatas, kita tidak dapat memanggil `a.bar()` karena Kelas A
tidak memiliki method tersebut. Dengan begitu kita dapat menyimpulkan bahwa method yang
spesifik pada kelas B akan menjadi **inactive**.

##### Downcasting

![downcasting](https://i.imgur.com/r5eCBMS.png)

Downcasting adalah melakukan proses pengubahan referensi **superclass ke subclass**.

```java
A a = new B(); // Upcasting

B b = (B) a; // Downcasting

b.bar(); // bar B
```


Proses **downcasting** dari variabel `a` ke variable `b` bertipe Kelas `B` memberi kita
akses untuk memanggil method `bar()` yang khusus pada Kelas `B`. **`PERHATIKAN`** bahwa kita
bisa memanggil `b.bar()` namun tidak dapat memanggil `a.bar()` (
[lihat penjelasan pada upcasting](#upcasting) ).

#### Static

Static type binding ini terjadi ketika proses compile terjadi. Hal ini karena perubahan type
terjadi pada method yang **static**.


```java
class A {
    // ...
    public static void foo() {
        System.out.println("zuper");
    }
    // ...
}

class B extends A {
    // ...
    public static void foo() {
        System.out.println("zub");
    }
    // ...
}
```


Bila kita melakukan simulasi pada kelas-kelas tersebut:

```java
A.foo() // zuper
B.foo() // zuper
```

Method static `foo()` pada kelas B menjadi tidak aktif dan digantikan oleh method static
`foo()` milik superclassnya.

### Abstract Class pada Polymorphism

**Abstract class** merupakan salah satu konsep yang sangat erat dengan **polymorphism**.
Abstact class adalah kelas yang dapat memiliki method tanpa body/implementasi. Method
tersebut akan **diimplementasikan** oleh **subclass**-nya.

```java
abstract class A {
    abstract void foo();
}
```


```java
class B extends A {
    void foo() {
        System.out.println("foo B");
    }

    void bar() {
        System.out.println("bar B");
    }
}
```


* Method `foo()` tanpa body pada kelas abstrak `A` harus juga `abstract`.
* Kelas B harus mengimplementasikan method `foo()` didalamnya.
* Bila kelas `B` tidak mengimplementasikan method `foo()` maka Kelas `B` harus berupa
  **abstract class** juga.
* Sebagaimana kelas pada umumnya, Abstract Class hanya dapat meng-extends satu kelas saja.

### **Example**

Masih dengan tema yang sama dengan Lab sebelumnya, berikut adalah contoh sederhana
penggunaan **polymorphism**, **abstract class**, dan **overiding**.

#### File `Simulasi.java`


```java
/*
 * Copyright (c) 2018. Made with love by Ada
 */

public class Simulasi {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(4);
        PersegiPanjang persegiPanjang = new PersegiPanjang(4, 2);
        SegitigaSikuSiku segitigaSikuSiku = new SegitigaSikuSiku(3, 4);
        SegitigaSamaSisi segitigaSamaSisi = new SegitigaSamaSisi(3);
        Lingkaran lingkaran = new Lingkaran(3);
        BangunDatar[] KumpulanBangunDatar = {persegi, persegiPanjang, segitigaSikuSiku, segitigaSamaSisi, lingkaran};

        printLuas(persegi);
        printKeliling(persegi);
        printLuas(persegiPanjang);
        printKeliling(persegiPanjang);
        printLuas(segitigaSikuSiku);
        printKeliling(segitigaSikuSiku);
        printLuas(segitigaSamaSisi);
        printKeliling(segitigaSamaSisi);
        printLuas(lingkaran);
        printKeliling(lingkaran);

        printLuas(KumpulanBangunDatar);
        printKeliling(KumpulanBangunDatar);
    }

    public static void printLuas(BangunDatar bangun) {
        System.out.printf("%-50s: %5.1f\n", "Luas dari " + bangun.getNama(), bangun.luas());
    }

    public static void printLuas(BangunDatar[] bangunan) {
        double total = 0;
        for (BangunDatar bangun :
                bangunan) {
            total += bangun.luas();
        }
        System.out.printf("%-50s: %5.1f\n", "TOTAL Luas", total);
    }

    public static void printKeliling(BangunDatar bangun) {
        System.out.printf("%-50s: %5.1f\n", "Keliling dari " + bangun.getNama(), bangun.keliling());
    }

    public static void printKeliling(BangunDatar[] bangunan) {
        double total = 0;
        for (BangunDatar bangun :
                bangunan) {
            total += bangun.luas();
        }
        System.out.printf("%-50s: %5.1f\n", "TOTAL Keliling", total);
    }
}

abstract class BangunDatar {
    protected double x, y;
    protected String nama;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public abstract double luas();

    public abstract double keliling();
}

class Lingkaran extends BangunDatar {
    public Lingkaran(double jariJari) {
        this.x = jariJari;
        this.y = jariJari;
        this.nama = "Lingkaran";
    }

    @Override
    public double luas() {
        return Math.PI * x * x;
    }

    @Override
    public double keliling() {
        return Math.PI * 2 * x;
    }
}

abstract class Segitiga extends BangunDatar {
    @Override
    public double luas() {
        return x * y / 2;
    }
}

class SegitigaSikuSiku extends Segitiga {
    public static double hitungSisiMiring(double alas, double tinggi) {
        return Math.sqrt(alas * alas + tinggi * tinggi);
    }

    public SegitigaSikuSiku(double alas, double tinggi) {
        this.x = alas;
        this.y = tinggi;
        this.nama = "Segitiga Siku-Siku";
    }

    @Override
    public double keliling() {
        return x + y + SegitigaSikuSiku.hitungSisiMiring(x, y);
    }
}

class SegitigaSamaSisi extends Segitiga {
    public static double hitungTinggi(double sisi) {
        return 0.5 * sisi * Math.sqrt(3);
    }

    public SegitigaSamaSisi(double sisi) {
        this.x = sisi;
        this.y = SegitigaSamaSisi.hitungTinggi(sisi);
        this.nama = "Segitiga Sama Sisi";
    }

    @Override
    public double keliling() {
        return 3 * x;
    }
}

abstract class SegiEmpat extends BangunDatar {
    @Override
    public double luas() {
        return x * y;
    }

    @Override
    public double keliling() {
        return (2 * x) + (2 * y);
    }
}

class PersegiPanjang extends SegiEmpat {
    public PersegiPanjang(int panjang, int lebar) {
        this.x = panjang;
        this.y = lebar;
        this.nama = "Persegi Panjang";
    }
}

class Persegi extends SegiEmpat {
    public Persegi(int panjangSisi) {
        this.x = panjangSisi;
        this.y = panjangSisi;
        this.nama = "Persegi";
    }
}
```


#### Output dari `Simulasi.java`

```
Luas dari Persegi                                 :  16.0
Keliling dari Persegi                             :  16.0
Luas dari Persegi Panjang                         :   8.0
Keliling dari Persegi Panjang                     :  12.0
Luas dari Segitiga Siku-Siku                      :   6.0
Keliling dari Segitiga Siku-Siku                  :  12.0
Luas dari Segitiga Sama Sisi                      :   3.9
Keliling dari Segitiga Sama Sisi                  :   9.0
Luas dari Lingkaran                               :  28.3
Keliling dari Lingkaran                           :  18.8
TOTAL Luas                                        :  62.2
TOTAL Keliling                                    :  62.2
```

#### Analisis `Simulasi.java`

Untuk memahami baris kode pada file tersebut, lihat diagram dibawah ini.
![Diagram](https://i.imgur.com/mltuBVz.png) Tanda panah dari kelas menunjukan proses
inheritance. Tujuan dari tanda panah merupakan subclass dari superclass tempat tanda panah
berasal.


Pada simulasi, kita memiliki beberapa kelas, diantaranya:

##### Kelas Abstrak `BangunDatar`

Kelas ini merepresentasikan bentuk umum dari bangun datar dengan ciri-ciri memiliki
*instance variable* nama, x dan y. Tentu kelas ini memiliki setter getter untuk setiap
kelas. Terdapat abstrak method `hitungLuas()` dan `hitungKeliling()` yang belum
diimplementasikan/*body* kosong. Kelas-kelas yang meng-*extend* kelas ini nantinya harus
mengimplementasi method tersebut.

##### Kelas `Lingkaran`

Kelas ini merepresentasikan bangun datar lingkaran yang meng-*extend* kelas `BangunDatar`.
Variabel **x dan y akan diisi jari-jari** dari lingkaran. Method abstrak `hitungLuas()` dan
`hitungKeliling()` dari *parent* pun telah diimplementasikan dalam kelas ini sesuai dengan
rumusnya.

##### Kelas Abstrak `Segitiga`

Kelas ini merepresentasikan bangun datar Segitiga yang meng-*extend* kelas `BangunDatar`.
Method abstrak `hitungLuas()` dari *parent* pun telah diimplementasikan dalam kelas ini
sesuai dengan rumusnya.

##### Kelas `SegitigaSikuSiku`

Kelas ini merepresentasikan bangun datar Segitiga Siku Siku yang meng-*extend* kelas
`Segitiga`. Method abstrak `hitungKeliling()` dari *parent* pun telah diimplementasikan
dalam kelas ini sesuai dengan rumusnya. Untuk menghitung keliling, diperlukan nilai dari
sisi miring. Untuk mencari sisi miring, terdapat impementasi method static
`hitungSisiMiring` untuk mencarinya.

##### Kelas `SegitigaSamaSisi`

Kelas ini merepresentasikan bangun datar Segitiga Sama Sisi yang meng-*extend* kelas
`Segitiga`. Method abstrak `hitungKeliling()` dari *parent* pun telah diimplementasikan
dalam kelas ini sesuai dengan rumusnya. Kelas ini mengimplementasikan x sebagai alas dan y
sebagai tinggi dari segitiga (tentu dengan fungsi `hitungTingg` untuk mencari tinggi
segitiga dari sisi )

##### Kelas Abstrak `SegiEmpat`

Kelas ini merepresentasikan bangun datar Segi Empat yang meng-*extend* kelas `BangunDatar`.
Method abstrak `hitungLuas()` dan `hitungKeliling()` dari *parent* pun telah
diimplementasikan dalam kelas ini sesuai dengan rumusnya (**Karena segi empat hanya terdiri
dari persegi dan persegi panjang. Impementasi akan berbeda bila jajar genjang atau belah
ketupat juga meng-*extend* kelas ini.**).

##### Kelas `PersegiPanjang`

Kelas ini merepresentasikan bangun datar Persegi Panjang yang meng-*extend* kelas
`SegiEmpat`. Kelas ini hanya memberikan nilai pada variabel **x dan y sebagai panjang dan
lebar**.

##### Kelas `Persegi`

Kelas ini merepresentasikan bangun datar Persegi yang meng-*extend* kelas `SegiEmpat`. Kelas
ini hanya memberikan nilai pada variabel x dan y dengan sisi-sisinya sehingga **nilai x sama
dengan nilai y**.


## **Soal Tutorial: "Whack Your Boss"**

**[`PERHATIAN`]** : kesamaan latar dan karakter merupakan ketidaksengajaan yang sangat
kebetulan.

### **What's the story?**

**Ricky** adalah seonggok makhluk hidup yang sedang berkuliah di jurusan Ilmu Komputer.
Tahun ini, dia diharuskan untuk mempraktikan segala hal yang telah ia pelajari selama kuliah
pada dunia kerja atau biasa disebut Kerja Praktik.

Setelah melalui proses seleksi penerimaan peserta magang pada suatu perusahaan bernama **PT.
TAMPAN**, Ricky yang sangat **pintar** pun diterima menjadi salah satu dari sedikit peserta
pintar yang diterima.

**PT. TAMPAN** yang merupakan start-up terkenal yang telah diakuisisi oleh PT. QEJOG
tidaklah beda dengan korporasi pada umumnya, perusahan tersebut memiliki `KARYAWAN`. Tentu
saja, karyawan disana memiliki jabatan yang bervariasi, ada yang menjabat sebagai `MANAGER`,
`STAFF`, dan `INTERN`. Dengan profesionalitas yang selalu dijaga oleh **PT. TAMPAN**, Ricky
pun tetap diperlakukan sebagaimana `INTERN` pada umumnya.

Sebagai tugas hari pertamanya, Ricky pun diminta untuk membuat **Sistem Infomasi Anggaran
Netto Gaji (SIANG) TAMPAN** oleh **Affan**, *CEO TAMPAN*. Ricky yang merupakan seorang
programmer handal pun tidak kesulitan sama sekali, tapi dia merasa tugas ini sangat
membosankan. Oleh karena itu, **Ricky meminta kalian para mahasiswa DDP 2 untuk membuatkan
tugas pertamanya ini**.

#### Beberapa Aturan

Aplikasi SIANG TAMPAN adalah aplikasi yang dapat mengatur proses pemberian gaji kepada
karyawan dari PT. TAMPAN. Aplikasi ini membantu mencatat data-data dari karyawan yang ada.
Hal yang lebih utama adalah aplikasi ini akan membantu Affan, CEO TAMPAN, untuk menggaji
karyawannya diperusahannya dengan one-click action.

* `KORPORASI` dapat memiliki banyak `KARYAWAN` dengan jumlah **tidak lebih** dari `10000`.
* `MANAGER`, `STAFF`, dan `INTERN` merupakan `KARYAWAN`.
* `MANAGER` dapat membawahi banyak `KARYAWAN` dengan jumlah **tidak lebih** dari `10`.
* `MANAGER` dapat menarik `STAFF` dan `INTERN` menjadi bawahannya.
* `STAFF` dapat membawahi banyak `KARYAWAN` dengan jumlah **tidak lebih** dari `10`.
* `STAFF` dapat menarik `INTERN` menjadi `bawahan`nya.
* `INTERN` **tidak dapat memiliki bawahan** sama sekali.
* Gaji diberikan **setiap bulan**nya kepada setiap `KARYAWAN`.
* Batas maksimal Gaji `STAFF` adalah baris pertama input, misalkan `5000` atau `18000`. Ketika Gaji staff melebihi batas maksimal, maka dia akan menjadi `MANAGER`.
* Nama `KARYAWAN` unik.

##### 1. Menambahkan MANAGER, STAFF atau INTERN

Kita dapat menambahkan KARYAWAN ke dalam perusahaan dengan perintah

```
TAMBAH_KARYAWAN <TIPE> <NAMA_KARYAWAN> <GAJI_AWAL>
```

Keluaran dari perintah ini adalah

`<NAMA KARYAWAN> mulai bekerja sebagai <TYPE> di PT. NAMPAN`

**PERHATIAN** Dalam suatu perusahaan **tidak diperboleh memiliki nama karyawan yang sama
satu dengan yang lainnya**.

###### Contoh 1

Input:

```
TAMBAH_KARYAWAN MANAGER DHIA 40000
```

Output: `DHIA mulai bekerja sebagai MANAGER di PT. TAMPAN`

###### Contoh 2

Input:

```
TAMBAH_KARYAWAN INTERN RICKY 10000
```

Output: `RICKY mulai bekerja sebagai INTERN di PT. TAMPAN`

###### Contoh 3

Input:

```
TAMBAH_KARYAWAN STAFF RICKY 10000
```

Output: `Karyawan dengan nama RICKY telah terdaftar`

##### 2. Mencetak status karyawan

Kita dapat mencetak STATUS dari KARYAWAN dengan perintah

```
STATUS <NAMA_KARYAWAN>
```

Keluaran dari perintah ini adalah `<NAMA_KARYAWAN> GAJI_PERBULAN>`

###### Contoh 1

Input:

```
STATUS RICKY
```

Output: `Ricky 10000`

Asumsi: Karyawan bernama **Ricky** **sudah** pernah dimasukan sebelumnya.

###### Contoh 2

Input:

```
STATUS YKCIR
```

Output: `Karyawan tidak ditemukan`

Asumsi: Karyawan bernama **Ykcir** **belum** pernah dimasukan sebelumnya.

##### 3. Merekrut menjadi bawahan

Seperti yang sudah dijelaskan diatas, MANAGER dan STAFF dapat memiliki bawahan dengan cara
menambahkannya ke daftar bawahan mereka dengan perintah

```
TAMBAH_BAWAHAN <NAMA_YANG_MENAMBAHKAN> <NAMA_YANG_DITAMBAHKAN>
```

Keluaran dari perintah ini: `Karyawan <NAMA_YANG_DITAMBAHKAN> berhasil ditambahkan menjadi
bawahan <NAMA_YANG_MENAMBAHKAN>`

| Kondisi                                                                                                    | Output                                                                           |
|:-----------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------|
| Apabila salah satu dari `NAMA_YANG_MENAMBAHKAN` atau `NAMA_YANG_DITAMBAHKAN` tidak ditemukan               | `Nama tidak berhasil ditemukan`                                                  |
| Apabila `NAMA_YANG_MENAMBAHKAN` **tidak memiliki hak** untuk **menambahkan bawahan** NAMA_YANG_DITAMBAHKAN | `Anda tidak layak memiliki bawahan`                                              |
| Apabila `NAMA_YANG_DITAMBAHKAN` **sudah** menjadi **bawahan** `NAMA_YANG_MENAMBAHKAN`                      | `Karyawan <NAMA_YANG_DITAMBAHKAN> telah menjadi bawahan <NAMA_YANG_MENAMBAHKAN>` |

###### Contoh 1

Input:

```
TAMBAH_BAWAHAN DHIA RICKY
```

Output: `Karyawan RICKY berhasil ditambahkan menjadi bawahan DHIA`

Asumsi: Ricky sudah pernah ditambahkan menjadi bawahan Dhia sebelumnya.

###### Contoh 2

Input:

```
TAMBAH_BAWAHAN RICKY DHIA
```

Output: `Anda tidak layak memiliki bawahan`

###### Contoh 3

Input:

```
TAMBAH_BAWAHAN FOO BAR
```

Output: `Nama tidak berhasil ditemukkan`

###### Contoh 4

Input:

```
TAMBAH_BAWAHAN DHIA RICKY
```

Output: `Karyawan RICKY telah menjadi bawahan DHIA`

##### 4. Gajian

Setiap KARYAWAN yang terdaftar pada KORPORASI akan mendapatkan gaji.

###### Contoh 1:

Input:

```
GAJIAN
```

Ouput: `Semua karyawan telah diberikan gaji`

##### 5. Naik Gaji

Apabila KARYAWAN telah mendapatkan gaji sebanyak 6 kali, maka ia berhak mendapatkan KENAIKAN
GAJI secara OTOMATIS terlepas dia rajin atau malas.

Ouput: `<NAMA_KARYAWAN> mengalami kenaikan gaji sebesar 10% dari <GAJI_YANG_BELUM_NAIK>
menjadi <GAJI_YANG_SUDAH_NAIK>`

##### 6. Semua STAFF dapat dipromosikan menjadi MANAGER

Promosi diberikan ketika gaji yang harus diberikan kepada STAFF tersebut telah melewati
batas maksimal gaji dari STAFF.

`Selamat, <NAMA_KARYAWAN> telah dipromosikan menjadi MANAGER`

###### Contoh 1

Input:

```
GAJIAN
```

Output:

`Semua karyawan telah diberikan gaji`

`Selamat, Ardhiva telah dipromosikan menjadi MANAGER`

Asumsi: Karyawan **Ardhiva** telah memiliki hak untuk digaji melebihi batas gaji `STAFF`
yaitu 18000.


#### Bonus


## Checklist

Ganti kurung siku [ ] dengan [ x ] untuk menceklis komponen.

### Komponen Wajib | 100 Poin

- [ ] **Mengimplementasikan class-class yang diminta (boleh mengimplementasikan lebih dari
      yang diminta)**

### Komponen Bonus | 10 Poin

- [ ] **...**

---

### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah
atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita mulai memakai sistem git sejak semester 2, mengikuti
kakak angkatan kalian yang baru mulai memakai sistem git sejak semester 3. Salah satu guna
dari menggunakan git adalah kita bisa menggunakan fitur Continuous Integration?

Apa itu **Continuous Integration**? **Continuous Integration** adalah konsep di mana ketika
kalian push, hasil push kalian langsung di build (compile) dan di test (uji langsung) secara
otomatis. Jika gagal, kalian akan diberitahu.

Bagian Build baru akan dijelaskan di mata kuliah Advanced Programming. Kalian hanya perlu
mengetahui bagian test.

Sistem yang digunakan untuk mengetest di Java bernama JUnit. Kita bisa menggunakan framework
**JUnit** untuk mengetes secara langsung (tanpa harus print di command line). Untuk
sekarang, kalian tidak perlu tahu cara kerja JUnit.

Kamu dapat memeriksa hasil kerja Junit di tab Commit. Tekan logo centang hijau atau cross
merah untuk memeriksa detail lebih lanjut.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

Ketika kamu menekan logo tersebut, kamu akan memeriksa rangkuman dari tes tersebut yang
memiliki dua lingkaran.

Jika lingkaran pertama cross, maka program kamu gagal karena compile error. Jika lingkaran
pertama centang hijau tetapi lingkaran kedua cross, maka program kamu tidak akurat. Jika
kedua lingkaran centang, berati program kamu sudah baik.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

Kamu dapat menekan tombol cross merah atau centang hijau untuk melihat hasil lebih lanjut.
Sebagai contoh, jika kalain mendapat cross merah di lingkaran kedua, kamu dapat menemkan
cross merah kedua untuk melihat test case mana program kalian tidak akurat.

