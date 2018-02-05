# Lab 1 : Pengenalan Java & Git
Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2017/2018

**Dibuat oleh: IF | KT**

***

## Java

Di DDP 1 kalian telah belajar konsep-konsep pemrograman dengan menggunakan bahasa Python, 
di DDP 2 ini kalian memperdalam pemahaman pemrograman kalian dengan konsep-konsep yang menarik 
seperti _Object Oriented Programming_ dengan menggunakan bahasa pemrograman Java.
 
Pasti timbul pertanyaan di benak kalian, kenapa memakai Java ? kenapa tidak pakai Python saja?. 

Singkatnya, Java mempunyai kelebihan yaitu kejelasan struktur dalam pemrogramannya, 
sehingga membuat mudah untuk memahami konsep _Object Oriented_. Selain itu juga masih ada perbedaan lain 
yang perlu kalian ketahui, simak penjelasan dibawah ini.

**Interpreted / Compiled**

Python merupakan salah satu _Interpreted Language_, dimana saat program dijalankan, 
komputer akan mengeksekusi tiap instruksi satu per satu. Oleh karena itu kita bisa langsung 
menjalankan program Python. Java merupakan salah satu _Compiled Language_, dimana setiap program 
harus diubah menjadi bahasa lain yang bisa dimengerti komputer, lalu setelah itu baru bisa dijalankan.

**Struktur Kode**

Pada dasarnya, walaupun memiliki perbedaan struktur kode yang mencolok, semua bahasa pemrograman itu memiliki garis 
besar yang sama, sehingga jika kalian telah memahami sebuah bahasa pemrograman, akan lebih mudah untuk memahami bahasa 
yang lain. 

Oleh karena itu, yuk simak perbedaan intruksi-intruksi di Python dan Java.

1.  **Declaring & Assigning Variables**
    
    Variabel di Python bersifat _dynamic_, contohnya adalah kita bisa memberi nilai dengan tipe data apapun ke sebuah 
    variabel, dan kita bisa mengubah nilai variabel tersebut dengan tipe data yang berbeda. 
    
    Java memiliki variabel yang 
    bersifat _static_, perbedaanya dengan Python adalah kita harus memberikan informasi mengenai tipe data sebuah variabel 
    secara **eksplisit**, serta kita hanya bisa mengganti nilai variabel tersebut dengan tipe data yang sama. 
    
    Untuk lebih jelasnya lihat perbandingan dibawah ini.

    **Python**
    
    ```python
    var1 = 3
    var2 = "Hehe"
    var3 = True
    var1 = False # bisa
    ```
    
    **Java**
    
    ```java
    int var1 = 3;
    String var2 = "Hehe";
    boolean var3 = true;
    var1 = False; // error, var1 bertipe int
    ```
    
    **_Catatan :_** Tipe tipe data di Java antara lain, **int** (bil. bulat), **double** (bil. pecahan), **boolean** 
    (true/false), **String** (kalimat), **char** (satu huruf), dan masih banyak lagi yang akan kalian pelajari nanti.
    
    >**Perhatian**
    >
    >Di Java, kalian harus memberikan semicolon ( **;** ) di tiap akhir instruksi, 
    ini menandakan akhir sebuah instruksi dan pemisah antar instruksi, 
    dimana di Python tiap instruksi dipisahkan dengan baris.
    
2.  **If-Else Conditions**

    Flow Conditions di Java dan Python sama, yang membedakan adalah di Python kita mengenal **elif**, 
    di Java menggunakan **else if**, simak contoh dibawah ini.

    **Python**
    
    ```python
    nilai = 78
    huruf = ''
    
    if(nilai > 85):
        huruf = 'A'
    elif(nilai > 70):
        huruf = 'B'
    elif(nilai > 55):
        huruf = 'C'
    else:
        huruf = 'D'
    
    print(huruf)
    ```
    
    **Java**
    
    ```java
    int nilai = 78;
    char huruf;
    
    if(nilai > 85){
        huruf = 'A';
    }else if(nilai > 70){
           huruf = 'B';
    }else if(nilai > 55){
           huruf = 'C';
    }else{
           huruf = 'D';
    }
    System.out.println(huruf);
    ```

    >**Perhatian**
    >
    >Di Python, untuk mendefinisikan isi sebuah conditions (if elif else), kita memberi titik dua  ( : ) 
    pada conditions, lalu isinya berada dibawahnya dengan indentasi. 
    >
    >Di Java, isi dari sebuah conditions ada didalam 
    kurung kurawal ( **{ }** ). penggunaan indentasi hanya sebagai aestetik agar program lebih mudah dibaca, 
    ini juga berlaku untuk fungsi, class, dan lain-lain.

3.  **Loop**
    
    Untuk memahami perbedaan loop di Java dengan Python, simak kode di bawah ini.
    
    **Python**
    
    ```python
    for num in range(10):
        print("Cetakan ke-" + str(num+1))
    
    point = 0
    while (point < 10):
        print(point)
        point += 1
    ```
    
    **Java**
    
    ```java
    for(int a = 0; a<10; a++){
                System.out.println("Cetakan ke-" + Integer.toString(a+1));
            }
    
    int point = 0;
    while(point<10){
        System.out.println(point);
        point++; // tanda ++ untuk menambah dengan nilai 1
    }
    ```

    Perbedaan paling mencolok ada pada `for` loop di Java yang memiliki format :
    
    ```java
    for (int variabel; syarat; peubah nilai){
         // isi
    }
    ```
    
    Kita harus membuat variabel dulu, lalu tentukan syarat berjalannya loop, yang selama true, maka loop akan berjalan, 
    dan yang ketiga memberikan peubah nilai agar nilai suatu saat loop nya berhenti. 
    
    Memang terlihat rumit namun kita bisa membuat for loop yang bermacam-macam.
    

### Membuat Program Java

Kalian sudah mengetahui beberapa perbedaan Java dengan Python, sekarang saatnya kalian belajar membuat program 
sederhana, berbeda dengan Python dimana kalian bisa langsung menulis instruksi di file python, ada beberapa aturan 
main saat kalian membuat program di Java, simak petunjuknya dibawah ini.

Pertama, buatlah sebuah file dengan format **.java** (buat sebuah file text, lalu ganti formatnya dengan .java), lalu 
buka dengan text editor (Notepad++, Sublime, dll.).

Hal yang pertama kita buat adalah sebuah **class**, karena di Java, setiap program yang kita buat harus berada di dalam 
sebuah class. Pastikan nama class nya sama dengan nama file nya (jika nama filenya **Halo.java**, maka nama class nya 
**Halo**).

Lalu, kita buat sebuah fungsi _main_, _**Buat apa fungsi main?**_ Fungsi main berguna sebagai entry-point (titik masuk) 
jalannya sebuah program, saat kalian jalankan program kalian, Java akan mencari letak fungsi main, lalu menjalankan 
instruksi yang ada didalamnya. 

Setelah itu di dalam fungsi main tersebut bisa diisikan instruksi-instruksi yang ingin dijalankan, contoh 
programnya :

```java
public class Halo{
    
    public static void main(String[] args){
    
        System.out.println("Hello World!");
        
        String nama = "Dek Depe";
        System.out.println("Namaku " + nama);
        
    }
    
}
```

> **_System.out.println()_** digunakan untuk mencetak sebuah informasi ke layar, di Python kita mengenal _print()_

Untuk menjalankan program kalian, pertama _save_ dulu file kalian, lalu buka folder dimana file kalian berada, pada 
address bar nya, ketik `cmd`, lalu tekan _Enter_, Command Prompt akan terbuka dengan directory menunjuk ke lokasi file 
kalian. 

Kalian juga bisa membuka _Command Prompt_ di _Start Menu_, namun kalian harus mengarahkan direktorinya ke folder
dimana program kalian berada secara manual 

>gunakan perintah `cd` untuk berpindah direktori, (misal D:\Kuliah), dan `<drive>:` untuk 
berpindah partisi (misal `D:`).

Untuk menjalankan program, kalian perlu melakukan 2 perintah di Command Prompt, yaitu :

1.  `javac NamaFile.java`

    Ini akan meng-_compile_ file Java kalian dan menghasilkan file bernama sama dengan tipe file `.class`

2.  `java NamaFile`
    
    Ini akan mengeksekusi file yang telah kalian compile, semua output akan terlihat di _Command Prompt_

Dan program Java pertama kalian berhasil dijalankan ! yay!

#### Latihan :

1.  Akhir tiap instruksi di Java harus diakhiri dengan . . . .

2.  Isi dari sebuah conditional, fungsi, dll harus berada di dalam tanda  . . . .

3.  Apa saja yang dibutuhkan untuk membuat for loop ?

***

## Git

Selain beralih dari bahasa pemrograman Python ke bahasa pemrograman Java, di mata kuliah DDP2 kali ini, kalian akan 
diberikan sebuah pengalaman baru dengan menggunakan Git.

**Version Control System (VCS)**

VCS merupakan sebuah software yang membantu para developer untuk saling bekerja sama dan tetap mempertahankan 
riwayat kerja mereka secara utuh. 

VCS memiliki beberapa fungsi, di antaranya mengizinkan para developer untuk  bekerja secara bersamaan, tidak 
mengizinkan saling tumpang-tindih perubahaan yang ada, dan mempertahankan riwayat dari setiap versi. 

VCS sendiri terbagi menjadi dua tipe, yaitu Centralized VCS (CVCS) dan Distributed/Decentralized VCS (DVCS). 

Git merupakan VCS yang sering digunakan sekarang ini. Git merupakan salah satu Distributed Version Control System 
(DVCS), yang berarti salinan kode yang tersimpan di local repository adalah sebuah version control repository yang 
lengkap. 

Jadi, antara local repository dan remote repository sama-sama berisi versi terakhir (terupdate).

**Perintah di Git**

Untuk melihat berbagai perintah (command) yang ada di Git, kamu bisa melihatnya di [sini](https://gitlab.com/gitlab-com/marketing/raw/master/design/print/git-cheatsheet/print-pdf/git-cheatsheet.pdf).

**Tutorial Git**

Pada bagian pertama, kamu sudah diberikan soal tutorial mengenai bahasa pemrograman Java. Pada bagian ini, kamu 
akan menyimpan file yang telah kamu buat secara remote di GitLab. 

Untuk melakukan hal tersebut, harap ikuti langkah-langkah berikut ini:

1.  Buatlah sebuah folder yang akan menjadi local repository yang kamu gunakan,. Nama folder bebas.
    > Catatan: dalam soal tutorial ini, nama folder yang digunakan adalah “TutorialDDP2”, kalian boleh menggantinya.

2.  Buka command prompt/shell.

3.  Ubah direktori sekarang menjadi direktori dari folder “TutorialDDP2”.
    > Misal : D:\DDP2\TutorialDDP2

4.  Jalankan perintah `git init` pada command prompt/shell.

    > ini akan menginisiasi Git pada direkori yang ditunjuk oleh _Command Prompt_, pastikan kalian tidak salah menginisiasi folder

5.  Jalankan perintah `git status` untuk memastikan bahwa inisiasi repository Git sudah berhasil dilakukan.

6.  Atur username dan email yang akan diasosiasikan dengan pekerjaanmu di repository Git dengan perintah berikut:
           `git config --global user.name “<nama-lengkapmu”`
           `git config --global user.email “<masukkan-emailmu>”`
    > ini untuk memberi informasi tentang pengguna repo, masukan email dan nama kalian.
           
7.  Setelah melakukan konfigurasi, silakan pindahkan file `Halo.java`  yang kalian buat pada tutorial sebelumnya ke dalam folder “TutorialDDP2”.
              
8.  Setelah itu, jalankan perintah `git status` pada _command prompt/shell_, maka nanti akan muncul daftar _untracked files_ dari folder tersebut. Oleh karena itu, jalankan perintah `git add <nama-file>` untuk setiap _untracked files_.
                 
9.  Setelah itu, jalankan perintah `git commit -m “<isi-dengan-pesanmu>”`. Hal tersebut berfungsi sebagai penanda terhadap perubahan yang terjadi di dalam files yang kamu buat sebelumnya. 
                    
10. Dengan begitu, kamu sudah berhasil mengimplementasikan Git di _local repository_. Untuk tahapan berikutnya, 
    kamu akan membagikan hasil kerjamu kepada orang lain melalui GitLab, yang terkoneksi dengan local repository yang 
    kamu miliki. Buka [GitLab](https://gitlab.com) melalui browser kalian.
                        
11. Buat sebuah project baru, kamu bisa atur nama project sesukamu, dan atur _Visibility Level_ menjadi **Private**, 
    sehingga hasil pekerjaan kalian tidak bisa dimanfaatkan pihak yang tidak bertanggung jawab.
                           
12. Silakan tekan tombol copy yang berada di sebelah baris yang berisi link menuju repository kamu.
                                
13. Buka kembali _command prompt/shell kamu_, lalu ketikkan perintah:
    
    ```git
    git remote add origin <CLONEURL>
    ```
    
    <CLONEURL> diganti dengan link yang sudah kamu copy sebelumnya. Contoh:
    
    ```git
    git remote add origin https://gitlab.com/dekdepe/ddp-2.git
    ```
    
    > git remote add origin merupakan perintah untuk menambahkan address/link ke git kalian, dengan format
    >
    > `git remote add <nama link> <branch> <link>` 
    > `origin` biasanya digunakan untuk link repo di gitlab kalian, sedangkan `upstream` biasanya digunakan untuk link
    > _sumber_ seperti repo ini. selebihnya akan dijelaskan nanti yaa.
                                    
14. Jalankan perintah `git remote -v`, maka akan muncul alamat repository kalian di bagian `origin`.
                                        
15. Setelah itu, buka repository resmi dari perkuliahan DDP 2 di GitLab melalui link 
    [ini](https://gitlab.com/DDP2-CSUI/ddp-lab). Setelah itu, lakukan hal 
    yang sama seperti pada langkah nomor 12.
                                            
16. Buka kembali _command prompt/shell_ kamu, lalu ketikkan perintah:
    
    ```git
    git remote add upstream <CLONEURL>
    ```
    
    <CLONEURL> diganti dengan link yang sudah kamu copy sebelumnya. Contoh:
    
    ```git
    git remote add upstream https://gitlab.com/DDP2-CSUI/ddp-lab
    ```
                                               
17.  Jalankan perintah `git remote -v`, maka akan muncul alamat repository kalian di bagian origin dan alamat 
     repository resmi DDP 2 di bagian upstream.
     
18. Untuk meng-_"upload"_ hasil pekerjaan kalian, setelah kalian lakukan perintah `add` dan `commit` seperti petunjuk 
    diatas. ketik perintah `git push origin master` untuk menyimpan file yang kalian telah `commit` sebelumnya ke repo 
    dengan nama `origin` (yaitu repo kalian)
    
    > perintah `push` memiliki format `git push <nama link> <branch>`

>Perhatian
>
>Jika terdapat poin yang tidak dimengerti pada penjelasan Soal Tutorial Git, harap segera bertanya kepada asisten atau 
teman kalian, agar kalian tidak tertinggal.

#### Latihan :

1. Menurutmu, kenapa kita menggunakan Git pada DDP 2 kali ini?
    
2. Menurutmu, apa saja keuntungan yang diperoleh jika kita menggunakan Git sejak perkuliahan DDP 2?
        
3. Sebutkan 5 perintah Git!

4. Jelaskan apa yang dilakukan kelima perintah Git yang sudah disebutkan di atas!


***

## Chapter 1 : A New Beginning

Dek Depe merupakan mahasiswa pindahan baru di Fasilkom UI, karena di tempat dulu ia belajar programming menggunakan 
bahasa pemrograman Python, dia kesulitan untuk memahami bahasa pemrograman Java yang digunakan di DDP 2. 

Dan ia pun meminta tolong kepada anda untuk menunjukkan bentuk program Java dari program Python yang ia buat, 
karena anda merupakan mahasiswa yang baik dan memiliki inisiatif s̶e̶r̶t̶a̶ ̶i̶n̶g̶i̶n̶ ̶P̶D̶K̶T̶ ̶d̶e̶n̶g̶a̶n̶ 
̶D̶e̶k̶ ̶D̶e̶p̶e̶. Anda pun bersedia untuk mengajarkan bahasa Java ke Dek Depe.

Tugas kalian adalah mengubah program Python dibawah ini menjadi sebuah Program Java, untuk tiap soal buatlah File dan 
Class nya sendiri (1 soal 1 file Java) dengan nama yang telah ditentukan di tiap soal.

1. Class : **_Jumlah_**

    ```python
    angka1 = 40
    angka2 = 2
    hasil = angka1 + angka2
    print(hasil)
    ```

2. Class : **_HitungBerulang_**

    ```python
    hasil = 0
    
    for a in range(10):
        hasil = hasil + (a*100 - a)
        
    print(hasil)
    ```

3. Class : **_CekUmur_**

    ```python
    umur = 19
    
    if(umur < 10):
        print("Anak-anak")
    elif(umur < 20):
        print("Remaja")
    elif(umur < 50):
        print("Dewasa")
    else:
        print("Lansia")
    ```

4. Class : **_GenapGanjil_**

    ```python
    hasil = 0
    ulangan = 10
    
    for angka in range(ulangan):
        if(angka%2 == 0):
            print("Angka Genap")
    
        elif(angka%2 == 1):
            print("Angka Ganjil")
    
        if(angka == ulangan//2):
            print("Angka tengah")
            
        hasil += angka
    
    print(hasil)
    ```

Setelah kalian selesai mengerjakan soal-soal di atas, coba compile dan jalankan programnya untuk mengecek kebenaran 
program yang telah dibuat. Pastikan program kalian berjalan dengan baik, output sesuai yang diharapkan tanpa ada 
error.

Untuk submisi tugas, didalam folder repo kalian, buat folder baru dengan nama `lab_1`, lalu masukkan semua file `.java` 
dari tugas diatas kedalam folder itu. Lalu add, commit, dan push semua file tersebut ke _online repo_ kalian.

Pastikan file `.class` tidak ikut di push.


## Checklist

### Komponen Wajib | 100 Poin

1. Java
    1. [ ] Memahami perbedaan struktur kode Java dan Python.
    2. [ ] Mampu membuat dan menjalankan program Java menggunakan _text editor_ dan _Command Prompt_.
    3. [ ] Mengerjakan soal 1 (Class : **_Jumlah_**)
    4. [ ] Mengerjakan soal 2 (Class : **_HitungBerulang_**)
    5. [ ] Mengerjakan soal 3 (Class : **_CekUmur_**)
    6. [ ] Mengerjakan soal 4 (Class : **_GenapGanjil_**)
    
2. Git
    1. [ ] Membuat _Local dan Online Repository_
    2. [ ] Melakukan `git init` pada _Local Repository_
    3. [ ] Set `origin` dan `upstream`
    4. [ ] Melakukan perintah `add`, `commit`, dan `push`
    
### Komponen Bonus | 10 Poin

_Belum ada bonus yaa hehe :)_
